package models;

import java.util.List;

public class BankBranch {
    private Integer id;
    private String address;
    private Bank bank;
    private List<Employee> employeeList;

    public BankBranch(Integer id, String address, Bank bank) {
        this.id = id;
        this.address = address;
        this.bank = bank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
