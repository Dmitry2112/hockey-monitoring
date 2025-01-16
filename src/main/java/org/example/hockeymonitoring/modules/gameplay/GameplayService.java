package org.example.hockeymonitoring.modules.gameplay;

import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.Athlete;
import org.example.hockeymonitoring.modules.athlete.AthleteService;
import org.example.hockeymonitoring.modules.gameplay.dto.CreateMatchesDto;
import org.example.hockeymonitoring.modules.match.Match;
import org.example.hockeymonitoring.modules.match.MatchService;
import org.example.hockeymonitoring.modules.match.dto.CreateMatchDto;
import org.example.hockeymonitoring.modules.team.Team;
import org.example.hockeymonitoring.modules.team.TeamService;
import org.example.hockeymonitoring.modules.team.dto.AddAthletesDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GameplayService {
    private final AthleteService athleteService;

    private final TeamService teamService;

    private final MatchService matchService;

    public List<Match> createMatches(CreateMatchesDto dto) {
        int playerCount = 2; // Количество игроков в команде, будет рассчитываться из типа матча
        String gender = "male"; // Пол игроков в матче, будет рассчитываться из пола турнира

        List<Athlete> athletes = athleteService
                .getList()
                .stream()
                .sorted(Comparator.comparing(Athlete::getRating))
                .toList();

        int teamCount = athletes.size() / playerCount;

        List<Team> teams = new ArrayList<>(teamCount);

        for (int i = 0; i < athletes.size(); i += 2) {
            Team team = new Team();
            team.setGender(gender);
            Team createdTeam = teamService.create(team);

            AddAthletesDto addAthletesDto = new AddAthletesDto(List.of(athletes.get(i).getId(), athletes.get(i + 1).getId()));
            teams.add(teamService.addAthletes(createdTeam.getId(), addAthletesDto));
        }

        int matchCount = teams.size() / 2;

        List<Match> matches = new ArrayList<>(matchCount);

        for (int i = 0; i < teamCount; i += 2) {
            CreateMatchDto createMatchDto = new CreateMatchDto(
                    dto.getTournamentId(),
                    teams.get(i).getId(),
                    teams.get(i + 1).getId(),
                    0,
                    0,
                    dto.getType(),
                    dto.getGender(),
                    dto.getStatus(),
                    dto.getStartDate(),
                    dto.getEndDate()
            );

            matches.add(matchService.create(createMatchDto));
        }

        return matches;
    }
}
