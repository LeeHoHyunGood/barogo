package com.barogo.api.web.common;

import com.barogo.api.web.RespWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/common")
public class CommonController {

//    @Operation(summary = "테스트 GET", description = "가라 데이터를 GET 합니다.", responses = {
//            @ApiResponse(responseCode = "200", description = "가라 데이터 불러오기 성공"),
//            @ApiResponse(responseCode = "400", description = "존재하지 않는 리소스") })
    @GetMapping("test/{id}")
    public RespWrapper getItem(@PathVariable("id") String id) {
        System.out.println(id);
        return RespWrapper.ok("test");
    }
}
