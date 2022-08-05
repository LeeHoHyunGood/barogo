package com.barogo.api.web;

import lombok.Data;

/**
 * 응답 공통 템플릿
 * */
@Data
public class RespWrapper {

    private final boolean ok;
    private final Object data;

    /** 성공 */
    public static RespWrapper ok(Object dto){
        return new RespWrapper(true, dto);
    }

    /** 실패 */
    public static RespWrapper fail(Object dto){
        return new RespWrapper(false, dto);
    }

}
