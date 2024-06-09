package mnij.wordhelper.member;

import mnij.wordhelper.grade.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repo;

    @BeforeEach
    void beforeEach() {
        repo = new MemoryMemberRepository();
        repo.clear();
    }

    @Test
    @DisplayName("회원가입 테스트 ")
    void saveTest() {
        Member member = new Member("jinwon", "jinwon", "1234", Grade.BEG);
        repo.save(member);

        Member findMember = repo.findById("jinwon");

        assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
    }

    @Test
    @DisplayName("중복 회원 테스트")
    void duplicateMemberTest() {
        Member member = new Member("jinwon", "jinwon", "1234", Grade.BEG);
        repo.save(member);

        Member dupMember = new Member("jinwon", "jinwon", "1234", Grade.BEG);
        Throwable e = assertThrows(RuntimeException.class, () -> repo.save(dupMember));
        assertThat(e.getMessage()).isEqualTo("사용할 수 없는 id 입니다.");
    }

    @Test
    @DisplayName("전체 회원 조회 테스트")
    void findAllTest() {
        Member member1 = new Member("jinwon1", "jinwon1", "1234", Grade.BEG);
        repo.save(member1);

        Member member2 = new Member("jinwon2", "jinwon2", "1234", Grade.BEG);
        repo.save(member2);

        List<Member> memberList = repo.findAll();
        assertThat(memberList.size()).isEqualTo(2);
    }




}