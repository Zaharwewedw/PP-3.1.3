package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM sys.users WHERE _username = :username", nativeQuery = true)
    Optional<User> findByUsNa(@Param("username") String username);


    // List<User> findAll();
    //  @Modifying
    // @Query(value = "INSERT INTO users VALUES(:user)", nativeQuery = true)
    //  void saveUser(@Param("user") User user);
    // Optional<User> findById(Long id);
    // void delete(User user);
}
