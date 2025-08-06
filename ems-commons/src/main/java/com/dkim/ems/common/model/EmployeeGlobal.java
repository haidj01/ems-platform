package com.dkim.ems.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.Instant;


@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeGlobal extends BaseModel{

    private String id;
    private String name;
    private String email;
    private Double salary;
    private int age;
    private Instant createdAt;
    private Boolean isActive;
    private String location;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;

    @JsonIgnore
    private Employee employee;

    public Employee getEmployee() {
        return new Employee(id, name, email, salary, age, createdAt, isActive,getGroupId(), getEventId(), getEventTime());
    }
}
