package com.example.csm.sms_sender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view) {
        EditText et_phone = (EditText) findViewById(R.id.et_phone);
        EditText et_content = (EditText) findViewById(R.id.et_content);

        String phone = et_phone.getText().toString();
        String content = et_content.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        List<String> smss = smsManager.divideMessage(content);
        for (String sms:smss) {
            //arg0:发送短信的号码
            //arg1:短信服务中心的号码，不要设置
            //arg2:短信内容
            smsManager.sendTextMessage(phone, null, sms, null, null);
        }
    }
}
