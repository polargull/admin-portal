package com.polar.admin.portal.dao.security;

import com.polar.admin.portal.domain.security.Org;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fuyuanpu on 2018/6/30.
 */
public interface OrgDao extends JpaRepository<Org, Long> {
}
