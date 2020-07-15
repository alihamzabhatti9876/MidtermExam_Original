package com.xyzqau.midtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText title;
    EditText task_detail;
    EditText deadline;
    Button btn;
    String TaskTitle;
    String TaskDetail;
    String TaskDeadline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        task_detail=findViewById(R.id.task_detail);
        deadline=findViewById(R.id.date);
        btn=findViewById(R.id.Upload_btn);
        TaskTitle = title.getText().toString();
        TaskDetail = task_detail.getText().toString();
        TaskDeadline = deadline.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insert(TaskTitle, TaskDetail, TaskDeadline);
            }
        });



    }
}