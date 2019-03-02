package com.example.hezhanheng.myapplication;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
private EditText et;
private RadioButton rb1;
private RadioButton rb2;
private Double height;
private String sex;
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initData();
        jump();
    }

    private void initData() {
        et=(EditText)findViewById(R.id.et);
        btn=(Button)findViewById(R.id.btn);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
    }

    private void jump() {
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                String str= et.getText().toString();
                if(!str.equals(""))
                    height=Double.parseDouble(et.getText().toString());
                else {
                    et.setHint("请输入身高");
                    return;
                }
                if (rb1.isChecked()){
                    sex="M";
                }
                else{
                    sex="W";
                }
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,twoActivity.class);
                Bundle bundle=new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,requestCode,data);
        if (requestCode==RESULT_OK)
        {
            Bundle bundle=data.getExtras();
            sex=bundle.getString("sex");
            height=bundle.getDouble("height");
            if(sex.equals("M")){
                rb1.setChecked(true);
            }
            else{
                rb2.setChecked(true);
            }
            String str=height.toString();
            et.setText(str);
        }
    }
}
