package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public abstract class MemberRepository {

    abstract Member save(Member member);
    abstract Optional<Member> findById(Long id);
    abstract Optional<Member> findByName(String name);
    abstract List<Member> findAll();

}
