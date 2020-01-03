package com.example.backend.api;

import com.example.backend.dao.CodeDAO;
import com.example.backend.dao.UserDAO;
import com.example.backend.entity.CodeEntity;
import com.example.backend.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletRegister {
    @Autowired
    UserDAO userDAO;
    @Autowired
    CodeDAO codeDAO;

    @PostMapping("/register")
    @ResponseBody
    public Map<String,Object> register(@RequestBody Map<String, String> data)
    {
        String status="";
        String details="";
        Map<String, Object> map = new HashMap<String, Object>();
        if(data.containsKey("user_name")&&data.containsKey("user_phone"))
        {
            List<UserEntity> ulist1 = userDAO.findByUserName(data.get("user_name"));
            List<UserEntity> ulist2 = userDAO.findByUserPhone(data.get("user_phone"));
            if(!ulist1.isEmpty())
            {
                status="wrong";
                details="用户名已存在";
            }
            else if(!ulist2.isEmpty())
            {
                status="wrong";
                details="手机号已注册";
            }
            //用户名和手机号都未被占用
            else
            {
                List<CodeEntity> clist=codeDAO.findByUserPhone(data.get("user_phone"));
                if(clist.get(0).getCode()==data.get("user_code"))
                {
                    UserEntity user=new UserEntity();
                    user.setUserName(data.get("user_name"));
                    user.setUserPassword(data.get("user_password"));
                    user.setUserSex(data.get("user_gender"));
                    user.setUserPhone(data.get("user_phone"));

                    userDAO.save(user);
                    status="right";
                    details="注册成功";
                }
                else
                {
                    status="wrong";
                    details="验证码错误";
                }
            }
        }
        else
        {
            status="wrong";
            details="连接失败";
        }
        map.put("status",status);
        map.put("details",details);
        return map;
    }
}

