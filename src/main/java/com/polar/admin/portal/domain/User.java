package com.polar.admin.portal.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by fuyuanpu on 2018/6/3.
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String pwd;
    String realName;
    String contact;
    String email;
    int status;
    @ManyToOne
    Org org;
    @ManyToMany
    List<Role> role;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
