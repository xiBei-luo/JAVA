package com.greenplatform.service.loginImpl;

import com.greenplatform.aop.YwOperationCheckAndLog;
import com.greenplatform.dao.*;
import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.LoginService;
import com.greenplatform.util.MD5;
import com.greenplatform.util.TimeUtil;
import com.greenplatform.util.UserStringUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;


@Transactional
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    PlateUserMapper plateUserMapper;
    @Autowired
    TGreenNlZjnlmxMapper tGreenNlZjnlmxMapper;
    @Autowired
    TGreenNlHzMapper tGreenNlHzMapper;
    @Autowired
    TGreenZzZjzzmxMapper tGreenZzZjzzmxMapper;
    @Autowired
    TGreenGoldHzMapper tGreenGoldHzMapper;

    ReturnModel returnModel = new ReturnModel();


    /**
     * 账号密码登陆
     * @param plateUser
     * @param session
     * @return
     */
    @Override
    public ReturnModel checkLogin(PlateUser plateUser, HttpSession session) {

        List plateUserList;
        PlateUserExample plateUserExample = new PlateUserExample();
        PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
        criteria.andCRyztEqualTo("1");//人员状态（0未激活1已激活）
        criteria.andCRyxzEqualTo("1");//人员性质（1正常 -1黑名单）
        criteria.andCZtEqualTo("1");//数据状态（0无效  1有效）

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
     * 注册业务，前端用户注册成功，账户赠送价值100能量的种子，已调整（2019-07-17）
     * @param jsonObject
     * @param session
     * @return
     */
    @YwOperationCheckAndLog(cCzfs = "I")
    @Override
    public ReturnModel doRegister(String jsonObject, HttpSession session) {
        try{
            JSONObject jsonParams = JSONObject.fromObject(jsonObject);

            Map hashMap = new HashMap();
            hashMap.put("cPhone",jsonParams.getString("cPhone"));
            hashMap.put("smsCode",jsonParams.getString("smsCode"));

            returnModel = checkSmsCode(hashMap,session);

            if (!(0 == returnModel.getFlag())){
                return returnModel;
            }else{
                session.removeAttribute("smsCodeObj");
                PlateUser plateUser = new PlateUser();
                plateUser.setcZcfs("1");
                plateUser.setcPhone(jsonParams.getString("cPhone"));
                plateUser.setcLoginname(jsonParams.getString("cLoginname"));
                plateUser.setcPassword(jsonParams.getString("cPassword"));
                plateUser.setcRylb(jsonParams.getString("cRylb"));

                //1.判断邮箱或用户名是否被注册
                if (false == checkUser("phone",plateUser.getcPhone())){
                    returnModel.setFlag(1);
                    returnModel.setObject(null);
                    returnModel.setMsg("注册失败，邮箱已经被注册!");
                    return returnModel;
                }

                if (false == checkUser("loginname",plateUser.getcLoginname())){
                    returnModel.setFlag(1);
                    returnModel.setObject(null);
                    returnModel.setMsg("注册失败，用户名已经被注册!");
                    return returnModel;
                }

                //3.注册用户
                String majorKey = UUID.randomUUID().toString().replaceAll("-", "");
                plateUser.setcPassword(MD5.md5(plateUser.getcPassword()));
                //3-1生成随机的username
                String tmpUsername = UserStringUtil.getRandomString2(6);

                plateUser.setcUsername(tmpUsername);
                plateUser.setcRyzt("1");//人员状态（0未激活1已激活）
                plateUser.setcRylb("2");//人员类别（1系统用户2前端用户）
                plateUser.setcRydj("0");//人员等级（0，1，2，3，4）
                plateUser.setcRyxz("1");//人员性质（1正常，-1黑名单）
                plateUser.setcZt("1");//数据状态（0无效1有效）
                plateUser.setcIssmz("0");//是否实名制
                plateUser.setcZcfs("");//注册方式

                plateUser.setcUserid(majorKey);
                plateUser.setdCjsj(TimeUtil.getTimestamp(new Date()));
                plateUser.setcCjuser(majorKey);
                int insertRet = plateUserMapper.insert(plateUser);
                if (1 != insertRet){
                    returnModel.setFlag(1);
                    returnModel.setObject(null);
                    returnModel.setMsg("注册失败，系统错误!");
                    return returnModel;
                }else{
                    //平台用户注册成功则对应账户账户增加价值100能量的种子(注册成功，但还未实名制账户，实名制后将状态修改为有效1)
                    TGreenZzZjzzmx tGreenZzZjzzmx = new TGreenZzZjzzmx();
                    tGreenZzZjzzmx.setcLsh(UUID.randomUUID().toString().replaceAll("-", ""));
                    tGreenZzZjzzmx.setcUserid(plateUser.getcUserid());
                    tGreenZzZjzzmx.setcSpbh("1");//仙人掌1
                    tGreenZzZjzzmx.setcZjyy("1");//注册赠送
                    tGreenZzZjzzmx.setdZjsj(TimeUtil.getTimestamp(new Date()));
                    tGreenZzZjzzmx.setcKjz("0");
                    tGreenZzZjzzmx.setcSfjz("0");
                    tGreenZzZjzzmx.setcZt("0");//(注册成功，但还未实名制账户，实名制后将状态修改为有效1)
                    tGreenZzZjzzmx.setcCjuser(plateUser.getcUserid());
                    tGreenZzZjzzmx.setdCjsj(TimeUtil.getTimestamp(new Date()));
                    tGreenZzZjzzmxMapper.insert(tGreenZzZjzzmx);


                    //能量汇总表为用户添加一条记录(注册成功，但还未实名制账户，实名制后将状态修改为有效1)
                    TGreenNlHz tGreenNlHz = new TGreenNlHz();
                    tGreenNlHz.setcUserid(plateUser.getcUserid());
                    tGreenNlHz.setnNlhz(new BigDecimal("0"));
                    tGreenNlHz.setcZt("0");//(注册成功，但还未实名制账户，实名制后将状态修改为有效1)
                    tGreenNlHz.setcCjuser(plateUser.getcUserid());
                    tGreenNlHz.setdCjsj(TimeUtil.getTimestamp(new Date()));
                    tGreenNlHzMapper.insert(tGreenNlHz);

                    session.setAttribute("loginUser",plateUser);//前端用户注册成功后写入session
                    returnModel.setFlag(0);
                    returnModel.setObject(null);
                    returnModel.setMsg("注册成功!");
                    return  returnModel;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            returnModel.setFlag(1);
            returnModel.setObject(null);
            returnModel.setMsg("注册失败，系统错误!");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return returnModel;
        }
    }

    /**
     * 验证用户是否有重复（前端用户）
     * @param type 验证类型（phone手机号码，email邮箱，loginname登录名）
     * @param value
     * @return  false未通过，true通过，false有重复，true没有重复
     */
    @Override
    public boolean checkUser(String type,String value){
        PlateUserExample plateUserExample = new PlateUserExample();
        PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
        criteria.andCZtEqualTo("1");
        criteria.andCRylbEqualTo("2");
        criteria.andCRyztEqualTo("1");
        criteria.andCRyxzEqualTo("1");
        if ("phone".equals(type)){
            criteria.andCPhoneEqualTo(value);
        }else if ("email".equals(type)){
            criteria.andCEmailEqualTo(value);
        }else if("loginname".equals(type)){
            criteria.andCLoginnameEqualTo(value);
        }
        List plateUserList = plateUserMapper.selectByExample(plateUserExample);
        if (!(plateUserList.isEmpty())){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 验证手机验证码
     * @param hashMap  <String,String> ("cPhone","smsCode")
     * @param session
     * @return
     */
    @Override
    public ReturnModel checkSmsCode(Map<String,String> hashMap, HttpSession session){
        ReturnModel returnModel = new ReturnModel();
        String cPhone = hashMap.get("cPhone");
        String smsCode = hashMap.get("smsCode");

        JSONObject jsonSessionParams = JSONObject.fromObject(session.getAttribute("smsCodeObj"));
        String sessionSmsCode = jsonSessionParams.getString("smsCode");//session域中的验证码

        System.out.println("验证参数"+hashMap);
        System.out.println("session域"+jsonSessionParams);

        //验证：手机号码是否匹配
        if (null == cPhone || ("").equals(cPhone)){
            returnModel.setFlag(1);
            returnModel.setMsg("手机号码不能为空！");
            returnModel.setObject(null);
            return returnModel;
        }else{
            if (!(cPhone.equals(jsonSessionParams.getString("cPhone")))){
                returnModel.setFlag(1);
                returnModel.setMsg("当前手机号码与验证手机号码不一致");
                returnModel.setObject(null);
                return returnModel;
            }else{
                if(!(smsCode.equals(sessionSmsCode))){
                    returnModel.setFlag(1);
                    returnModel.setMsg("验证码错误！");
                    returnModel.setObject(null);
                    return returnModel;
                }
                if((System.currentTimeMillis() - jsonSessionParams.getLong("createTime")) > 1000 * 60 * 5){
                    returnModel.setFlag(1);
                    returnModel.setMsg("验证码已过期，请重新获取！");
                    returnModel.setObject(null);
                    return returnModel;
                }
            }
        }

        return returnModel;
    }


    /**
     * 修改前端用户密码
     * @param jsonObject
     * @param session
     * @return
     */
    @Override
    public ReturnModel retWebUserPassowrd(String jsonObject, HttpSession session) {
        try{
            JSONObject jsonParams = JSONObject.fromObject(jsonObject);
            System.out.println("参数："+jsonParams);
            String cPhone = jsonParams.getString("cPhone");
            String cPassword = jsonParams.getString("cPassword");

            PlateUserExample plateUserExample = new PlateUserExample();
            PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
            criteria.andCZtEqualTo("1");
            criteria.andCRylbEqualTo("2");
            criteria.andCRyztEqualTo("1");
            criteria.andCRyxzEqualTo("1");
            criteria.andCPhoneEqualTo(cPhone);
            List plateUserList = plateUserMapper.selectByExample(plateUserExample);
            if (plateUserList.size() < 1){
                System.out.println("用户没有注册平台");
            }else if (plateUserList.size() == 1){
                System.out.println("注册过平台，找回密码");
                PlateUser plateUser = (PlateUser) plateUserList.get(0);
                plateUser.setcPassword(MD5.md5(cPassword));
                plateUser.setdXgsj(TimeUtil.getTimestamp(new Date()));
                plateUser.setcXguser(plateUser.getcUserid());
                System.out.println("修改数据："+plateUser);
                plateUserMapper.updateByPrimaryKey(plateUser);
                returnModel.setFlag(0);
                returnModel.setMsg("");
                returnModel.setObject(null);
            }else{
                System.out.println("电话号码存在重复，有误！");
            }
            return returnModel;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            returnModel.setFlag(1);
            returnModel.setMsg("操作失败，系统错误");
            returnModel.setObject(null);
            return returnModel;
        }
    }


    /**
     * 手机验证码登陆
     * @param jsonObject
     * @param session
     * @return
     */
    @Override
    public ReturnModel loginByPhone(String jsonObject, HttpSession session) {
        JSONObject jsonParams = JSONObject.fromObject(jsonObject);

        Map hashMap = new HashMap();
        hashMap.put("cPhone",jsonParams.getString("cPhone"));
        hashMap.put("smsCode",jsonParams.getString("smsCode"));
        ReturnModel returnModel1 = checkSmsCode(hashMap,session);//验证验证码是否正确

        if (0 == returnModel.getFlag()){
            PlateUserExample plateUserExample = new PlateUserExample();
            PlateUserExample.Criteria criteria = plateUserExample.createCriteria();
            criteria.andCZtEqualTo("1");
            criteria.andCRylbEqualTo("2");
            criteria.andCRyztEqualTo("1");
            criteria.andCRyxzEqualTo("1");
            criteria.andCPhoneEqualTo(jsonParams.getString("cPhone"));
            List plateUserList = plateUserMapper.selectByExample(plateUserExample);
            PlateUser plateUser = (PlateUser) plateUserList.get(0);
            session.setAttribute("loginUser",plateUser);
            returnModel1.setFlag(0);
            returnModel1.setMsg("登陆成功");
            returnModel1.setObject(null);
            return returnModel1;
        }else{
            return returnModel1;
        }
    }


}
