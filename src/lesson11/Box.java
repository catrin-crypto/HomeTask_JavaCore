package lesson11;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(T fruit) {
        if (!fruits.isEmpty() && !fruits.get(0).getClass().equals(fruit.getClass())) {
            System.out.println("Wrong type of fruit!");
        } else {
            fruits.add(fruit);
        }

    }

    public double getWeight() {
        double sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box boxToCompare) {
        return Double.compare(this.getWeight(), boxToCompare.getWeight()) == 0 ? true : false;
    }

    public void merge(Box boxToMergeInto) {
        if (fruits.isEmpty()) {
            return;
        }
        fruits.forEach((fruit) -> boxToMergeInto.addFruit(fruit));
        if (!boxToMergeInto.fruits.isEmpty() &&
                boxToMergeInto.fruits.get(0).getClass().equals(this.fruits.get(0).getClass())) {
            fruits.clear();
        }
    }

}
