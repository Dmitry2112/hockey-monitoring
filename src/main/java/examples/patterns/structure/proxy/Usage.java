package examples.patterns.structure.proxy;

public class Usage {
    public static void main(String[] args) {
        //Без использования proxy файл будет читаться каждый раз при печати результатов
        TournamentResults table = new TournamentResultsTable();
        System.out.println();
        printResults(table);
        System.out.println();
        printResults(table);
        System.out.println();
        printResults(table);
        System.out.println();

        //С использованием proxy файл будет читаться только при первой печати
        table = new TournamentResultsTableProxy();
        System.out.println();
        printResults(table);
        System.out.println();
        printResults(table);
        System.out.println();
        printResults(table);
    }

    public static void printResults(TournamentResults tournamentResults) {
        String[] results = tournamentResults.getResults();
        String[] rowData;
        System.out.println("Фамилия\t\tНомер\tГород\tДата\t\tРейтинг до\tРейтинг после");
        for (String s : results) {
            rowData = s.split(";");
            System.out.printf("%s\t\t%s\t\t%s\t%s\t%s\t\t\t%s\n", rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5]);
        }
    }
}
