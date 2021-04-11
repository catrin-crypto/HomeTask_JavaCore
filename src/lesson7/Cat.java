package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }
    public void eat(Plate p){
        if(p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            satiety = true;
            appetite = 0;
        }

    }

    public String getName() {
        return name;
    }

    public boolean isFoodEnough(){
        if(appetite == 0){
            return true;
        } else{
            return false;
        }
    }
}
