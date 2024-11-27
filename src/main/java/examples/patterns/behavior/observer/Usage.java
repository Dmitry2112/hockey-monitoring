package examples.patterns.behavior.observer;

public class Usage {
    public static void main(String[] args) {
        Score score = new Score();

        BlueFan blueFan1 = new BlueFan("Дмитрий");
        BlueFan blueFan2 = new BlueFan("Петр");
        BlueFan blueFan3 = new BlueFan("Иван");

        RedFan redFan1 = new RedFan("Константин");
        RedFan redFan2 = new RedFan("Сергей");
        RedFan redFan3 = new RedFan("Анатолий");

        score.subscribe(blueFan1);
        score.subscribe(blueFan2);
        score.subscribe(blueFan3);
        score.subscribe(redFan1);
        score.subscribe(redFan2);
        score.subscribe(redFan3);

        score.increaseBlueGoals();
        System.out.println("*************************************\n");

        score.increaseRedGoals();
        System.out.println("*************************************\n");

        score.increaseRedGoals();
        System.out.println("*************************************\n");

        score.increaseRedGoals();
        System.out.println("*************************************\n");
    }
}
