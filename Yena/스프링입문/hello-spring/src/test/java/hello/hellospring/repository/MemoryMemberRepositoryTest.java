package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){ //메소드 끝날때마다 호출
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);//리퍼지터리에 저장

        Member result = repository.findById(member.getId()).get();//리퍼지터리에 id를 가져오는지 확인
        //optional에서 값을 꺼낼 땐 get으로 꺼낼 수 있음.
        //메모리에서 꺼낸것과 저장한 것이 같으면 참
       // System.out.println("result = "+(result=member)); 이렇게 작성할 수 있으나 콘솔로 계속 확인해야함
        assertThat(member).isEqualTo(result); //멤버가 결과와 같은가
    }

    @Test
    public  void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

     Member result =  repository.findByName("spring1").get();
     assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
