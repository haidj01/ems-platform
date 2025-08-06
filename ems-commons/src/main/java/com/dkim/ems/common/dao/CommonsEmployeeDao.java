package com.dkim.ems.common.dao;

import com.dkim.ems.common.model.Employee;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CommonsEmployeeDao {

    @Resource
    private CommonsDao<Employee> commonsDao;

    public Mono<Employee> upsertEmployee(Employee employee) {
        return commonsDao.upsert(employee);
    }
}
