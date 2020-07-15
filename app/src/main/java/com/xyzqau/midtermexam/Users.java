package com.xyzqau.midtermexam;

public class Users {
    public String Task_Name;
    public String Task_detail;
    public String Task_Deadline;

    public Users(String task_Name, String task_detail, String task_Deadline) {
        Task_Name = task_Name;
        Task_detail = task_detail;
        Task_Deadline = task_Deadline;
    }

    public String getTask_Name() {
        return Task_Name;
    }

    public String getTask_detail() {
        return Task_detail;
    }

    public String getTask_Deadline() {
        return Task_Deadline;
    }
}
