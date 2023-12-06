package ml.sunyufei.orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // 恢复状态
        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("KEY");
            textView.setText(s);
        }

        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.button1);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        // 发生屏幕翻转时保存数据
        outState.putString("KEY", textView.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 屏幕翻转时 activity 被销毁掉重新加载
        // 为保存的数据将被丢弃
        Log.d(TAG, "onDestroy: ");
    }
}