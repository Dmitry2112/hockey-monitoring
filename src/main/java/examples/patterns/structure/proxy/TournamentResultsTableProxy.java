package examples.patterns.structure.proxy;

/**
 * Паттерн Proxy
 */
public class TournamentResultsTableProxy implements TournamentResults {
    private final TournamentResultsTable tournamentResultsTable = new TournamentResultsTable();

    private String[] resultsCache = null;

    @Override
    public String[] getResults() {
        System.out.println("Вызов метода proxy");
        if (resultsCache == null) {
            resultsCache = tournamentResultsTable.getResults();
        }
        return resultsCache;
    }

    public void clearCache() {
        resultsCache = null;
    }
}
