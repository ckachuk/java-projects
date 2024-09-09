package models;

public class Charge {
    private int id;
    private String name;
    private String salary;

    public Charge(int id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
