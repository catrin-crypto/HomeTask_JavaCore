package lesson10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>( 15);
        arrList.add("Swimming");
        arrList.add("Tennis");
        arrList.add("Swimming");
        arrList.add("Football");
        arrList.add("Badminton");
        arrList.add("Swimming");
        arrList.add("Surfing");
        arrList.add("Basketball");
        arrList.add("Volleyball");
        arrList.add("Ping-pong");
        arrList.add("Swimming");
        arrList.add("Surfing");
        arrList.add("Snowboarding");
        arrList.add("Skiing");
        arrList.add("Snowboarding");
        Iterator<String> iter = arrList.iterator();
        Map<String, Integer> uniqueWordsMap = new TreeMap();
        while (iter.hasNext()){
            String currentString = iter.next();
            int count = uniqueWordsMap.containsKey(currentString) ? uniqueWordsMap.get(currentString) : 0;
            uniqueWordsMap.put(currentString, count + 1);
        }
        System.out.println("Unique words are:");
        uniqueWordsMap.forEach((key, value) -> {if(value == 1) System.out.print(key + ", " );});
        System.out.println();
        System.out.println("Total count of words in arrList:");
        System.out.println(uniqueWordsMap);


        //Console output for PhoneBook
        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.addUsersData("Bond", "809027645");
        phoneBook1.addUsersData("Freeman", "421475677655");
        phoneBook1.addUsersData("Bond", "5467027645");
        phoneBook1.addUsersData("Pitt", "23456u765");
        phoneBook1.addUsersData("Bond", "qh632e447gy");
        phoneBook1.addUsersData("Rambo", "89007642234567");
        System.out.println("Bond numbers: " + phoneBook1.getPhoneNumbers("Bond"));
        System.out.println("Pitt numbers: " + phoneBook1.getPhoneNumbers("Pitt"));
    }
}
