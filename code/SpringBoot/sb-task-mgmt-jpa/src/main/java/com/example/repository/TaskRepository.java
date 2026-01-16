package com.example.repository;
import com.example.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByTaskStatus(String taskStatus);
}
