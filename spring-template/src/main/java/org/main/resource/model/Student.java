package org.main.resource.model;

public class Student {
    private String firstname;
    private String lastname;
    private String email;

    public Student () {
        this.firstname = "";
        this.lastname = "";
        this.email = "";
    }

    public Student (String firstname , String lastname , String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getFirstname() {

        return firstname;

    }

    public void setFirstname(String firstname) {

        this.firstname = firstname;

    }

    public String getLastname() {

        return lastname;

    }

    public void setLastname(String lastname) {

        this.lastname = lastname;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }
    @Override
    public String toString() {

        return "Student{" +
                "firstName='" + this.firstname + '\'' +
                ", lastName='" + this.lastname + '\'' +
                ", email='" + this.email + '\'' +
                '}';

        /* Result Student{firstName='', lastName='', email=''}
        *  this method is going to work when
        *  display from Object... */
    }

}
