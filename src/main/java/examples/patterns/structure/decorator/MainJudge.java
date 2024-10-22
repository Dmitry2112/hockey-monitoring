package examples.patterns.structure.decorator;

public class MainJudge implements Judge {
    @Override
    public void sayVerdict() {
        System.out.print("Судья вынес вердикт");
    }
}
