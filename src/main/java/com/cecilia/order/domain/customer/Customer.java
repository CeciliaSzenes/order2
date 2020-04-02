package com.cecilia.order.domain.customer;

import java.util.Objects;

public class Customer {

    private static int counter = 1;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private int identifier;



    public Customer(String firstName, String lastName, String email, String address, String phoneNumber, int identifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber=phoneNumber;
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

    public int getIdentifier(){ return identifier;}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getIdentifier() == customer.getIdentifier() &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getAddress(), customer.getAddress()) &&
                Objects.equals(getPhoneNumber(), customer.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getAddress(), getPhoneNumber(), getIdentifier());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", identifier=" + identifier +
                '}';
    }
}
