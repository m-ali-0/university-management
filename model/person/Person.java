package model.person;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private final int id;
    private final String fullName;
    private String address;
    private String phone;
    private String email;
    private final LocalDate dateOfBirth;

    protected Person(int id, String fullName, String address, String phone, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }
        this.dateOfBirth = dateOfBirth;
    } catch (IllegalArgumentException | DateTimeException e) {
        System.err.println("Error initializing Person: " + e.getMessage());
        throw e;  // Rethrow the exception after logging it
    
    }

    protected Person(int id, String fullName, LocalDate dateOfBirth) {
        try {
            this.id = id;
            this.fullName = fullName;
            if (dateOfBirth == null) {
                throw new IllegalArgumentException("Date of birth cannot be null");
            }
            this.dateOfBirth = dateOfBirth;
        } catch (IllegalArgumentException | DateTimeException e) {
            System.err.println("Error initializing Person: " + e.getMessage());
            throw e;  // Rethrow the exception after logging it
        }
    }

    // Getters
    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public int getAge() {
        try {
            LocalDate today = LocalDate.now();
            Period period = Period.between(this.dateOfBirth, today);
            return period.getYears();
        } catch (DateTimeException e) {
            System.err.println("Error calculating age: " + e.getMessage());
            return -1;  // Return -1 if there is an issue calculating age
        }
    }
    // Setters
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        try {
            if (this == o) return true;
            if (!(o instanceof Person)) return false; // for subclasses
            Person person = (Person) o;
            return id == person.id; // id is unique
        } catch (ClassCastException e) {
            System.err.println("Error comparing Person objects: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Person{");
            sb.append("id=").append(id);
            sb.append(", fullName='").append(fullName).append("'");
            sb.append(", address='").append(address).append("'");
            sb.append(", phone='").append(phone).append("'");
            sb.append(", email='").append(email).append("'");
            sb.append(", dateOfBirth=").append(dateOfBirth);
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            System.err.println("Error generating string representation of Person: " + e.getMessage());
            return "Error generating person information.";  // Return a fallback message
        
    }
}    
