package mnij.wordhelper.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordServiceImpl implements WordService {

    WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public void regWord(Word word) {
        wordRepository.regWord(word);
    }

    @Override
    public List<Word> getWordList(String memberId) {
        return wordRepository.getWords(memberId);
    }
}
