package com.polar.admin.portal.dao.security;

import com.polar.admin.portal.domain.security.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fuyuanpu on 2018/6/30.
 */
public interface ResourceDao extends JpaRepository<Resource, Long> {
}
