package lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public int getFood() {
        return food;
    }
    public void info(){
        System.out.println("Plate: " + food);
    }
    public void decreaseFood(int n){
        food -= n;
        if(food < 0){
            food = 0;
        }
    }
    public void increaseFood(int n){
        food += n;
    }
}
