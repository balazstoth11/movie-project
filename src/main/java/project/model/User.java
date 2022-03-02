package project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.mindrot.jbcrypt.BCrypt;

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
    @Column
    private String password;
    @Column(name = "user_name")
    private String userName;

    public User(String firstName, String lastName, String eMailAddress, int yearOfBirth, LocalDate registrationDate, String password, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.yearOfBirth = yearOfBirth;
        this.registrationDate = registrationDate;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
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

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public int userAge() {
        return LocalDate.now().getYear() - yearOfBirth;
    }
}
