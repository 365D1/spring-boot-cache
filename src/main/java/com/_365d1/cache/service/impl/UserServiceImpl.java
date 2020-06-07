package com._365d1.cache.service.impl;
// +----------------------------------------------------------------------
// | 官方网站: www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 
// +----------------------------------------------------------------------
// | 时　　间: 2020/6/7 12:48
// +----------------------------------------------------------------------
// | 代码创建: 朱荻 <292018748@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:（修改人 - 修改时间）
// +----------------------------------------------------------------------

import com._365d1.cache.dao.UserDao;
import com._365d1.cache.model.User;
import com._365d1.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Cacheable(key = "#id", unless = "#result == null")
    @Override
    public User detail(Integer id) {
        log.info("{}", "执行查询");
        return userDao.detail(id);
    }

    @CachePut(key = "#result.id")
    @Override
    public User update(User user) {
        log.info("{}", "执行更新");
        userDao.update(user.getNickName(), user.getId());
        return user;
    }

    @CacheEvict(key = "#id")
    @Override
    public void delete(Integer id) {
        log.info("{}", "执行删除");
        userDao.delete(id);
    }

}
