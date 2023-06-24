package ru.kata.spring.boot_security.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

@Service
public class UserRegistration {

    private final UserDao userDao;

    @Autowired
    public UserRegistration(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void register(User user){
        userDao.saveUser(user.getUsNa(), user.getPass(), user.getEmail(), user.getAge(), user.getName());
    }
}