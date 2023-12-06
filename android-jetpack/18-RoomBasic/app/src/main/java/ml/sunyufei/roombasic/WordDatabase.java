package ml.sunyufei.roombasic;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    // 多个 entity，用多个 Dao
    public abstract WordDao getWordDao();
}
