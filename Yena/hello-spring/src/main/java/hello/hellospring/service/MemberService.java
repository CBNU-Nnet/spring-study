package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
public class MemberService {


    private final MemberRepository memberRepository;
    //외부에서 넣어주도록 함

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /**
    회원 가입
     */
    public Long join(Member member){ //같은 이름이 있으면 안된다
        //같은 이름이 있는 중복 회원은 x

        ValidateDuplicateMember(member);//중복 회원 검증

        memberRepository.save(member);
        return member.getId();

    }

    private void ValidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
               .ifPresent(m -> {
                   //optional로 감싸서 사용할 수 있음
           throw new IllegalStateException("이미 존재하는 회원입니다. ");

       });
    }

    /**
     전체 회원 조회
     **/
    public List<Member> findMembers(){
         return memberRepository.findAll();

    }
    public  Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
