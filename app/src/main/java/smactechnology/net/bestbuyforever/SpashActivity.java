package smactechnology.net.bestbuyforever;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

public class SpashActivity extends AppCompatActivity {
class MyTimer extends CountDownTimer{

    public MyTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long l) {

    }

    @Override
    public void onFinish() {
Intent intent=new Intent(SpashActivity.this,MainActivity.class);
startActivity(intent);
finish();
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        MyTimer timer=new MyTimer(2000,500);
        timer.start();

    }
}
