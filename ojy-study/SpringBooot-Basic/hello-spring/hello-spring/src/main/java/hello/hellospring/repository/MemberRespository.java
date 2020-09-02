package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRespository {

    Member save(Member member);
    Optional<Member> findById(Long id); //id,name을 가져옴 null알아서 처리
    Optional<Member> findByName(String name);
    List<Member> findAll(); //저장된 모든 멤버 리스트 반환

}
