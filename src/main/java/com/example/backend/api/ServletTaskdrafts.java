package com.example.backend.api;

import com.example.backend.dao.TaskdraftsDAO;
import com.example.backend.entity.TaskdraftsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletTaskdrafts {
    @Autowired
    TaskdraftsDAO taskdraftsDAO;

    @GetMapping("/getUserDrafts")
    @ResponseBody
    public Map<String,Object> getUserDrafts(@RequestBody Map<String, String> data)
    {
        String status;
        String details;
        Map<String, Object> map = new HashMap<String, Object>();

        if(data.containsKey("user_id"))
        {
            List<TaskdraftsEntity> taskdraftsList=taskdraftsDAO.findByTaskCreator(Integer.parseInt(data.get("user_id")));
            if(taskdraftsList.size()>0) {
                status = "right";
                details = "";
            }
            else {
                status = "wrong";
                details="草稿箱为空";
            }
            map.put("List",taskdraftsList);
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

    @GetMapping("/modifyDrafts")
    @ResponseBody
    public Map<String,Object> modifyDrafts(@RequestBody Map<String, String> data)
    {
        String status;
        String details;
        Map<String, Object> map = new HashMap<String, Object>();

        if(data.containsKey("task_id"))
        {
            TaskdraftsEntity draft=taskdraftsDAO.findById(Integer.parseInt(data.get("user_id")));
            draft.setTaskBeginTime(data.get("publish_time"));
            draft.setTaskInfo(data.get("task_info"));
            draft.setTaskEndTime(data.get("end_time"));
            draft.setTaskBonus(Double.parseDouble(data.get("task_bonus")));
            draft.setTaskType(data.get("task_type"));
            draft.setTaskTitle(data.get("task_title"));

            taskdraftsDAO.save(draft);
            status="right";
            details="编辑成功";
        }
        else
        {
            if(data.containsKey("task_title"))
            {
                TaskdraftsEntity draft=new TaskdraftsEntity();
                draft.setTaskBeginTime(data.get("publish_time"));
                draft.setTaskInfo(data.get("task_info"));
                draft.setTaskEndTime(data.get("end_time"));
                draft.setTaskBonus(Double.parseDouble(data.get("task_bonus")));
                draft.setTaskType(data.get("task_type"));
                draft.setTaskTitle(data.get("task_title"));
                draft.setTaskCreator(Integer.parseInt(data.get("user_id")));

                status="right";
                details="添加了一条新草稿";
                taskdraftsDAO.save(draft);
            }
            else
            {
                status="wrong";
                details="连接失败";
            }
        }
        map.put("status",status);
        map.put("details",details);
        return map;
    }
}
