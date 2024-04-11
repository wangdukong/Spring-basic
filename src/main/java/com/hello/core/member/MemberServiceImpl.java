package com.hello.core.member;

public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository=new MemoryMemberRepository();
    //DIP 지켜지지 않음, 구현체를 의존
    //-> 따라서 저장소가 바뀌면 서비스 코드도 바뀌어야함 ->OCP 원칙 지켜지지 않음
    private final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository repository){ //생성자 주입방식
        this.memberRepository=repository;
    }
    //DIP와 OCP 해결
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
