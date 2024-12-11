package examples.patterns.behavior.templatemethod;

/**
 * паттерн Template method
 */
public abstract class TournamentRegistrar {
    public final void register(HockeyPlayer player) {
        String docs = getSuperDocuments(player);
        addPlayerInTeam(player, docs);
    }

    protected abstract String getSuperDocuments(HockeyPlayer player);

    protected abstract void addPlayerInTeam(HockeyPlayer player, String docs);
}
