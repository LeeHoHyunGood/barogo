package com.barogo.api.config.secuirity;

import com.barogo.domain.member.Member;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class AuthVo implements UserDetails {

    private Member member;

    public static AuthVo of(Member member) {
        AuthVo vo = new AuthVo();
        vo.member = member;
        return vo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getMember().getAuthorities();
    }

    @Override
    public String getPassword() {
        return getMember().getPwd();
    }

    @Override
    public String getUsername() {
        return getMember().getMemberId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
