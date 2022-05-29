package com.cr.accountsMigration.model;

import org.apache.logging.log4j.util.Strings;

import java.time.LocalDateTime;

public class Person {
    private Integer id;
    private String name;
    private String email;
    private LocalDateTime bday;
    private Integer age;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBday() {
        return bday;
    }

    public void setBday(LocalDateTime bday) {
        this.bday = bday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public boolean isValida() {
        return !Strings.isBlank(name) && !Strings.isBlank(email) && bday != null;
    }

}
