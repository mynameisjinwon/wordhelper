package mnij.wordhelper.word;

import java.util.List;

public interface WordRepository {

    void regWord(Word word);

    List<Word> getWords(String memberId);
}
