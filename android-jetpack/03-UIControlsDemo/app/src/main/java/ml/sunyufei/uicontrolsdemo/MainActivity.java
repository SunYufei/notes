package ml.sunyufei.uicontrolsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    Switch aSwitch;
    ProgressBar progressBar;
    EditText editText;
    RadioGroup radioGroup;
    CheckBox checkBoxJava, checkBoxGo, checkBoxDart;
    String java = "", go = "", dart = "";
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.button);
            }
        });

        aSwitch = findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setText("Open");
                } else {
                    textView.setText("Close");
                }
            }
        });

        progressBar = findViewById(R.id.progressBar);

        editText = findViewById(R.id.editTextPlain);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    textView.setText(R.string.android);
                } else if (checkedId == R.id.radioButton2) {
                    textView.setText(R.string.ios);
                }
            }
        });

        checkBoxJava = findViewById(R.id.checkBox1);
        checkBoxJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    java = "Java";
                } else {
                    java = "";
                }
                textView.setText(java + go + dart);
            }
        });

        checkBoxGo = findViewById(R.id.checkBox2);
        checkBoxGo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    go = "Golang";
                } else {
                    go = "";
                }
                textView.setText(java + go + dart);
            }
        });

        checkBoxDart = findViewById(R.id.checkBox3);
        checkBoxDart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dart = "Dart";
                } else {
                    dart = "";
                }
                textView.setText(java + go + dart);
            }
        });

        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView.setText("pause");
    }
}