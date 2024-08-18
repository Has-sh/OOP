import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BASIC {
    private JFrame frame;
    private JButton addUserButton;
    private JButton deleteUserButton;
    private JButton getUserDetailsButton;
    private JButton addPropertyButton;
    private JButton deletePropertyButton;
    private JButton getPropertyDetailsButton;
    private JButton addBookingButton;
    private JButton getUserBookingButton;
    private JButton getBookingCostButton;
    private JButton listUsersButton;
    private JButton listPropertiesButton;
    private JButton getDiscountForUserButton;
    private JButton addInspectionToPropertyButton;
    private JButton comparePropertyPricePerDayButton;
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Property> properties = new ArrayList<>();

    public BASIC() {
        frame = new JFrame("Bed And Breakfast In Cyprus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);

        addUserButton = new JButton("Add User");
        deleteUserButton = new JButton("Delete User");
        getUserDetailsButton = new JButton("Get User Details");
        addPropertyButton = new JButton("Add Property");
        deletePropertyButton = new JButton("Delete Property");
        getPropertyDetailsButton = new JButton("Get Property Details");
        addBookingButton = new JButton("Add Booking");
        getUserBookingButton = new JButton("Get User Bookings");
        getBookingCostButton = new JButton("Get Booking Cost");
        listUsersButton = new JButton("List Users");
        listPropertiesButton = new JButton("List Properties");
        getDiscountForUserButton = new JButton("Get Discount for User");
        addInspectionToPropertyButton = new JButton("Add Inspection to Property");
        comparePropertyPricePerDayButton = new JButton("Compare Property Price Per Day");

        JMenuItem exitButton = new JMenuItem("Close");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Exit");

        JPanel mainPanel = new JPanel(new GridLayout(15, 1));
        mainPanel.add(new JLabel("Welcome to Bed And Breakfast In Cyprus", SwingConstants.CENTER));
        mainPanel.add(addUserButton);
        mainPanel.add(deleteUserButton);
        mainPanel.add(getUserDetailsButton);
        mainPanel.add(addPropertyButton);
        mainPanel.add(deletePropertyButton);
        mainPanel.add(getPropertyDetailsButton);
        mainPanel.add(addBookingButton);
        mainPanel.add(getUserBookingButton);
        mainPanel.add(getBookingCostButton);
        mainPanel.add(listUsersButton);
        mainPanel.add(listPropertiesButton);
        mainPanel.add(getDiscountForUserButton);
        mainPanel.add(addInspectionToPropertyButton);
        mainPanel.add(comparePropertyPricePerDayButton);

        menu.add(exitButton);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);


        frame.add(mainPanel);

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addUserFrame = new JFrame("Add User");
                addUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addUserFrame.setSize(400, 300);
                addUserFrame.setLocationRelativeTo(null);

                JLabel userIdLabel = new JLabel("User ID:");
                JTextField userIdField = new JTextField();

                JLabel dobLabel = new JLabel("Date of Birth (dd/MM/yyyy):");
                JTextField dobField = new JTextField();

                JLabel firstNameLabel = new JLabel("First Name:");
                JTextField firstNameField = new JTextField();

                JLabel lastNameLabel = new JLabel("Last Name:");
                JTextField lastNameField = new JTextField();

                JLabel regDateLabel = new JLabel("Registration Date (dd/MM/yyyy):");
                JTextField regDateField = new JTextField();

                JLabel userTypeLabel = new JLabel("User Type:");
                String[] userTypes = {"Host", "Standard", "Gold"};
                JComboBox<String> userTypeComboBox = new JComboBox<>(userTypes);

                JLabel hostInfoLabel = new JLabel("Tax Number:");
                JTextField hostInfoField = new JTextField();

                JLabel standardInfoLabel = new JLabel("Payment Method :");
                JTextField standardInfoField = new JTextField();

                JLabel goldInfoLabel = new JLabel("Gold Level (1-3) :");
                JTextField goldInfoField = new JTextField();

                JButton submitButton = new JButton("Submit");

                JPanel addUserPanel = new JPanel(new GridLayout(10, 2));
                addUserPanel.add(userIdLabel);
                addUserPanel.add(userIdField);
                addUserPanel.add(dobLabel);
                addUserPanel.add(dobField);
                addUserPanel.add(firstNameLabel);
                addUserPanel.add(firstNameField);
                addUserPanel.add(lastNameLabel);
                addUserPanel.add(lastNameField);
                addUserPanel.add(regDateLabel);
                addUserPanel.add(regDateField);
                addUserPanel.add(userTypeLabel);
                addUserPanel.add(userTypeComboBox);
                addUserPanel.add(hostInfoLabel);
                addUserPanel.add(hostInfoField);
                addUserPanel.add(standardInfoLabel);
                addUserPanel.add(standardInfoField);
                addUserPanel.add(goldInfoLabel);
                addUserPanel.add(goldInfoField);
                addUserPanel.add(submitButton);
                addUserFrame.add(addUserPanel);
                goldInfoLabel.setVisible(false);
                goldInfoField.setVisible(false);
                standardInfoLabel.setVisible(false);
                standardInfoField.setVisible(false);
                hostInfoLabel.setVisible(true);
                hostInfoField.setVisible(true);
                userTypeComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedType = (String) userTypeComboBox.getSelectedItem();
                        if ("Host".equalsIgnoreCase(selectedType)) {
                            hostInfoLabel.setVisible(true);
                            hostInfoField.setVisible(true);
                            standardInfoLabel.setVisible(false);
                            standardInfoField.setVisible(false);
                            goldInfoLabel.setVisible(false);
                            goldInfoField.setVisible(false);
                        } else if ("Standard".equalsIgnoreCase(selectedType)) {
                            standardInfoLabel.setVisible(true);
                            standardInfoField.setVisible(true);
                            hostInfoLabel.setVisible(false);
                            hostInfoField.setVisible(false);
                            goldInfoLabel.setVisible(false);
                            goldInfoField.setVisible(false);
                        } else if ("Gold".equalsIgnoreCase(selectedType)) {
                            goldInfoLabel.setVisible(true);
                            goldInfoField.setVisible(true);
                            standardInfoLabel.setVisible(true);
                            standardInfoField.setVisible(true);
                            hostInfoLabel.setVisible(false);
                            hostInfoField.setVisible(false);
                        } else {
                            goldInfoLabel.setVisible(false);
                            goldInfoField.setVisible(false);
                            standardInfoLabel.setVisible(false);
                            standardInfoField.setVisible(false);
                            hostInfoLabel.setVisible(false);
                            hostInfoField.setVisible(false);
                        }
                    }
                });

                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int userId = Integer.parseInt(userIdField.getText());
                            String dobInput = dobField.getText();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            Date dob = dateFormat.parse(dobInput);

                            String firstName = firstNameField.getText();
                            String lastName = lastNameField.getText();

                            String regDateInput = regDateField.getText();
                            Date regDate = dateFormat.parse(regDateInput);

                            String userType = (String) userTypeComboBox.getSelectedItem();
                            User newUser = null;

                            if ("Host".equalsIgnoreCase(userType)) {
                                double taxNumber = Double.parseDouble(hostInfoField.getText());
                                newUser = new Host(userId, dob, firstName, lastName, regDate, taxNumber);
                                users.add(newUser);
                            } else if ("Standard".equalsIgnoreCase(userType)) {
                                String creditCardInfo = standardInfoField.getText();
                                newUser = new Standard(userId, dob, firstName, lastName, regDate, creditCardInfo);
                                users.add(newUser);
                            } else if ("Gold".equalsIgnoreCase(userType)) {
                                int goldLevel = Integer.parseInt(goldInfoField.getText());
                                String creditCardInfo = goldInfoField.getText();
                                if (goldLevel >= 1 && goldLevel <= 3) {
                                    newUser = new Gold(userId, dob, firstName, lastName, regDate, creditCardInfo, goldLevel);
                                    users.add(newUser);
                                } else {
                                    JOptionPane.showMessageDialog(addUserFrame, "Gold Level must be between 1 and 3. Could not add user.");
                                    return;
                                }
                            }

                            JOptionPane.showMessageDialog(addUserFrame, "User added successfully.");
                            addUserFrame.dispose();
                        } catch (ParseException | NumberFormatException ex) {
                            JOptionPane.showMessageDialog(addUserFrame, "Invalid input. Please check the values.");
                        }
                    }
                });

                addUserFrame.setVisible(true);
            }
        });

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID:"));

                    User foundUser = null;
                    for (int i = 0; i < users.size(); i++) {
                        if(users.get(i).getUserId()==userId) {
                            foundUser = users.get(i);
                            users.remove(foundUser);
                            break;
                        }
                    }
                    if (foundUser != null) {
                        JOptionPane.showMessageDialog(frame, "User Successfully Deleted", "User Deleted", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid user ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getUserDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID:"));

                    User foundUser = null;
                    for (int i = 0; i < users.size(); i++) {
                        if(users.get(i).getUserId()==userId) {
                            foundUser = users.get(i);
                            break;
                        }
                    }
                    if (foundUser != null) {
                        StringBuilder userDetails = new StringBuilder();
                        userDetails.append("User ID: ").append(foundUser.getUserId()).append("\n");
                        userDetails.append("Date of Birth: ").append(foundUser.getDataOfBirth()).append("\n");
                        userDetails.append("First Name: ").append(foundUser.getFirstName()).append("\n");
                        userDetails.append("Last Name: ").append(foundUser.getLastName()).append("\n");
                        userDetails.append("Registration Date: ").append(foundUser.getRegistrationDate()).append("\n");

                        if (foundUser instanceof Host) {
                            userDetails.append("Tax Number: ").append(((Host) foundUser).getTaxNumber()).append("\n");
                        } else if (foundUser instanceof Standard) {
                            userDetails.append("Preferred Payment Method: ").append(((Standard) foundUser).getPreferredPaymentMethod()).append("\n");
                        } else if (foundUser instanceof Gold) {
                            userDetails.append("Preferred Payment Method: ").append(((Gold) foundUser).getPreferredPaymentMethod()).append("\n");
                            userDetails.append("Gold Level: ").append(((Gold) foundUser).getGoldLevel()).append("\n");
                        }

                        String userDetails1 = userDetails.toString();
                        JOptionPane.showMessageDialog(frame, userDetails1, "User Details", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid user ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addPropertyFrame = new JFrame("Add Property");
                addPropertyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addPropertyFrame.setSize(400, 300);
                addPropertyFrame.setLocationRelativeTo(null);

                JLabel propertyIdLabel = new JLabel("Property ID:");
                JTextField propertyIdField = new JTextField();

                JLabel noBedRoomsLabel = new JLabel("Number of Bed Rooms:");
                JTextField noBedRoomsField = new JTextField();

                JLabel noRoomsLabel = new JLabel("Number of Rooms:");
                JTextField noRoomsField = new JTextField();

                JLabel cityLabel = new JLabel("City:");
                JTextField cityField = new JTextField();

                JLabel pricePerDayLabel = new JLabel("Price per Day:");
                JTextField pricePerDayField = new JTextField();

                JLabel hostIdLabel = new JLabel("Host ID:");
                JTextField hostIdField = new JTextField();

                JLabel propertyTypeLabel = new JLabel("Property Type:");
                String[] propertyTypes = {"Full", "Shared"};
                JComboBox<String> propertyTypeComboBox = new JComboBox<>(propertyTypes);

                JLabel propertySizeLabel = new JLabel("Property Size (sq meters):");
                JTextField propertySizeField = new JTextField();

                JButton submitButton = new JButton("Submit");

                JPanel addPropertyPanel = new JPanel(new GridLayout(9, 2));
                addPropertyPanel.add(propertyIdLabel);
                addPropertyPanel.add(propertyIdField);
                addPropertyPanel.add(noBedRoomsLabel);
                addPropertyPanel.add(noBedRoomsField);
                addPropertyPanel.add(noRoomsLabel);
                addPropertyPanel.add(noRoomsField);
                addPropertyPanel.add(cityLabel);
                addPropertyPanel.add(cityField);
                addPropertyPanel.add(pricePerDayLabel);
                addPropertyPanel.add(pricePerDayField);
                addPropertyPanel.add(hostIdLabel);
                addPropertyPanel.add(hostIdField);
                addPropertyPanel.add(propertyTypeLabel);
                addPropertyPanel.add(propertyTypeComboBox);
                addPropertyPanel.add(propertySizeLabel);
                addPropertyPanel.add(propertySizeField);
                addPropertyPanel.add(submitButton);

                addPropertyFrame.add(addPropertyPanel);

                propertyTypeComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedType = (String) propertyTypeComboBox.getSelectedItem();
                        propertySizeLabel.setVisible("Full".equalsIgnoreCase(selectedType));
                        propertySizeField.setVisible("Full".equalsIgnoreCase(selectedType));
                    }
                });

                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int propertyId = Integer.parseInt(propertyIdField.getText());
                            int noBedRooms = Integer.parseInt(noBedRoomsField.getText());
                            int noRooms = Integer.parseInt(noRoomsField.getText());
                            String city = cityField.getText();
                            float pricePerDay = Float.parseFloat(pricePerDayField.getText());
                            int hostId = Integer.parseInt(hostIdField.getText());
                            String propertyType = (String) propertyTypeComboBox.getSelectedItem();
                            double propertySize = 0.0;

                            if ("Full".equalsIgnoreCase(propertyType)) {
                                propertySize = Double.parseDouble(propertySizeField.getText());
                            }

                            // Check if the host with the given ID exists
                            Host host=null;

                            for(int i=0;i<users.size();i++){
                                if(users.get(i) instanceof Host && users.get(i).getUserId()==hostId) {
                                    host= (Host) users.get(i);
                                    break;
                                }
                            }

                            if (host != null) {
                                if ("Full".equalsIgnoreCase(propertyType)) {
                                    FullProperty property1 = new FullProperty(propertyId, noBedRooms, noRooms, city, pricePerDay, propertySize, host);
                                    properties.add(property1);
                                } else if ("Shared".equalsIgnoreCase(propertyType)) {
                                    SharedProperty property2 = new SharedProperty(propertyId, noBedRooms, noRooms, city, pricePerDay, host);
                                    properties.add(property2);
                                } else {
                                    JOptionPane.showMessageDialog(addPropertyFrame, "Invalid Property Type");
                                    return;
                                }

                                JOptionPane.showMessageDialog(addPropertyFrame, "Property added successfully.");
                                addPropertyFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(addPropertyFrame, "Host with ID " + hostId + " does not exist.");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(addPropertyFrame, "Invalid input. Please check the values.");
                        }
                    }
                });

                addPropertyFrame.setVisible(true);
            }
        });

        deletePropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int propertyId = Integer.parseInt(JOptionPane.showInputDialog("Enter Property ID:"));

                    Property foundProperty = null;
                    for (int i = 0; i < properties.size(); i++) {
                        if(properties.get(i).getPropertyId()==propertyId) {
                            foundProperty = properties.get(i);
                            properties.remove(foundProperty);
                            break;
                        }
                    }
                    if (foundProperty != null) {
                        JOptionPane.showMessageDialog(frame, "Property Successfully Deleted", "Property Deleted", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Property not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid property ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getPropertyDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int propertyId = Integer.parseInt(JOptionPane.showInputDialog("Enter Property ID:"));

                    Property foundProperty = null;
                    for (int i = 0; i < properties.size(); i++) {
                        if(properties.get(i).getPropertyId()==propertyId) {
                            foundProperty = properties.get(i);
                            break;
                        }
                    }
                    if (foundProperty != null) {
                        StringBuilder propertyDetails = new StringBuilder();
                        propertyDetails.append("Property ID: ").append(foundProperty.getPropertyId()).append("\n");
//                        propertyDetails.append("Host ID: ").append(foundProperty.getHost().getUserId()).append("\n");
                        propertyDetails.append("Number of Rooms: ").append(foundProperty.getNoRooms()).append("\n");
                        propertyDetails.append("City Name: ").append(foundProperty.getCity()).append("\n");
                        propertyDetails.append("Price Per Day: ").append(foundProperty.getPricePerDay()).append("\n");

                        if (foundProperty instanceof FullProperty) {
                            propertyDetails.append("Property size: ").append(((FullProperty) foundProperty).getPropertySize()).append("\n");
                        }

                        String propertyDetails1 = propertyDetails.toString();
                        JOptionPane.showMessageDialog(frame, propertyDetails1, "Property Details", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Property not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid property ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addBookingFrame = new JFrame("Add Booking");
                addBookingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addBookingFrame.setSize(400, 300);
                addBookingFrame.setLocationRelativeTo(null);

                JLabel userIdLabel = new JLabel("User ID:");
                JTextField userIdField = new JTextField();

                JLabel propertyIdLabel = new JLabel("Property ID:");
                JTextField propertyIdField = new JTextField();

                JLabel startDateLabel = new JLabel("Start Date (dd/MM/yyyy):");
                JTextField startDateField = new JTextField();

                JLabel endDateLabel = new JLabel("End Date (dd/MM/yyyy):");
                JTextField endDateField = new JTextField();

                JLabel isPaidLabel = new JLabel("Is Paid (true/false):");
                JTextField isPaidField = new JTextField();

                JButton submitButton = new JButton("Submit");

                JPanel addBookingPanel = new JPanel(new GridLayout(6, 2));
                addBookingPanel.add(userIdLabel);
                addBookingPanel.add(userIdField);
                addBookingPanel.add(propertyIdLabel);
                addBookingPanel.add(propertyIdField);
                addBookingPanel.add(startDateLabel);
                addBookingPanel.add(startDateField);
                addBookingPanel.add(endDateLabel);
                addBookingPanel.add(endDateField);
                addBookingPanel.add(isPaidLabel);
                addBookingPanel.add(isPaidField);
                addBookingPanel.add(submitButton);

                addBookingFrame.add(addBookingPanel);

                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int userId = Integer.parseInt(userIdField.getText());
                            int propertyId = Integer.parseInt(propertyIdField.getText());

                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            Date startDate = dateFormat.parse(startDateField.getText());
                            Date endDate = dateFormat.parse(endDateField.getText());

                            boolean isPaid = Boolean.parseBoolean(isPaidField.getText());

                            int flag = 0, index = -1;
                            Property property = null;
                            Booking booking = null;

                            for (int i = 0; i < users.size(); i++) {
                                if ((users.get(i).getUserId() == userId) && (users.get(i) instanceof Customer)) {
                                    index = i;
                                    flag++;
                                }
                            }

                            for (int i = 0; i < properties.size(); i++) {
                                if (properties.get(i).getPropertyId() == propertyId) {
                                    property = properties.get(i);
                                    flag++;
                                }
                            }

                            if (flag != 2) {
                                JOptionPane.showMessageDialog(addBookingFrame, "User or Property not found. Please check the IDs.");
                                return;
                            }

                            if (property instanceof SharedProperty) {
                                booking = new Booking(startDate, endDate, isPaid, users.get(index), property);
                            } else if (property instanceof FullProperty) {
                                booking = new Booking(startDate, endDate, isPaid, users.get(index), property);
                            }

                            users.get(index).addBooking(booking);

                            JOptionPane.showMessageDialog(addBookingFrame, "Booking added successfully.");
                            addBookingFrame.dispose();
                        } catch (NumberFormatException | ParseException ex) {
                            JOptionPane.showMessageDialog(addBookingFrame, "Invalid input. Please check the values.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                addBookingFrame.setVisible(true);
            }
        });

        getUserBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter Booker ID:"));
                    int index = -1;
                    User user = null;

                    for (int i = 0; i < users.size(); i++) {
                        if ((users.get(i).getUserId() == userId) && (users.get(i) instanceof Customer)) {
                            user=users.get(i);
                            index = i;
                            break;
                        }
                    }

                    if (user == null) {
                        JOptionPane.showMessageDialog(frame, "User not found. Please check the ID.");
                        return;
                    }

                    ArrayList<Booking> userBookings = ((Customer) users.get(index)).getBookings();

                    if (userBookings.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "This user has no bookings.");
                    } else {
                        StringBuilder bookingsInfo = new StringBuilder("Bookings for User Id: " + users.get(index).getUserId() + "\n");
                        for (int i = 0; i < userBookings.size(); i++) {
                            bookingsInfo.append("Property Id: ").append(userBookings.get(i).getProperty().getPropertyId()).append("\n");
                            bookingsInfo.append("Start Date: ").append(userBookings.get(i).getStartDate()).append("\n");
                            bookingsInfo.append("End Date: ").append(userBookings.get(i).getEndDate()).append("\n");
                            bookingsInfo.append("Is Paid: ").append(userBookings.get(i).getIsPaid()).append("\n");
                        }
                        JOptionPane.showMessageDialog(frame, bookingsInfo.toString());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please check the values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getBookingCostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID:"));
                    int propertyId = Integer.parseInt(JOptionPane.showInputDialog("Enter Property ID:"));

                    int flag = 0, index = -1;
                    Property property = null;

                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getUserId() == userId && users.get(i) instanceof Customer) {
                            index = i;
                            flag++;
                        }
                    }

                    for (int i = 0; i < properties.size(); i++) {
                        if (properties.get(i).getPropertyId() == propertyId) {
                            property = properties.get(i);
                            flag++;
                        }
                    }

                    if (flag != 2) {
                        JOptionPane.showMessageDialog(frame, "User or Property not found. Please check the IDs.");
                        return;
                    }

                    ArrayList<Booking> userBookings = ((Customer) users.get(index)).getBookings();
                    flag = 0;

                    for (int i = 0; i < userBookings.size(); i++) {
                        if (userBookings.get(i).getProperty() == property) {
                            float cost = userBookings.get(i).totalCost();
                            double discount = getDiscountForUser(userId);
                            cost = cost - (float)(cost * discount);
                            JOptionPane.showMessageDialog(frame, "Total Cost: " + cost);
                            flag = 1;
                        }
                    }

                    if (flag == 0) {
                        JOptionPane.showMessageDialog(frame, "User has no booking for this property");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please check the values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            private double getDiscountForUser(int userId) {
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUserId() == userId && users.get(i) instanceof Customer) {
                        return ((Customer) users.get(i)).discountPercentage();
                    }
                }
                System.out.println("User with ID " + userId + " is not a Customer");
                return 0;
            }
        });
        listUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder usersInfo = new StringBuilder("List of Users:\n");

                for (int i = 0; i < users.size(); i++) {
                    usersInfo.append("User Id: ").append(users.get(i).getUserId()).append("\n");
                    usersInfo.append("Date of Birth: ").append(users.get(i).getDataOfBirth()).append("\n");
                    usersInfo.append("First name: ").append(users.get(i).getFirstName()).append("\n");
                    usersInfo.append("Last name: ").append(users.get(i).getLastName()).append("\n\n");
                }
                if(users.isEmpty())
                    JOptionPane.showMessageDialog(frame, "User List is Empty");
                else
                    JOptionPane.showMessageDialog(frame, usersInfo.toString());
            }
        });
        listPropertiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder propertiesInfo = new StringBuilder("List of Properties:\n");

                for (int i = 0; i < properties.size(); i++) {
                    propertiesInfo.append("Property Id: ").append(properties.get(i).getPropertyId()).append("\n");
                    propertiesInfo.append("Number of bedrooms: ").append(properties.get(i).getNoBedRooms()).append("\n");
                    propertiesInfo.append("Number of rooms: ").append(properties.get(i).getNoRooms()).append("\n");
                    propertiesInfo.append("City Name: ").append(properties.get(i).getCity()).append("\n");
                    propertiesInfo.append("Price per Day: ").append(properties.get(i).getPricePerDay()).append("\n\n");
//                    propertiesInfo.append("Host Name: ").append(properties.get(i).getHost().getFirstName()).append("\n\n");
                }
                if(properties.isEmpty())
                    JOptionPane.showMessageDialog(frame, "Property List is Empty");
                else
                    JOptionPane.showMessageDialog(frame, propertiesInfo.toString());
            }
        });
        getDiscountForUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID:"));
                    int flag = 0;
                    StringBuilder discountInfo = new StringBuilder("Discount For User:\n");
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getUserId() == userId && users.get(i) instanceof Customer) {
                            discountInfo.append(((Customer) users.get(i)).discountPercentage()).append("\n");
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0)
                        JOptionPane.showMessageDialog(frame, "No customer exists by this User Id", "Error", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(frame, discountInfo.toString());
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please check the values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        addInspectionToPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int flag = 0;
                    int propertyId = Integer.parseInt(JOptionPane.showInputDialog("Enter Property ID:"));
                    String inspect = JOptionPane.showInputDialog("Enter Inspection details:");
                    for (int i = 0; i < properties.size(); i++) {
                        if (properties.get(i).getPropertyId() == propertyId) {
                            properties.get(i).addinspection(inspect);
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==0)
                        JOptionPane.showMessageDialog(frame, "No User exists by this User Id", "Error", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(frame, "Your recorded inspection: " + inspect);

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please check the values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        comparePropertyPricePerDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int flag = 0;
                    int propertyId1 = Integer.parseInt(JOptionPane.showInputDialog("Enter Property 1 ID:"));
                    int propertyId2 = Integer.parseInt(JOptionPane.showInputDialog("Enter Property 2 ID:"));
                    Property property2=null;
                    Property property1=null;

                    for (int i = 0; i < properties.size(); i++) {
                        if (properties.get(i).getPropertyId() == propertyId1) {
                            property1=properties.get(i);
                        }
                    }
                    for (int i = 0; i < properties.size(); i++) {
                        if (properties.get(i).getPropertyId() == propertyId2) {
                            property2=properties.get(i);
                        }
                    }
                    if(property1==null || property2==null){
                        JOptionPane.showMessageDialog(frame, "No Property exists for these Property Ids", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        int result=property1.compareTo(property2);
                        if(result == -1)
                            JOptionPane.showMessageDialog(frame, "Property 1 is cheaper");
                        else if(result == 1)
                            JOptionPane.showMessageDialog(frame, "Property 2 is cheaper");
                        else
                            JOptionPane.showMessageDialog(frame, "Property 1 and Property 2 are the same price");
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please check the values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws ParseException {
//        uncomment the bottom part for inital initialization of data and comment after initialization is done
//        PopulateData.createInstanceFile();
//        PopulateData.loadInstanceFile();
        Security.loadUsersMD5FromFile();
        DataStorage.loadDataFromDataBase(users,properties);

        Runtime.getRuntime().addShutdownHook(new Thread(()->{//stackoverflow copied as didnt learn how to save on close though i can just add it to exit button listner but thats not fun
            DataStorage.saveDataFromDataBase(users, properties);
            Security.saveUsersMD5ToFile(users);
        }));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BASIC().frame.setVisible(true);
            }
        });
    }
}
