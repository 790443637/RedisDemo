package com.ld.controller;

import com.ld.domain.User;
import com.ld.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class userController {

    @Autowired
    private IUserService UserServiceImpl;

    @RequestMapping("/user")
    public String user(String  userName,Model m){
        User login = UserServiceImpl.login(userName);
        if(login!=null){
            List<User> list = UserServiceImpl.list();
            System.out.println(list);
            m.addAttribute("list",list);
            return "HelloWorld";
        }
        return "login";
    }

    @RequestMapping("/userid")
    public String ID(long id,Model m){
        User user = UserServiceImpl.get(id);
            System.out.println(user);
            m.addAttribute("user",user);
            return "b";
    }

    @RequestMapping("/update")
    public String update(User u, String dd) throws Exception {
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = sdf.parse(dd);
        u.setBornDate(date);
        System.out.println(u);
        return "login";
    }

    @RequestMapping("/redisTestSet")
    public String redisSst(String name,String pass){
        UserServiceImpl.redisSet(name,pass);
        return "redisGet";
    }

    @RequestMapping("/redisTestGet")
    public String redisGet(String name,Model m){
        String s = UserServiceImpl.redisGet(name);
        m.addAttribute("redis",s);
        return "redisShow";
    }
}
