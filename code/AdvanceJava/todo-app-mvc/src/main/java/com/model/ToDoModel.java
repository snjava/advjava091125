package com.model;

import com.dto.TaskDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<TaskDto> getAllTask() {
        List<TaskDto> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            String query = "SELECT * FROM task order by scheduledon asc";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                TaskDto dto = new TaskDto();
                dto.setId(rs.getInt("id"));
                dto.setTitle(rs.getString("title"));
                dto.setTaskDesc(rs.getString("taskDesc"));
                dto.setStatus(rs.getString("status"));
                dto.setScheduledDt(rs.getString("scheduledOn"));
                dto.setUpdatedDt(rs.getString("updatedOn"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
