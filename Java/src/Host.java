import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Host extends User{
    private double taxNumber;
    /**
     * Gets the tax number of the host.
     *
     * @return the tax number of the host
     */
    public double getTaxNumber() {
        return taxNumber;
    }
    /**
     * Constructs a new host with the specified ID, date of birth, first name, last name, registration
     * date, and tax number.
     *
     * @param userId the ID of the host
     * @param dataOfBirth the date of birth of the host
     * @param firstName the first name of the host
     * @param lastName the last name of the host
     * @param registrationDate the registration date of the host
     * @param taxNumber the tax number of the host
     */
    public Host(int userId, Date dataOfBirth, String firstName, String lastName, Date registrationDate, double taxNumber) {
        super(userId, dataOfBirth, firstName, lastName, registrationDate);
        this.taxNumber=taxNumber;
        ArrayList<Property> properties = new ArrayList<>();
    }

    public Host(User user, double taxNumber) {
        super(user);
        this.taxNumber = taxNumber;
    }

    @Override
    public String toString() {
        return "Host{" +
                "taxNumber=" + taxNumber +
                '}';
    }

    public void write(DataOutputStream out) throws IOException {
        out.writeInt(getUserId());
        Date dob = getDataOfBirth();
        out.writeUTF(new SimpleDateFormat("dd/MM/yyyy").format(dob));
        out.writeUTF(getFirstName());
        out.writeUTF(getLastName());
        Date registrationDate = getRegistrationDate();
        out.writeUTF(new SimpleDateFormat("dd/MM/yyyy").format(registrationDate));
        out.writeDouble(getTaxNumber());
    }
}
