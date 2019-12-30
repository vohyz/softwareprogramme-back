package com.example.backend.api;

import com.example.backend.dao.TaskDAO;
import com.example.backend.dao.TaskDraftDAO;
import com.example.backend.dao.TaskDraftInfoDAO;
import com.example.backend.entity.TaskDraftEntity;
import com.example.backend.entity.TaskDraftInfoEntity;
import com.example.backend.entity.TaskEntity;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

    DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    @PostMapping("/getUserDrafts")
    @ResponseBody
    public Map<String,Object> getUserDrafts(@RequestBody Map<String, String> data)
    {
        String status;
        String details;
        Map<String, Object> map = new HashMap<String, Object>();

        if(data.containsKey("user_id"))
        {
            List<TaskDraftInfoEntity> taskDraftInfoList=taskDraftInfoDAO.findByCreator(data.get("user_name"));
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
            draft.setBeginTime(DateTime.parse(data.get("begin_time"),format));
            draft.setInfo(data.get("task_info"));
            draft.setEndTime(DateTime.parse(data.get("end_time"),format));
            draft.setBonus(Double.parseDouble(data.get("task_bonus")));
            draft.setTags(data.get("task_tags"));
            draft.setTitle(data.get("task_title"));

            taskDraftInfoDAO.save(draft);
            status="right";
            details="编辑成功";
        }
        else
        {
            if(data.containsKey("task_title"))
            {
                TaskDraftInfoEntity draft=new TaskDraftInfoEntity();
                draft.setBeginTime(DateTime.parse(data.get("begin_time"),format));
                draft.setInfo(data.get("task_info"));
                draft.setEndTime(DateTime.parse(data.get("end_time"),format));
                draft.setBonus(Double.parseDouble(data.get("task_bonus")));
                draft.setTags(data.get("task_tags"));
                draft.setTitle(data.get("task_title"));
                draft.setCreator(data.get("user_name"));

                status="right";
                details="添加了一条新草稿";
                taskDraftInfoDAO.save(draft);
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
