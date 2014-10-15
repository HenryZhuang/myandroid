package com.zhb.myandroid.activity;

import com.loopj.android.image.SmartImageView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private static final String imgUrl = "http://img2.nipic.com/2008-03-07/20083781418265_1.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SmartImageView siv = (SmartImageView) this.findViewById(R.id.siv);
        Button btn = (Button) this.findViewById(R.id.testBtn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                TelephonyManager telephonyManager = (TelephonyManager) MainActivity.this.getSystemService((Context.TELEPHONY_SERVICE));
                // String NativePhoneNumber = telephonyManager.getLine1Number();
                String imsi = telephonyManager.getSimSerialNumber();

                System.out.println("saf:" + imsi);
                // 测试SmartImageView的使用
                // siv.setImageUrl(imgUrl, R.drawable.ic_launcher,
                // R.drawable.ic_launcher);

                // MyUtils.callPhone(MainActivity.this, "10086");//测试拨打电话
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void btn2(View view) {
         
    }

    public void btn3(View view) {
    }
}
