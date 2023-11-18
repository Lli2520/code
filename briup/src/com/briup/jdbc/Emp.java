package com.briup.jdbc;

public class Emp {
    private   int id;
    private String name;
    private int salary;
    private String title;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", title='" + title + '\'' +
                '}';
    }

    public Emp(int id, String name, int salary, String title) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.title = title;
    }
}
