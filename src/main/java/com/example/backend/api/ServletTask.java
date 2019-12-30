package com.example.backend.api;

import com.example.backend.dao.*;
import com.example.backend.entity.TaskEntity;
import com.example.backend.entity.TaskFinishedInfoEntity;
import com.example.backend.entity.TaskPublishedInfoEntity;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletTask {
    @Autowired
    TaskDraftInfoDAO taskDraftInfoDAO;
    @Autowired
    TaskPublishedInfoDAO taskPublishedInfoDAO;
    @Autowired
    TaskFinishedInfoDAO taskFinishedInfoDAO;
    @Autowired
    TaskOngoingInfoDAO taskOngoingInfoDAO;
    @Autowired
    TaskDAO taskDAO;

    @GetMapping("/task/publishedTask")
    @ResponseBody
    public Map<String, Object> getPubilshedTask(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String userName;
        String status;
        String details;
        if(inMap.containsKey("user_name")){
            userName= inMap.get("user_name");
            map.put("finished",taskFinishedInfoDAO.findByTaskPunlisherNameOnOmit(userName));
            map.put("ongoing",taskOngoingInfoDAO.findByTaskPunlisherNameOnOmit(userName));
            map.put("published",taskPublishedInfoDAO.findByTaskPunlisherNameOnOmit(userName));
            if(map.get("finished")==null&&map.get("ongoing")==null&&map.get("published")==null){
                status="wrong";
                details="您没有发布任务";
            }
            else{
                status="right";
                details="";
            }
        }
        else{
            status="wrong";
            details="连接失败";
        }
        map.put("status",status);
        map.put("details", details);
        return map;
    }

    @GetMapping("/task/executeTask")
    @ResponseBody
    public Map<String, Object> getExecuteTaskOnOmit(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<String, Object>();

        String status;
        String details;

        String userName;
        String taskstatus;
        if(inMap.containsKey("user_name")){
            userName= inMap.get("user_name");
            taskstatus=inMap.get("task_type");
            if(taskstatus.equals("finished"))
                map.put("task_omitinfo",taskFinishedInfoDAO.findByTaskExecutorNameOnOmit(userName));
            else if(taskstatus.equals("ongoing"))
                map.put("task_omitinfo",taskOngoingInfoDAO.findByTaskExecutorNameOnOmit(userName));
            if(map.get("task_omitinfo")==null){
                status="wrong";
                details="您没有发布任务";
            }
            else{
                status="right";
                details="";
            }
        }
        else{
            status="wrong";
            details="连接失败";
        }
        map.put("status",status);
        map.put("details", details);
        return map;
    }

    @GetMapping("/task/publishTask")
    @ResponseBody
    public Map<String, Object> publishTask(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<String, Object>();

        String status;
        String details;

        String taskTitle;
        String taskInfo;
        Double taskBonus;
        String taskType;
        String publishTime;
        String endTime;
        String userName;
        if(inMap.containsKey("user_name")){
            userName= inMap.get("user_name");
            taskTitle=inMap.get("task_title");
            taskInfo=inMap.get("task_info");
            taskBonus= Double.valueOf(inMap.get("task_bonus"));
            taskType=inMap.get("task_type");
            publishTime=inMap.get("publish_time");
            TaskPublishedInfoEntity taskEntity=new TaskPublishedInfoEntity();
            taskEntity.setInfo(taskInfo);
            taskEntity.setTitle(taskTitle);
            taskEntity.setTags(taskType);
            taskEntity.setBonus(taskBonus);
            DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
            DateTime publishtime = DateTime.parse(publishTime, format);
            taskEntity.setPublisher(userName);
            taskEntity.setPublishtime(publishtime);
            taskPublishedInfoDAO.save(taskEntity);
            status="right";
            details="";
        }
        else{
            status="wrong";
            details="连接失败";
        }
        map.put("status",status);
        map.put("details", details);
        return map;
    }

    @GetMapping("/task/deleteTask")
    @ResponseBody
    public Map<String, Object> deleteTask(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<String, Object>();

        String status;
        String details;

        int taskId;
        if(inMap.containsKey("task_id")){
            taskId= Integer.parseInt(inMap.get("task_id"));
            TaskEntity tasktarget=taskOngoingInfoDAO.findById(taskId).get(0);
            if(tasktarget==null){
                status="wrong";
                details="没有找到目标任务";
            }
            else{
                taskDAO.delete(tasktarget);
                status="right";
                details="";
            }
        }
        else{
            status="wrong";
            details="连接失败";
        }
        map.put("status",status);
        map.put("details", details);
        return map;
    }

    @GetMapping("/task/completeTask")
    @ResponseBody
    public Map<String, Object> completeTask(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<String, Object>();

        String status;
        String details;

        int taskId;
        if(inMap.containsKey("task_id")){
            taskId= Integer.parseInt(inMap.get("task_id"));
            TaskEntity tasktarget=taskOngoingInfoDAO.findById(taskId).get(0);
            if(tasktarget==null){
                status="wrong";
                details="没有找到目标任务";
            }
            else{
                TaskFinishedInfoEntity taskFinishedInfoEntity=new TaskFinishedInfoEntity();
                taskFinishedInfoEntity.setId(tasktarget.getId());

                status="right";
                details="";
            }
        }
        else{
            status="wrong";
            details="连接失败";
        }
        map.put("status",status);
        map.put("details", details);
        return map;
    }

    @GetMapping("/task/findTaskByTags")
    @ResponseBody
    public Map<String, Object> getTaskByTags(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<String, Object>();

        String status;
        String details;

        String tags;
        if(inMap.containsKey("tags")){
            tags= inMap.get("tags");
            map.put("task_omitinfo",taskDAO.findByTags(tags));
            if(map.get("task_omitinfo")==null){
                status="wrong";
                details="没有符合的任务";
            }
            else{
                status="right";
                details="";
            }
        }
        else{
            status="wrong";
            details="连接失败";
        }
        map.put("status",status);
        map.put("details", details);
        return map;
    }

    @GetMapping("/task/search")
    @ResponseBody
    public Map<String, Object> search(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<String, Object>();

        String status;
        String details;

        String keyword;
        if(inMap.containsKey("keyword")){
            keyword= inMap.get("keyword");
            map.put("task_omitinfo",taskDAO.Search(keyword));
            if(map.get("task_omitinfo")==null){
                status="wrong";
                details="没有符合的任务";
            }
            else{
                status="right";
                details="";
            }
        }
        else{
            status="wrong";
            details="连接失败";
        }
        map.put("status",status);
        map.put("details", details);
        return map;
    }
}
