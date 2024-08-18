import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public abstract class Customer extends User{
    private String preferredPaymentMethod;
    private ArrayList<Booking> bookings;

    /**
     * Constructs a new customer with the specified ID, date of birth, first name, last name,
     * registration date, and preferred payment method.
     *
     * @param userId the ID of the customer
     * @param dataOfBirth the date of birth of the customer
     * @param firstName the first name of the customer
     * @param lastName the last name of the customer
     * @param registrationDate the registration date of the customer
     * @param preferredPaymentMethod the preferred payment method of the customer
     */
    public Customer(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod) {
        super(userId, dataOfBirth, firstName, lastName, registrationDate);
        this.preferredPaymentMethod=preferredPaymentMethod;
        bookings = new ArrayList<>();
    }

    public Customer(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, ArrayList<Booking> bookings) {
        super(userId, dataOfBirth, firstName, lastName, registrationDate);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.bookings = bookings;
    }

    public Customer(User user, String preferredPaymentMethod, ArrayList<Booking> bookings) {
        super(user);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.bookings = bookings;
    }

    /**
     * Adds a booking to the customer's list of bookings.
     *
     * @param booking the booking to add
     */
    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }
    /**
     * Gets the customer's list of bookings.
     *
     * @return the customer's list of bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * Calculates the discount percentage for the customer.
     *
     * @return the discount percentage for the customer
     */
    public double discountPercentage(){
        if(this instanceof Gold){
            int level=((Gold) this).getGoldLevel();
            if(level==1)
                return 0.01;
            else if(level==2){
                return 0.02;
            }
            else
                return 0.03;
        }
        else{
            Date currentDate = new Date();
            Date registrationDate=this.getRegistrationDate();
            long calc = Math.abs(currentDate.getTime() - registrationDate.getTime());
            int years = (int) (calc / (1000 * 60 * 60 * 24 * 365));
            if(years>=10)
                return 0.02;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "preferredPaymentMethod='" + preferredPaymentMethod + '\'' +
                ", bookings=" + bookings +
                '}';
    }

}
