package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM sys.users WHERE _username = :username", nativeQuery = true)
    Optional<User> findByUsNa(@Param("username") String username);

    @Modifying
    @Query(value = "INSERT INTO sys.users(_username, pass, email, age, name) VALUES (:username, :passwordd, :email, :age, :name)",
            nativeQuery = true)
    void saveUser(@Param("username") String username,
                  @Param("passwordd") String password,
                  @Param("email") String email,
                  @Param("age") int age,
                  @Param("name") String name);

    @Query(value = "SELECT * FROM sys.users", nativeQuery = true )
    List<User> getAllByUsers();

    @Query(value = "SELECT * FROM sys.users WHERE id = :id", nativeQuery = true)
    User getById(@Param("id") Long id);
    @Modifying
    @Query(value = "UPDATE sys.users u SET u.name = :name, u.email = :email, u.age = :age WHERE u.id = :id", nativeQuery = true)
    void upDateUser( @Param("id") Long id,
                     @Param("email") String email,
                     @Param("age") int age,
                     @Param("name") String name);
    @Modifying
    @Query(value = "DELETE FROM sys.users u WHERE u.id = :id", nativeQuery = true)
    void deleteUser(@Param("id") Long id);
}
