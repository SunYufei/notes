package ml.sunyufei.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class MyData {
    public int number;

    private final Context context;

    public MyData(Context context) {
        this.context = context;
    }

    public void save() {
        String name = context.getResources().getString(R.string.shared_preference);
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(context.getResources().getString(R.string.my_key), number);
        editor.apply();
    }

    public int load() {
        String name = context.getResources().getString(R.string.shared_preference);
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        number = sharedPreferences.getInt(context.getResources().getString(R.string.my_key),
                context.getResources().getInteger(R.integer.default_value));
        return number;
    }
}
