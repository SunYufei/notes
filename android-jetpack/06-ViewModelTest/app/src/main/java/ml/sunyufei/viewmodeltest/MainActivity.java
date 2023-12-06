package ml.sunyufei.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    TextView textView;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MyViewModel.class);

        textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(myViewModel.number));

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.number++;
                textView.setText(String.valueOf(myViewModel.number));
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.number += 2;
                textView.setText(String.valueOf(myViewModel.number));
            }
        });
    }
}