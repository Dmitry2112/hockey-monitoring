package examples.patterns.behavior.state;

public class Trainer {
    private Mood mood = TrainerMood.GOOD;

    public void switchMood(Mood mood) {
        if (mood != null) {
            System.out.printf("У тренера изменилось настроение на %s\n", mood);
            this.mood = mood;
        }
    }

    public void say() {
        mood.say();
    }
}
