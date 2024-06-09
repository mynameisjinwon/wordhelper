package mnij.wordhelper.word;

import java.util.List;

public class WordServiceImpl implements WordService {

    WordRepository wordRepository = new MemoryWordRepository();

    @Override
    public void regWord(Word word) {
        wordRepository.regWord(word);
    }

    @Override
    public List<Word> getWordList(String memberId) {
        return wordRepository.getWords(memberId);
    }
}
