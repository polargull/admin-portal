package com.polar.admin.portal.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by fuwei on 2018/6/11.
 */
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @ManyToMany
    List<Resource> resource;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
