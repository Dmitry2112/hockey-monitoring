package examples.patterns.behavior.mediator;

public class Usage {
    public static void main(String[] args) {
        SuperTeam team = new SuperTeam();

        TeamMember teamCaptain = new TeamCaptain(team, "Дмитрий");
        TeamMember striker = new HockeyPlayer(team, "Иван");
        TeamMember goalkeeper = new HockeyPlayer(team, "Петр");

        team.setTeamCaptain(teamCaptain);
        team.addPlayer(striker);
        team.addPlayer(goalkeeper);

        striker.sendMessage("Смотрите! Я забил гол!");
        goalkeeper.sendMessage("А я не пропустил в наши ворота ни одной шайбы!");
        teamCaptain.sendMessage("Отличная игра! Мы молодцы!");
    }
}
