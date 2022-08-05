package com.barogo.api.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
public class CommonConfiguration {

    /** 프로젝트 명 */
    public static final String PROJECT_NAME = "barogo";

    /** 프로젝트 루트 */
    public static final String PROJECT_ROOT = "com.barogo";

    /** 프로젝트 도메인 */
    public static final String PROJECT_DOMAIN = PROJECT_ROOT+".domain";

    /** db 정보 local만 있으니 JDBC_MINIMUM_IDLE 1 풀사이즈4로만 해둔다
     * 해당 db 정보는 static으로 있으면 안되는데 보안적으로 aws 쓰거나 따로 관리를 해야 한다
     * 하지만 여기선 일단 이렇게... */
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/barogo?relaxAutoCommit=true";
    public static final String JDBC_USERNAME = "dlghgus";
    public static final String JDBC_PWD = "gheoddl123!@#";
    public static final int JDBC_MAX_POOL_SIZE = 4;
    public static final int JDBC_MINIMUM_IDLE = 1;

}
