package com.cecilia.order.domain.customer;

public class CustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private int identifier;


    public CustomerDto(String firstName, String lastName, String email, String address, String phoneNumber, int identifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.identifier=identifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getIdentifier(){
        return identifier;
    }
}
