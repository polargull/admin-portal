package com.polar.admin.portal.domain.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by fuwei on 2018/6/11.
 */
@Getter
@Setter
@Entity
public class Org {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long parentId;
    String name;
    String simpleName;
    String manager;
    String sortNum;
    String remark;
}
