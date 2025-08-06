package com.dkim.ems.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends BaseModel {
    @Id
    private String id;
    private String name;
    private String email;
    private Double salary;
    private int age;
    private Instant createdAt;
    private Boolean isActive;

    public Employee(String id, String name, String email, Double salary, int age, Instant createdAt, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.age = age;
        this.createdAt = createdAt;
        this.isActive = isActive;
    }
}
