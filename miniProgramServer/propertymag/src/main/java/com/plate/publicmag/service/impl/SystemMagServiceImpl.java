package com.plate.publicmag.service.impl;

import com.plate.publicmag.dao.TSystemMenuMapper;
import com.plate.publicmag.dao.owerDao.SystemMagMapper;
import com.plate.publicmag.model.TSystemAdmin;
import com.plate.publicmag.model.TSystemMenu;
import com.plate.publicmag.model.TSystemMenuExample;
import com.plate.publicmag.model.baseModel.ReturnModel;
import com.plate.publicmag.service.SystemMagService;
import com.plate.publicmag.util.GetCurrentLoginUser;
import com.plate.publicmag.util.returnUtil.ReturnModelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;


@Service
@Transactional
public class SystemMagServiceImpl implements SystemMagService {
    @Autowired
    SystemMagMapper systemMagMapper;

    @Autowired
    TSystemMenuMapper tSystemMenuMapper;

    /**
     * 根据当前登录用户查询当前用户的权限
     * @param httpSession
     * @return
     */
    @Override
    public ReturnModel selectMenuByLoginUser(HttpSession httpSession) {
        List retList = new ArrayList();
        TSystemAdmin tSystemAdmin = GetCurrentLoginUser.getCurrentUser();

        Map paramMap = new HashMap();
        paramMap.put("userid",tSystemAdmin.getUserId());
        List<Map> menuList = systemMagMapper.selectMenuByLoginUser(paramMap);//先查出所有第一级

        for (Map menuMap : menuList){
            Map retMap = new HashMap();
            retMap.put("id",menuMap.get("id"));
            retMap.put("text",menuMap.get("menu_name"));//tree使用
            retMap.put("menu_name",menuMap.get("menu_name"));
            retMap.put("menu_icon",menuMap.get("menu_icon"));
            retMap.put("menu_action",menuMap.get("menu_action"));
            retMap.put("children",getChildren(Integer.parseInt(menuMap.get("id").toString())));
            retMap.put("item",retMap.get("children"));//tree使用
            retList.add(retMap);
        }
        System.out.println(retList);
        return ReturnModelHandler.success(retList);
    }


    /**
     * 查询所有菜单,组装菜单树
     * @return
     */
    @Override
    public ReturnModel selectAllMenu() {
        List retList = new ArrayList();
        //1.查出第一级菜单（无父级）
        TSystemMenuExample tSystemMenuExample  =new TSystemMenuExample();
        TSystemMenuExample.Criteria criteria = tSystemMenuExample.createCriteria();
        criteria.andParentIdIsNull();
        tSystemMenuExample.setOrderByClause("menu_sort");
        List<TSystemMenu> notParentList = tSystemMenuMapper.selectByExample(tSystemMenuExample);


        for(TSystemMenu tSystemMenu : notParentList){
            Map retMap = new HashMap();
            retMap.put("id",tSystemMenu.getId());
            retMap.put("text",tSystemMenu.getMenuName());
            retMap.put("open",1);
            retMap.put("item",getChildren(tSystemMenu.getId()));
            retMap.put("userdata",getTreeUserData(tSystemMenu));

            retList.add(retMap);
        }
        System.out.println(retList);
        return ReturnModelHandler.success(retList);
    }


    /**
     * 递归查询子节点
     * @param parentId
     * @return
     */
    private List<Map> getChildren(Integer parentId){
        List<Map> retList = new ArrayList<Map>();
        TSystemMenuExample tSystemMenuExample = new TSystemMenuExample();
        TSystemMenuExample.Criteria criteria = tSystemMenuExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TSystemMenu> childList = tSystemMenuMapper.selectByExample(tSystemMenuExample);
        for(TSystemMenu tSystemMenu : childList){
            Map retMap = new HashMap();
            retMap.put("id",tSystemMenu.getId());
            retMap.put("text",tSystemMenu.getMenuName());//tree使用
            retMap.put("open",1);//tree使用
            retMap.put("menu_name",tSystemMenu.getMenuName());
            retMap.put("menu_icon",tSystemMenu.getMenuIcon());
            retMap.put("menu_action",tSystemMenu.getMenuAction());
            retMap.put("children",getChildren(tSystemMenu.getId()));
            retMap.put("item",retMap.get("children"));//tree使用
            retMap.put("userdata",getTreeUserData(tSystemMenu));//tree使用
            retList.add(retMap);
        }

        return retList;
    }


    /**
     * 组装树结构userdata对象
     * @param tSystemMenu
     * @return
     */
    private List<Map> getTreeUserData(TSystemMenu tSystemMenu){
        //组装userdata
        List<Map> userdataList = new ArrayList<Map>();
        Map userdataMap = new HashMap();
        userdataMap.put("name","data");
        userdataMap.put("content",tSystemMenu);
        userdataList.add(userdataMap);
        return userdataList;
    }
}
