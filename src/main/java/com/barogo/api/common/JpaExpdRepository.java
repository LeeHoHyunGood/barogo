package com.barogo.api.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 프로젝트에서 정의한 JPA 기본 구현체
 * */
@NoRepositoryBean
public interface JpaExpdRepository<T, ID extends Serializable>  extends JpaRepository<T, ID> {

    /**
     * 아무거나 X개를 찾아온다. 테스트 용도로 사용
     * */
    List<T> findAny(int limit);

}
