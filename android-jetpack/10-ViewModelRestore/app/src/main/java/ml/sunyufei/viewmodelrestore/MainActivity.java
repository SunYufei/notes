package ml.sunyufei.viewmodelrestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import ml.sunyufei.viewmodelrestore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyViewModel myViewModel;

    public final static String KEY_NUMBER = "my_number";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        myViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MyViewModel.class);
        myViewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);
        // 利用 onSaveInstanceState 保存数据
//        if (savedInstanceState != null) {
//            myViewModel.getNumber().setValue(savedInstanceState.getInt(KEY_NUMBER));
//        }

        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//        outState.putInt(KEY_NUMBER, myViewModel.getNumber().getValue());
//    }
}