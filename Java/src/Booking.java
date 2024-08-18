import java.util.Date;

public class Booking {
    private Date startDate;
    private Date endDate;
    private boolean isPaid;
    private User user;
    private Property property;

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    /**
     * Gets the start date of the booking.
     *
     * @return the start date of the booking
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * Gets the end date of the booking.
     *
     * @return the end date of the booking
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * Gets the user who made the booking.
     *
     * @return the user who made the booking
     */
    public User getUser() {
        return user;
    }
    /**
     * Sets the user who made the booking.
     *
     * @param user the user who made the booking
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Gets the property that was booked.
     *
     * @return the property that was booked
     */
    public Property getProperty() {
        return property;
    }
    /**
     * Sets the property that was booked.
     *
     * @param property the property that was booked
     */
    public void setProperty(Property property) {
        this.property = property;
    }
    /**
     * Constructs a new booking with the specified start date, end date, and whether it has been
     * paid.
     *
     * @param startDate the start date of the booking
     * @param endDate the end date of the booking
     * @param isPaid whether the booking has been paid
     */
    public Booking(Date startDate, Date endDate, boolean isPaid) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid=isPaid;
    }
    /**
     * Constructs a new booking for a shared property with the specified start date, end date,
     * whether it has been paid, and shared property.
     *
     * @param startDate the start date of the booking
     * @param endDate the end date of the booking
     * @param isPaid whether the booking has been paid
     * @param property1 the shared property to book
     */
    public Booking(Date startDate, Date endDate, boolean isPaid, SharedProperty property1) {
        this.startDate =  startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
        property = new SharedProperty(property1);
    }
    /**
     * Constructs a new booking for a full property with the specified start date, end date,
     * whether it has been paid, and full property.
     *
     * @param startDate the start date of the booking
     * @param endDate the end date of the booking
     * @param isPaid whether the booking has been paid
     * @param property2 the full property to book
     */
    public Booking(Date startDate, Date endDate, boolean isPaid, FullProperty property2) {
        this.startDate =  startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
        property = new FullProperty(property2);
    }
    /**
     * Constructs a new booking based on an existing booking.
     *
     * @param booking the existing booking
     */
    public Booking(Booking booking){
        startDate=booking.startDate;
        endDate=booking.endDate;
        isPaid=booking.isPaid;
        property = booking.property;
    }
    public Booking(Date startDate, Date endDate, boolean isPaid, User user, Property property) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
        this.user = user;
        this.property = property;
    }
    /**
     * Calculates the total cost of the booking.
     *
     * @return the total cost of the booking
     */
    public float totalCost(){
        float cost;
        float days =  endDate.getTime() - startDate.getTime();
        days = (int) (days/(1000*60*60*24));
        cost = (float) (days * property.calculatePricePerDay());
        return cost;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", isPaid=" + isPaid +
                ", user=" + user +
                ", property=" + property +
                '}';
    }
}
