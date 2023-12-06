package ml.sunyufei.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordDatabase wordDatabase;
    WordDao wordDao;

    Button buttonInsert, buttonUpdate, buttonClear, buttonDelete;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordDatabase = Room.databaseBuilder(this, WordDatabase.class, "word_database")
                .allowMainThreadQueries()   // 临时使用
                .build();
        wordDao = wordDatabase.getWordDao();

        updateView();

        textView = findViewById(R.id.textView);

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(view -> {
            Word word1 = new Word("hello", "你好");
            Word word2 = new Word("world", "世界");
            wordDao.insertWords(word1, word2);
            updateView();
        });

        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(view -> {
            wordDao.deleteAllWords();
            updateView();
        });

        buttonUpdate = findViewById(R.id.buttonUpdate);

        buttonDelete = findViewById(R.id.buttonDelete);
    }

    private void updateView() {
        List<Word> list = wordDao.getAllWords();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Word word = list.get(i);
            text.append(word.getId())
                    .append(":")
                    .append(word.getWord())
                    .append("=")
                    .append(word.getChineseMeaning())
                    .append("\n");
        }
        textView.setText(text.toString());
    }
}