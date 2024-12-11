package examples.patterns.behavior.visitor;

public class HockeySportCommission implements SportCommission {
    @Override
    public void inspect(HockeyPlayer player) {
        System.out.println("Хоккейная спортивная коммисия проверяет, что игрок является хоккеистом");
    }

    @Override
    public void inspect(Judge judge) {
        System.out.println("Хоккейная спортивная коммисия проверяет, что судья знает правила хоккея");
    }

    @Override
    public void inspect(Trainer trainer) {
        System.out.println("Хоккейная спортивная коммисия проверяет, что тренер знает, как учить играть в хоккей");
    }
}
