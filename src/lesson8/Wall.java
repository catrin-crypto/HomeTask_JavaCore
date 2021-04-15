package lesson8;

public class Wall implements Barrier {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public Boolean passBarrier(RunJump jumper) {
        return jumper.jump(height);
    }


}
