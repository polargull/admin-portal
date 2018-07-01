package com.polar.admin.portal.domain.security;

import com.polar.admin.portal.util.EnumDisplayNameSupport;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by fuyuanpu on 2018/6/3.
 */

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(unique = true)
    String name;
    String pwd;
    String realName;
    String contact;
    String email;
    @Enumerated
    Status status;
    @ManyToMany
    Set<Org> org;
    @ManyToMany
    Set<Role> role;
    long chiefId;

    public enum Status implements EnumDisplayNameSupport {
        DISABLE("禁用"), ENABLE("启用");
        private String displayName;

        Status(String name) {
            displayName = name;
        }

        public static Status of(int ordinal) {
            return Status.values()[ordinal];
        }

        @Override
        public String displayName() {
            return this.displayName;
        }
    }
}
