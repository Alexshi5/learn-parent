package com.mengfei.test.fbsep.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    private static final long serialVersionUID = -1143500883607680243L;

    private Long oid;

    private String username;

    private String pwd;

    private Integer age;

    private String email;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "oid=" + oid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
