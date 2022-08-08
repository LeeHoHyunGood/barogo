package com.barogo.domain.member;

import com.barogo.api.common.JpaExpdRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaExpdRepository<Member, String> {
}
