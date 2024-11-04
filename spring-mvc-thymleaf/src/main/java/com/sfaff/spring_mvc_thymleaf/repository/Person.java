package com.sfaff.spring_mvc_thymleaf.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
public class Person extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -2952735933715107252L;

    @Column(unique = true)
    private String username;

    private String firstname;
    private String lastname;

    public Person() {
        this(null);
    }


    public Person(Long id) {
        this.setId(id);
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Returns the username.
     *
     * @return
     */
    public String getUsername() {

        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
