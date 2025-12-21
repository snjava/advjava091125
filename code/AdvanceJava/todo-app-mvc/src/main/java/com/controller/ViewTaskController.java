package com.controller;

import com.dto.TaskDto;
import com.model.ToDoModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-my-all-task")
public class ViewTaskController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ToDoModel model = new ToDoModel();
        List<TaskDto> taskList = model.getAllTask();
        req.setAttribute("mytask", taskList);
        RequestDispatcher rd = req.getRequestDispatcher("view-task.jsp");
        rd.forward(req,resp);
    }
}
