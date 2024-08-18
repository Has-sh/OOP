import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Gold extends Customer{

    private int goldLevel;
    private String preferredPaymentMethod;

    /**
     * Constructs a new gold customer with the specified ID, date of birth, first name, last name,
     * registration date, preferred payment method, and gold level.
     *
     * @param userId the ID of the customer
     * @param dataOfBirth the date of birth of the customer
     * @param firstName the first name of the customer
     * @param lastName the last name of the customer
     * @param registrationDate the registration date of the customer
     * @param preferredPaymentMethod the preferred payment method of the customer
     * @param goldLevel the gold level of the customer
     */
    public Gold(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, int goldLevel) {
        super(userId, dataOfBirth, firstName, lastName, registrationDate, preferredPaymentMethod);
        this.goldLevel=goldLevel;
        this.preferredPaymentMethod=preferredPaymentMethod;
    }

    /**
     * Gets the gold level of the customer.
     *
     * @return the gold level of the customer
     */
    public int getGoldLevel() {
        return goldLevel;
    }

    @Override
    public String toString() {
        return "Gold{" +
                "goldLevel=" + goldLevel +
                ", preferredPaymentMethod='" + preferredPaymentMethod + '\'' +
                '}';
    }

    public Gold(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, int goldLevel, String preferredPaymentMethod1) {
        super(userId, dataOfBirth, firstName, lastName, registrationDate, preferredPaymentMethod);
        this.goldLevel = goldLevel;
        this.preferredPaymentMethod = preferredPaymentMethod1;
    }

    public Gold(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, ArrayList<Booking> bookings, int goldLevel, String preferredPaymentMethod1) {
        super(userId, dataOfBirth, firstName, lastName, registrationDate, preferredPaymentMethod, bookings);
        this.goldLevel = goldLevel;
        this.preferredPaymentMethod = preferredPaymentMethod1;
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(getUserId());
        Date dob = getDataOfBirth();
        out.writeUTF(new SimpleDateFormat("dd/MM/yyyy").format(dob));
        out.writeUTF(getFirstName());
        out.writeUTF(getLastName());
        Date registrationDate = getRegistrationDate();
        out.writeUTF(new SimpleDateFormat("dd/MM/yyyy").format(registrationDate));
        out.writeInt(getGoldLevel());
        out.writeUTF(getPreferredPaymentMethod());
    }
}
