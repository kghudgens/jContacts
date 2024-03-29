package main.java;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String occupation;

    public Contact(int id, String firstName, String lastName, String phoneNumber, String email, String occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.occupation = occupation;
    }

    public Contact(String lastName){
        this.lastName = lastName;
    }

    public Contact(int id){
        this.id = id;
    }


    public Contact(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }
}
