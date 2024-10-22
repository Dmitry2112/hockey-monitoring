package examples.patterns.structure.decorator;

public class Usage {
    public static void main(String[] args) {
        Judge judge = new MainJudge();

        judge.sayVerdict();
        System.out.println();

        judge = new GoodMood(new MainJudge());
        judge.sayVerdict();
        System.out.println();

        judge = new BadMood(new MainJudge());
        judge.sayVerdict();
        System.out.println();
    }
}
