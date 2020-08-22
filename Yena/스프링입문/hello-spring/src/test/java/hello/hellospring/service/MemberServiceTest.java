package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    //다른 인스턴스기떄문에 달라질 수 있기에 서비스에서 바꿔주어야함
    MemoryMemberRepository memberRepository;
    @BeforeEach
    public void beforeEach(){
        //테스트 실행할 때마다 각각 생성
        memberRepository = new MemoryMemberRepository(); //같은 메모리 레버지터리 사용
        memberService = new MemberService(memberRepository);//멤버 서비스에서 넣어주도록
    }

    @AfterEach
    public void afterEach(){ //메소드 끝날때마다 호출
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 주어졌을 때
        Member member = new Member();
        member.setName("spring");

        //when 이러한 상황에
        Long saveId = memberService.join(member);

        //then 이렇게 동작해야 함
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test 
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
        // memberService.join(member2);

      /*try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ");
        }*/
        //then
    }
    @Test
    void findMembers() {
    }
    @Test
    void findOne() {
    }
}