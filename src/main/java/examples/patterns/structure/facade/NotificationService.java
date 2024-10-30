package examples.patterns.structure.facade;

public class NotificationService {
    public void notifySuccess(HockeyPlayer player) {
        System.out.printf("Игрок: '%s' успешно зарегистрирован", player.getName());
    }

    public void notifyFailed(HockeyPlayer player, Exception e) {
        System.out.printf("При регистрации игрока '%s' произошла ошибка", player.getName());
    }
}
