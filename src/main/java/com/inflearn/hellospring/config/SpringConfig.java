package com.inflearn.hellospring.config;

import com.inflearn.hellospring.repository.JdbcMemberRepository;
import com.inflearn.hellospring.repository.JdbcTemplateMemberRepository;
import com.inflearn.hellospring.repository.MemberRepository;
import com.inflearn.hellospring.repository.MemoryMemberRepository;
import com.inflearn.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
