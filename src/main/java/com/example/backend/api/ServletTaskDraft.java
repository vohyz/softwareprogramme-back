package com.example.backend.api;

import com.example.backend.dao.TaskDAO;
import com.example.backend.dao.TaskDraftDAO;
import com.example.backend.dao.TaskDraftInfoDAO;
import com.example.backend.entity.TaskDraftEntity;
import com.example.backend.entity.TaskDraftInfoEntity;
import com.example.backend.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletTaskDraft {
    @Autowired
    TaskDAO taskDAO;
    TaskDraftDAO taskDraftDAO;
    TaskDraftInfoDAO taskDraftInfoDAO;

    @PostMapping("/getUserDrafts")
    @ResponseBody
    public Map<String,Object> getUserDrafts(@RequestBody Map<String, String> data)
    {
        String status;
        String details;
        Map<String, Object> map = new HashMap<String, Object>();

        if(data.containsKey("user_id"))
        {
            List<TaskDraftInfoEntity> taskDraftInfoList=taskDraftInfoDAO.findByCreator(Integer.parseInt(data.get("user_id")));
            if(taskDraftInfoList.size()>0) {
                status = "right";
                details = "";
            }
            else {
                status = "wrong";
                details="草稿箱为空";
            }
            map.put("List",taskDraftInfoList);
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

    @PostMapping("/modifyDrafts")
    @ResponseBody
    public Map<String,Object> modifyDrafts(@RequestBody Map<String, String> data)
    {
        String status;
        String details;
        Map<String, Object> map = new HashMap<String, Object>();

        if(data.containsKey("task_id"))
        {
            TaskDraftInfoEntity draft=taskDraftInfoDAO.findById(Integer.parseInt(data.get("task_id")));
            draft.setBeginTime(data.get("publish_time"));
            draft.setInfo(data.get("task_info"));
            draft.setEndTime(data.get("end_time"));
            draft.setBonus(Double.parseDouble(data.get("task_bonus")));
            draft.setTaskType(data.get("task_type"));
            draft.setTitle(data.get("task_title"));

            taskDAO.save(draft);
            status="right";
            details="编辑成功";
        }
        else
        {
            if(data.containsKey("task_title"))
            {
                TaskEntity draft=new TaskEntity();
                draft.setBeginTime(data.get("publish_time"));
                draft.setInfo(data.get("task_info"));
                draft.setEndTime(data.get("end_time"));
                draft.setBonus(Double.parseDouble(data.get("task_bonus")));
                draft.setType(data.get("task_type"));
                draft.setTitle(data.get("task_title"));
                draft.setCreator(Integer.parseInt(data.get("user_id")));

                status="right";
                details="添加了一条新草稿";
                taskDAO.save(draft);
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
