package lesson8;

public class Track implements Barrier{
    private final int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public Boolean passBarrier(RunJump runner) {
        return runner.run(length);
    }


    }

