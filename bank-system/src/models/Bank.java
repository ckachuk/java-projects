package models;

import java.util.List;

public class Bank {
    private Integer id;
    private String name;
    private List<BankBranch> bankBranchList;
    private List<Account> accountList;

    public Bank(int id, String name, List<BankBranch> bankBranchList, List<Account> accountList) {
        this.id = id;
        this.name = name;
        this.bankBranchList = bankBranchList;
        this.accountList = accountList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankBranch> getBankBranchList() {
        return bankBranchList;
    }

    public void setBankBranchList(List<BankBranch> bankBranchList) {
        this.bankBranchList = bankBranchList;
    }
    public List<Account> getAccountList() {
        return accountList;
    }
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
