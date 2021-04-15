package lesson8;

public class Main {
    public static void main(String[] args){

        RunJump[] participants = {new Cat(100, 5, "Barsik"),
                                  new Robot(3000, 7, "R2D2"),
                                    new Human(5000, 10, "Vasya"),
                                    new Human(550, 3, "Artur"),
                                    new Robot(25, 45, "Trinity"),
                                    new Cat(45, 2, "Murzik"), };
        Barrier[] barriers = {new Track(90), new Wall(1), new Track(200),
                                new Track(500), new Wall(5), new Track(1000),
                                new Wall(35), new Track(4900), };
        for (int i = 0; i < barriers.length; i++) {
            for (int j = 0; j < participants.length; j++) {
                if(participants[j] != null){
                    Boolean result = barriers[i].passBarrier(participants[j]);
                    if(result == false){
                        participants[j] = null;
                    }
                }
            }
        }

    }

}
