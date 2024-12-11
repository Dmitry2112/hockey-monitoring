package examples.patterns.behavior.templatemethod;

public class MaleTournamentRegistrar extends TournamentRegistrar {
    @Override
    protected String getSuperDocuments(HockeyPlayer player) {
        System.out.println("Получить документы из военкомата для игрока");
        return "Документы из военкомата";
    }

    @Override
    protected void addPlayerInTeam(HockeyPlayer player, String docs) {
        System.out.println("Добавить игрока в мужскую сборную");
    }
}
