package examples.patterns.structure.facade;

/**
 * Паттерн Facade
 */
public class RegisterService {
    private final StatusService statusService;
    private final HockeyTeamService hockeyTeamService;
    private final NotificationService notificationService;

    public RegisterService(
            StatusService statusService,
            HockeyTeamService hockeyTeamService,
            NotificationService notificationService
    ) {
        this.statusService = statusService;
        this.hockeyTeamService = hockeyTeamService;
        this.notificationService = notificationService;
    }

    public void registerOnGame(HockeyPlayer player) {
        try {
            boolean registered = statusService.checkStatus(player);
            if (registered) {
                System.out.printf("Игрок '%s' уже зарегистрирован", player.getName());
            } else {
                boolean teamExist = hockeyTeamService.checkTeam(player);
                if (!teamExist) {
                    player.changeTeamIsExist(true);
                }
                player.changeIsRegister(true);
                notificationService.notifySuccess(player);
            }
        } catch (Exception e) {
            notificationService.notifyFailed(player, e);
        }
    }
}
