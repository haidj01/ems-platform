package com.dkim.ems.common.service;

import com.dkim.ems.common.dao.CommonsEmployeeDao;
import com.dkim.ems.common.model.Employee;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CommonsEmployeeService {
    @Resource
    CommonsEmployeeDao employeeDao;

    public Mono<Employee> upsertEmployee(Employee employee) {
        return employeeDao.upsertEmployee(employee);
    }
}
