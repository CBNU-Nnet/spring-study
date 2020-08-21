package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
  //  @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입()  {
        //given 주어졌을 때
        Member member = new Member();
        member.setName("spring8");

        //when 이러한 상황에
        Long saveId = memberService.join(member);

        //then 이렇게 동작해야 함
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    public void 중복_회원_예외(){

            //given
            Member member1 = new Member();
            member1.setName("spring");

            Member member2 = new Member();
            member2.setName("spring");

            //when
            memberService.join(member1);
            IllegalStateException e = assertThrows(IllegalStateException.class,()-> memberService.join(member2)) ;
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ");
    }


}
