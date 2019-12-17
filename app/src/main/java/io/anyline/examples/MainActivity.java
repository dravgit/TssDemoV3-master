package io.anyline.examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.tsslogo72);
    }

    public void showICCard(View v) {
        Intent intent = new Intent(this, IcCardActivity.class);
        startActivity(intent);
    }

    public void showICCardInfoOnly(View v) {
        Intent intent = new Intent(this, IcCardInfoOnlyActivity.class);
        startActivity(intent);
    }

    public void showDriver(View v) {
        Intent intent = new Intent("android.intent.action.SwipeCardActivity");
        startActivity(intent);
    }

    public void showVisa(View v) {
        Intent intent = new Intent("android.intent.action.VisaActivity");
        startActivity(intent);
    }

    public void showMaster(View v) {
        Intent intent = new Intent("android.intent.action.MasterActivity");
        startActivity(intent);
    }

    public void showElevenCard(View v) {
        Intent intent = new Intent("android.intent.action.ElevenActivity");
        startActivity(intent);
    }

    public void showPassport(View v) {
       Intent intent = new Intent("android.intent.action.PassportReader");
        startActivity(intent);
    }

    public void showIC_nopicCard(View v) {
        Intent intent = new Intent("android.intent.action.MainICNopicActivity");
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String message;
        if (requestCode == 2) {
            message = data.getStringExtra("MESSAGE");
            Intent intent = new Intent("android.intent.action.PrintActivity");
            startActivity(intent);
        }

        if (requestCode == 3) {
            message = data.getStringExtra("MESSAGE");
            String _xx = message;
        }

        if (requestCode == 0) {
            message = data.getStringExtra("MESSAGE");
            if (message.startsWith("READING")) {
                Intent i2 = new Intent();
                i2.setClassName("com.centerm.nfcforb4a", "com.centerm.nfcforb4a.MainActivity");
                i2.putExtra("CMD", "00A4040C07A0000002471001|0084000008");
                i2.putExtra("REQUEST_CODE", 2);
                i2.putExtra("RESET", true);
                startActivityForResult(i2, 2);
            }
        }
    }

    public void showPrinter(View v) {
        Intent intent = new Intent("android.intent.action.PrintOnline");
        startActivity(intent);
    }

    public void showUnionpay(View v) {
        Intent intent = new Intent("android.intent.action.UnionpayActivity");
        startActivity(intent);
    }
}
