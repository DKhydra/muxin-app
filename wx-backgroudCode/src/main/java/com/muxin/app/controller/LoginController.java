package com.muxin.app.controller;


import com.muxin.app.dao.entry.Users;
import com.muxin.app.exception.XbaseError;
import com.muxin.app.result.ResultModel;
import com.muxin.app.service.UserService;
import com.muxin.app.util.ApiVersion;
import com.muxin.app.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "app/{version}")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param users
     * @param request
     * @return
     */
    @RequestMapping(value="/login" ,method = RequestMethod.POST)
    @ApiVersion(1)
    @ResponseBody
    public Map<String ,Object> Login(@RequestBody Users users, HttpServletRequest request){

        ResultModel<Users> result = new ResultModel<>();
        //Todo 密码加密效验
        if(StringUtils.isBlank(users.getUsername()) || StringUtils.isBlank(users.getPassword())){
            result.setReturnCode(XbaseError.LOGIN_EMPTY.getErrorCode());
            result.setReturnMessage(XbaseError.LOGIN_EMPTY.getErrorDesc());
            return result.dump();
        }
        Boolean charm =userService.LoginInfo(users);

        if(charm==true){
            result.setReturnMessage("login success.");
            request.getSession().setAttribute("userInfo", users);

        }else {
            result.setReturnCode(XbaseError.LOGIN_ERROR.getErrorCode());
            result.setReturnMessage(XbaseError.LOGIN_ERROR.getErrorDesc());
        }
        return result.dump();
    }

    /**
     * 邮箱注册
     * @return
     */
    public Map<String ,Object> registerByEmail(){
        ResultModel<Users> result = new ResultModel<>();
        return result.dump();

    }

    /**
     * 手机号注册
     * @return
     */
    public Map<String ,Object> registerByMobile(){
        ResultModel<Users> result = new ResultModel<>();
        return result.dump();

    }

    /**
     * 登出
     * @return
     */
    public Map<String ,Object> Logout(){
        ResultModel<Users> result = new ResultModel<>();
        return result.dump();

    }

    /**
     * 测试注册-（暂用）
     * @return
     */
    @RequestMapping(value="/register" ,method = RequestMethod.POST)
    @ApiVersion(1)
    @ResponseBody
    public Map<String ,Object> register(@RequestBody Users users) throws Exception{
        ResultModel<Users> result = new ResultModel<>();
        users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
        return result.dump();

    }
}
