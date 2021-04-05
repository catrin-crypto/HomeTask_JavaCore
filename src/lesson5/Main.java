package lesson5;

public class Main {

    public static void main(String[] args){
        Employee[] personArray = new Employee[5];
        personArray[0] = new Employee("Johnny Depp", "star actor", "depp@hollywood.com",
                "4005672345", "1.000.000$", 45);
        personArray[1] = new Employee("Keanu Reeves", "star actor", "rivz@hollywood.com",
                "9657798765", "1.500.000$", 34);
        personArray[2] = new Employee("Kim Travis", "art-director", "travis@hollywood.com",
                "1533245986", "20.000$", 23);
        personArray[3] = new Employee("Quentin Tarantino", "film director", "taran@hollywood.com",
                "876433680", "3.000.000$", 56);
        personArray[4] = new Employee("Jane Doe", "debuting actress", "doe@hollywood.com",
                "5010103209", "500$", 21);

        for (int i = 0; i < personArray.length; i++) {
            if(personArray[i].getAge() > 40){
                personArray[i].printInfo();
                System.out.println();
            }
        }


    }
}
