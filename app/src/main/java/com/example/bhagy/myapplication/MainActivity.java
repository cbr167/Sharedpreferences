package com.example.bhagy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editName)
    EditText editName;

    @BindView(R.id.editemail)
    EditText editEmail;

    @BindView(R.id.saveButton)
    Button saveButton;

    @BindView(R.id.getButton)
    Button getButton;

    @BindView(R.id.clearButton)
    Button clearButton;

    @BindView(R.id.nameText)
    TextView nameText;

    @BindView(R.id.emailText)
    TextView emailText;
private  SaveSetting saveSetting = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (null == saveSetting) {
            saveSetting = SaveSetting.getInstance();
            saveSetting.initSetting(getApplicationContext());
        }
    //     SaveSetting saveSetting = new SaveSetting();



        saveButton.setOnClickListener(btnListener);
        getButton.setOnClickListener(btnListener);
        clearButton.setOnClickListener(btnListener);
    }

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.saveButton:
                        saveSetting.name = editName.getText().toString();
                        saveSetting.email = editEmail.getText().toString();
                        saveSetting.saveDetails();
                        break;
                    case R.id.getButton:
                        nameText.setText(saveSetting.getName());
                        emailText.setText(saveSetting.getEmail());
                        break;
                    case R.id.clearButton:
                        saveSetting.clear();
                        break;
                }
            }
        };

    }

