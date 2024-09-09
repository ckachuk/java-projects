package models;

public class Person {
    private String dni;
    private String name;
    private String surname;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String dateOfBirth;

    public Person(){

    }
    public Person(String dni, String name, String surname, String gender, String address, String phone, String email, String dateOfBirth) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
