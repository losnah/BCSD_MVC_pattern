package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NoticeEnrollActivity extends AppCompatActivity {

    private EditText mEditTextTitle;
    private EditText mEditTextName;
    private EditText mEditTextTime;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_enroll);

        init();
    }

    void init(){
        mEditTextTitle = (EditText)findViewById(R.id.activity_notice_enroll_title_edittext);
        mEditTextName = (EditText)findViewById(R.id.activity_notice_enroll_name_edittext);
        mEditTextTime = (EditText)findViewById(R.id.activity_notice_enroll_time_edittext);
        mButton = (Button)findViewById(R.id.activity_notice_enroll_button);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("title",mEditTextTitle.getText().toString());
                intent.putExtra("name",mEditTextName.getText().toString());
                intent.putExtra("time",mEditTextTime.getText().toString());

                startActivity(intent);

            }
        });

    }
}
