package examples.patterns.behavior.state;

public enum TrainerMood implements Mood {
    GOOD {
        @Override
        public void say() {
            System.out.println("Молодцы, ребята! Так держать!");
        }
    },

    BAD {
        @Override
        public void say() {
            System.out.println("Какая ужасная команда...");
        }
    }
}
