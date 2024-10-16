package examples.patterns.structure.bridge;

public class CityJudge implements JudgeLevel {
    @Override
    public String getLevel() {
        return "Городской";
    }
}
