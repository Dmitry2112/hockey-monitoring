package examples.patterns.behavior.templatemethod;

public class FemaleTournamentRegistrar extends TournamentRegistrar {
    @Override
    protected String getSuperDocuments(HockeyPlayer player) {
        System.out.println("Получить документы из женской консультации для игрока");
        return "Документы из женской консультации";
    }

    @Override
    protected void addPlayerInTeam(HockeyPlayer player, String docs) {
        System.out.println("Добавить игрока в женскую сборную");
    }
}
