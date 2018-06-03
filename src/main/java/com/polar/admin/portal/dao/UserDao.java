package com.polar.admin.portal.dao;

import com.polar.admin.portal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fuyuanpu on 2018/6/3.
 */
public interface UserDao extends JpaRepository<User, Long> {
}
