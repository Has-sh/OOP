import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * An abstract class representing a user in the booking system.
 * Implementations must provide specific details about the user.
 */
public abstract class User implements Serializable {
    private int userId;
    private Date dataOfBirth;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    /**
     * Gets the unique identifier of the user.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }
    /**
     * Sets the unique identifier of the user.
     *
     * @param userId The new user ID.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * Gets the date of birth of the user.
     *
     * @return The date of birth.
     */
    public Date getDataOfBirth() {
        return dataOfBirth;
    }
    /**
     * Gets the first name of the user.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the first name of the user.
     *
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gets the last name of the user.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name of the user.
     *
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Gets the registration date of the user.
     *
     * @return The registration date.
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }
    /**
     * Sets the registration date of the user.
     *
     * @param registrationDate The new registration date.
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    /**
     * Constructs a User object with the specified details.
     *
     * @param userId           The unique identifier of the user.
     * @param dataOfBirth      The date of birth of the user.
     * @param firstName        The first name of the user.
     * @param lastName         The last name of the user.
     * @param registrationDate The registration date of the user.
     */
    public User(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate) {
        this.userId = userId;
        this.dataOfBirth = dataOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }
    /**
     * Constructs a User object by copying another User object.
     *
     * @param user The User object to copy.
     */
    public User(User user){
        this.userId=user.userId;
        this.dataOfBirth=user.dataOfBirth;
        this.firstName=user.firstName;
        this.lastName=user.lastName;
        this.registrationDate=user.registrationDate;
    }
    public void addBooking(Booking booking) {
        booking.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", dataOfBirth=" + dataOfBirth +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
