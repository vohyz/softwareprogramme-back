package com.example.backend.api;

import com.example.backend.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletUser {
    @Autowired
    UserDAO userDAO;

    @GetMapping("/getUserAvatar")
    @ResponseBody
    public Map<String,Object> getUserAvatar(@RequestBody Map<String, String> data)
    {
        String status;
        String details;
        Map<String, Object> map = new HashMap<String, Object>();

        if(data.containsKey("user_id"))
        {
            String avatar=userDAO.findByUserId(Integer.parseInt(data.get("user_id"))).getUserAvatar();
            status="right";
            details="";
            map.put("user_avatar",avatar);
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
