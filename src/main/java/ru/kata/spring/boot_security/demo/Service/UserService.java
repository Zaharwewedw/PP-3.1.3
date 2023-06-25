package ru.kata.spring.boot_security.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
       return userDao.getAllByUsers();
    }

    @Transactional(readOnly = true)
    public User getByIdUser(Long id) {
        return userDao.getById(id);
    }

    @Transactional
    public void upDateUser(User user) {
        userDao.upDateUser(user.getId(), user.getEmail(), user.getAge(), user.getName());
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

}
