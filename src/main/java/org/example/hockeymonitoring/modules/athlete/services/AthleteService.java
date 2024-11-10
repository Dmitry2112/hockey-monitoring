package org.example.hockeymonitoring.modules.athlete.services;

import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.dto.CreateAthleteDto;
import org.example.hockeymonitoring.modules.athlete.models.Athlete;
import org.example.hockeymonitoring.modules.athlete.repositories.AthleteRepository;
import org.example.hockeymonitoring.modules.teamrole.models.TeamRole;
import org.example.hockeymonitoring.modules.teamrole.services.TeamRoleService;
import org.example.hockeymonitoring.modules.trainingmethod.models.TrainingMethod;
import org.example.hockeymonitoring.modules.trainingmethod.services.TrainingMethodService;
import org.example.hockeymonitoring.modules.user.models.User;
import org.example.hockeymonitoring.modules.user.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AthleteService {
    private final AthleteRepository athleteRepository;
    private final UserService userService;
    private final TrainingMethodService trainingMethodService;
    private final TeamRoleService teamRoleService;

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public Athlete saveAthlete(CreateAthleteDto createAthleteDto) {
        User user = userService.findById(createAthleteDto.getUserId());
        TrainingMethod trainingMethod = trainingMethodService.findById(createAthleteDto.getTrainingMethodId());
        TeamRole teamRole = teamRoleService.findById(createAthleteDto.getTeamRoleId());

        Athlete athlete = createAthleteDto.getAthlete();
        athlete.setUser(user);
        athlete.setTrainingMethod(trainingMethod);
        athlete.setTeamRole(teamRole);

        return athleteRepository.save(athlete);
    }

    public Athlete findById(Long id) {
        return athleteRepository.findById(id).orElse(null);
    }

    public Athlete updateAthlete(Athlete athlete, Long userId) {
        User user = userService.findById(userId);

        athlete.setUser(user);

        return athleteRepository.save(athlete);
    }

    public void deleteAthlete(Long id) {
        athleteRepository.deleteById(id);
    }
}