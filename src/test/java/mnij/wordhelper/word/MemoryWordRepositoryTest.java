package mnij.wordhelper.word;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryWordRepositoryTest {

    MemoryWordRepository repo;

    @BeforeEach
    void before() {
        repo = new MemoryWordRepository();
    }

    @Test
    @DisplayName("단어 등록 테스트")
    void regWordTest() {
        Word word1 = new Word("jinwon", "love", "사랑하다", 0);
        Word word2 = new Word("jinwon", "like", "좋아하다", 0);
        Word word3 = new Word("jinwon", "hate", "싫어하다", 0);
        Word word4 = new Word("jinwon", "dislike", "싫어하다", 0);

        repo.regWord(word1);
        repo.regWord(word2);
        repo.regWord(word3);
        repo.regWord(word4);

        List<Word> words = repo.getWords(word1.getMemberId());
        assertThat(words.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("중복 단어 등록 테스트")
    void regDuplicatedWord() {
        Word word = new Word("jinwon", "love", "사랑하다", 0);

        repo.regWord(word);
        Throwable e = assertThrows(RuntimeException.class, () -> repo.regWord(word));
        assertThat(e.getMessage()).isEqualTo("이미 등록된 단어입니다!");
    }

    @Test
    @DisplayName("아무 단어도 등록하지 않았을 때 getWords 테스트")
    void getWordEmptyTest() {
        Throwable e = assertThrows(RuntimeException.class, () -> repo.getWords("jinwon"));
        assertThat(e.getMessage()).isEqualTo("아무 단어도 등록하지 않았습니다!");

    }
}