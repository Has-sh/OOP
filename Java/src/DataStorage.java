import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DataStorage {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static void loadDataFromDataBase(ArrayList<User> users, ArrayList<Property> properties){
        Connection connection = null;
        Statement userStatement = null;
        Statement propertyStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basicdb", "cng443user", "1234");

            userStatement = connection.createStatement();
            propertyStatement = connection.createStatement();

            ResultSet userResultSet = userStatement.executeQuery("select * from user");
            ResultSet propertyResultSet = propertyStatement.executeQuery("select * from property");

            while (userResultSet.next()){
                String userType = userResultSet.getString("type");
                if ("h".equals(userType)){
                    Host host = new Host(userResultSet.getInt("userID"),userResultSet.getDate("dateOfBirth"),userResultSet.getString("firstName"),userResultSet.getString("lastName"),userResultSet.getDate("registrationDate"),userResultSet.getDouble("taxNumber"));
                    users.add(host);
                }
                else if("g".equals(userType)){
                    Gold gold = new Gold(userResultSet.getInt("userID"),userResultSet.getDate("dateOfBirth"),userResultSet.getString("firstName"),userResultSet.getString("lastName"),userResultSet.getDate("registrationDate"),userResultSet.getString("preferredPaymentMethod"),userResultSet.getInt("goldLevel"));
                    users.add(gold);
                }
                else if("s".equals(userType)){
                    Standard standard = new Standard(userResultSet.getInt("userID"),userResultSet.getDate("dateOfBirth"),userResultSet.getString("firstName"),userResultSet.getString("lastName"),userResultSet.getDate("registrationDate"),userResultSet.getString("preferredPaymentMethod"));
                    users.add(standard);
                }
            }
            while (propertyResultSet.next()){
                String propertyType = propertyResultSet.getString("type");
                if ("s".equals(propertyType)){
                    SharedProperty sharedProperty = new SharedProperty(propertyResultSet.getInt("propertyID"),propertyResultSet.getInt("noBedRooms"),propertyResultSet.getInt("noRooms"),propertyResultSet.getString("city"),propertyResultSet.getDouble("pricePerDay"));
                    properties.add(sharedProperty);
                }
                else if("f".equals(propertyType)){
                    FullProperty fullProperty = new FullProperty(propertyResultSet.getInt("propertyID"),propertyResultSet.getInt("noBedRooms"),propertyResultSet.getInt("noRooms"),propertyResultSet.getString("city"),propertyResultSet.getDouble("pricePerDay"),propertyResultSet.getDouble("propertySize"));
                    properties.add(fullProperty);
                }
            }
        }
        catch (SQLException se){
            // Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e){
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        finally {
            try {
                if (propertyStatement != null) {
                    propertyStatement.close();
                }
                if (userStatement != null) {
                    userStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void saveDataFromDataBase(ArrayList<User> users, ArrayList<Property> properties){
        Connection connection = null;
        PreparedStatement hostStatement = null;
        PreparedStatement standardStatement = null;
        PreparedStatement goldStatement = null;
        PreparedStatement fullStatement = null;
        PreparedStatement sharedStatement = null;
        Statement truncateUserTable = null;
        Statement truncatePropertyTable = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basicdb", "cng443user", "1234");

            truncateUserTable = connection.createStatement();
            truncatePropertyTable = connection.createStatement();

            truncateUserTable.executeUpdate("truncate table user");
            truncatePropertyTable.executeUpdate("truncate table property");

            hostStatement=connection.prepareStatement("insert into user(userID, dateOfBirth, firstName, lastName, registrationDate, type, taxNumber)values (?,?,?,?,?,?,?)");
            standardStatement=connection.prepareStatement("insert into user(userID, dateOfBirth, firstName, lastName, registrationDate, type, preferredPaymentMethod)values (?,?,?,?,?,?,?)");
            goldStatement=connection.prepareStatement("insert into user(userID, dateOfBirth, firstName, lastName, registrationDate, type, preferredPaymentMethod,goldLevel)values (?,?,?,?,?,?,?,?)");
            fullStatement=connection.prepareStatement("insert into property(propertyID,noBedRooms,noRooms,city,pricePerDay,type,propertySize)values(?,?,?,?,?,?,?)");
            sharedStatement=connection.prepareStatement("insert into property(propertyID,noBedRooms,noRooms,city,pricePerDay,type)values(?,?,?,?,?,?)");

            for(int i=0;i< users.size();i++){
                if(users.get(i) instanceof Host){
                    hostStatement.setInt(1, users.get(i).getUserId());
                    hostStatement.setDate(2,  new java.sql.Date(users.get(i).getDataOfBirth().getTime()));
                    hostStatement.setString(3,  users.get(i).getFirstName());
                    hostStatement.setString(4,  users.get(i).getLastName());
                    hostStatement.setDate(5,  new java.sql.Date(users.get(i).getRegistrationDate().getTime()));
                    hostStatement.setString(6,  "h");
                    hostStatement.setDouble(7,  ((Host) users.get(i)).getTaxNumber());
                    hostStatement.executeUpdate();
                }
                else if(users.get(i) instanceof Standard){
                    standardStatement.setInt(1, users.get(i).getUserId());
                    standardStatement.setDate(2,  new java.sql.Date(users.get(i).getDataOfBirth().getTime()));
                    standardStatement.setString(3,  users.get(i).getFirstName());
                    standardStatement.setString(4,  users.get(i).getLastName());
                    standardStatement.setDate(5,  new java.sql.Date(users.get(i).getRegistrationDate().getTime()));
                    standardStatement.setString(6,  "s");
                    standardStatement.setString(7,  ((Standard) users.get(i)).getPreferredPaymentMethod());
                    standardStatement.executeUpdate();
                }
                else if(users.get(i) instanceof Gold){
                    goldStatement.setInt(1, users.get(i).getUserId());
                    goldStatement.setDate(2,  new java.sql.Date(users.get(i).getDataOfBirth().getTime()));
                    goldStatement.setString(3,  users.get(i).getFirstName());
                    goldStatement.setString(4,  users.get(i).getLastName());
                    goldStatement.setDate(5,  new java.sql.Date(users.get(i).getRegistrationDate().getTime()));
                    goldStatement.setString(6,  "g");
                    goldStatement.setString(7,  ((Gold) users.get(i)).getPreferredPaymentMethod());
                    goldStatement.setInt(8,  ((Gold) users.get(i)).getGoldLevel());
                    goldStatement.executeUpdate();
                }
            }
            for(int i=0;i< properties.size();i++){
                if(properties.get(i) instanceof FullProperty){
                    fullStatement.setInt(1, properties.get(i).getPropertyId());
                    fullStatement.setInt(2,  properties.get(i).getNoBedRooms());
                    fullStatement.setInt(3,  properties.get(i).getNoRooms());
                    fullStatement.setString(4,  properties.get(i).getCity());
                    fullStatement.setDouble(5,  properties.get(i).getPricePerDay());
                    fullStatement.setString(6,  "f");
                    fullStatement.setDouble(7,  ((FullProperty) properties.get(i)).getPropertySize());
                    fullStatement.executeUpdate();
                }
                else if(properties.get(i) instanceof SharedProperty){
                    sharedStatement.setInt(1, properties.get(i).getPropertyId());
                    sharedStatement.setInt(2,  properties.get(i).getNoBedRooms());
                    sharedStatement.setInt(3,  properties.get(i).getNoRooms());
                    sharedStatement.setString(4,  properties.get(i).getCity());
                    sharedStatement.setDouble(5,  properties.get(i).getPricePerDay());
                    sharedStatement.setString(6,  "s");
                    sharedStatement.executeUpdate();
                }
            }
        }
        catch (SQLException se){
            // Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e){
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        finally {
            try {
                if (sharedStatement!=null) {
                    sharedStatement.close();
                }
                if (fullStatement!=null) {
                    fullStatement.close();
                }
                if (goldStatement!=null) {
                    goldStatement.close();
                }
                if (standardStatement!=null) {
                    standardStatement.close();
                }
                if (hostStatement!=null) {
                    hostStatement.close();
                }
                if (truncatePropertyTable!=null){
                    truncatePropertyTable.close();
                }
                if (truncateUserTable!=null){
                    truncateUserTable.close();
                }
                if (connection!=null) {
                    connection.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
