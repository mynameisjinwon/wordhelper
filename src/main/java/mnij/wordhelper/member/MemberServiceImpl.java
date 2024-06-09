package mnij.wordhelper.member;

public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(String memberId) {
        return memberRepository.findById(memberId);
    }
}
