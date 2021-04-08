package com.vote.controller;

import com.vote.pojo.Users;
import com.vote.service.UsersService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UsersController {
    @Autowired
    private UsersService us;
    @RequestMapping("/loginCheck")
    public String loginCheck(Users uu, HttpSession ss, Model mm){
        Users user = (Users) ss.getServletContext().getAttribute("user");
        Users users = us.Check(uu);
        if (users==null){
            mm.addAttribute("meg","用户名或密码错误");
            return "login";
        }else if (user!=null){
            mm.addAttribute("meg","用户已登录");
            return "login";
        }else if ("admin".equals(uu.getVu_user_name())&&uu.getVu_password().equals(users.getVu_password())){
            ss.setAttribute("user",users);
            ss.getServletContext().setAttribute("user",uu);
            //redirect
            return "forward:/findAll";
        }else {
            ss.setAttribute("user",users);
            ss.getServletContext().setAttribute("user",uu);
            return "forward:/findAll";
        }
    }
    @RequestMapping("/regCheck")
    @ResponseBody
    public String regCheck(Users uu){
        Users user = us.Check(uu);
        if (user==null){
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping("/addUsers")
    public String addUsers(Users users,Model mm){
        int num = us.addUser(users);
        if (num>0){
            return "login";
        }else {
            mm.addAttribute("msg","服务器开小差了,请重新添加");
            return "regist";
        }
    }
}
