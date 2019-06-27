package com.greenplatform.service.plateImpl;

import com.greenplatform.aop.OperationLog;
import com.greenplatform.dao.*;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.util.GetcurrentLoginUser;
import com.greenplatform.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class PlateServiceImpl implements PlateService {

    /*ReturnModel returnModel = new ReturnModel();*/
    /*@Autowired
    PlateDao plateDao;*/
    @Autowired
    PlateUserMapper plateUserMapper;
    @Autowired
    TGreenNlZjnlmxMapper tGreenNlZjnlmxMapper;
    @Autowired
    TGreenNlHzMapper tGreenNlHzMapper;
    @Autowired
    PlateCodeDmlbMapper plateCodeDmlbMapper;
    @Autowired
    PlateCodeDmzMapper plateCodeDmzMapper;
    @Autowired
    PlateLogMapper plateLogMapper;
    @Autowired
    TGreenSpSpmxMapper tGreenSpSpmxMapper;
    @Autowired
    TGreenRwRwmxMapper tGreenRwRwmxMapper;

    ReturnModel returnModel = new ReturnModel();


    /**
     * 登陆
     * @param plateUser
     * @param session
     * @return
     */
    @Override
    public ReturnModel selectPlateuser(PlateUser plateUser, HttpSession session) {
        List plateUserList;
        PlateUserExample plateUserExample = new PlateUserExample();
        PlateUserExample.Criteria criteria = plateUserExample.createCriteria();

        //1、用户是否存在
        plateUser.setcPassword(MD5.md5(plateUser.getcPassword()));
        criteria.andCLoginnameEqualTo(plateUser.getcLoginname());
        plateUserList = plateUserMapper.selectByExample(plateUserExample);
        if (plateUserList.isEmpty()){
            returnModel.setFlag(1);
            returnModel.setMsg("用户不存在！");
            returnModel.setObject(null);
            return returnModel;
        }else{
            //2.登陆密码是否正确
            criteria.andCPasswordEqualTo(plateUser.getcPassword());
            criteria.andCRylbEqualTo(plateUser.getcRylb());
            plateUserList = plateUserMapper.selectByExample(plateUserExample);
            if (plateUserList.isEmpty()){
                returnModel.setFlag(1);
                returnModel.setMsg("登录密码错误");
                returnModel.setObject(null);
                return returnModel;
            }else{
                returnModel.setFlag(0);
                returnModel.setMsg("登陆成功");
                returnModel.setObject(plateUserList);
                PlateUser plateUser1 = (PlateUser) plateUserList.get(0);
                session.setAttribute("loginUser",plateUser1);
                return returnModel;
            }
        }
    }

    /**
     * 查询
     * @param plateUser
     * @return
     */
    @Override
    public ReturnModel selectPlateuser(PlateUser plateUser) {
        List plateUserList;
        PlateUserExample plateUserExample = new PlateUserExample();
        PlateUserExample.Criteria criteria = plateUserExample.createCriteria();

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
     * 新增
     * @param plateUser
     * @param session
     * @return
     */
    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateuser(PlateUser plateUser, HttpSession session) {
        try{
            List plateUserList;
            PlateUser plateUser1 = new PlateUser();
            //1.判断邮箱或用户名是否被注册

            PlateUserExample plateUserExample = new PlateUserExample();
            PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
            criteria.andCRylbEqualTo(plateUser.getcRylb());
            criteria.andCEmailEqualTo(plateUser.getcEmail());

            plateUserList = plateUserMapper.selectByExample(plateUserExample);
            if (!(plateUserList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                if ("1".equals(plateUser.getcRylb())){
                    returnModel.setMsg("新增用户失败，邮箱已经被注册!");
                }else {
                    returnModel.setMsg("注册失败，邮箱已经被注册!");
                }
                return returnModel;
            }
            //2.判断用户名是否被注册
            PlateUserExample plateUserExample1 = new PlateUserExample();
            plateUserExample1.createCriteria().andCLoginnameEqualTo(plateUser.getcLoginname());
            plateUserList = plateUserMapper.selectByExample(plateUserExample1);
            if (!(plateUserList.isEmpty())){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                if ("1".equals(plateUser.getcRylb())){
                    returnModel.setMsg("新增用户失败，用户名已经被注册!");
                }else {
                    returnModel.setMsg("注册失败，用户名已经被注册!");
                }
                return returnModel;
            }
            //3.新增用户（注册用户 1平台用户  2前端用户）
            String majorKey = UUID.randomUUID().toString().replaceAll("-", "");
            plateUser.setcPassword(MD5.md5(plateUser.getcPassword()));
            plateUser.setcRyzt("1");
            plateUser.setcUserid(majorKey);
            plateUser.setdCjsj(getTimestamp(new Date()));
            if("1".equals(plateUser.getcRylb())){
                plateUser.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            }else{
                plateUser.setcCjuser(majorKey);
                plateUser.setcRydj("1");
            }
            int insertRet = plateUserMapper.insert(plateUser);
            if (1 != insertRet){
                returnModel.setFlag(1);
                returnModel.setObject(null);
                if ("1".equals(plateUser.getcRylb())){
                    returnModel.setMsg("新增用户失败,系统错误!");
                }else {
                    returnModel.setMsg("注册失败，系统错误!");
                }
                return returnModel;
            }else{
                //平台用户注册成功则对应账户账户增加100能量
                if ("2".equals(plateUser.getcRylb())){
                    TGreenNlZjnlmx tGreenNlZjnlmx = new TGreenNlZjnlmx();
                    tGreenNlZjnlmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
                    tGreenNlZjnlmx.setcUserid(plateUser.getcUserid());
                    tGreenNlZjnlmx.setcZjnl("100");
                    tGreenNlZjnlmx.setdZjsj(getTimestamp(new Date()));
                    tGreenNlZjnlmx.setcZjyy("1");
                    tGreenNlZjnlmx.setcZt("1");
                    tGreenNlZjnlmx.setcCjuser(plateUser.getcUserid());
                    tGreenNlZjnlmx.setdCjsj(getTimestamp(new Date()));

                    TGreenNlHz tGreenNlHz = new TGreenNlHz();
                    tGreenNlHz.setcUserid(plateUser.getcUserid());
                    tGreenNlHz.setcNlhz("100");
                    tGreenNlHz.setcZt("1");
                    tGreenNlHz.setcCjuser(plateUser.getcUserid());
                    tGreenNlHz.setdCjsj(getTimestamp(new Date()));

                    tGreenNlZjnlmxMapper.insert(tGreenNlZjnlmx);
                    tGreenNlHzMapper.insert(tGreenNlHz);
                    session.setAttribute("loginUser",plateUser);//前端用户注册成功后写入session
                    returnModel.setFlag(0);
                    returnModel.setObject(null);
                    returnModel.setMsg("注册成功!");
                }else{
                    returnModel.setFlag(0);
                    returnModel.setObject(null);
                    returnModel.setMsg("新增用户成功!");
                }
                return  returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setObject(null);
            if ("1".equals(plateUser.getcRylb())){
                returnModel.setMsg("新增用户失败,系统错误!");
            }else {
                returnModel.setMsg("注册失败，系统错误!");
            }
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

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

    @OperationLog(cCzfs = "U")
    @Override//重置密码
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
                plateUser1.setdXgsj(getTimestamp(new Date()));
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
                plateUser.setcUsername(plateUser1.getcUsername());
                plateUser.setcLoginname(plateUser1.getcLoginname());
                plateUser.setcPhone(plateUser1.getcPhone());//姓名，登录名，电话号码不能修改
                plateUser.setcRyzt(plateUser1.getcRyzt());
                plateUser.setcRylb(plateUser1.getcRylb());

                plateUser.setdXgsj(getTimestamp(new Date()));
                plateUser.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateUserMapper.updateByPrimaryKey(plateUser);
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


    //查询代码类别
    @Override
    public ReturnModel selectPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        List plateCodeDmlbList;
        try {
            plateCodeDmlbList = plateCodeDmlbMapper.selectByExample(new PlateCodeDmlbExample());
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(plateCodeDmlbList);
        }catch (Exception e){
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        try{
            //1.判断代码类别是否已存在
            PlateCodeDmlb plateCodeDmlb1 = plateCodeDmlbMapper.selectByPrimaryKey(plateCodeDmlb.getcDmlb());
            if(!(null == plateCodeDmlb1 || "".equals(plateCodeDmlb1))){
                returnModel.setFlag(1);
                returnModel.setMsg("新增出错，代码类别已存在！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //2.插入值
                plateCodeDmlb.setdCjsj(getTimestamp(new Date()));
                plateCodeDmlb.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmlbMapper.insert(plateCodeDmlb);
                returnModel.setFlag(0);
                returnModel.setMsg("新增成功！");
                returnModel.setObject(null);
                return returnModel;
            }
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
    public ReturnModel delPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        try{
            //1.判断数据是否存在
            PlateCodeDmlb plateCodeDmlb1 = plateCodeDmlbMapper.selectByPrimaryKey(plateCodeDmlb.getcDmlb());
            if (null == plateCodeDmlb1 || "".equals(plateCodeDmlb1)){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，待删除的数据不存在！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //2.执行删除
                plateCodeDmlbMapper.deleteByPrimaryKey(plateCodeDmlb.getcDmlb());
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
    public ReturnModel updPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb) {
        try{
            //1.判断数据是否存在
            PlateCodeDmlb plateCodeDmlb1 = plateCodeDmlbMapper.selectByPrimaryKey(plateCodeDmlb.getcDmlb());
            if (null == plateCodeDmlb1 || "".equals(plateCodeDmlb1)){
                returnModel.setFlag(1);
                returnModel.setMsg("操作失败，待修改的数据不存在！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateCodeDmlb.setdXgsj(getTimestamp(new Date()));
                plateCodeDmlb.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmlbMapper.updateByPrimaryKey(plateCodeDmlb);
                returnModel.setFlag(0);
                returnModel.setMsg("操作成功！");
                returnModel.setObject(null);
                return returnModel;
            }
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(0);
            returnModel.setMsg("操作失败，服务器端出错！");
            returnModel.setObject(null);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
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
            criteria.andCDmlbEqualTo(plateCodeDmz.getcDmlb());
        }
        if (!(("").equals(plateCodeDmz.getcDm()) || null == plateCodeDmz.getcDm())){
            criteria.andCDmEqualTo(plateCodeDmz.getcDm());
        }
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

    @OperationLog(cCzfs = "I")
    @Override
    public ReturnModel insertPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        try{
            //1.判断插入的数据是否有重复
            PlateCodeDmz plateCodeDmz1 = plateCodeDmzMapper.selectByPrimaryKey(plateCodeDmz.getcDm(),plateCodeDmz.getcDmlb());
            if (!(null == plateCodeDmz1 || "".equals(plateCodeDmz1))){
                returnModel.setFlag(1);
                returnModel.setMsg("新增出错，该代码类别下的代码值已存在！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                plateCodeDmz.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmz.setdCjsj(getTimestamp(new Date()));
                plateCodeDmzMapper.insert(plateCodeDmz);
                returnModel.setFlag(0);
                returnModel.setMsg("新增成功！");
                returnModel.setObject(plateCodeDmz);
                return returnModel;
            }
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
    public ReturnModel delPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
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

    @OperationLog(cCzfs = "U")
    @Override
    public ReturnModel updPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        try{
            //1.判断数据是否存在
            PlateCodeDmz plateCodeDmz1 = plateCodeDmzMapper.selectByPrimaryKey(plateCodeDmz.getcDm(),plateCodeDmz.getcDmlb());
            if (null == plateCodeDmz1 || "".equals(plateCodeDmz1)){
                returnModel.setFlag(1);
                returnModel.setMsg("修改失败，没有找到待修改的数据！");
                returnModel.setObject(null);
                return returnModel;
            }else{
                //2.执行修改
                plateCodeDmz.setcXguser(GetcurrentLoginUser.getCurrentUser().getcUserid());
                plateCodeDmz.setdXgsj(getTimestamp(new Date()));
                plateCodeDmzMapper.updateByPrimaryKey(plateCodeDmz);
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

    @Override
    public ReturnModel insertPlateLog(PlateLog plateLog) {
        try{
            plateLogMapper.insert(plateLog);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
            tGreenSpSpmx.setcSpbh(UUID.randomUUID().toString().replaceAll("-", ""));
            tGreenSpSpmx.setcCjuser(GetcurrentLoginUser.getCurrentUser().getcUserid());
            tGreenSpSpmx.setdCjsj(getTimestamp(new Date()));
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
                tGreenSpSpmx1.setdXgsj(getTimestamp(new Date()));
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

    @Override
    public ReturnModel selectTGreenRwRwmx(TGreenRwRwmx tGreenRwRwmx) {

        TGreenRwRwmxExample tGreenRwRwmxExample = new TGreenRwRwmxExample();
        TGreenRwRwmxExample.Criteria criteria = tGreenRwRwmxExample.createCriteria();

        if (!(("").equals(tGreenRwRwmx.getcRwlb()) || null == tGreenRwRwmx.getcRwlb())){
            criteria.andCRwlbEqualTo(tGreenRwRwmx.getcRwlb());
        }
        List tGreenRwRwmxList;
        try {
            tGreenRwRwmxList = tGreenRwRwmxMapper.selectByExample(tGreenRwRwmxExample);
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

    @Override
    public ReturnModel selectTGreenNlHz(TGreenNlHz tGreenNlHz) {
        List tGreenNlHzList;
        try{
            tGreenNlHzList = tGreenNlHzMapper.selectByExample(new TGreenNlHzExample());
            returnModel.setFlag(0);
            returnModel.setMsg("");
            returnModel.setObject(tGreenNlHzList);
        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setMsg("查询出错，系统错误！");
            returnModel.setObject(null);
        }
        return returnModel;
    }

    @Override
    public ReturnModel insertTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

    @Override
    public ReturnModel delTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }

    @Override
    public ReturnModel updTGreenNlHz(TGreenNlHz tGreenNlHz) {
        return null;
    }


    //获取当前系统时间timestamp
    public Timestamp getTimestamp(Date date){
        if (null == date){
            date = new Date();
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
    //获取系统当前时间   2019-05-22 16:35:01
    public String getLocalDate(Date date){
        if (null == date){
            date = new Date();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String localDate = df.format(date);
        return localDate;
    }
    //根据代码值获取代码名称
    public String getDmmc(String cDmlb,String cDm){
        /**
         * cDmlb
         * cSpbh===根据商品编号获取商品名称
         * cUserid===根据人员ID获取人员姓名
         * 其他===从基础代码表中获取
         */
        if ("cSpbh".equals(cDmlb)){
            TGreenSpSpmxExample tGreenSpSpmxExample = new TGreenSpSpmxExample();
            tGreenSpSpmxExample.createCriteria().andCSpbhEqualTo(cDm);
            List tGreenSpSpmxList = tGreenSpSpmxMapper.selectByExample(tGreenSpSpmxExample);
            TGreenSpSpmx tGreenSpSpmx1;
            if (!(tGreenSpSpmxList.isEmpty())){
                tGreenSpSpmx1 = (TGreenSpSpmx) tGreenSpSpmxList.get(0);
            }else{
                tGreenSpSpmx1 = new TGreenSpSpmx();
            }
            return tGreenSpSpmx1.getcSpmc();
        }else if ("cUsername".equals(cDmlb)){
            return null;
        }else{
            PlateCodeDmzExample plateCodeDmzExample = new PlateCodeDmzExample();
            plateCodeDmzExample.createCriteria().andCDmEqualTo(cDm);
            plateCodeDmzExample.createCriteria().andCDmlbEqualTo(cDmlb);
            List plateCodeDmzList = plateCodeDmzMapper.selectByExample(plateCodeDmzExample);
            PlateCodeDmz plateCodeDmz1;
            if (!(plateCodeDmzList.isEmpty())){
                plateCodeDmz1 = (PlateCodeDmz) plateCodeDmzList.get(0);
            }else{
                plateCodeDmz1 = new PlateCodeDmz();
            }
            return plateCodeDmz1.getcDmmc();
        }
    }
}
