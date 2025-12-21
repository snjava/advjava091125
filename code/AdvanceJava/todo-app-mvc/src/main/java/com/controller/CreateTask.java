package com.controller;

import com.dto.TaskDto;
import com.model.ToDoModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/create-my-task")
public class CreateTask extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        String status = req.getParameter("status");
        String taskDate = req.getParameter("taskDate");
        TaskDto taskDto = new TaskDto();
        taskDto.setTitle(title);
        taskDto.setTaskDesc(desc);
        taskDto.setStatus(status);
        taskDto.setScheduledDt(taskDate);
        ToDoModel model = new ToDoModel();
        boolean result = model.saveTask(taskDto);
        if(result) {
            resp.sendRedirect("create-task.jsp?code=1");
        } else {
            resp.sendRedirect("create-task.jsp?code=2");
        }
    }
}
