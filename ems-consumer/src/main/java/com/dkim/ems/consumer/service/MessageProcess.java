package com.dkim.ems.consumer.service;

import com.dkim.ems.common.model.Employee;
import com.dkim.ems.common.model.EmployeeGlobal;
import com.dkim.ems.common.service.CommonsEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MessageProcess {

    @Resource
    CommonsEmployeeService employeeService;

    @Bean
    public Consumer<KStream<String, String>> process (ObjectMapper objectMapperForSnakeCase) {
        return input -> input.foreach((key, value) -> {
            System.out.println("Received key=" + key + ", value=" + value);
            try {
                EmployeeGlobal employeeGlobal = objectMapperForSnakeCase.readValue(value, EmployeeGlobal.class);
                Employee employee = employeeGlobal.getEmployee();
                employeeService.upsertEmployee(employee)
                    .then()
                    .subscribe();
                System.out.println(employee);
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });
    }
}
