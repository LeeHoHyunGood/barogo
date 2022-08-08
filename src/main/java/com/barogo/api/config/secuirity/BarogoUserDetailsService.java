package com.barogo.api.config.secuirity;

import com.barogo.domain.member.Member;
import com.barogo.domain.member.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BarogoUserDetailsService implements UserDetailsService {

    @Resource private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("존재 하지 않는 사용자 입니다."));
        return (UserDetails) memberRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("존재 하지 않는 사용자 입니다."));
    }
}
