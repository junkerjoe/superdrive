package com.udacity.jwdnd.course1.cloudstorage.model;

public class Users {
    public Integer userid;
    public String username;
    public String salt;
    public String password;
    public String firstname;
    public String lastname;

    public Users(Integer userid, String username, String salt,
                String password, String firstname, String lastname) {
        this.userid = userid;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer id) {
        this.userid = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
    
}
