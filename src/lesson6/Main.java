package lesson6;

public class Main {
    public static void main(String[] args){
        Cat murzik = new Cat("Murzik");
        Dog bobik = new Dog("Bobik");
        murzik.swim(20);
        murzik.run(56);
        bobik.swim(100);
        bobik.run(1000);

        System.out.println("Total number of animals is " + Animal.getAnimalsCount());
        System.out.println("Total number of cats is " + Cat.getCatsCount());
        System.out.println("Total number of dogs is " + Dog.getDogsCount());
    }
}
