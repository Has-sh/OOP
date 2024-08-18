import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PopulateData {
    private static final String HOST_FILE = "host.dat";
    private static final String STANDARD_FILE = "standard.dat";
    private static final String GOLD_FILE = "gold.dat";
    private static final String SHARED_PROPERTY_FILE = "sharedProperty.dat";
    private static final String FULL_PROPERTY_FILE = "fullProperty.dat";

    public static void createInstanceFile() throws ParseException {

        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");

        Date dob1 = ft.parse("01/12/2002");
        Host h1 = new Host(1, dob1, "Muhammad Hashaam", "Shahid", ft.parse("06/12/2023"), 386);

        Date dob2 = ft.parse("27/03/2002");
        Host h2 = new Host(2, dob2, "Abdullah", "Sheikh", ft.parse("12/09/2020"), 528);

        Date dob3 = ft.parse("09/04/1999");
        Gold h3 = new Gold(3, dob3, "Daniel", "Burak", ft.parse("23/01/2015"), "Paypal", 2);

        Date dob4 = ft.parse("01/01/1990");
        Standard h4 = new Standard(4, dob4, "Shoaib", "Usman", ft.parse("15/05/2006"), "Cash");

        try (DataOutputStream hostOut = new DataOutputStream(new FileOutputStream(HOST_FILE))) {
            h1.write(hostOut);
            h2.write(hostOut);
        } catch (IOException e) {
            System.out.println("Error writing hosts to file: " + e.getMessage());
        }

        try (DataOutputStream goldOut = new DataOutputStream(new FileOutputStream(GOLD_FILE))) {
            h3.write(goldOut);
        } catch (IOException e) {
            System.out.println("Error writing Gold User to file: " + e.getMessage());
        }

        try (DataOutputStream standOut = new DataOutputStream(new FileOutputStream(STANDARD_FILE))) {
            h4.write(standOut);
        } catch (IOException e) {
            System.out.println("Error writing Standard User to file: " + e.getMessage());
        }

        Date start1 = ft.parse("01/11/2023");
        Date end1 = ft.parse("10/11/2023");
        SharedProperty p1 = new SharedProperty(1, 15, 5, "Nicosia", 130, h1);

        Date start2 = ft.parse("27/08/2023");
        Date end2 = ft.parse("05/09/2023");
        SharedProperty p2 = new SharedProperty(2, 10, 1, "Lefke", 90, h2);

        Date start3 = ft.parse("09/06/2023");
        Date end3 = ft.parse("16/06/2023");
        SharedProperty p3 = new SharedProperty(3, 6, 2, "Girne", 350, h1);

        Date start4 = ft.parse("15/05/2024");
        Date end4 = ft.parse("22/05/2024");
        FullProperty p4 = new FullProperty(4, 5, 3, "Guzelyurt", 200, 20, h1);

        h3.addBooking(new Booking(start3, end3, true, h3, p3));
        h4.addBooking(new Booking(start4, end4, true, h4, p4));

        try (DataOutputStream sharedOut = new DataOutputStream(new FileOutputStream(SHARED_PROPERTY_FILE))) {
            p1.write(sharedOut);
            p2.write(sharedOut);
            p3.write(sharedOut);
        } catch (IOException e) {
            System.out.println("Error writing Shared Property to file: " + e.getMessage());
        }
        try (DataOutputStream fullOut = new DataOutputStream(new FileOutputStream(FULL_PROPERTY_FILE))) {
            p4.write(fullOut);
        } catch (IOException e) {
            System.out.println("Error writing Full Property to file users to file: " + e.getMessage());
        }
    }

    public static void loadInstanceFile() throws ParseException {
        try (DataInputStream hostIn = new DataInputStream(new FileInputStream(HOST_FILE))) {
            while (hostIn.available() > 0) {
                int id = hostIn.readInt();
                String dobStr = hostIn.readUTF();
                Date dob = parseDate(dobStr);
                String firstName = hostIn.readUTF();
                String lastName = hostIn.readUTF();
                String regDateStr = hostIn.readUTF();
                Date registrationDate = parseDate(regDateStr);
                double taxNumber = hostIn.readDouble();

                Host host = new Host(id, dob, firstName, lastName, registrationDate, taxNumber);
                BASIC.users.add(host);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading hosts from file: " + e.getMessage());
        }

        try (DataInputStream standardIn = new DataInputStream(new FileInputStream(STANDARD_FILE))) {
            while (standardIn.available() > 0) {
                int id = standardIn.readInt();
                String dobStr = standardIn.readUTF();
                Date dob = parseDate(dobStr);
                String firstName = standardIn.readUTF();
                String lastName = standardIn.readUTF();
                String regDateStr = standardIn.readUTF();
                Date registrationDate = parseDate(regDateStr);
                String preferredPayment = standardIn.readUTF();

                Standard standard = new Standard(id, dob, firstName, lastName, registrationDate,preferredPayment);
                BASIC.users.add(standard);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading standard users from file: " + e.getMessage());
        }

        try (DataInputStream goldIn = new DataInputStream(new FileInputStream(GOLD_FILE))) {
            int id = goldIn.readInt();
            String dobStr = goldIn.readUTF();
            Date dob = parseDate(dobStr);
            String firstName = goldIn.readUTF();
            String lastName = goldIn.readUTF();
            String regDate = goldIn.readUTF();
            Date registrationDate = parseDate(regDate);
            int goldLevel = goldIn.readInt();
            String preferredPayment = goldIn.readUTF();


            Gold gold = new Gold(id, dob, firstName, lastName, registrationDate,preferredPayment,goldLevel);
            BASIC.users.add(gold);
        } catch (IOException | ParseException e) {
            System.out.println("Error reading gold users from file: " + e.getMessage());
        }

        try (DataInputStream sharedIn = new DataInputStream(new FileInputStream(SHARED_PROPERTY_FILE))) {
            while (sharedIn.available() > 0) {
                int id = sharedIn.readInt();
                int noBedRooms = sharedIn.readInt();
                int noRooms = sharedIn.readInt();
                String city = sharedIn.readUTF();
                double pricePerDay = sharedIn.readDouble();

                int hostid = sharedIn.readInt();
                String dobStr = sharedIn.readUTF();
                Date dob = parseDate(dobStr);
                String firstName = sharedIn.readUTF();
                String lastName = sharedIn.readUTF();
                String regDateStr = sharedIn.readUTF();
                Date registrationDate = parseDate(regDateStr);
                double taxNumber = sharedIn.readDouble();

                Host host = new Host(hostid, dob, firstName, lastName, registrationDate, taxNumber);
                SharedProperty sharedProperty = new SharedProperty(id, noBedRooms, noRooms, city, pricePerDay,host);
                BASIC.properties.add(sharedProperty);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading shared properties from file: " + e.getMessage());
        }

        try (DataInputStream fullIn = new DataInputStream(new FileInputStream(FULL_PROPERTY_FILE))) {
            while (fullIn.available() > 0) {
                int id = fullIn.readInt();
                int noBedRooms = fullIn.readInt();
                int noRooms = fullIn.readInt();
                String city = fullIn.readUTF();
                double pricePerDay = fullIn.readDouble();
                double propertySize = fullIn.readDouble();

                int hostid = fullIn.readInt();
                String dobStr = fullIn.readUTF();
                Date dob = parseDate(dobStr);
                String firstName = fullIn.readUTF();
                String lastName = fullIn.readUTF();
                String regDateStr = fullIn.readUTF();
                Date registrationDate = parseDate(regDateStr);
                double taxNumber = fullIn.readDouble();

                Host host = new Host(hostid, dob, firstName, lastName, registrationDate, taxNumber);
                FullProperty fullProperty = new FullProperty(id, noBedRooms, noRooms, city, pricePerDay,propertySize,host);
                BASIC.properties.add(fullProperty);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading full properties from file: " + e.getMessage());
        }
    }
    private static Date parseDate(String dateStr) throws ParseException {
        if (dateStr.isEmpty()) {
            return null;
        }
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
    }
}
