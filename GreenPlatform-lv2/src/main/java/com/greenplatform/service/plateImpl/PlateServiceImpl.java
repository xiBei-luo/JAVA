package com.greenplatform.service.plateImpl;

import com.greenplatform.aop.YwOperationCheckAndLog;
import com.greenplatform.dao.*;
import com.greenplatform.dao.owerMapper.*;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.MD5;
import com.greenplatform.util.returnUtil.ReturnModelHandler;
import com.greenplatform.util.TimeUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    TGreenNlJsnlmxMapper tGreenNlJsnlmxMapper;
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
    @Autowired
    TGreenNlCzjlMapper tGreenNlCzjlMapper;
    @Autowired
    TGreenNlTxjlMapper tGreenNlTxjlMapper;
    @Autowired
    PlateUserBlacklistMapper plateUserBlacklistMapper;
    @Autowired
    OperateTableMapper operateTableMapper;



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
            return ReturnModelHandler.success(plateUserList);
        }catch(Exception e){
            e.printStackTrace();
            return ReturnModelHandler.systemError();
        }
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
            return ReturnModelHandler.success(plateUserList);
        }catch(Exception e){
            e.printStackTrace();
            return ReturnModelHandler.systemError();
        }
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
                return ReturnModelHandler.error("新增用户失败，邮箱已经被注册!");
            }
            //2.判断用户名是否被注册
            criteria.andCLoginnameEqualTo(plateUser.getcLoginname());
            plateUserList = plateUserMapper.selectByExample(plateUserExample);
            if (!(plateUserList.isEmpty())){
                return ReturnModelHandler.error("新增用户失败，用户名已经被注册!");
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
                return ReturnModelHandler.systemError();
            }else{
                return ReturnModelHandler.success(plateUser);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("删除用户失败，用户编号不能为空！");
            }
            PlateUser plateUser1 = plateUserMapper.selectByPrimaryKey(plateUser.getcUserid());
            if (null == plateUser1 || "".equals(plateUser1.getcUserid())){
                return ReturnModelHandler.error("删除用户失败，没有找到待删除的数据!");
            }else{
                plateUserMapper.deleteByPrimaryKey(plateUser.getcUserid());
                return ReturnModelHandler.success(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("重置失败，没有找到待修改的数据!");
            }else{
                plateUser1.setcPassword(MD5.md5("aaaaaa"));
                plateUser1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateUser1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                plateUserMapper.updateByPrimaryKey(plateUser1);
                return ReturnModelHandler.success(plateUser1);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("修改用户失败，没有找到待修改的数据!");
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
                return ReturnModelHandler.success(plateUser1);
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
            return ReturnModelHandler.success(plateCodeDmzList);
        }catch (Exception e){
            e.printStackTrace();
            return ReturnModelHandler.error("操作失败，系统错误");
        }
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
            return ReturnModelHandler.success(plateCodeDmzList);
        }catch (Exception e){
            e.printStackTrace();
            return ReturnModelHandler.error("操作失败,系统错误！");
        }
    }

    @YwOperationCheckAndLog(cCzfs = "D")
    @Override
    public ReturnModel delPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        //1.参数非空判断
        if (("").equals(plateCodeDmz.getcDmlb()) || null == plateCodeDmz.getcDmlb()){
            return ReturnModelHandler.error("操作失败，代码类别不能为空");
        }
        if (("").equals(plateCodeDmz.getcDm()) || null == plateCodeDmz.getcDm()){
            return ReturnModelHandler.error("操作失败，代码不能为空");
        }
        try{
            //1.判断数据是否存在
            PlateCodeDmz plateCodeDmz1 = plateCodeDmzMapper.selectByPrimaryKey(plateCodeDmz.getcDm(),plateCodeDmz.getcDmlb());
            if (null == plateCodeDmz1 || "".equals(plateCodeDmz1)){
                return ReturnModelHandler.error("删除失败，没有找到待删除的数据！");
            }else{
                plateCodeDmzMapper.deleteByPrimaryKey(plateCodeDmz.getcDm(),plateCodeDmz.getcDmlb());
                return ReturnModelHandler.success(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("操作失败，代码类别不能为空");
            }
            if (("").equals(plateCodeDmz.getcDm()) || null == plateCodeDmz.getcDm()){
                return ReturnModelHandler.error("操作失败，代码不能为空");
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
                return ReturnModelHandler.error("指定代码类别下已经有此代码存在！代码类别【\"+plateCodeDmz.getcDmlb()+\"】\"+\",代码值【\"+plateCodeDmz.getcDm()+\"】");
            }else{
                //3-1.新增代码类别数据
                plateCodeDmz.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmz.setdCjsj(TimeUtil.getTimestamp(new Date()));
                plateCodeDmzMapper.insert(plateCodeDmz);
                return ReturnModelHandler.success(plateCodeDmz);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
            return ReturnModelHandler.error("操作失败，代码类别不能为空");
        }
        if (("").equals(plateCodeDmz.getcDm()) || null == plateCodeDmz.getcDm()){
            return ReturnModelHandler.error("操作失败，代码不能为空");
        }
        try{
            //2.判断数据是否存在
            PlateCodeDmz plateCodeDmz1 = plateCodeDmzMapper.selectByPrimaryKey(plateCodeDmz.getcDm(),plateCodeDmz.getcDmlb());
            PlateCodeDmlb plateCodeDmlb1 = plateCodeDmlbMapper.selectByPrimaryKey(plateCodeDmlb.getcDmlb());
            if (null == plateCodeDmz1 || "".equals(plateCodeDmz1)){
                return ReturnModelHandler.error("修改失败，没有找到待修改的数据！");
            }else if(null == plateCodeDmlb1 || "".equals(plateCodeDmlb1)){
                return ReturnModelHandler.error("修改失败，没有找到待修改的数据！");
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
                return ReturnModelHandler.success(plateCodeDmz);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
            Map permissionFlMap = new HashMap();//具备哪些类型的权限（系统应用/业务应用）
            permissionFlMap.put("C_YWGN",false);
            permissionFlMap.put("C_PLATE",false);

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
                    PlateUserPermission plateUserPermission = (PlateUserPermission) plateUserPermissionmenuList.get(j);
                    PlateYwLxMenuExample plateYwLxMenuExample = new PlateYwLxMenuExample();
                    PlateYwLxMenuExample.Criteria criteria2 = plateYwLxMenuExample.createCriteria();
                    criteria2.andCMenudmEqualTo(plateUserPermission.getcMenudm());
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

                    if ("C_YWGN".equals(plateUserPermission.getcYwlxdm())){
                        permissionFlMap.put("C_YWGN",true);
                    }

                    if ("C_PLATE".equals(plateUserPermission.getcYwlxdm())){
                        permissionFlMap.put("C_PLATE",true);
                    }

                }
                loginuserYwqxMap.put("plateYwLxMenuList",plateYwLxMenuList);
            }
            loginuserYwqxMap.put("permissionFlMap",permissionFlMap);
            return ReturnModelHandler.success(loginuserYwqxMap);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    @Override
    public ReturnModel selectTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        List tGreenSpmxList;
        try {
            TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
            tGreenSpSpmxExample.setOrderByClause("n_spjg");
            tGreenSpmxList = tGreenSpSpmxMapper.selectByExample(tGreenSpSpmxExample);
            return ReturnModelHandler.success(tGreenSpmxList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel insertTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try{
            //1.参数非空判断
            if (("").equals(tGreenSpSpmx.getcSpmc()) || null == tGreenSpSpmx.getcSpmc()){
                return ReturnModelHandler.error("操作失败，商品名称不能为空");
            }
            if (("").equals(tGreenSpSpmx.getnSpjg()) || null == tGreenSpSpmx.getnSpjg()){
                return ReturnModelHandler.error("操作失败，商品价格不能为空");
            }

            //2.商品名称是否有重复
            TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
            TGreenSpSpmxExample.Criteria criteria = tGreenSpSpmxExample.createCriteria();
            criteria.andCSpmcEqualTo(tGreenSpSpmx.getcSpmc());
            List tGreenSpSpmxList = tGreenSpSpmxMapper.selectByExample(tGreenSpSpmxExample);
            if (!(tGreenSpSpmxList.isEmpty())){
                return ReturnModelHandler.error("商品名称不能重复，指定商品名称已存在！商品名称【"+tGreenSpSpmx.getcSpmc()+"]");
            }
            //3.执行新增
            tGreenSpSpmx.setcSpbh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenSpSpmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenSpSpmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenSpSpmxMapper.insert(tGreenSpSpmx);
            return ReturnModelHandler.success(tGreenSpSpmx);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    @YwOperationCheckAndLog(cCzfs = "D")
    @Override
    public ReturnModel delTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try{
            TGreenSpSpmx tGreenSpSpmx1 = tGreenSpSpmxMapper.selectByPrimaryKey(tGreenSpSpmx.getcSpbh());
            if (null == tGreenSpSpmx1 || "".equals(tGreenSpSpmx1)){
                return ReturnModelHandler.error("操作失败，没有找到待删除的数据！");
            }else{
                tGreenSpSpmxMapper.deleteByPrimaryKey(tGreenSpSpmx.getcSpbh());
                return ReturnModelHandler.success(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }

    }

    @YwOperationCheckAndLog(cCzfs = "U")
    @Override
    public ReturnModel updTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        try {
            //1.判断修改数据是否存在
            TGreenSpSpmx tGreenSpSpmx1 = tGreenSpSpmxMapper.selectByPrimaryKey(tGreenSpSpmx.getcSpbh());
            if (null == tGreenSpSpmx1 || "".equals(tGreenSpSpmx1)){
                return ReturnModelHandler.error("操作失败，没有找到待删除的数据！");
            }else{
                tGreenSpSpmx1.setcSpmc(tGreenSpSpmx.getcSpmc());
                tGreenSpSpmx1.setnSpjg(tGreenSpSpmx.getnSpjg());
                tGreenSpSpmx1.setcSpms(tGreenSpSpmx.getcSpms());
                tGreenSpSpmx1.setcImgurl(tGreenSpSpmx.getcImgurl());
                tGreenSpSpmx1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                tGreenSpSpmx1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                tGreenSpSpmxMapper.updateByPrimaryKey(tGreenSpSpmx1);
                return ReturnModelHandler.success(tGreenSpSpmx1);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
            return ReturnModelHandler.success(tGreenRwRwmxList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
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
            return ReturnModelHandler.success(plateUserRoleList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("新增用户角色失败，用户角色不能为空!");
            }else if(("").equals(plateUserRole.getcRolename()) || null == plateUserRole.getcRolename()){
                return ReturnModelHandler.error("新增用户角色失败，用户角色名称不能为空!");
            }else{
                PlateUserRole plateUserRole1 = plateUserRoleMapper.selectByPrimaryKey(plateUserRole.getcRole());
                if (!(("").equals(plateUserRole1) || null == plateUserRole1)){
                    return ReturnModelHandler.error("新增用户角色失败，用户角色已存在!");
                }else{
                    plateUserRole.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                    plateUserRole.setdCjsj(TimeUtil.getTimestamp(new Date()));
                    plateUserRoleMapper.insert(plateUserRole);
                    return ReturnModelHandler.success(plateUserRole);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("修改用户角色失败，用户角色不能为空!");
            }

            PlateUserRole plateUserRole1 = plateUserRoleMapper.selectByPrimaryKey(plateUserRole.getcRole());
            if (null == plateUserRole1){
                return ReturnModelHandler.error("修改用户角色失败，没有找到待修改的数据!");
            }else{
                plateUserRole1.setcRolename(plateUserRole.getcRolename());
                plateUserRole1.setcZt(plateUserRole.getcZt());
                plateUserRole1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateUserRole1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                plateUserRoleMapper.updateByPrimaryKey(plateUserRole1);
                return ReturnModelHandler.success(plateUserRole1);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("删除失败，用户角色标识符不能为空!");
            }
            PlateUserRole plateUserRole1 = plateUserRoleMapper.selectByPrimaryKey(plateUserRole.getcRole());
            if (null == plateUserRole1 || "".equals(plateUserRole1.getcRole())){
                return ReturnModelHandler.error("删除失败，没有找到待删除的数据!");
            }else{
                plateUserRoleMapper.deleteByPrimaryKey(plateUserRole.getcRole());
                return ReturnModelHandler.success(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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

            return ReturnModelHandler.success(plateYwLxMenuList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("新增应用失败，业务类型代码不能为空!");
            }else if(("").equals(plateYwLxMenu.getcMenudm()) || null == plateYwLxMenu.getcMenudm()){
                return ReturnModelHandler.error("新增应用失败，菜单功能代码代码不能为空!");
            }else{
                PlateYwLxMenuExample plateYwLxMenuExample = new PlateYwLxMenuExample();
                PlateYwLxMenuExample.Criteria criteria = plateYwLxMenuExample.createCriteria();
                criteria.andCMenudmEqualTo(plateYwLxMenu.getcMenudm());
                criteria.andCZtEqualTo("1");
                List plateYwLxMenuList = plateYwLxMenuMapper.selectByExample(plateYwLxMenuExample);
                if (!(plateYwLxMenuList.isEmpty())){
                    return ReturnModelHandler.error("新增应用失败，菜单功能代码已存在!");
                }
                plateYwLxMenu.setdCjsj(TimeUtil.getTimestamp(new Date()));
                plateYwLxMenu.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                plateYwLxMenuMapper.insert(plateYwLxMenu);
                return  ReturnModelHandler.success(plateYwLxMenu);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("修改应用失败，业务类型代码不能为空!");
            }else if(("").equals(plateYwLxMenu.getcMenudm()) || null == plateYwLxMenu.getcMenudm()){
                return ReturnModelHandler.error("修改应用失败，菜单功能代码代码不能为空!");
            }else{
                PlateYwLxMenu plateYwLxMenu1 = plateYwLxMenuMapper.selectByPrimaryKey(plateYwLxMenu.getcMenudm());
                if (null == plateYwLxMenu1){
                    return ReturnModelHandler.error("修改应用失败，没有找到待修改的数据!");
                }else{
                    plateYwLxMenu1.setcMenumc(plateYwLxMenu.getcMenumc());
                    plateYwLxMenu1.setcMenujc(plateYwLxMenu.getcMenujc());
                    plateYwLxMenu1.setcRuncommand(plateYwLxMenu.getcRuncommand());
                    plateYwLxMenu1.setcSort(plateYwLxMenu.getcSort());

                    plateYwLxMenu1.setcZt(plateYwLxMenu.getcZt());
                    plateYwLxMenu1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                    plateYwLxMenu1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                    plateYwLxMenuMapper.updateByPrimaryKey(plateYwLxMenu1);
                    return ReturnModelHandler.success(plateYwLxMenu1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("删除应用失败，菜单功能代码代码不能为空!");
            }else{
                PlateYwLxMenu plateYwLxMenu1 = plateYwLxMenuMapper.selectByPrimaryKey(plateYwLxMenu.getcMenudm());
                if (null == plateYwLxMenu1){
                    return ReturnModelHandler.error("删除应用失败，没有找到待删除的数据!");
                }else{
                    plateYwLxMenuMapper.deleteByPrimaryKey(plateYwLxMenu1.getcMenudm());
                    return ReturnModelHandler.success(null);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
            return ReturnModelHandler.success(returnList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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

            return ReturnModelHandler.success(returnList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("保存失败，参数传递错误!");
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
            return ReturnModelHandler.success(paramMap);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
        try{
            if (jsonObject.isEmpty()){
                return ReturnModelHandler.error("保存失败，参数传递错误!");
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

            return ReturnModelHandler.success(paramMap);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
            List tGreenNlHzList = owerTGreenNlHzMapper.selectTGreenNlHz(paramMap);

            return ReturnModelHandler.success(tGreenNlHzList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
            return ReturnModelHandler.success(plateCodeXtcsList);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("新增失败，参数代码已存在!");
            }
            //3.新增参数
            plateCodeXtcs.setdCjsj(TimeUtil.getTimestamp(new Date()));
            plateCodeXtcs.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());

            int insertRet = plateCodeXtcsMapper.insert(plateCodeXtcs);
            if (1 != insertRet){
                return ReturnModelHandler.systemError();
            }else{
                return ReturnModelHandler.success(plateCodeXtcs);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("修改失败，没有找到待修改的数据!");
            }else{
                plateCodeXtcs1.setcValue(plateCodeXtcs.getcValue());
                plateCodeXtcs1.setcBz(plateCodeXtcs.getcBz());
                plateCodeXtcs1.setcZt(plateCodeXtcs.getcZt());
                plateCodeXtcs1.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateCodeXtcs1.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());

                plateCodeXtcsMapper.updateByPrimaryKey(plateCodeXtcs1);
                return ReturnModelHandler.success(plateCodeXtcs1);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
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
                return ReturnModelHandler.error("删除失败，参数代码不能为空!");
            }
            PlateCodeXtcs plateCodeXtcs1 = plateCodeXtcsMapper.selectByPrimaryKey(plateCodeXtcs.getcKey());
            if (null == plateCodeXtcs1 || "".equals(plateCodeXtcs1.getcKey())){
                return ReturnModelHandler.error("删除用失败，没有找到待删除的数据!");
            }else{
                plateCodeXtcsMapper.deleteByPrimaryKey(plateCodeXtcs.getcKey());
                return ReturnModelHandler.success(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    /**
     * 用户能量充值
     * 业务描述：验证参数=>修改用户能量表（明细表新增一条记录，汇总表修改值）=>充值记录表新增一条记录
     * @param jsonObject
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel insertTGreenNlCzjl(JSONObject jsonObject) {
        try{
            String nFkje = jsonObject.getString("nFkje");//充值金额
            String nSknl = nFkje;//充值能量

            PlateUser plateUserOp = GetcurrentLoginUser.getCurrentUser();//当前登陆人

            //参数非空验证
            if (null == jsonObject.getString("cUserid") || "".equals(jsonObject.getString("cUserid"))){
                return ReturnModelHandler.error("操作失败，到账账户不能为空！");
            }
            if (null == jsonObject.getString("cPhone") || "".equals(jsonObject.getString("cPhone"))){
                return ReturnModelHandler.error("操作失败，到账账户电话号码不能为空！");
            }
            if (19 != jsonObject.getString("dFksj").length()){
                return ReturnModelHandler.error("操作失败，付款时间格式有误！格式为【2019-01-01 12:00:00】");
            }

            if (19 != jsonObject.getString("dSksj").length()){
                return ReturnModelHandler.error("操作失败，收款时间格式有误！格式为【2019-01-01 12:00:00】");
            }

            PlateUser plateUser = plateUserMapper.selectByPrimaryKey(jsonObject.getString("cUserid"));
            //参数核对
            if (!"1".equals(plateUser.getcRyzt())){
                return ReturnModelHandler.error("操作失败，充值账户人员状态无效！");
            }
            if (!"1".equals(plateUser.getcZt())){
                return ReturnModelHandler.error("操作失败，充值账户人员状态无效！");
            }
            if (!"2".equals(plateUser.getcRylb())){
                return ReturnModelHandler.error("操作失败，只能为前端平台用户充值！");
            }
            if (!"1".equals(plateUser.getcIssmz())){
                return ReturnModelHandler.error("操作失败，充值账户人员还未实名制！");
            }
            if (!"1".equals(plateUser.getcRyxz())){
                return ReturnModelHandler.error("操作失败，充值账户人员为平台黑名单用户！");
            }
            if (!plateUser.getcPhone().equals(jsonObject.getString("cPhone"))){
                return ReturnModelHandler.error("操作失败，充值账户与人员信息不一致,请核对充值账户！");
            }
            /*if (!plateUser.getcZjhm().equals(jsonObject.getString("cZjhm"))){
                return ReturnModelHandler.error("操作失败，充值账户与人员信息不一致,请核对充值账户！");
            }
            if (!plateUser.getcEmail().equals(jsonObject.getString("cEmail"))){
                return ReturnModelHandler.error("操作失败，充值账户与人员信息不一致,请核对充值账户！");
            }*/
            if (!plateUser.getcUsername().equals(jsonObject.getString("cUsername"))){
                return ReturnModelHandler.error("操作失败，充值账户与人员信息不一致,请核对充值账户！");
            }

            PlateUser plateUserCz = plateUser;//充值账户

            //增加能量明细
            TGreenNlZjnlmx tGreenNlZjnlmx = new TGreenNlZjnlmx();//增加能量明细表
            tGreenNlZjnlmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenNlZjnlmx.setcUserid(plateUserCz.getcUserid());
            tGreenNlZjnlmx.setnZjnl(new BigDecimal(nFkje));
            tGreenNlZjnlmx.setdZjsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlZjnlmx.setcZjyy("5");//增加原因：充值
            tGreenNlZjnlmx.setcZt("1");
            tGreenNlZjnlmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlZjnlmx.setcCjuser(plateUserOp.getcUserid());
            tGreenNlZjnlmxMapper.insert(tGreenNlZjnlmx);

            //修改能量汇总
            TGreenNlHz tGreenNlHz = tGreenNlHzMapper.selectByPrimaryKey(plateUserCz.getcUserid());//能量汇总表
            tGreenNlHz.setnNlhz(tGreenNlHz.getnNlhz().add(new BigDecimal(nSknl)));//充值金额对应能量比目前为  1:1
            tGreenNlHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlHz.setcXguser(plateUserOp.getcUserid());
            tGreenNlHzMapper.updateByPrimaryKey(tGreenNlHz);

            //新增充值记录
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dFksj = sdf.parse(jsonObject.getString("dFksj"));//格式化付款时间
            Date dSksj = sdf.parse(jsonObject.getString("dSksj"));//格式化收款时间

            TGreenNlCzjl tGreenNlCzjl = new TGreenNlCzjl();
            tGreenNlCzjl.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenNlCzjl.setcUserid(plateUserCz.getcUserid());

            tGreenNlCzjl.setcFkzh(jsonObject.getString("cFkzh"));//付款账户
            tGreenNlCzjl.setcSkzh(jsonObject.getString("cSkzh"));//收款账户

            tGreenNlCzjl.setcFkfs(jsonObject.getString("cFkfs"));//付款方式
            tGreenNlCzjl.setcSkfs(jsonObject.getString("cSkfs"));//收款账户

            tGreenNlCzjl.setdFksj(TimeUtil.getTimestamp(dFksj));//付款时间
            tGreenNlCzjl.setdSksj(TimeUtil.getTimestamp(dSksj));//收款时间

            tGreenNlCzjl.setcFkyh(jsonObject.getString("cFkyh"));//付款银行
            tGreenNlCzjl.setcSkyh(jsonObject.getString("cSkyh"));//收款银行

            tGreenNlCzjl.setcFkkh(jsonObject.getString("cFkkh"));//付款卡号
            tGreenNlCzjl.setcSkkh(jsonObject.getString("cSkkh"));//收款卡号

            tGreenNlCzjl.setcFksfcg(jsonObject.getString("cFksfcg"));//付款是否成功
            tGreenNlCzjl.setcSksfcg(jsonObject.getString("cSksfcg"));//收款是否成功

            tGreenNlCzjl.setcFkdh(jsonObject.getString("cFkdh"));//付款单号
            tGreenNlCzjl.setcSkdh(jsonObject.getString("cSkdh"));//收款单号

            tGreenNlCzjl.setnSknl(new BigDecimal(nSknl));//收款能量

            tGreenNlCzjl.setnFkje(new BigDecimal(nFkje));//付款金额

            tGreenNlCzjl.setcBz(jsonObject.getString("cBz"));//备注
            tGreenNlCzjl.setcZt("1");
            tGreenNlCzjl.setcCjuser(plateUserOp.getcUserid());
            tGreenNlCzjl.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlCzjlMapper.insert(tGreenNlCzjl);

            return ReturnModelHandler.success(null);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }


    /**
     * 用户能量提现
     * @param jsonObject
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel insertTGreenNlTxjl(JSONObject jsonObject) {
        try{
            String nFknl = jsonObject.getString("nFknl");//付款能量
            String nSkje = nFknl;//收款金额

            PlateUser plateUserOp = GetcurrentLoginUser.getCurrentUser();//当前登陆人

            //参数非空验证
            if (null == jsonObject.getString("cUserid") || "".equals(jsonObject.getString("cUserid"))){
                return ReturnModelHandler.error("操作失败，到账账户不能为空！");
            }
            if (null == jsonObject.getString("cPhone") || "".equals(jsonObject.getString("cPhone"))){
                return ReturnModelHandler.error("操作失败，到账账户电话号码不能为空！");
            }
            if (19 != jsonObject.getString("dFksj").length()){
                return ReturnModelHandler.error("操作失败，付款时间格式有误！格式为【2019-01-01 12:00:00】");
            }

            if (19 != jsonObject.getString("dSksj").length()){
                return ReturnModelHandler.error("操作失败，收款时间格式有误！格式为【2019-01-01 12:00:00】");
            }

            PlateUser plateUser = plateUserMapper.selectByPrimaryKey(jsonObject.getString("cUserid"));
            //参数核对
            if (!("1".equals(plateUser.getcRyzt()))){
                return ReturnModelHandler.error("操作失败，充值账户人员状态无效！");
            }
            if (!("1".equals(plateUser.getcZt()))){
                return ReturnModelHandler.error("操作失败，充值账户人员状态无效！");
            }
            if (!("2".equals(plateUser.getcRylb()))){
                return ReturnModelHandler.error("操作失败，只能为前端平台用户充值！");
            }
            if (!("1".equals(plateUser.getcIssmz()))){
                return ReturnModelHandler.error("操作失败，充值账户人员还未实名制！");
            }
            if (!("1".equals(plateUser.getcRyxz()))){
                return ReturnModelHandler.error("操作失败，充值账户人员为平台黑名单用户！");
            }
            if (!(plateUser.getcPhone().equals(jsonObject.getString("cPhone")))){
                return ReturnModelHandler.error("操作失败，充值账户与人员信息不一致,请核对充值账户！");
            }
            if (!(plateUser.getcUsername().equals(jsonObject.getString("cUsername")))){
                return ReturnModelHandler.error("操作失败，充值账户与人员信息不一致,请核对充值账户！");
            }

            PlateUser plateUserCz = plateUser;//充值账户

            //减少能量明细
            TGreenNlJsnlmx tGreenNlJsnlmx = new TGreenNlJsnlmx();//减少能量明细表
            tGreenNlJsnlmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenNlJsnlmx.setcUserid(plateUserCz.getcUserid());
            tGreenNlJsnlmx.setnJssl(new BigDecimal(nFknl));
            tGreenNlJsnlmx.setdJssj(TimeUtil.getTimestamp(new Date()));
            tGreenNlJsnlmx.setcJsyy("C_NL_JSYY_2");//减少原因：充值
            tGreenNlJsnlmx.setcZt("1");
            tGreenNlJsnlmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlJsnlmx.setcCjuser(plateUserOp.getcUserid());
            tGreenNlJsnlmxMapper.insert(tGreenNlJsnlmx);

            //修改能量汇总
            TGreenNlHz tGreenNlHz = tGreenNlHzMapper.selectByPrimaryKey(plateUserCz.getcUserid());//能量汇总表
            tGreenNlHz.setnNlhz(tGreenNlHz.getnNlhz().subtract(new BigDecimal(nSkje)));//充值金额对应能量比目前为  1:1
            tGreenNlHz.setdXgsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlHz.setcXguser(plateUserOp.getcUserid());
            tGreenNlHzMapper.updateByPrimaryKey(tGreenNlHz);

            //新增提现记录
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dFksj = sdf.parse(jsonObject.getString("dFksj"));//格式化付款时间
            Date dSksj = sdf.parse(jsonObject.getString("dSksj"));//格式化收款时间

            TGreenNlTxjl tGreenNlTxjl = new TGreenNlTxjl();
            tGreenNlTxjl.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenNlTxjl.setcUserid(plateUserCz.getcUserid());

            tGreenNlTxjl.setcFkzh(jsonObject.getString("cFkzh"));//付款账户
            tGreenNlTxjl.setcSkzh(jsonObject.getString("cSkzh"));//收款账户

            tGreenNlTxjl.setcFkfs(jsonObject.getString("cFkfs"));//付款方式
            tGreenNlTxjl.setcSkfs(jsonObject.getString("cSkfs"));//收款账户

            tGreenNlTxjl.setdFksj(TimeUtil.getTimestamp(dFksj));//付款时间
            tGreenNlTxjl.setdSksj(TimeUtil.getTimestamp(dSksj));//收款时间

            tGreenNlTxjl.setcFkyh(jsonObject.getString("cFkyh"));//付款银行
            tGreenNlTxjl.setcSkyh(jsonObject.getString("cSkyh"));//收款银行

            tGreenNlTxjl.setcFkkh(jsonObject.getString("cFkkh"));//付款卡号
            tGreenNlTxjl.setcSkkh(jsonObject.getString("cSkkh"));//收款卡号

            tGreenNlTxjl.setcFksfcg(jsonObject.getString("cFksfcg"));//付款是否成功
            tGreenNlTxjl.setcSksfcg(jsonObject.getString("cSksfcg"));//收款是否成功

            tGreenNlTxjl.setcFkdh(jsonObject.getString("cFkdh"));//付款单号
            tGreenNlTxjl.setcSkdh(jsonObject.getString("cSkdh"));//收款单号

            tGreenNlTxjl.setnFknl(new BigDecimal(nFknl));//付款能量

            tGreenNlTxjl.setnSkje(new BigDecimal(nSkje));//收款金额

            tGreenNlTxjl.setcBz(jsonObject.getString("cBz"));//备注
            tGreenNlTxjl.setcZt("1");
            tGreenNlTxjl.setcCjuser(plateUserOp.getcUserid());
            tGreenNlTxjl.setdCjsj(TimeUtil.getTimestamp(new Date()));
            tGreenNlTxjlMapper.insert(tGreenNlTxjl);

            return ReturnModelHandler.success(null);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }


    /**
     * 用户添加或移除黑名单(黑名单表增加一条记录，用户表修改状态)
     * @param jsonObject
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "I")
    public ReturnModel insertPlateuserBlacklist(JSONObject jsonObject) {
        try{
            if (null == jsonObject.getString("cUserid") || "".equals(jsonObject.getString("cUserid"))){
                return ReturnModelHandler.error("操作失败,用户编号不能为空");
            }
            if (null == jsonObject.getString("cCzyy") || "".equals(jsonObject.getString("cCzyy"))){
                return ReturnModelHandler.error("操作失败,操作原因不能为空");
            }
            if (null == jsonObject.getString("cCzfs") || "".equals(jsonObject.getString("cCzfs"))){
                return ReturnModelHandler.error("操作失败,操作方式不能为空");
            }

            //修改用户主表状态
            PlateUser plateUser = plateUserMapper.selectByPrimaryKey(jsonObject.getString("cUserid"));
            if ("add".equals(jsonObject.getString("cCzfs"))){
                plateUser.setcRyxz("-1");//黑名单
                plateUser.setcRyzt("0");//人员状态修改为无效
            }else if ("remove".equals(jsonObject.getString("cCzfs"))){
                plateUser.setcRyxz("1");//移除黑名单
                plateUser.setcRyzt("1");//人员状态修改为有效
            }

            plateUser.setdXgsj(TimeUtil.getTimestamp(new Date()));
            plateUser.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            plateUserMapper.updateByPrimaryKey(plateUser);

            //黑名单表新增一条记录
            PlateUserBlacklist plateUserBlacklist = new PlateUserBlacklist();
            plateUserBlacklist.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
            plateUserBlacklist.setcUserid(plateUser.getcUserid());
            plateUserBlacklist.setcCzfs(jsonObject.getString("cCzfs"));
            plateUserBlacklist.setcCzr(GetcurrentLoginUser.getCurrentUser().getcUserid());
            plateUserBlacklist.setdCzsj(TimeUtil.getTimestamp(new Date()));
            plateUserBlacklist.setcCzyy(jsonObject.getString("cCzyy"));
            plateUserBlacklist.setcZt("1");
            plateUserBlacklist.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            plateUserBlacklist.setdCjsj(TimeUtil.getTimestamp(new Date()));
            plateUserBlacklistMapper.insert(plateUserBlacklist);
            return ReturnModelHandler.success(plateUserBlacklist);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }


    /**
     * 修改管理员密码
     * @param cPassword
     * @return
     */
    @Override
    @YwOperationCheckAndLog(cCzfs = "U")
    public ReturnModel updPlateUserPass(String cPassword) {
        try{
            PlateUser plateUser = GetcurrentLoginUser.getCurrentUser();
            plateUser.setcPassword(MD5.md5(cPassword));
            plateUser.setdXgsj(TimeUtil.getTimestamp(new Date()));
            plateUser.setcXguser(plateUser.getcUserid());
            plateUserMapper.updateByPrimaryKey(plateUser);

            return ReturnModelHandler.success(plateUser);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ReturnModelHandler.systemError();
        }
    }

    @Override
    public ReturnModel bakupLog() {
        //备份日志表
        String newTbleName = "plate_log_"+(TimeUtil.getLocalDate(new Date()).substring(0,10).replace("-",""));//新备份表名称
        Map newTblMap = new HashMap();
        newTblMap.put("oldTable","plate_log");
        newTblMap.put("newTable",newTbleName);
        operateTableMapper.createNewTable(newTblMap);//创建新表
        Map paramsMap = new HashMap();
        paramsMap.put("newTable",newTbleName);
        paramsMap.put("oldTable","plate_log");
        operateTableMapper.insertNewTblData(paramsMap);//新表插入数据




        //清空日志表
        plateLogMapper.deleteByExample(new PlateLogExample());
        return ReturnModelHandler.success(null);
    }


}
