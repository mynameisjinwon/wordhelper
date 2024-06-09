package mnij.wordhelper.member;

import java.util.List;

public interface MemberService {
    void join(Member member);

    Member findById(String memberId);
}
