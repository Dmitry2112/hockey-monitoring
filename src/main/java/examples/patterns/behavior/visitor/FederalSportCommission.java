package examples.patterns.behavior.visitor;

public class FederalSportCommission implements SportCommission {
    @Override
    public void inspect(HockeyPlayer player) {
        System.out.println("Федеральная спортивная коммисия проверяет, что игрок является спортсменом");
    }

    @Override
    public void inspect(Judge judge) {
        System.out.println("Федеральная спортивная коммисия проверяет, что судья является спортивным судьей");
    }

    @Override
    public void inspect(Trainer trainer) {
        System.out.println("Федеральная спортивная коммисия проверяет, что тренер является спортивным тренером");
    }
}
