package com.nzh.entity;

/**
 * @author 倪志浩
 * @program springboot-shiro
 * @packageName com.nzh.entity
 * @ClassName User
 * @description
 * @create 2020-01-22
 * @Version 1.0
 **/
public class User {
    private String id;
    private String name;
    private String password;
    private String perms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}
