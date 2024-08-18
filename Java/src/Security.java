import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Security {
    private static final String UserFile = "users.ser";
    private static final String MD5File = "MD5.txt";

    public static void saveUsersMD5ToFile(ArrayList<User> users) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(UserFile));
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(users);
            byte[] serializedUsers = byteArrayOutputStream.toByteArray();

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(serializedUsers);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(MD5File);
                fileOutputStream.write(hashBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException | NoSuchAlgorithmException e ){
            e.printStackTrace();
        }
    }

    public static void loadUsersMD5FromFile() {
        Thread thread = new Thread(() -> {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(UserFile));
                ArrayList<User> users = (ArrayList<User>) objectInputStream.readObject();

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(users);
                byte[] serializedUsers = byteArrayOutputStream.toByteArray();

                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashBytes = md.digest(serializedUsers);

                FileInputStream fileInputStream = new FileInputStream(MD5File);
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                byte[] fileHashBytes = new byte[fileInputStream.available()];
                fileInputStream.read(fileHashBytes);

                if (Arrays.equals(hashBytes, fileHashBytes)) {
                    System.out.println("Serialized users is not modified");
                } else {
                    System.out.println("Serialized users are modified proceed with caution");
                }
            } catch (IOException | NoSuchAlgorithmException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
