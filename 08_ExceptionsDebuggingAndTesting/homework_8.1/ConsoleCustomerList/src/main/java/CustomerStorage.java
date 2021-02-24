import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        try {
            String[] components = data.split("\\s+");
            if (components.length != 4) {
                throw new ComponentsLengthVolumeWrong("Components length volume not equal to 4.");
            }

            if (components[INDEX_PHONE].matches("(\\+7|8|007)\\d+")) {
            } else {
                throw new PhoneNumberIsWrongFormat ("Phone number is wrong format.");
            }

            if (components[INDEX_EMAIL].matches("\\w+(|\\.\\w+)@\\w+\\.[ru|com|gov]+")) {
            } else {
                throw new EmailNameIsWrongFormat ("Email name is wrong format.");
            }

            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        } catch (ComponentsLengthVolumeWrong e) {
            System.out.println(e.getMessage());
        } catch (EmailNameIsWrongFormat e) {
            System.out.println(e.getMessage());
        } catch (PhoneNumberIsWrongFormat e) {
            System.out.println(e.getMessage());
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    private class ComponentsLengthVolumeWrong extends Throwable {
        public ComponentsLengthVolumeWrong (String message) {
            super (message);
        }
    }

    private class PhoneNumberIsWrongFormat extends Throwable {
        public PhoneNumberIsWrongFormat (String massage) {
            super (massage);
        }
    }

    private class EmailNameIsWrongFormat extends Throwable {
        public EmailNameIsWrongFormat (String massage) {
            super (massage);
        }
    }
}