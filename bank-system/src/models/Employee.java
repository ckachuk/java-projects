package models;

public class Employee extends Person{
    private Integer id;
    private Charge charge;
    private BankBranch bankBranch;
    private String password;

    public Employee(int id, Charge charge, BankBranch bankBranch, String password) {
        this.id = id;
        this.charge = charge;
        this.bankBranch = bankBranch;
        this.password = password;
    }

    public Employee(String dni, String name, String surname, String gender, String address, String phone, String email, String dateOfBirth, int id, Charge charge, BankBranch bankBranch, String password) {
        super(dni, name, surname, gender, address, phone, email, dateOfBirth);
        this.id = id;
        this.charge = charge;
        this.bankBranch = bankBranch;
        this.password = password;
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
    public BankBranch getBankBranch() {
        return bankBranch;
    }
    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
