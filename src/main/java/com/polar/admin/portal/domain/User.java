package com.polar.admin.portal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
