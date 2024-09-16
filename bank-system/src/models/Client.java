package models;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person{
    private Integer id;
    private Date dateOfRegistration;
    private List<Account> accounts;
    private BankBranch bankBranch;
    private String password;

    public Client(){
        super();
    }
    public Client(Date dateOfRegistration,BankBranch bankBranch, String dni, String name, String surname, String gender, String address, String phone, String email, String dateOfBirth, String password) {
        super(dni, name, surname, gender, address, phone, email, dateOfBirth);
        this.dateOfRegistration = dateOfRegistration;
        this.bankBranch = bankBranch;
        this.accounts = new ArrayList<>();
        this.password = password;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }
    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
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
    public String toString(){
        return "Client{ ID:" + id + ", Name: "+ super.getName() +", Surname: " + super.getSurname() + ", DNI" + super.getDni() + ", Bank branch:" + bankBranch + "}";
    }

}
