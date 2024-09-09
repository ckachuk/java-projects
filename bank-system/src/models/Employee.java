package models;

public class Employee extends Person{
    private Integer id;
    private Charge charge;

    public Employee(int id, Charge charge) {
        this.id = id;
        this.charge = charge;
    }

    public Employee(String dni, String name, String surname, String gender, String address, String phone, String email, String dateOfBirth, int id, Charge charge) {
        super(dni, name, surname, gender, address, phone, email, dateOfBirth);
        this.id = id;
        this.charge = charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }
}
