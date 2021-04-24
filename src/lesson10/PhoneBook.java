package lesson10;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private Map<String, ArrayList> usersData = new TreeMap<>();

    public void addUsersData(String surname, String phoneNumber) {
        ArrayList<String> phoneNumbers = usersData.containsKey(surname) ? usersData.get(surname) : new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        usersData.put(surname, phoneNumbers);
    }

    public ArrayList<String> getPhoneNumbers(String surname) {
        return usersData.get(surname);
    }
}
