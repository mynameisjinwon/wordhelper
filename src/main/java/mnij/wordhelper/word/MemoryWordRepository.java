package mnij.wordhelper.word;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemoryWordRepository implements WordRepository{

    private static final Map<String, Map<String, Word>> wordStore = new HashMap<>();

    @Override
    public void regWord(Word word) {

        // 해당 멤버가 등록한 단어가 없으면 HashMap 을 초기화한다.
        if (wordStore.get(word.getMemberId()) == null) {
            Map<String, Word> wordMap = new HashMap<>();
            wordStore.put(word.getMemberId(), wordMap);
        }
        // 등록하려고 하는 단어가 이미 있는 단어이면 예외 발생
        if (checkDuplicate(word)) {
            throw new RuntimeException("이미 등록된 단어입니다!");
        }
        wordStore.get(word.getMemberId()).put(word.getWord(), word);
    }

    private static boolean checkDuplicate(Word word) {
        Map<String, Word> wordMap = wordStore.getOrDefault(word.getMemberId(), null);

        // 등록된 단어가 없으면 중복 확인 x
        if(wordMap == null) return false;

        Word duplicateChecker = wordMap.getOrDefault(word.getWord(), null);
        return duplicateChecker != null;
    }

    @Override
    public List<Word> getWords(String memberId) {
        if(wordStore.get(memberId) == null)
            throw new RuntimeException("아무 단어도 등록하지 않았습니다!");
        return new ArrayList<>(wordStore.get(memberId).values());
    }
}
