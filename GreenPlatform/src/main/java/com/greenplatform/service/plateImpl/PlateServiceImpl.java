package com.greenplatform.service.plateImpl;

import com.greenplatform.aop.YwOperationCheckAndLog;
import com.greenplatform.dao.*;
import com.greenplatform.dao.owerMapper.OwerPlateCodeDmzMapper;
import com.greenplatform.dao.owerMapper.OwerPlateUserMapper;
import com.greenplatform.dao.owerMapper.OwerTGreenNlHzMapper;
import com.greenplatform.dao.owerMapper.OwerTGreenRwRwmxMapper;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.MD5;
import com.greenplatform.util.TimeUtil;
import net.sf.json.JSONObject;
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
    PlateUserRoleMidMapper plateUserRoleMidMapper;
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
    @Autowired
    OwerTGreenNlHzMapper owerTGreenNlHzMapper;
    @Autowired
    PlateCodeXtcsMapper plateCodeXtcsMapper;

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
    @YwOperationCheckAndLog(cCzfs = "I")
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
            plateUser.setcIssmz("0");//是否实名制（0非1是，此字段只针对前端用户）
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
    @YwOperationCheckAndLog(cCzfs = "D")
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
    @YwOperationCheckAndLog(cCzfs = "U")
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
    @YwOperationCheckAndLog(cCzfs = "U")
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

    @YwOperationCheckAndLog(cCzfs = "D")
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
    @YwOperationCheckAndLog(cCzfs = "I")
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
    @YwOperationCheckAndLog(cCzfs = "U")
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
                plateCodeDmz1.setcDmz(plateCodeDmz.getcDmz());
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

    @YwOperationCheckAndLog(cCzfs = "I")
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
     * plate_user===plate_user_role_mid===plate_user_role
     * plate_user_permission===plate_yw_lx_menu
     * @return
     */
    @Override
    public ReturnModel selectLoginuserYwqx() {
        Map loginuserYwqxMap = new HashMap();

        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            PlateUserRoleMidExample plateUserRoleMidExample = new PlateUserRoleMidExample();
            PlateUserRoleMidExample.Criteria criteria = plateUserRoleMidExample.createCriteria();
            criteria.andCUseridEqualTo(plateUser.getcUserid());
            criteria.andCZtEqualTo("1");
            List plateUserRoleMidList = plateUserRoleMidMapper.selectByExample(plateUserRoleMidExample);//查询当前用户的角色
            loginuserYwqxMap.put("plateUserRoleMidList",plateUserRoleMidList);
            for (int i = 0;i < plateUserRoleMidList.size();i++){
                PlateUserRoleMid plateUserRoleMid = (PlateUserRoleMid) plateUserRoleMidList.get(i);
                PlateUserPermissionExample plateUserPermissionExample = new PlateUserPermissionExample();
                PlateUserPermissionExample.Criteria criteria1 = plateUserPermissionExample.createCriteria();
                criteria1.andCRoleEqualTo(plateUserRoleMid.getcRole());
                criteria1.andCZtEqualTo("1");
                List plateUserPermissionmenuList = plateUserPermissionMapper.selectByExample(plateUserPermissionExample);//查询角色对应的功能表
                loginuserYwqxMap.put("plateUserPermissionmenuList",plateUserPermissionmenuList);

                List plateYwLxMenuList = new ArrayList();
                for (int j = 0;j < plateUserPermissionmenuList.size();j++){
                    Map plateYwLxMenuMap = new HashMap();
                    PlateUserPermission lateUserPermission = (PlateUserPermission) plateUserPermissionmenuList.get(j);
                    PlateYwLxMenuExample plateYwLxMenuExample = new PlateYwLxMenuExample();
                    PlateYwLxMenuExample.Criteria criteria2 = plateYwLxMenuExample.createCriteria();
                    criteria2.andCMenudmEqualTo(lateUserPermission.getcMenudm());
                    criteria2.andCZtEqualTo("1");
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
            System.out.println(loginuserYwqxMap);
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

    @YwOperationCheckAndLog(cCzfs = "I")
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
            if (("").equals(tGreenSpSpmx.getnSpjg()) || null == tGreenSpSpmx.getnSpjg()){
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

    @YwOperationCheckAndLog(cCzfs = "D")
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

    @YwOperationCheckAndLog(cCzfs = "U")
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
                tGreenSpSpmx1.setnSpjg(tGreenSpSpmx.getnSpjg());
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
            //criteria.andCZtEqualTo("1");
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
    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateUserRole(PlateUserRole plateUserRole) {
        try{
            if (("").equals(plateUserRole.getcRole()) || null == plateUserRole.getcRole()){
                returnModel.setFlag(1);
                returnModel.setMsg("新增用户角色失败，用户角色不能为空!");
                returnModel.setObject(null);
                return returnModel;
            }else if(("").equals(plateUserRole.getcRolename()) || null == plateUserRole.getcRolename()){
                returnModel.setFlag(1);
                returnModel.setMsg("新增用户角色失败，用户角色名称不能为空!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                PlateUserRole plateUserRole1 = plateUserRoleMapper.selectByPrimaryKey(plateUserRole.getcRole());
                if (!(("").equals(plateUserRole1) || null == plateUserRole1)){
                    returnModel.setFlag(1);
                    returnModel.setMsg("新增用户角色失败，用户角色已存在!");
                    returnModel.setObject(null);
                }else{
                    plateUserRole.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                    plateUserRole.setdCjsj(TimeUtil.getTimestamp(new Date()));
                    plateUserRoleMapper.insert(plateUserRole);
                    returnModel.setFlag(0);
                    returnModel.setMsg("新增用户角色成功!");
                    returnModel.setObject(null);

                }
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
     * 修改用户角色
     * @param plateUserRole
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateUserRole(PlateUserRole plateUserRole) {
        try{
            if (("").equals(plateUserRole.getcRole()) || null == plateUserRole.getcRole()){
                returnModel.setFlag(1);
                returnModel.setMsg("修改用户角色失败，用户角色不能为空!");
                returnModel.setObject(null);
                return returnModel;
            }

            PlateUserRole plateUserRole1 = plateUserRoleMapper.selectByPrimaryKey(plateUserRole.getcRole());
            if (null == plateUserRole1){
                returnModel.setFlag(1);
                returnModel.setMsg("修改用户角色失败，没有找到待修改的数据!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateUserRole1.setcRolename(plateUserRole.getcRolename());
                plateUserRole1.setcZt(plateUserRole.getcZt());
                plateUserRole1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateUserRole1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                plateUserRoleMapper.updateByPrimaryKey(plateUserRole1);
                returnModel.setFlag(0);
                returnModel.setMsg("修改用户角色成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("修改用户角色失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 删除用户角色
     * @param plateUserRole
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateUserRole(PlateUserRole plateUserRole) {
        try{
            if ("".equals(plateUserRole.getcRole()) || null == plateUserRole.getcRole()){
                returnModel.setFlag(1);
                returnModel.setMsg("删除失败，用户角色标识符不能为空!");
                returnModel.setObject(null);
                return returnModel;
            }
            PlateUserRole plateUserRole1 = plateUserRoleMapper.selectByPrimaryKey(plateUserRole.getcRole());
            if (null == plateUserRole1 || "".equals(plateUserRole1.getcRole())){
                returnModel.setFlag(1);
                returnModel.setMsg("删除失败，没有找到待删除的数据!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateUserRoleMapper.deleteByPrimaryKey(plateUserRole.getcRole());
                returnModel.setFlag(0);
                returnModel.setMsg("删除成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("删除失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


    /**
     * 查询业务功能
     * @param plateYwLxMenu
     * @return
     */
    @Override
    public ReturnModel selectPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu){
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

    /**
     * 新增应用
     * @param plateYwLxMenu
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu) {
        try{
            if (("").equals(plateYwLxMenu.getcYwlxdm()) || null == plateYwLxMenu.getcYwlxdm()){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("新增应用失败，业务类型代码不能为空!");
                return returnModel;
            }else if(("").equals(plateYwLxMenu.getcMenudm()) || null == plateYwLxMenu.getcMenudm()){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("新增应用失败，菜单功能代码代码不能为空!");
                return returnModel;
            }else{
                PlateYwLxMenuExample plateYwLxMenuExample = new PlateYwLxMenuExample();
                PlateYwLxMenuExample.Criteria criteria = plateYwLxMenuExample.createCriteria();
                criteria.andCMenudmEqualTo(plateYwLxMenu.getcMenudm());
                criteria.andCZtEqualTo("1");
                List plateYwLxMenuList = plateYwLxMenuMapper.selectByExample(plateYwLxMenuExample);
                if (!(plateYwLxMenuList.isEmpty())){
                    returnModel.setFlag(1);
                    returnModel.setObject(null);
                    returnModel.setMsg("新增应用失败，菜单功能代码已存在!");
                    return returnModel;
                }
                plateYwLxMenu.setdCjsj(TimeUtil.getTimestamp(new Date()));
                plateYwLxMenu.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                plateYwLxMenuMapper.insert(plateYwLxMenu);
                returnModel.setFlag(0);
                returnModel.setObject(null);
                returnModel.setMsg("新增应用成功!");
                return  returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setObject(null);
            returnModel.setMsg("新增应用失败,系统错误!");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 修改应用
     * @param plateYwLxMenu
     * @return
     */
    //@OperationLog(cCzfs = "U")
    @YwOperationCheckAndLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu) {
        try{
            if (("").equals(plateYwLxMenu.getcYwlxdm()) || null == plateYwLxMenu.getcYwlxdm()){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("修改应用失败，业务类型代码不能为空!");
                return returnModel;
            }else if(("").equals(plateYwLxMenu.getcMenudm()) || null == plateYwLxMenu.getcMenudm()){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("修改应用失败，菜单功能代码代码不能为空!");
                return returnModel;
            }else{
                PlateYwLxMenu plateYwLxMenu1 = plateYwLxMenuMapper.selectByPrimaryKey(plateYwLxMenu.getcMenudm());
                if (null == plateYwLxMenu1){
                    returnModel.setFlag(1);
                    returnModel.setMsg("修改应用失败，没有找到待修改的数据!");
                    returnModel.setObject(null);
                    return returnModel;
                }else{
                    plateYwLxMenu1.setcMenumc(plateYwLxMenu.getcMenumc());
                    plateYwLxMenu1.setcMenujc(plateYwLxMenu.getcMenujc());
                    plateYwLxMenu1.setcRuncommand(plateYwLxMenu.getcRuncommand());
                    plateYwLxMenu1.setcSort(plateYwLxMenu.getcSort());

                    plateYwLxMenu1.setcZt(plateYwLxMenu.getcZt());
                    plateYwLxMenu1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                    plateYwLxMenu1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                    plateYwLxMenuMapper.updateByPrimaryKey(plateYwLxMenu1);
                    returnModel.setFlag(0);
                    returnModel.setMsg("修改应用成功!");
                    returnModel.setObject(null);
                    return returnModel;
                }
            }
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("修改用户角色失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 删除应用
     * @param plateYwLxMenu
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu) {
        try{
            if(("").equals(plateYwLxMenu.getcMenudm()) || null == plateYwLxMenu.getcMenudm()){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("删除应用失败，菜单功能代码代码不能为空!");
                return returnModel;
            }else{
                PlateYwLxMenu plateYwLxMenu1 = plateYwLxMenuMapper.selectByPrimaryKey(plateYwLxMenu.getcMenudm());
                if (null == plateYwLxMenu1){
                    returnModel.setFlag(1);
                    returnModel.setMsg("删除应用失败，没有找到待删除的数据!");
                    returnModel.setObject(null);
                    return returnModel;
                }else{
                    plateYwLxMenuMapper.deleteByPrimaryKey(plateYwLxMenu1.getcMenudm());
                    returnModel.setFlag(0);
                    returnModel.setMsg("删除应用成功!");
                    returnModel.setObject(null);
                    return returnModel;
                }
            }
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("删除应用失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


    /**
     * 查询指定角色拥有的业务功能权限
     * @param cRole
     * @return
     */
    @Override
    public ReturnModel selectPermissionByRole(String cRole) {
        try{
            PlateYwLxMenuExample plateYwLxMenuExample = new PlateYwLxMenuExample();
            PlateYwLxMenuExample.Criteria criteria = plateYwLxMenuExample.createCriteria();
            criteria.andCZtEqualTo("1");
            plateYwLxMenuExample.setOrderByClause("c_ywlxdm,c_menudm,c_sort");
            List plateYwLxMenuList = plateYwLxMenuMapper.selectByExample(plateYwLxMenuExample);//1.查出系统中所有的功能菜单

            PlateUserPermissionExample plateUserPermissionExample = new PlateUserPermissionExample();
            PlateUserPermissionExample.Criteria criteria1 = plateUserPermissionExample.createCriteria();
            criteria1.andCZtEqualTo("1");
            criteria1.andCRoleEqualTo(cRole);
            plateUserPermissionExample.setOrderByClause("c_menudm");
            List plateUserPermissionList = plateUserPermissionMapper.selectByExample(plateUserPermissionExample);//2.查询指定角色拥有的权限

            List returnList = new ArrayList();
            for(int i=0;i<plateYwLxMenuList.size();i++){
                Map returnMap = new HashMap();
                PlateYwLxMenu plateYwLxMenu = (PlateYwLxMenu) plateYwLxMenuList.get(i);
                returnMap.put("cYwlxdm",plateYwLxMenu.getcYwlxdm());
                returnMap.put("cMenudm",plateYwLxMenu.getcMenudm());
                returnMap.put("cMenumc",plateYwLxMenu.getcMenumc());
                returnMap.put("cMenujc",plateYwLxMenu.getcMenujc());
                returnMap.put("cRuncommand",plateYwLxMenu.getcRuncommand());
                returnMap.put("cSort",plateYwLxMenu.getcSort());

                if (plateUserPermissionList.size() > 0){
                    for (int j=0;j<plateUserPermissionList.size();j++){
                        PlateUserPermission plateUserPermission = (PlateUserPermission) plateUserPermissionList.get(j);
                        if(plateYwLxMenu.getcMenudm().equals(plateUserPermission.getcMenudm())){
                            returnMap.put("isCheck","1");
                            break;
                        }else{
                            returnMap.put("isCheck","0");
                        }
                    }
                }else{
                    returnMap.put("isCheck","0");
                }
                returnList.add(returnMap);
            }
            System.out.println(returnList);
            returnModel.setObject(0);
            returnModel.setMsg("");
            returnModel.setObject(returnList);
            return returnModel;
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("获取数据失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 查询系统用户中哪些用户拥有指定权限
     * @param cRole
     * @return
     */
    @Override
    public ReturnModel selectPlateuserByRole(String cRole) {
        try {
            PlateUserRole plateUserRole = plateUserRoleMapper.selectByPrimaryKey(cRole);
            String cRolename = plateUserRole.getcRolename();

            PlateUserExample plateUserExample = new PlateUserExample();
            PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
            criteria.andCRylbEqualTo("1");//人员类别
            criteria.andCRyztEqualTo("1");//人员类别（1系统用户2网站前端用户）
            criteria.andCRyxzEqualTo("1");//员性质（1正常 -1黑名单）
            criteria.andCZtEqualTo("1");//数据状态（0无效  1有效）
            List plateUserlist = plateUserMapper.selectByExample(plateUserExample);

            PlateUserRoleMidExample plateUserRoleMidExample = new PlateUserRoleMidExample();
            PlateUserRoleMidExample.Criteria criteria1 = plateUserRoleMidExample.createCriteria();
            criteria1.andCZtEqualTo("1");
            criteria1.andCRoleEqualTo(cRole);
            List plateUserRoleMidList = plateUserRoleMidMapper.selectByExample(plateUserRoleMidExample);

            List returnList = new ArrayList();
            for (int i = 0;i < plateUserlist.size();i++){
                Map retMap = new HashMap();
                PlateUser plateUser = (PlateUser) plateUserlist.get(i);
                retMap.put("cUserid",plateUser.getcUserid());
                retMap.put("cUsername",plateUser.getcUsername());
                retMap.put("cLoginname",plateUser.getcLoginname());
                retMap.put("cEmail",plateUser.getcEmail());
                retMap.put("cRole",cRole);
                retMap.put("cRolename",cRolename);
                if (plateUserRoleMidList.size() > 0){
                    for (int j = 0;j < plateUserRoleMidList.size();j++){
                        PlateUserRoleMid plateUserRoleMid = (PlateUserRoleMid) plateUserRoleMidList.get(j);
                        System.out.println(plateUserRoleMid.getcUserid());
                        System.out.println(plateUser.getcUserid());
                        if (plateUserRoleMid.getcUserid().equals(plateUser.getcUserid())){
                            retMap.put("isCheck","1");
                            break;
                        }else{
                            retMap.put("isCheck","0");
                        }
                    }
                }
                returnList.add(retMap);
            }
            System.out.println(returnList);

            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(returnList);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("查询失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 给系统角色授权【保存角色权限】
     * @param jsonObject
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel saveUserRolePermission(JSONObject jsonObject) {
        try{
            if (jsonObject.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("保存失败，参数传递错误!");
                returnModel.setObject(null);
                return returnModel;
            }
            String cRole = (String) jsonObject.get("cRole");
            //1.先删除该用户角色在系统中的权限
            PlateUserPermissionExample plateUserPermissionExample = new PlateUserPermissionExample();
            PlateUserPermissionExample.Criteria criteria = plateUserPermissionExample.createCriteria();
            criteria.andCRoleEqualTo(cRole);
            criteria.andCZtEqualTo("1");
            plateUserPermissionMapper.deleteByExample(plateUserPermissionExample);

            Map paramMap = (Map) jsonObject.get("permissionJson");
            Iterator iterator = paramMap.keySet().iterator();
            while (iterator.hasNext()){
                String key = (String) iterator.next();
                boolean value = (boolean) paramMap.get(key);
                String[] cYwlxdmArr = key.split("_");
                String cYwlxdm = cYwlxdmArr[0]+"_"+cYwlxdmArr[1];
                if (true == value){
                    PlateUserPermission plateUserPermission = new PlateUserPermission();
                    plateUserPermission.setcRole(cRole);
                    plateUserPermission.setcYwlxdm(cYwlxdm);
                    plateUserPermission.setcMenudm(key);
                    plateUserPermission.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                    plateUserPermission.setdCjsj(TimeUtil.getTimestamp(new Date()));
                    plateUserPermission.setcZt("1");
                    plateUserPermissionMapper.insert(plateUserPermission);
                }

            }

            returnModel.setFlag(0);
            returnModel.setMsg("保存成功!");
            returnModel.setObject(null);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("保存失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 给用户赋予某个角色【保存用户角色】
     * @param jsonObject
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel saveUserRoleMid(JSONObject jsonObject) {
        System.out.println(jsonObject);
        try{
            if (jsonObject.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("保存失败，参数传递错误!");
                returnModel.setObject(null);
                return returnModel;
            }
            String cRole = (String) jsonObject.get("cRole");
            //1.先删除该用户角色在系统中的角色
            PlateUserRoleMidExample plateUserRoleMidExample = new PlateUserRoleMidExample();
            PlateUserRoleMidExample.Criteria criteria = plateUserRoleMidExample.createCriteria();
            criteria.andCRoleEqualTo(cRole);
            criteria.andCZtEqualTo("1");
            plateUserRoleMidMapper.deleteByExample(plateUserRoleMidExample);

            Map paramMap = (Map) jsonObject.get("userJson");
            Iterator iterator = paramMap.keySet().iterator();
            while (iterator.hasNext()){
                String key = (String) iterator.next();
                boolean value = (boolean) paramMap.get(key);
                if (true == value){
                    PlateUserRoleMid plateUserRoleMid = new PlateUserRoleMid();
                    plateUserRoleMid.setcRole(cRole);
                    plateUserRoleMid.setcUserid(key);

                    plateUserRoleMid.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                    plateUserRoleMid.setdCjsj(TimeUtil.getTimestamp(new Date()));
                    plateUserRoleMid.setcZt("1");
                    plateUserRoleMidMapper.insert(plateUserRoleMid);
                }
            }

            returnModel.setFlag(0);
            returnModel.setMsg("保存成功!");
            returnModel.setObject(null);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("保存失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 用户能量总量查询
     * @param jsonObject
     * @return
     */
    @Override
    public ReturnModel selectTGreenNlHz(JSONObject jsonObject) {
        try{
            Map paramMap = jsonObject;
            System.out.println(paramMap);
            List tGreenNlHzList = owerTGreenNlHzMapper.selectTGreenNlHz(paramMap);
            System.out.println(tGreenNlHzList);

            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(tGreenNlHzList);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("保存失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 查询系统参数
     * @param plateCodeXtcs
     * @return
     */
    @Override
    public ReturnModel selectPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs) {
        try{
            PlateCodeXtcsExample plateCodeXtcsExample = new PlateCodeXtcsExample();
            PlateCodeXtcsExample.Criteria criteria = plateCodeXtcsExample.createCriteria();
            if (!(("").equals(plateCodeXtcs.getcKey()) || null == plateCodeXtcs.getcKey())){
                criteria.andCKeyLike(plateCodeXtcs.getcKey());
            }
            List plateCodeXtcsList = plateCodeXtcsMapper.selectByExample(plateCodeXtcsExample);
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateCodeXtcsList);
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("查询失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 新增系统参数
     * @param plateCodeXtcs
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs) {
        try{
            List plateCodeXtcsList;
            PlateUser plateUser1 = new PlateUser();
            //1.判断参数代码是否已存在
            PlateCodeXtcsExample plateCodeXtcsExample = new PlateCodeXtcsExample();
            PlateCodeXtcsExample.Criteria criteria = plateCodeXtcsExample.createCriteria();
            criteria.andCZtEqualTo("1");
            criteria.andCKeyEqualTo(plateCodeXtcs.getcKey());

            plateCodeXtcsList = plateCodeXtcsMapper.selectByExample(plateCodeXtcsExample);
            if (!(plateCodeXtcsList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("新增失败，参数代码已存在!");
                return returnModel;
            }
            //3.新增参数
            plateCodeXtcs.setdCjsj(TimeUtil.getTimestamp(new Date()));
            plateCodeXtcs.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());

            int insertRet = plateCodeXtcsMapper.insert(plateCodeXtcs);
            if (1 != insertRet){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                returnModel.setMsg("新增失败,系统错误!");
                return returnModel;
            }else{
                returnModel.setFlag(0);
                returnModel.setObject(null);
                returnModel.setMsg("新增成功!");
                return  returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setObject(null);
            returnModel.setMsg("新增失败,系统错误!");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 修改系统参数
     * @param plateCodeXtcs
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs) {
        try{
            PlateCodeXtcs plateCodeXtcs1 = plateCodeXtcsMapper.selectByPrimaryKey(plateCodeXtcs.getcKey());
            if (null == plateCodeXtcs1){
                returnModel.setFlag(1);
                returnModel.setMsg("修改失败，没有找到待修改的数据!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateCodeXtcs1.setcValue(plateCodeXtcs.getcValue());
                plateCodeXtcs1.setcBz(plateCodeXtcs.getcBz());
                plateCodeXtcs1.setcZt(plateCodeXtcs.getcZt());
                plateCodeXtcs1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateCodeXtcs1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                plateCodeXtcsMapper.updateByPrimaryKey(plateCodeXtcs1);
                returnModel.setFlag(0);
                returnModel.setMsg("修改成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("修改失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 删除系统参数
     * @param plateCodeXtcs
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs) {
        try{
            if ("".equals(plateCodeXtcs.getcKey())){
                returnModel.setFlag(1);
                returnModel.setMsg("删除失败，参数代码不能为空!");
                returnModel.setObject(null);
                return returnModel;
            }
            PlateCodeXtcs plateCodeXtcs1 = plateCodeXtcsMapper.selectByPrimaryKey(plateCodeXtcs.getcKey());
            if (null == plateCodeXtcs1 || "".equals(plateCodeXtcs1.getcKey())){
                returnModel.setFlag(1);
                returnModel.setMsg("删除用失败，没有找到待删除的数据!");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateCodeXtcsMapper.deleteByPrimaryKey(plateCodeXtcs.getcKey());
                returnModel.setFlag(0);
                returnModel.setMsg("删除成功!");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("删除失败，服务器端错误!");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }


}
