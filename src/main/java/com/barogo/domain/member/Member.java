package com.barogo.domain.member;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "member")
public class Member implements Serializable {

    @Id
    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false, length = 10)
    private String memberName;

    @Column(length = 1000)
    private String pwd;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, length = 20)
//    private RoleGroup roleGroup;


}
