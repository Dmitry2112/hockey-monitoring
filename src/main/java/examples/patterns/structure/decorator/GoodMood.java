package examples.patterns.structure.decorator;

public class GoodMood extends Mood {
    public GoodMood(Judge judge) {
        super(judge);
    }

    @Override
    public void sayVerdict() {
        super.sayVerdict();
        System.out.print(" и улыбнулся.");
    }
}
