package ru.kata.spring.boot_security.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys.role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_role_")
    private String roleUser;

    @ManyToMany(mappedBy = "roleSet")
    private List<User> userSet;
    public Role(String roleUser) {
        this.roleUser = roleUser;
    }

    public Role() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }
}
