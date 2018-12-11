package com.example.bwq.paydialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.pay);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PayDialog(MainActivity.this).setData(20, 30)
                        .setListener(new PayDialog.OnPayClickListener() {
                            @Override
                            public void onPayClick(int payType) {
                                switch (payType) {
                                    case PayDialog.ALI_PAY:
                                        Toast.makeText(MainActivity.this, "支付宝", Toast.LENGTH_LONG).show();
                                        break;
                                    case PayDialog.WX_PAY:
                                        Toast.makeText(MainActivity.this, "微信", Toast.LENGTH_LONG).show();
                                        break;
                                    case PayDialog.BALANCE_PAY:
                                        Toast.makeText(MainActivity.this, "余额", Toast.LENGTH_LONG).show();
                                        break;
                                }
                            }
                        }).show();
            }
        });
    }
}
