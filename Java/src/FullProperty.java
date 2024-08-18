import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class FullProperty extends Property{
    private double propertySize;

    /**
     * Constructs a new full-sized property with the specified ID, number of bedrooms, number of rooms,
     * city, price per day, property size, and host.
     *
     * @param propertyId the ID of the property
     * @param noBedRooms the number of bedrooms in the property
     * @param noRooms the number of rooms in the property
     * @param city the city where the property is located
     * @param pricePerDay the price per day of the property
     * @param propertySize the property size
     * @param host the host of the property
     */
    public FullProperty(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay,double propertySize, Host host) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay, host);
        this.propertySize=propertySize;
    }
    /**
     * Constructs a new full-sized property based on an existing property.
     *
     * @param property the existing property
     */
    public FullProperty(Property property){
        super(property);
    }

    public double getPropertySize() {
        return propertySize;
    }

    @Override
    public double calculatePricePerDay() {
        if(propertySize<200)
            return (getPricePerDay()*0.01)+getPricePerDay();
        else if (propertySize>=200 && propertySize<=300) {
            return (getPricePerDay()*0.03)+getPricePerDay();
        }
        else
            return (getPricePerDay()*0.04)+getPricePerDay();
    }

    public FullProperty(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay, Host host, double propertySize) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay, host);
        this.propertySize = propertySize;
    }
    public FullProperty(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay, double propertySize) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay);
        this.propertySize = propertySize;
    }
    public FullProperty(Property property, double propertySize) {
        super(property);
        this.propertySize = propertySize;
    }

    @Override
    public String toString() {
        return "FullProperty{" +
                "propertySize=" + propertySize +
                '}';
    }
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(getPropertyId());
        out.writeInt(getNoBedRooms());
        out.writeInt(getNoRooms());
        out.writeUTF(getCity());
        out.writeDouble(getPricePerDay());
        out.writeDouble(getPropertySize());

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
