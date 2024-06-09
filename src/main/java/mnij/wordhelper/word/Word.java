package mnij.wordhelper.word;

public class Word {
    private String memberId; // 단어를 등록한 회원 아이디 저장
    private String word;
    private String meaning;
    private int wrongCnt; // 단어테스트에서 틀린 횟수 저장

    public Word(String memberId, String word, String meaning, int wrongCnt) {
        this.memberId = memberId;
        this.word = word;
        this.meaning = meaning;
        this.wrongCnt = wrongCnt;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public int getWrongCnt() {
        return wrongCnt;
    }

    public void setWrongCnt(int wrongCnt) {
        this.wrongCnt = wrongCnt;
    }

    @Override
    public String toString() {
        return "Word{" +
                "memberId='" + memberId + '\'' +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", wrongCnt=" + wrongCnt +
                '}';
    }
}
