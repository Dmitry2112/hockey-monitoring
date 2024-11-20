package org.example.hockeymonitoring.modules.team;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    private final ObjectMapper objectMapper;

    public List<Team> getList() {
        return teamRepository.findAll();
    }

    public Team getOne(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        return teamOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public Team create(Team team) {
        return teamRepository.save(team);
    }

    public Team patch(Long id, JsonNode patchNode) throws IOException {
        Team team = teamRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(team).readValue(patchNode);

        return teamRepository.save(team);
    }

    public Team delete(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        if (team != null) {
            teamRepository.delete(team);
        }
        return team;
    }
}
