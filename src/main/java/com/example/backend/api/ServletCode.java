package com.example.backend.api;

import com.aliyuncs.exceptions.ClientException;
import com.example.backend.dao.ConfirmcodeDAO;
import com.example.backend.entity.ConfirmcodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletCode {
    @Autowired
    ConfirmcodeDAO confirmcodeDAO;

    @GetMapping("/getCode")
    @ResponseBody
    public Map<String, Object> getCode(@RequestBody Map<String, String> data) throws ClientException, InterruptedException {
        Map<String, Object> map = new HashMap<String, Object>();
        String status;
        String details;

        if(data.containsKey("user_phone")) {
            int code = ((int) ((Math.random() * 9 + 1) * 100000));
            List<ConfirmcodeEntity> list = confirmcodeDAO.findByUserPhone(data.get("user_phone"));

            if(list.isEmpty()) {
                ConfirmcodeEntity confirmcodeEntity = new ConfirmcodeEntity();
                confirmcodeEntity.setCode(Integer.toString(code));
                confirmcodeEntity.setUserPhone(data.get("user_phone"));

                confirmcodeDAO.save(confirmcodeEntity);
            }
            //手机号已存在，更新验证码
            else
            {
                list.get(0).setCode(Integer.toString(code));

                confirmcodeDAO.save(list.get(0));
            }
            status="right";
            details="";
            Sms.sendSms(data.get("user_phone"),code);
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
