package ml.sunyufei.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String TAG = "myTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getPreferences
        // SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String name = getString(R.string.shared_preference);
        SharedPreferences sharedPreferences = getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.my_key), 100);
        editor.apply(); // 非同步提交 或 editor.commit();

        int x = sharedPreferences.getInt(getString(R.string.my_key),
                getApplicationContext().getResources().getInteger(R.integer.default_value));
        Log.d(TAG, "onCreate: " + x);

        // getApplicationContext() 指向 app 的全局引用，不能传递 this
        MyData myData = new MyData(getApplicationContext());
        myData.number = 1000;
        myData.save();
        int y = myData.load();
        Log.d(TAG, "onCreate: " + y);
    }
}