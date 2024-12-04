package examples.patterns.behavior.state;

public class Usage {
    public static void main(String[] args) {
        Trainer trainer = new Trainer();

        trainer.say();
        System.out.println();

        trainer.switchMood(TrainerMood.BAD);
        trainer.say();
        System.out.println();

        trainer.switchMood(TrainerMood.GOOD);
        trainer.say();
        System.out.println();
    }
}
