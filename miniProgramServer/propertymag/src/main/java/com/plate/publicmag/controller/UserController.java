package com.plate.publicmag.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.plate.publicmag.model.baseModel.ReturnModel;
import com.plate.publicmag.service.UserService;
import com.plate.publicmag.util.returnUtil.ReturnModelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    UserService userService;


    /**
     *
     * @param page 当前页
     * @param rows  一页显示记录数
     * @param sidx  排序列名（id/username......）
     * @param sord  排序方式（ASC/DESC）
     * @return
     */
    @RequestMapping("/selectAllUser")
    public ReturnModel selectAllUser(int page,int rows,String sidx,String sord){
        PageHelper.startPage(page,rows);
        List userList = userService.selectAllUser();//查询数据
        PageInfo pageInfo=new PageInfo(userList);
        Map retMap = new HashMap();
        retMap.put("currPage",pageInfo.getPageNum());//页码
        retMap.put("totalCount",pageInfo.getTotal());//总记录数
        retMap.put("totalPage",pageInfo.getPages());//总页数
        retMap.put("retDatas",pageInfo.getList());

        return ReturnModelHandler.success(retMap);
    }


    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public ReturnModel editUser(@RequestBody JsonObject jsonObject){
        System.out.println(jsonObject);

        return null;
    }
}
