package com.codeinnova.UserCRUD.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    // atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Name;
    private String LastName;
    private String Email;
    private String Password;
    private Integer Age;
    private Long Phone;

    // constructor
    public Users() {
    }

    public Users(Integer id, String lastName, String name, String email, String password, Integer age, Long phone) {
        this.id = id;
        LastName = lastName;
        Name = name;
        Email = email;
        Password = password;
        Age = age;
        Phone = phone;
    }

    //getter y setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Long getPhone() {
        return Phone;
    }

    public void setPhone(Long phone) {
        Phone = phone;
    }

    //To string
    @Override
    public String toString() {
        return "User{" +
                "Id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Age='" + Age + '\'' +
                ", Phone=" + Phone +
                '}';
    }
}
