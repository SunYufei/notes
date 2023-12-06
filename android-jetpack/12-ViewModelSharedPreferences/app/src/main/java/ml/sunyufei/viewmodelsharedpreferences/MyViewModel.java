package ml.sunyufei.viewmodelsharedpreferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    SavedStateHandle handle;
    String key = getApplication().getResources().getString(R.string.data_key);
    String name = getApplication().getResources().getString(R.string.shp_name);

    public LiveData<Integer> getNumber() {
        return handle.getLiveData(key);
    }

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(key)) {
            load();
        }
    }

    private void load() {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        int value = sharedPreferences.getInt(key, 0);
        handle.set(key, value);
    }

    public void save() {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, getNumber().getValue());
        editor.apply();
    }

    public void add(int x) {
        handle.set(key, getNumber().getValue() + x);
    }
}
