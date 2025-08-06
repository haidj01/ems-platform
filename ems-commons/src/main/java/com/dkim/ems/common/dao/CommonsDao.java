package com.dkim.ems.common.dao;

import jakarta.annotation.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CommonsDao<E> {

    @Resource
    private R2dbcEntityTemplate r2dbcEntityTemplate;

    public Mono<E> save(E entity) {
        return r2dbcEntityTemplate.insert(entity);
    }

    public Mono<E> update(E entity) {
        return r2dbcEntityTemplate.update(entity);
    }

    public Mono<E> upsert(E entity) {
        return r2dbcEntityTemplate.insert(entity)
            .onErrorResume(DataIntegrityViolationException.class,
                e -> r2dbcEntityTemplate.update(entity));
    }

    public Mono<Long> update(Update update, Query query, Class<E> clazz) {
        return r2dbcEntityTemplate.update(query,update, clazz );
    }


    public Mono<E> SelectOne(E entity, Query query, Class<E> clazz) {
        return r2dbcEntityTemplate.select(clazz).matching(query).one();
    }

    public Flux<E> selectAll(Class<E> clazz) {
        return r2dbcEntityTemplate.select(clazz).all();
    }

    public Mono<Void> delete(Class<E> clazz, Query query) {
        return r2dbcEntityTemplate.delete(clazz).matching(query)
            .all().then();
    }
}
