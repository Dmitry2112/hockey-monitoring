package examples.patterns.structure.decorator;

public class BadMood extends Mood {
    public BadMood(Judge judge) {
        super(judge);
    }

    @Override
    public void sayVerdict() {
        super.sayVerdict();
        System.out.print(", но рассердился.");
    }
}
