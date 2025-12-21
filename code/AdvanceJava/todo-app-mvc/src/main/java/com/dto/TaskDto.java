package com.dto;
public class TaskDto {
    private int id;
    private String title;
    private String taskDesc;
    private String status;
    private String scheduledDt;
    private String updatedDt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduledDt() {
        return scheduledDt;
    }

    public void setScheduledDt(String scheduledDt) {
        this.scheduledDt = scheduledDt;
    }

    public String getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(String updatedDt) {
        this.updatedDt = updatedDt;
    }
}
