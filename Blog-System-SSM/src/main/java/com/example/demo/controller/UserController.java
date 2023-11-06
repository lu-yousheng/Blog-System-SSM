package com.example.demo.controller;

import com.example.demo.common.AjaxResult;
import com.example.demo.common.AppVariable;
import com.example.demo.entity.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("/reg")
    public AjaxResult reg(Userinfo userinfo) {
        //非空校验和擦书有效性校验
        if (userinfo == null || !StringUtils.hasLength(userinfo.getUsername())
        || !StringUtils.hasLength(userinfo.getPassword())) {
            return AjaxResult.fail(-1,"非法参数");
        }
        return AjaxResult.success(userService.reg(userinfo));
    }

    @RequestMapping("/login")
    public AjaxResult login(HttpServletRequest request, String username, String password) {
        //非空校验和擦书有效性校验
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return AjaxResult.fail(-1,"非法参数");
        }
        Userinfo userinfo = userService.getUserByName(username);
        if (userinfo != null && userinfo.getId() > 0) {
            //有效用户
            //判断密码是否相等
            if (password.equals(userinfo.getPassword())) {
                //登录成功
                userinfo.setPassword(""); //返回前端之前隐藏敏感信息
                //将用户存储到session
                HttpSession session = request.getSession(); //默认为TRUE
                session.setAttribute(AppVariable.USER_SESSION_KEY,userinfo);
                return AjaxResult.success(userinfo);
            }
        } else {
            return AjaxResult.success(0,null);
        }
        return AjaxResult.fail(-1,"非法参数");
    }
}
