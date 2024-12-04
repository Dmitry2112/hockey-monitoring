package examples.patterns.behavior.strategy;

/**
 * паттерн Strategy
 */
public enum TeamRole {
    ATTACKER {
        @Override
        public void play() {
            System.out.println("Мчится к воротам соперника забивать голы");
        }
    },

    GOALKEEPER {
        @Override
        public void play() {
            System.out.println("Стойко защищает свои ворота");
        }
    };

    public abstract void play();
}
