package examples.patterns.behavior.visitor;

public class Usage {
    public static void main(String[] args) {
        HockeyClub club = new HockeyClub();

        SportCommission federalSportCommission = new FederalSportCommission();
        SportCommission hockeySportCommission = new HockeySportCommission();

        club.accept(federalSportCommission);

        System.out.println();

        club.accept(hockeySportCommission);
    }
}
