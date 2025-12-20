package com.controller;

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

        System.out.println("Title : " + title);
        System.out.println("Description : " + desc);
        System.out.println("Status : " + status);
        System.out.println("Date : " + taskDate);

    }
}
