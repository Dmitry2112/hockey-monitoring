package org.example.hockeymonitoring.modules.tournament;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.tournament.dto.CreateTournamentDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    private final ObjectMapper objectMapper;

    public List<Tournament> getList() {
        return tournamentRepository.findAll();
    }

    public Tournament getOne(Long id) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);
        return tournamentOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public Tournament create(CreateTournamentDto dto) {
        Tournament tournament = new Tournament();

        tournament.setDate(dto.getDate());
        tournament.setType(dto.getType());
        tournament.setGender(dto.getGender());
        tournament.setStatus(dto.getStatus());
        tournament.setStartDate(dto.getStartDate());
        tournament.setEndDate(dto.getEndDate());

        return tournamentRepository.save(tournament);
    }

    public Tournament patch(Long id, JsonNode patchNode) throws IOException {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(tournament).readValue(patchNode);

        return tournamentRepository.save(tournament);
    }

    public Tournament delete(Long id) {
        Tournament tournament = tournamentRepository.findById(id).orElse(null);
        if (tournament != null) {
            tournamentRepository.delete(tournament);
        }
        return tournament;
    }
}
