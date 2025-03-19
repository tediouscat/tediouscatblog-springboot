package com.tediouscat.tediouscatblog.jwt.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中查询
        // ...

		// 暂时先写死，密码为 quanxiaoha, 这里填写的密文，数据库中也是存储此种格式
		// authorities 用于指定角色，这里写死为 ADMIN 管理员
        return User.withUsername("tediouscat")
                .password("$2a$10$xsMw.kvxQeHKU0ih/KtiMeDkfzSLJ6WtX5a22YLsClEZlL0NrgeKq")
                .authorities("ADMIN")
                .build();
    }
}
