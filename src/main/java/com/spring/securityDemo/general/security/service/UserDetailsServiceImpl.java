package com.spring.securityDemo.general.security.service;

import com.spring.securityDemo.general.security.CustomerUserDetails;
import com.spring.securityDemo.general.security.dao.UserDao;
import com.spring.securityDemo.general.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    public UserDetailsServiceImpl() {
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return new CustomerUserDetails(user);
    }
}