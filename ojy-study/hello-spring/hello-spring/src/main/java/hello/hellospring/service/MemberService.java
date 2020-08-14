package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRespository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRespository memberRespository;

    //생성자를 통해서 들어옴,생성자 주입
    public MemberService(MemberRespository memberReposiory ){
        this.memberRespository=memberReposiory;
    }

    /*
    회원가입
     */
    public Long join(Member member){
       //같은 이름이 있는 중복 회원 x
        validateDuplicateMember(member);//중복 회원 검증
        memberRespository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member){
        memberRespository.findByName(member.getName())
                .ifPresent(m -> {
                   throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /*
    전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRespository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRespository.findById(memberId);
    }

}
