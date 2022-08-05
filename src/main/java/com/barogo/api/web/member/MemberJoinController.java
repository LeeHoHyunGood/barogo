package com.barogo.api.web.member;

import com.barogo.api.web.RespWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/member")
public class MemberJoinController {

    @GetMapping("join/{memberId}")
    public RespWrapper getItem(@PathVariable String memberId) {
        return RespWrapper.ok("memberJoin");
    }

}
