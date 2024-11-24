package org.example.hockeymonitoring.modules.teamrole;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamRoleService {

    private final TeamRoleRepository teamRoleRepository;

    private final ObjectMapper objectMapper;

    public List<TeamRole> getList() {
        return teamRoleRepository.findAll();
    }

    public TeamRole getOne(Long id) {
        Optional<TeamRole> teamRoleOptional = teamRoleRepository.findById(id);
        return teamRoleOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public TeamRole create(TeamRole teamRole) {
        return teamRoleRepository.save(teamRole);
    }

    public TeamRole patch(Long id, JsonNode patchNode) throws IOException {
        TeamRole teamRole = teamRoleRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(teamRole).readValue(patchNode);

        return teamRoleRepository.save(teamRole);
    }

    public TeamRole delete(Long id) {
        TeamRole teamRole = teamRoleRepository.findById(id).orElse(null);
        if (teamRole != null) {
            teamRoleRepository.delete(teamRole);
        }
        return teamRole;
    }
}
