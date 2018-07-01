package com.polar.admin.portal.dao.security;

import com.polar.admin.portal.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fuyuanpu on 2018/6/3.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByName(String name);
}
