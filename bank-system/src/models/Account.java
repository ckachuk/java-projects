package models;

public class Account {
    private Integer id;
    private String cbu;
    private Double balance;
    private String type;
    private Bank bank;
    private Client client;

    public Account(Integer id, String cbu, Double balance, String type, Bank bank, Client client) {
        this.id = id;
        this.cbu = cbu;
        this.balance = balance;
        this.type = type;
        this.bank = bank;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
