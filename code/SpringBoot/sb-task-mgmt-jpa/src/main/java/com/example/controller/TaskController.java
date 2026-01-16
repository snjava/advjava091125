package com.example.controller;

import com.example.entity.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/save-task")
    public Task saveTask(@RequestBody Task task) {
       return taskService.saveTask(task);
    }
    @PutMapping("/update-task")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }
    @GetMapping("/get-all-task")
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }
    @DeleteMapping("/delete-task")
    public String deleteById(@RequestParam("id") int id) {
        taskService.deleteTaskById(id);
        return "Task Deleted Successfully";
    }
    @GetMapping("/get-by-status/{status}")
    public List<Task> getTaskByStatus(@PathVariable("status") String status) {
        return taskService.getByStatus(status);
    }
}
