package org.example.hockeymonitoring.modules.athlete.services;

import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.models.Athlete;
import org.example.hockeymonitoring.modules.athlete.repositories.AthleteRepository;
import org.example.hockeymonitoring.modules.user.models.User;
import org.example.hockeymonitoring.modules.user.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AthleteService {
    private final AthleteRepository athleteRepository;
    private final UserService userService;

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public Athlete saveAthlete(Athlete athlete, Long userId) {
        User user = userService.findById(userId);

        athlete.setUser(user);

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