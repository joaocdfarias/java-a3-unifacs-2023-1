package com.unifacs.entities;

public class Institution {
    private String name;
    private Address address;
    private Professor employees;
    private Student students;
    private Course courses;

    public Institution() {
    }

    public Institution(String name, Address address, Professor employees, Student students, Course courses) {
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.students = students;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Professor getEmployees() {
        return employees;
    }

    public void setEmployees(Professor employees) {
        this.employees = employees;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

}
