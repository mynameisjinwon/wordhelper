package mnij.wordhelper.member;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<String, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        // 중복 확인
        if (checkDuplicate(member)) {
            throw new RuntimeException("사용할 수 없는 id 입니다.");
        }

        store.put(member.getMemberId(), member);
    }

    private static boolean checkDuplicate(Member member) {
        Member duplicateChecker = store.getOrDefault(member.getMemberId(), null);
        return duplicateChecker != null;
    }

    @Override
    public Member findById(String memberId) {
        return store.get(memberId);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<Member>(store.values());
    }

    public void clear() {
        store.clear();
    }
}
