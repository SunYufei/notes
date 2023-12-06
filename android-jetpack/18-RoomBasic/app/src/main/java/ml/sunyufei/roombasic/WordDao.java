package ml.sunyufei.roombasic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao    // Database access object
public interface WordDao {
    @Insert
    void insertWords(Word... words);

    @Update
    int updateWords(Word... words);

    @Delete
    void deleteWords(Word... words);

    @Query("DELETE FROM Word")
    void deleteAllWords();

    @Query("SELECT * FROM Word ORDER BY id DESC")
    List<Word> getAllWords();
}
