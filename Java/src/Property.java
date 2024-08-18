import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public abstract class Property implements PropertyPrice,Comparable<Property> {
    private int propertyId;
    private int noBedRooms;
    private int noRooms;
    private String city;
    private double pricePerDay;
    private HashMap<String,Integer> inspection;
    private Host host;

    public int getPropertyId() {
        return propertyId;
    }

    public int getNoBedRooms() {
        return noBedRooms;
    }

    public int getNoRooms() {
        return noRooms;
    }

    public String getCity() {
        return city;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }
    /**
     * Constructs a new Property object with the specified details.
     *
     * @param propertyId   the unique identifier for the property
     * @param noBedRooms   the number of bedrooms in the property
     * @param noRooms      the total number of rooms in the property
     * @param city         the city where the property is located
     * @param pricePerDay  the price per day for renting the property
     * @param host         the host of the property
     */
    public Property(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay, Host host) {
        this.propertyId = propertyId;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.inspection = new HashMap<>();
        this.host=host;
    }
    public Property(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay) {
        this.propertyId = propertyId;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.inspection = new HashMap<>();
    }
    /**
     * Constructs a new Property object by copying details from an existing property.
     *
     * @param property the property to copy details from
     */
    public  Property(Property property){
        propertyId=property.propertyId;
        noRooms=property.noRooms;
        noBedRooms=property.noBedRooms;
        city=property.city;
        pricePerDay=property.pricePerDay;
        inspection=property.inspection;
    }
    public void addinspection(String inspect){
        Date date = new Date();
        SimpleDateFormat set = new SimpleDateFormat("dd MMMM yyyy");
        String date1 = new String(set.format(date));
        if(inspection.containsKey(date1)){
            System.out.println("This property already had an inspection today :)");
            return;
        }
        else{
            System.out.println("Your recorded inspections :\n");
            System.out.println("dummy data");
        }
    }

    public int compareTo(Property property) {
        if(this.pricePerDay>property.pricePerDay)
            return 1;
        else if (this.pricePerDay<property.pricePerDay) {
            return -1;
        }
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", noBedRooms=" + noBedRooms +
                ", noRooms=" + noRooms +
                ", city='" + city + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", inspection=" + inspection +
                ", host=" + host +
                '}';
    }
}
