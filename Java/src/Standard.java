import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Standard extends Customer{
    private String preferredPaymentMethod;
    /**
     * Constructs a new object with the specified details.
     *
     * @param userId               the unique identifier for the customer
     * @param dataOfBirth          the date of birth of the customer
     * @param firstName            the first name of the customer
     * @param lastName             the last name of the customer
     * @param registrationDate     the date when the customer registered
     * @param preferredPaymentMethod the preferred payment method of the customer
     */
    public Standard(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod) {
        super(userId, dataOfBirth, firstName, lastName, registrationDate, preferredPaymentMethod);
        this.preferredPaymentMethod=preferredPaymentMethod;
    }
    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "preferredPaymentMethod='" + preferredPaymentMethod + '\'' +
                '}';
    }

    public Standard(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, String preferredPaymentMethod1) {
        super(userId, dataOfBirth, firstName, lastName, registrationDate, preferredPaymentMethod);
        this.preferredPaymentMethod = preferredPaymentMethod1;
    }

    public void write(DataOutputStream out) throws IOException {
        out.writeInt(getUserId());
        Date dob = getDataOfBirth();
        out.writeUTF(new SimpleDateFormat("dd/MM/yyyy").format(dob));
        out.writeUTF(getFirstName());
        out.writeUTF(getLastName());
        Date registrationDate = getRegistrationDate();
        out.writeUTF(new SimpleDateFormat("dd/MM/yyyy").format(registrationDate));
        out.writeUTF(getPreferredPaymentMethod());
    }
}
