package com.model;

import com.dto.TaskDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class ToDoModel {
    private final String URL = "jdbc:mysql://localhost:3306/advjava0911";
    private final String USER = "root";
    private final String PASS = "root";
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    public boolean saveTask(TaskDto dto) {
        boolean flag = false;
        try(Connection con = getConnection();) {
            //String query = "INSERT INTO task values(task_seq.nextVal,?,?,?,?,?)";
            String query = "INSERT INTO task values(0,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, dto.getTitle());
            stmt.setString(2, dto.getTaskDesc());
            stmt.setString(3, dto.getStatus());
            stmt.setString(4, dto.getScheduledDt());
            stmt.setString(5, LocalDate.now().toString());
            int count = stmt.executeUpdate();
            flag = count > 0;
        } catch (Exception e) {e.printStackTrace();}
        return flag;
    }

}
