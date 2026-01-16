package com.example.service;
import com.example.entity.Task;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
    public boolean deleteTaskById(int id) {
        taskRepository.deleteById(id);
        return Boolean.TRUE;
    }
    public List<Task> getByStatus(String status) {
        return taskRepository.findByTaskStatus(status);
    }


}
