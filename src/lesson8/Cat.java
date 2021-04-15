package lesson8;

public class Cat implements RunJump{
    private int runLimit;
    private int jumpLimit;
    private String name;

    public Cat(int runLimit, int jumpLimit, String name) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.name = name;
    }

    @Override
    public Boolean run(int size) {
        if (size <= runLimit) {
            System.out.println("Cat " + name + " has run successfully.");
            return true;
        } else {
            System.out.println("Cat " + name + " failed in running.");
            return false;
        }
    }

    @Override
    public Boolean jump(int size) {
        if (size <= jumpLimit) {
            System.out.println("Cat " + name + " has jumped successfully.");
            return true;
        } else {
            System.out.println("Cat " + name + " failed in jumping.");
            return false;
        }
    }
}
