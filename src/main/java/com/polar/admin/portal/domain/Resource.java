package com.polar.admin.portal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by fuwei on 2018/6/11.
 */
@Data
@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String code;
    int type;
    int parentId;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
