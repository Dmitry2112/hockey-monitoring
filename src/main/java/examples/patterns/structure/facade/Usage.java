package examples.patterns.structure.facade;

public class Usage {
    public static void main(String[] args) {
        StatusService statusService = new StatusService();
        HockeyTeamService hockeyTeamService = new HockeyTeamService();
        NotificationService notificationService = new NotificationService();

        RegisterService registerService = new RegisterService(statusService, hockeyTeamService, notificationService);

        HockeyPlayer hockeyPlayer = new HockeyPlayer("Дмитрий");

        registerService.registerOnGame(hockeyPlayer);
    }
}
