package examples.patterns.structure.bridge;

/**
 * Паттерн Bridge
 */
public abstract class Judge {
    protected final JudgeLevel judgeLevel;

    protected Judge(JudgeLevel judgeLevel) {
        this.judgeLevel = judgeLevel;
    }

    public abstract String getVerdict();
}
