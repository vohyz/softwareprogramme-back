package com.example.backend.api;

import com.example.backend.dao.TaskDAO;
import com.example.backend.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletTask {
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
            map.put("task_omitinfo",taskDAO.findByTaskPunlisherNameOnOmit(userName));
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
            map.put("task_omitinfo",taskDAO.findByTaskExecutorNameAndTaskStatusOnOmit(userName, taskstatus));
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
        int taskBonus;
        String taskType;
        String publishTime;
        String endTime;
        String userName;
        if(inMap.containsKey("user_name")){
            userName= inMap.get("user_name");
            taskTitle=inMap.get("task_title");
            taskInfo=inMap.get("task_info");
            taskBonus= Integer.parseInt(inMap.get("task_bonus"));
            taskType=inMap.get("task_type");
            publishTime=inMap.get("publish_time");
            endTime=inMap.get("end_time");
            taskDAO.save(new TaskEntity(userName,taskTitle,taskInfo,taskBonus,taskType,publishTime,endTime));
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
            TaskEntity tasktarget=taskDAO.findByTaskId(taskId).get(0);
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
            TaskEntity tasktarget=taskDAO.findByTaskId(taskId).get(0);
            if(tasktarget==null){
                status="wrong";
                details="没有找到目标任务";
            }
            else{
                tasktarget.setTaskStatus("ed");
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
