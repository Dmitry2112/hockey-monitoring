package org.example.hockeymonitoring.modules.match;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.match.dto.CreateMatchDto;
import org.example.hockeymonitoring.modules.matchtype.MatchType;
import org.example.hockeymonitoring.modules.matchtype.MatchTypeService;
import org.example.hockeymonitoring.modules.team.Team;
import org.example.hockeymonitoring.modules.team.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MatchService {

    private final MatchRepository matchRepository;

    private final ObjectMapper objectMapper;

    private final TeamService teamService;
    private final MatchTypeService matchTypeService;

    public List<Match> getList() {
        return matchRepository.findAll();
    }

    public Match getOne(Long id) {
        Optional<Match> matchOptional = matchRepository.findById(id);
        return matchOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public Match create(CreateMatchDto dto) {
        Team firstTeam = teamService.getOne(dto.getFirstTeamId());
        Team secondTeam = teamService.getOne(dto.getSecondTeamId());
        MatchType type = matchTypeService.getOne(dto.getTypeId());

        Match match = new Match();

        match.setFirstTeam(firstTeam);
        match.setSecondTeam(secondTeam);
        match.setType(type);

        return matchRepository.save(match);
    }

    public Match patch(Long id, JsonNode patchNode) throws IOException {
        //TODO: Написать логику обновления матча, если потребуется

        Match match = matchRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(match).readValue(patchNode);

        return matchRepository.save(match);
    }

    public Match delete(Long id) {
        Match match = matchRepository.findById(id).orElse(null);
        if (match != null) {
            matchRepository.delete(match);
        }
        return match;
    }
}
