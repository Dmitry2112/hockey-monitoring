package examples.patterns.behavior.interpreter;

public class Usage {
    public static void main(String[] args) {
        Expression isSimpleJudge = getSimpleJudgeExpression();
        Expression isTeamJudge = getTeamJudgeExpression();

        System.out.println("Это простой судья: " + isSimpleJudge.interpret("Trainer"));
        System.out.println("Это командный судья: " + isTeamJudge.interpret("Trainer Judge"));
    }

    public static Expression getSimpleJudgeExpression() {
        Expression trainer = new TerminalExpression("Trainer");
        Expression judge = new TerminalExpression("Judge");

        return new OrExpression(trainer, judge);
    }

    public static Expression getTeamJudgeExpression() {
        Expression trainer = new TerminalExpression("Trainer");
        Expression judge = new TerminalExpression("Judge");

        return new AndExpression(trainer, judge);
    }
}
