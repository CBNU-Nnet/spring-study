package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository  implements  MemberRepository{
    private  static Map<Long, Member> store = new HashMap<>();//키는 회원의 아이디 값은 멤버
    private static long sequence = 0L;//키값을 0,1,2,,생성해 주는 것

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //시퀀스 값을 1나 증가 시키고
        store.put(member.getId(), member); //맵에 아이디와 멤버 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {//store에서 꺼내기
       // return store.get(id); //null이 반환될 수 있으니 optional로 감싸야함
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public Optional<Member> findByName(String name) {

       return  store.values().stream()
                .filter(member -> member.getName().equals(name))//찾는 이름과 같은지
                .findAny(); //루프를 계속 돌면서 찾음 , 앖으면 optional 반환

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());//스토어의 멤버들이 반환됨
    }
    public void clearStore(){
        store.clear(); //store을 싹 비워줌
    }
}
