package mnij.wordhelper.word;

import java.util.List;

public interface WordService {
    void regWord(Word word);

    List<Word> getWordList(String memberId);
}
