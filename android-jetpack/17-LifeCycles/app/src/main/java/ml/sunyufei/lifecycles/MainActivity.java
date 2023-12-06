package ml.sunyufei.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    MyChronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.meter);
//        chronometer.setBase(System.currentTimeMillis());    // UNIX 时间
//        chronometer.setBase(SystemClock.elapsedRealtime()); // 默认，手机从上一次启动到现在的时间
//        chronometer.start();
        getLifecycle().addObserver(chronometer);
    }
}