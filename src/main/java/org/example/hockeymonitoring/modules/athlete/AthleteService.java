package org.example.hockeymonitoring.modules.athlete;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.dto.CreateAthleteDto;
import org.example.hockeymonitoring.modules.category.Category;
import org.example.hockeymonitoring.modules.category.CategoryService;
import org.example.hockeymonitoring.modules.teamrole.TeamRole;
import org.example.hockeymonitoring.modules.teamrole.TeamRoleService;
import org.example.hockeymonitoring.modules.trainingmethod.TrainingMethod;
import org.example.hockeymonitoring.modules.trainingmethod.TrainingMethodService;
import org.example.hockeymonitoring.modules.user.User;
import org.example.hockeymonitoring.modules.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AthleteService {

    private final AthleteRepository athleteRepository;

    private final ObjectMapper objectMapper;

    private final UserService userService;
    private final TrainingMethodService trainingMethodService;
    private final TeamRoleService teamRoleService;
    private final CategoryService categoryService;

    public List<Athlete> getList() {
        return athleteRepository.findAll();
    }

    public Athlete getOne(Long id) {
        Optional<Athlete> athleteOptional = athleteRepository.findById(id);
        return athleteOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public Athlete create(CreateAthleteDto dto) {
        User user = userService.findById(dto.getUserId());
        TrainingMethod trainingMethod = trainingMethodService.findById(dto.getTrainingMethodId());
        TeamRole teamRole = teamRoleService.findById(dto.getTeamRoleId());
        Category category = categoryService.getOne(dto.getCategoryId());

        Athlete athlete = new Athlete();

        athlete.setUser(user);
        athlete.setTrainingMethod(trainingMethod);
        athlete.setTeamRole(teamRole);
        athlete.setCategory(category);
        athlete.setRating(dto.getRating());
        athlete.setGender(dto.getGender());
        athlete.setPositionNumber(dto.getPositionNumber());

        return athleteRepository.save(athlete);
    }

    public Athlete patch(Long id, JsonNode patchNode) throws IOException {
        Athlete athlete = athleteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(athlete).readValue(patchNode);

        return athleteRepository.save(athlete);
    }

    public Athlete delete(Long id) {
        Athlete athlete = athleteRepository.findById(id).orElse(null);
        if (athlete != null) {
            athleteRepository.delete(athlete);
        }
        return athlete;
    }
}