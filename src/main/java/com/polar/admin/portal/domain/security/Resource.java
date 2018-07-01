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
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    int parentId;
    String name;
    String code;
    Type type;
    String remark;

    public enum Type {
        MENU, PERMISSION;
    }
}
