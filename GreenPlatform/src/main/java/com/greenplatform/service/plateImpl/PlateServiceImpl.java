package com.greenplatform.service.plateImpl;

import com.greenplatform.aop.OperationLog;
import com.greenplatform.dao.*;
import com.greenplatform.dao.owerMapper.OwerPlateCodeDmzMapper;
import com.greenplatform.dao.owerMapper.OwerPlateUserMapper;
import com.greenplatform.dao.owerMapper.OwerTGreenRwRwmxMapper;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.MD5;
import com.greenplatform.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Transactional
@Service
public class PlateServiceImpl implements PlateService {

    @Autowired
    PlateUserMapper plateUserMapper;
    @Autowired
    PlateUserRoleMapper plateUserRoleMapper;
    @Autowired
    PlateUserPermissionMapper plateUserPermissionMapper;
    @Autowired
    PlateYwLxMenuMapper plateYwLxMenuMapper;
    @Autowired
    OwerPlateUserMapper owerPlateUserMapper;
    @Autowired
    TGreenNlZjnlmxMapper tGreenNlZjnlmxMapper;
    @Autowired
    TGreenNlHzMapper tGreenNlHzMapper;
    @Autowired
    PlateCodeDmlbMapper plateCodeDmlbMapper;
    @Autowired
    PlateCodeDmzMapper plateCodeDmzMapper;
    @Autowired
    OwerPlateCodeDmzMapper owerPlateCodeDmzMapper;
    @Autowired
    PlateLogMapper plateLogMapper;
    @Autowired
    TGreenSpSpmxMapper tGreenSpSpmxMapper;
    @Autowired
    TGreenRwRwmxMapper tGreenRwRwmxMapper;
    @Autowired
    OwerTGreenRwRwmxMapper owerTGreenRwRwmxMapper;

    ReturnModel returnModel = new ReturnModel();



    /**
     * 系统用户查询
     * @param plateUser
     * @return
     */
    @Override
    public ReturnModel selectPlateuser(PlateUser plateUser) {
        List plateUserList;
        PlateUserExample plateUserExample = new PlateUserExample();
        PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
        criteria.andCRylbEqualTo("1");//只查系统用户
        if (!(("").equals(plateUser.getcRylb()) || null == plateUser.getcRylb())){
            criteria.andCRylbEqualTo(plateUser.getcRylb());
        }
        if (!(("").equals(plateUser.getcUsername()) || null == plateUser.getcUsername())){
            criteria.andCUsernameLike("%" + plateUser.getcUsername() + "%");
        }
        if (!(("").equals(plateUser.getcPhone()) || null == plateUser.getcPhone())){
            criteria.andCPhoneEqualTo(plateUser.getcPhone());
        }
        try{
            plateUserList = plateUserMapper.selectByExample(plateUserExample);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateUserList);
        }catch(Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("系统错误");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    /**
     * 网站用户查询
     * @param plateUser
     * @return
     */
    @Override
    public ReturnModel selectWebUser(PlateUser plateUser) {
        List plateUserList;
        plateUser.setcRylb("2");//只查询前端用户

        try{
            plateUserList = owerPlateUserMapper.selectWebUser(plateUser);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateUserList);
        }catch(Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("系统错误");
            returnModel.setObject(null);
        }
        return returnModel;
    }


    /**
     * 新增系统用户
     * @param plateUser
     * @return
     */
    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateuser(PlateUser plateUser) {
        try{
            List plateUserList;
            PlateUser plateUser1 = new PlateUser();
            //1.判断邮箱或用户名是否被注册
            PlateUserExample plateUserExample = new PlateUserExample();
            PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
            criteria.andCRylbEqualTo("1");//人员类别
            criteria.andCRyztEqualTo("1");//人员类别（1系统用户2网站前端用户）
            criteria.andCRyxzEqualTo("1");//员性质（1正常 -1黑名单）
            criteria.andCZtEqualTo("1");//数据状态（0无效  1有效）
            criteria.andCEmailEqualTo(plateUser.getcEmail());

            plateUserList = plateUserMapper.selectByExample(plateUserExample);
            if (!(plateUserList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("新增用户失败，邮箱已经被注册!");
                return returnModel;
            }
            //2.判断用户名是否被注册
            criteria.andCLoginnameEqualTo(plateUser.getcLoginname());
            plateUserList = plateUserMapper.selectByExample(plateUserExample);
            if (!(plateUserList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("新增用户失败，用户名已经被注册!");
                return returnModel;
            }
            //3.新增用户
            String majorKey = UUID.randomUUID().toString().replaceAll("-", "");
            plateUser.setcPassword(MD5.md5(plateUser.getcPassword()));
            plateUser.setcRyzt("1");//人员状态（0未激活1已激活）
            plateUser.setcRylb("1");//人员类别（1系统用户2网站前端用户）
            plateUser.setcRyxz("1");//人员性质（1正常 -1黑名单）
            plateUser.setcZt("1");//数据状态（0无效  1有效）
            plateUser.setcUserid(majorKey);
            plateUser.setdCjsj(TimeUtil.getTimestamp(new Date()));
            plateUser.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());

            int insertRet = plateUserMapper.insert(plateUser);
            if (1 != insertRet){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("新增用户失败,系统错误!");
                return returnModel;
            }else{
                returnModel.setFlag(0);
                returnModel.setObject(null);
                returnModel.setMsg("新增用户成功!");
                return  returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setObject(null);
            returnModel.setMsg("新增用户失败,系统错误!");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


    /**
     * 删除系统用户
     * @param plateUser
     * @return
     */
    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateuser(PlateUser plateUser) {
        try{
            if ("".equals(plateUser.getcUserid())){
                returnModel.setFlag(1);
                returnModel.setMsg("删除用户失败，用户编号不能为空!");
                returnModel.setObject(null);
                return returnModel;
            }
            PlateUser plateUser1 = plateUserMapper.selectByPrimaryKey(plateUser.getcUserid());
            if (null == plateUser1 || "".equals(plateUser1.getcUserid())){
                returnModel.setFlag(1);
                returnModel.setMsg("删除用户失败，没有找到待删除的数据!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateUserMapper.deleteByPrimaryKey(plateUser.getcUserid());
                returnModel.setFlag(0);
                returnModel.setMsg("删除成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("删除用户失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 重置系统用户密码
     * @param plateUser
     * @return
     */
    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel retsetPass(PlateUser plateUser) {
        try{
            PlateUser plateUser1 = plateUserMapper.selectByPrimaryKey(plateUser.getcUserid());
            if (null == plateUser1){
                returnModel.setFlag(1);
                returnModel.setMsg("重置失败，没有找到待修改的数据!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateUser1.setcPassword(MD5.md5("aaaaaa"));
                plateUser1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateUser1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());


                plateUserMapper.updateByPrimaryKey(plateUser1);
                returnModel.setFlag(0);
                returnModel.setMsg("重置成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("重置失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 修改用户信息
     * @param plateUser
     * @return
     */
    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateuser(PlateUser plateUser) {
        try{
            PlateUser plateUser1 = plateUserMapper.selectByPrimaryKey(plateUser.getcUserid());
            if (null == plateUser1){
                returnModel.setFlag(1);
                returnModel.setMsg("修改用户失败，没有找到待修改的数据!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateUser1.setcUsername(plateUser.getcUsername());
                plateUser1.setcSex(plateUser.getcSex());
                plateUser1.setcPhone(plateUser.getcPhone());
                plateUser1.setcZjlx(plateUser.getcZjlx());
                plateUser1.setcZjhm(plateUser.getcZjhm());
                plateUser1.setcJtzz(plateUser.getcJtzz());
                plateUser1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateUser1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                plateUserMapper.updateByPrimaryKey(plateUser1);
                returnModel.setFlag(0);
                returnModel.setMsg("修改用户成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("修改用户失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }



    /**
     * 自定义mapper====查询代码值
     * @param params
     * @return
     */
    @Override
    public ReturnModel selectPlateCodeDmz(Map params) {
        try{
            List plateCodeDmzList = owerPlateCodeDmzMapper.selectPlateCodeDmz(params);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功!");
            returnModel.setObject(plateCodeDmzList);
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误!");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    /**
     * 查询基础代码
     * @param plateCodeDmz
     * @return
     */
    @Override
    public ReturnModel selectPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        PlateCodeDmzExample plateCodeDmzExample = new PlateCodeDmzExample();
        PlateCodeDmzExample.Criteria criteria = plateCodeDmzExample.createCriteria();

        if (!(("").equals(plateCodeDmz.getcDmlb()) || null == plateCodeDmz.getcDmlb())){
            criteria.andCDmlbLike(plateCodeDmz.getcDmlb());
        }
        if (!(("").equals(plateCodeDmz.getcDm()) || null == plateCodeDmz.getcDm())){
            criteria.andCDmlbLike(plateCodeDmz.getcDm());
        }
        plateCodeDmzExample.setOrderByClause("c_dmlb");
        try{
            List plateCodeDmzList = plateCodeDmzMapper.selectByExample(plateCodeDmzExample);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功!");
            returnModel.setObject(plateCodeDmzList);
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误!");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        //1.参数非空判断
        if (("").equals(plateCodeDmz.getcDmlb()) || null == plateCodeDmz.getcDmlb()){
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，代码类别不能为空");
            returnModel.setObject(null);
            return returnModel;
        }
        if (("").equals(plateCodeDmz.getcDm()) || null == plateCodeDmz.getcDm()){
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，代码不能为空");
            returnModel.setObject(null);
            return returnModel;
        }
        try{
            //1.判断数据是否存在
            PlateCodeDmz plateCodeDmz1 = plateCodeDmzMapper.selectByPrimaryKey(plateCodeDmz.getcDm(),plateCodeDmz.getcDmlb());
            if (null == plateCodeDmz1 || "".equals(plateCodeDmz1)){
                returnModel.setFlag(1);
                returnModel.setMsg("删除失败，没有找到待删除的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateCodeDmzMapper.deleteByPrimaryKey(plateCodeDmz.getcDm(),plateCodeDmz.getcDmlb());
                returnModel.setFlag(0);
                returnModel.setMsg("删除成功");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("删除失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


    /**
     * 自定义mapper====业务基础代码维护
     * @param plateCodeDmlb
     * @param plateCodeDmz
     * @return
     */
    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertYwjcdm(PlateCodeDmlb plateCodeDmlb,PlateCodeDmz plateCodeDmz) {
        try {
            //1.参数非空判断
            if (("").equals(plateCodeDmz.getcDmlb()) || null == plateCodeDmz.getcDmlb()){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，代码类别不能为空");
                returnModel.setObject(null);
                return returnModel;
            }
            if (("").equals(plateCodeDmz.getcDm()) || null == plateCodeDmz.getcDm()){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，代码不能为空");
                returnModel.setObject(null);
                return returnModel;
            }
            //2-1.如果指定代码类别不存在则现在代码类别主表插入一条数据
            PlateCodeDmlb plateCodeDmlb1 = plateCodeDmlbMapper.selectByPrimaryKey(plateCodeDmz.getcDmlb());
            if (null == plateCodeDmlb1 || "".equals(plateCodeDmlb1)){
                plateCodeDmlb.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmlb.setdCjsj(TimeUtil.getTimestamp(new Date()));
                plateCodeDmlbMapper.insert(plateCodeDmlb);
            }
            //2-2.验证代码值是否已存在
            PlateCodeDmzExample plateCodeDmzExample = new PlateCodeDmzExample();
            PlateCodeDmzExample.Criteria criteria = plateCodeDmzExample.createCriteria();
            criteria.andCDmlbEqualTo(plateCodeDmz.getcDmlb());
            criteria.andCDmEqualTo(plateCodeDmz.getcDm());
            List plateCodeDmzList = plateCodeDmzMapper.selectByExample(plateCodeDmzExample);
            if (!(plateCodeDmzList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setMsg("指定代码类别下已经有此代码存在！代码类别【"+plateCodeDmz.getcDmlb()+"】"+",代码值【"+plateCodeDmz.getcDm()+"】");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //3-1.新增代码类别数据
                plateCodeDmz.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmz.setdCjsj(TimeUtil.getTimestamp(new Date()));
                plateCodeDmzMapper.insert(plateCodeDmz);
                returnModel.setFlag(0);
                returnModel.setMsg("新增成功！");
                returnModel.setObject(plateCodeDmz);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


    /**
     * 自定义mapper====修改代码类别及代码值
     * @param plateCodeDmlb
     * @param plateCodeDmz
     * @return
     */
    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updYwjcdm(PlateCodeDmlb plateCodeDmlb,PlateCodeDmz plateCodeDmz) {
        //1.参数非空判断
        if (("").equals(plateCodeDmz.getcDmlb()) || null == plateCodeDmz.getcDmlb()){
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，代码类别不能为空");
            returnModel.setObject(null);
            return returnModel;
        }
        if (("").equals(plateCodeDmz.getcDm()) || null == plateCodeDmz.getcDm()){
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，代码不能为空");
            returnModel.setObject(null);
            return returnModel;
        }
        try{
            //2.判断数据是否存在
            PlateCodeDmz plateCodeDmz1 = plateCodeDmzMapper.selectByPrimaryKey(plateCodeDmz.getcDm(),plateCodeDmz.getcDmlb());
            PlateCodeDmlb plateCodeDmlb1 = plateCodeDmlbMapper.selectByPrimaryKey(plateCodeDmlb.getcDmlb());
            if (null == plateCodeDmz1 || "".equals(plateCodeDmz1)){
                returnModel.setFlag(1);
                returnModel.setMsg("修改失败，没有找到待修改的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else if(null == plateCodeDmlb1 || "".equals(plateCodeDmlb1)){
                returnModel.setFlag(1);
                returnModel.setMsg("修改失败，没有找到待修改的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //3-1.执行修改代码类别
                plateCodeDmlb1.setcDmlbmc(plateCodeDmlb.getcDmlbmc());
                plateCodeDmlb1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmlb1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateCodeDmlbMapper.updateByPrimaryKey(plateCodeDmlb1);
                //3-2.执行修改代码值
                plateCodeDmz1.setcSort(plateCodeDmz.getcSort());
                plateCodeDmz1.setcZt(plateCodeDmz.getcZt());
                plateCodeDmz1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmz1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateCodeDmzMapper.updateByPrimaryKey(plateCodeDmz1);
                returnModel.setFlag(0);
                returnModel.setMsg("修改成功");
                returnModel.setObject(plateCodeDmz);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("修改失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateLog(PlateLog plateLog) {
        try{
            plateLogMapper.insert(plateLog);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询当前登陆用户业务权限
     * @return
     */
    @Override
    public ReturnModel selectLoginuserYwqx() {
        Map loginuserYwqxMap = new HashMap();

        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            PlateUserRoleExample plateUserRoleExample = new PlateUserRoleExample();
            PlateUserRoleExample.Criteria criteria = plateUserRoleExample.createCriteria();
            criteria.andCUseridEqualTo(plateUser.getcUserid());
            List plateUserRoleList = plateUserRoleMapper.selectByExample(plateUserRoleExample);//查询当前用户的角色
            loginuserYwqxMap.put("plateUserRoleList",plateUserRoleList);
            for (int i = 0;i < plateUserRoleList.size();i++){
                PlateUserRole plateUserRole = (PlateUserRole) plateUserRoleList.get(i);
                PlateUserPermissionExample plateUserPermissionExample = new PlateUserPermissionExample();
                PlateUserPermissionExample.Criteria criteria1 = plateUserPermissionExample.createCriteria();
                criteria1.andCRoleEqualTo(plateUserRole.getcRole());
                List plateUserPermissionmenuList = plateUserPermissionMapper.selectByExample(plateUserPermissionExample);//查询角色对应的功能表
                loginuserYwqxMap.put("plateUserPermissionmenuList",plateUserPermissionmenuList);

                List plateYwLxMenuList = new ArrayList();
                for (int j = 0;j < plateUserPermissionmenuList.size();j++){
                    Map plateYwLxMenuMap = new HashMap();
                    PlateUserPermission lateUserPermission = (PlateUserPermission) plateUserPermissionmenuList.get(j);
                    PlateYwLxMenuExample plateYwLxMenuExample = new PlateYwLxMenuExample();
                    PlateYwLxMenuExample.Criteria criteria2 = plateYwLxMenuExample.createCriteria();
                    criteria2.andCMenudmEqualTo(lateUserPermission.getcMenudm());
                    List plateYwLxMenuListTmp = plateYwLxMenuMapper.selectByExample(plateYwLxMenuExample);
                    if (plateYwLxMenuListTmp.size() > 0){
                        PlateYwLxMenu plateYwLxMenu = (PlateYwLxMenu) plateYwLxMenuListTmp.get(0);
                        plateYwLxMenuMap.put("cMenudm",plateYwLxMenu.getcMenudm());
                        plateYwLxMenuMap.put("cMenumc",plateYwLxMenu.getcMenumc());
                        plateYwLxMenuMap.put("cMenujc",plateYwLxMenu.getcMenujc());
                        plateYwLxMenuMap.put("cYwlxdm",plateYwLxMenu.getcYwlxdm());
                        plateYwLxMenuMap.put("cRuncommand",plateYwLxMenu.getcRuncommand());
                        plateYwLxMenuMap.put("cZt",plateYwLxMenu.getcZt());
                        plateYwLxMenuList.add(plateYwLxMenuMap);
                    }
                }
                loginuserYwqxMap.put("plateYwLxMenuList",plateYwLxMenuList);
            }

            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(loginuserYwqxMap);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @Override
    public ReturnModel selectTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        List tGreenSpmxList;
        try {
            tGreenSpmxList = tGreenSpSpmxMapper.selectByExample(new TGreenSpSpmxExample());
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(tGreenSpmxList);
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try{
            //1.参数非空判断
            if (("").equals(tGreenSpSpmx.getcSpmc()) || null == tGreenSpSpmx.getcSpmc()){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，商品名称不能为空");
                returnModel.setObject(null);
                return returnModel;
            }
            if (("").equals(tGreenSpSpmx.getcSpjg()) || null == tGreenSpSpmx.getcSpjg()){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，商品价格不能为空");
                returnModel.setObject(null);
                return returnModel;
            }

            //2.商品名称是否有重复
            TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
            TGreenSpSpmxExample.Criteria criteria = tGreenSpSpmxExample.createCriteria();
            criteria.andCSpmcEqualTo(tGreenSpSpmx.getcSpmc());
            List tGreenSpSpmxList = tGreenSpSpmxMapper.selectByExample(tGreenSpSpmxExample);
            if (!(tGreenSpSpmxList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setMsg("商品名称不能重复，指定商品名称已存在！商品名称【"+tGreenSpSpmx.getcSpmc()+"]");
                returnModel.setObject(null);
                return returnModel;
            }
            //3.执行新增
            tGreenSpSpmx.setcSpbh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenSpSpmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenSpSpmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenSpSpmxMapper.insert(tGreenSpSpmx);
            returnModel.setFlag(0);
            returnModel.setMsg("操作成功");
            returnModel.setObject(tGreenSpSpmx);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("新增出错，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try{
            TGreenSpSpmx tGreenSpSpmx1 = tGreenSpSpmxMapper.selectByPrimaryKey(tGreenSpSpmx.getcSpbh());
            if (null == tGreenSpSpmx1 || "".equals(tGreenSpSpmx1)){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，没有找到待删除的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                tGreenSpSpmxMapper.deleteByPrimaryKey(tGreenSpSpmx.getcSpbh());
                returnModel.setFlag(0);
                returnModel.setMsg("操作成功！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }

    }

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try {
            //1.判断修改数据是否存在
            TGreenSpSpmx tGreenSpSpmx1 = tGreenSpSpmxMapper.selectByPrimaryKey(tGreenSpSpmx.getcSpbh());
            if (null == tGreenSpSpmx1 || "".equals(tGreenSpSpmx1)){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，没有找到待删除的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                tGreenSpSpmx1.setcSpmc(tGreenSpSpmx.getcSpmc());
                tGreenSpSpmx1.setcSpjg(tGreenSpSpmx.getcSpjg());
                tGreenSpSpmx1.setcSpms(tGreenSpSpmx.getcSpms());
                tGreenSpSpmx1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                tGreenSpSpmx1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                tGreenSpSpmxMapper.updateByPrimaryKey(tGreenSpSpmx1);
                returnModel.setFlag(0);
                returnModel.setMsg("操作成功！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


    /**
     * 自定义mapper====查询任务明细
     * @param paramsMap
     * @return
     */
    @Override
    public ReturnModel selectTGreenRwRwmx(Map paramsMap) {
        List tGreenRwRwmxList;
        try {
            tGreenRwRwmxList = owerTGreenRwRwmxMapper.selectTGreenRwRwmx(paramsMap);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(tGreenRwRwmxList);
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    /**
     * 查询系统用户角色
     * @param plateUserRole
     * @return
     */
    @Override
    public ReturnModel selectPlateUserRole(PlateUserRole plateUserRole) {
        try{
            PlateUserRoleExample plateUserRoleExample = new PlateUserRoleExample();
            PlateUserRoleExample.Criteria criteria = plateUserRoleExample.createCriteria();
            plateUserRoleExample.setOrderByClause("d_cjsj");
            if (!(("").equals(plateUserRole.getcRolename()) || null == plateUserRole.getcRolename())){
                criteria.andCRolenameLike("%"+plateUserRole.getcRolename()+"%");
            }
            criteria.andCZtEqualTo("1");
            List plateUserRoleList = plateUserRoleMapper.selectByExample(plateUserRoleExample);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateUserRoleList);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 新增系统用户角色
     * @param plateUserRole
     * @return
     */
    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateUserRole(PlateUserRole plateUserRole) {
        return null;
    }

    /**
     * 修改用户角色
     * @param plateUserRole
     * @return
     */
    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateUserRole(PlateUserRole plateUserRole) {
        return null;
    }

    /**
     * 删除用户角色
     * @param plateUserRole
     * @return
     */
    @OperationLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateUserRole(PlateUserRole plateUserRole) {
        return null;
    }


    /**
     * 查询业务功能
     * @param plateYwLxMenu
     * @return
     */
    @Override
    public ReturnModel selectPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu) {
        try{
            PlateYwLxMenuExample plateYwLxMenuExample = new PlateYwLxMenuExample();
            PlateYwLxMenuExample.Criteria criteria = plateYwLxMenuExample.createCriteria();
            plateYwLxMenuExample.setOrderByClause("c_ywlxdm,c_sort");
            if (!(("").equals(plateYwLxMenu.getcYwlxdm()) || null == plateYwLxMenu.getcYwlxdm())){
                criteria.andCYwlxdmEqualTo(plateYwLxMenu.getcYwlxdm());
            }

            if (!(("").equals(plateYwLxMenu.getcMenudm()) || null == plateYwLxMenu.getcMenudm())){
                criteria.andCYwlxdmLike(plateYwLxMenu.getcYwlxdm());
            }

            if (!(("").equals(plateYwLxMenu.getcMenumc()) || null == plateYwLxMenu.getcMenumc())){
                criteria.andCMenumcLike(plateYwLxMenu.getcMenumc());
            }

            if (!(("").equals(plateYwLxMenu.getcMenujc()) || null == plateYwLxMenu.getcMenujc())){
                criteria.andCMenujcLike(plateYwLxMenu.getcMenujc());
            }

            List plateYwLxMenuList = plateYwLxMenuMapper.selectByExample(plateYwLxMenuExample);

            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateYwLxMenuList);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


}
