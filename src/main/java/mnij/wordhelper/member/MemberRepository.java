package mnij.wordhelper.member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);

    Member findById(String memberId);

    List<Member> findAll();
}
