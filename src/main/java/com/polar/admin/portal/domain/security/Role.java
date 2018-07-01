package com.polar.admin.portal.domain.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by fuwei on 2018/6/11.
 */
@Setter
@Getter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String enName;
    @ManyToMany
    List<Resource> resource;
}