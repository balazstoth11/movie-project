package project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class User extends BaseModel {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String eMailAddress;
    @Column(name = "year_of_birth")
    private Integer yearOfBirth;
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "user_name")
    private String userName;

    protected User() {
    }

    public User(String firstName, String lastName, String eMailAddress, int yearOfBirth, LocalDate registrationDate,
            String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.yearOfBirth = yearOfBirth;
        this.registrationDate = registrationDate;
        this.userName = userName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getUserName() {
        return userName;
    }

    public int userAge() {
        return LocalDate.now().getYear() - yearOfBirth;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", eMailAddress=" + eMailAddress
                + ", yearOfBirth=" + yearOfBirth + ", registrationDate=" + registrationDate + ", userName=" + userName
                + "]";
    }

}
