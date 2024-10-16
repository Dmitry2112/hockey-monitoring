package examples.patterns.structure.bridge;

public class ChiefJudge extends Judge {
    public ChiefJudge(JudgeLevel judgeLevel) {
        super(judgeLevel);
    }

    @Override
    public String getVerdict() {
        return String.format("%s главный судья присвоил победу команде A", judgeLevel.getLevel());
    }
}
