package examples.patterns.structure.bridge;

public class VideoJudge extends Judge {
    public VideoJudge(JudgeLevel judgeLevel) {
        super(judgeLevel);
    }

    @Override
    public String getVerdict() {
        return String.format("%s видеосудья зафиксировал нарушение на камеру", judgeLevel.getLevel());
    }
}
