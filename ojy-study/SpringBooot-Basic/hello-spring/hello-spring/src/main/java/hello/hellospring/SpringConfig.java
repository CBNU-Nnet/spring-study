package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRespository memberRespository;

    @Autowired
    public SpringConfig(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }


    @Bean
    public MemberService memberService(){

        return new MemberService(memberRespository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
    //@Bean
    //public MemberRespository memberRespository(){
        //return new JdbcMemberRepository(dataSource);
        //인터페이스는 new가 안됨
        //return new JdbcTemplateMemberRepository(dataSource);
       // return new JpaMemberRepository(em);

    //}
}
