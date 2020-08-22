package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//회원save 기능
    Optional<Member> findById(Long id);//id로 회원을 찾는것
    Optional<Member> findByName(String name);//이름으로 회원 찾기
    List<Member> findAll();//저장한 회원 반환하는 리스트
}
