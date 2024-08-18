import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SharedProperty extends Property{
    /**
     * Constructs a new SharedProperty object with the specified details.
     *
     * @param propertyId    the unique identifier for the property
     * @param noBedRooms    the number of bedrooms in the property
     * @param noRooms       the total number of rooms in the property
     * @param city          the city where the property is located
     * @param pricePerDay   the price per day for renting the property
     * @param host          the host of the property
     */
    public SharedProperty(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay,Host host) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay,host);
    }
    public SharedProperty(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay);
    }
    /**
     * Constructs a SharedProperty object by copying details from existing property.
     *
     * @param property the property to copy details from
     */
    public SharedProperty(Property property){
        super(property);
    }

    @Override
    public String toString() {
        return "SharedProperty{}";
    }

    /**
     * Calculates the price per day for each bedroom in the shared property.
     *
     * @return the calculated price per day per bedroom
     */
    @Override
    public double calculatePricePerDay() {
        return getPricePerDay()/getNoBedRooms();
    }

    public void write(DataOutputStream out) throws IOException {
        out.writeInt(getPropertyId());
        out.writeInt(getNoBedRooms());
        out.writeInt(getNoRooms());
        out.writeUTF(getCity());
        out.writeDouble(getPricePerDay());

        out.writeInt(getHost().getUserId());
        Date dob = getHost().getDataOfBirth();
        out.writeUTF(new SimpleDateFormat("dd/MM/yyyy").format(dob));
        out.writeUTF(getHost().getFirstName());
        out.writeUTF(getHost().getLastName());
        Date registrationDate = getHost().getRegistrationDate();
        out.writeUTF(new SimpleDateFormat("dd/MM/yyyy").format(registrationDate));
        out.writeDouble(getHost().getTaxNumber());
    }
}
