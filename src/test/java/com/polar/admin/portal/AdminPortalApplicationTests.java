package com.polar.admin.portal;

import com.polar.admin.portal.dao.security.OrgDao;
import com.polar.admin.portal.dao.security.ResourceDao;
import com.polar.admin.portal.dao.security.RoleDao;
import com.polar.admin.portal.dao.security.UserDao;
import com.polar.admin.portal.domain.security.Org;
import com.polar.admin.portal.domain.security.Resource;
import com.polar.admin.portal.domain.security.Role;
import com.polar.admin.portal.domain.security.User;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminPortalApplicationTests {
    public static final String TEST_NAME_1 = "test1";
    @Autowired
    UserDao userDao;
    @Autowired
    ResourceDao resourceDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    OrgDao orgDao;

    @Test
    public void contextLoads() {
        userDao.deleteAllInBatch();
        orgDao.deleteAllInBatch();
        roleDao.deleteAllInBatch();
        resourceDao.deleteAllInBatch();
        Org org = saveOrg();
        Resource resource = saveResource();
        Role role = saveRole(resource);
        saveUser(org, role);
    }

    @Test
    @Transactional
    public void getUser() {
        User getUser = userDao.findByName(TEST_NAME_1);
        getUser.getRole().iterator().forEachRemaining(role1 -> System.out.println(role1.getName()));
        getUser.getOrg().iterator().forEachRemaining(org1 -> System.out.println(org1.getName()));
        System.out.println(getUser.getStatus().displayName() + " " + getUser.getStatus().ordinal() + " " + User.Status.of(getUser.getStatus().ordinal()));
    }

    private void saveUser(Org org, Role role) {
        User user = new User();
        user.setName(TEST_NAME_1);
        user.setPwd("=asdfnnnefxxx");
        user.setStatus(User.Status.ENABLE);
        user.setChiefId(0L);
        user.setOrg(Sets.newHashSet(Lists.newArrayList(org)));
        user.setRole(Sets.newHashSet(Lists.newArrayList(role)));
        userDao.save(user);
    }

    private Role saveRole(Resource resource) {
        Role role = new Role();
        role.setEnName("sys_manager");
        role.setName("系统管理员");
        role.setResource(Lists.newArrayList(resource));
        return roleDao.save(role);
    }

    private Resource saveResource() {
        Resource resource = new Resource();
        resource.setCode("index");
        resource.setName("后台首页");
        resource.setType(Resource.Type.MENU);
        resource.setParentId(0);
        resourceDao.save(resource);
        return resource;
    }

    private Org saveOrg() {
        Org org = new Org();
        org.setManager("机构1管理员");
        org.setName("机构1");
        org.setParentId(0);
        org.setSortNum("1");
        return orgDao.save(org);
    }

}
