package ru.kata.spring.boot_security.demo.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "sys.users")
public class  User {
    @NotEmpty(message = "The name cannot be empty")
    @Size(min = 2, max = 15, message = "The name must consist of less than 2 and no more than 15 characters")
    @Column(name = "name")
    private String name;
    @Min(value = 14, message = "Access to persons under 14 years of age is prohibited")
    @Max(value = 150, message = "The age is too great")
    @Column(name = "age")
    private int age;
    @Email(message = "The email does not meet the requirements")
    @NotEmpty(message = "The email cannot be empty")
    @Column(name = "email")
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "_username")
    private String usNa;

    @Column(name = "pass")
    private String pass;

    @ManyToMany
    @JoinTable(name = "sys.user_role",
            joinColumns = @JoinColumn(name = "id_User"),
            inverseJoinColumns = @JoinColumn(name = "id_Role"))
    private List<Role> roleSet;

    public User() {

    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getUsNa() {
        return usNa;
    }

    public void setUsNa(String usNa) {
        this.usNa = usNa;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "   name = " + name +
                "  age = " + age +
                "  email = " + email + "   ";
    }
}
