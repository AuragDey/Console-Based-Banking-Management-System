import java.io.*;
import java.util.*;

public class DataStore {

    private static final String FILE = "bankdata.ser";

    public static void save(Map<Integer, Account> accounts, List<Transaction> transactions) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(accounts);
            out.writeObject(transactions);
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    @SuppressWarnings("unchecked")
    public static Object[] load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            return new Object[]{in.readObject(), in.readObject()};
        } catch (Exception e) {
            return new Object[]{new HashMap<>(), new ArrayList<>()};
        }
    }
}
