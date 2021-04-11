package lesson7;

public class Main {
    public static void main(String[] args){
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Barsik", 20, false);
        cats[1] = new Cat("Murzik", 10, false);
        cats[2] = new Cat("Kitty", 5, false);
        cats[3] = new Cat("Uno", 50, false);

        Plate plate = new Plate(50);

        for (int i = 0; i < cats.length; i++) {
            plate.info();
            cats[i].eat(plate);
            plate.info();
            if(cats[i].isFoodEnough()){
                System.out.println("Cat " + cats[i].getName() + " is full!");
            } else {
                System.out.println("Cat " + cats[i].getName() + " is hungry!");
            }

        }

    }
}
