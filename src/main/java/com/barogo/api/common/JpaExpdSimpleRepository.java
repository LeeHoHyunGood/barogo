package com.barogo.api.common;

import com.barogo.api.common.JpaExpdRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * SimpleJpaRepository 의 구현체
 * */
public class JpaExpdSimpleRepository<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements JpaExpdRepository<T,ID> {

    private EntityManager entityManager;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public JpaExpdSimpleRepository(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override public List<T> findAny(int limit) {
        PageRequest req = PageRequest.of(0,limit);
        List<T> content = findAll(req).getContent();
        return content;
    }

}
