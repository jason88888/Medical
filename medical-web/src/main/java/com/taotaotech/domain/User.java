package com.taotaotech.domain;

import com.taotaotech.service.Page;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;

public class User {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String code;

    private String username;

    private String password;

    private Byte role;

    protected Page<User> page;

    @JsonIgnore
    @XmlTransient
    public Page<User> getPage() {
        if (page == null){
            page = new Page<User>();
        }
        return page;
    }

    public Page<User> setPage(Page<User> page) {
        this.page = page;
        return page;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}