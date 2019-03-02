package com.example.hezhanheng.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HeZhanHeng on 2018/4/23.
 */

public class twoActivity extends AppCompatActivity {
    private TextView textView;
    private String sex;
    private  String sexText;
    private Double height;
    private String weight;
    private Button button;
    private Intent intent;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstate){
        super.onCreate(savedInstate);
        setContentView(R.layout.activity_two);
        initData();
        setBackData();
    }

    private void initData() {
        textView=(TextView)findViewById(R.id.text);
        button=(Button)findViewById(R.id.btn2);
        intent=this.getIntent();
        bundle=intent.getExtras();
        sex=bundle.getString("sex");
        height=bundle.getDouble("height");
        if(sex.equals("M"));
        {
            sexText = "男性";
        }


        getWeight();
    }

    public void getWeight() {
        if (sex.equals("M")){
            weight=(height-80)*0.7+"";
        }else {
            weight=(height-70)*0.6+"";
        }
    }
         private void setBackData(){
        textView.setText("你是一位"+sexText+"\n你的身高是"+height+"厘米\n你的标准体重是"+weight+"公斤");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK,intent);
                finish();
            }
        });
}


}
