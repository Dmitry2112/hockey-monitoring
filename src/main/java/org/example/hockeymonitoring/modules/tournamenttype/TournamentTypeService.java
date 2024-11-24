package org.example.hockeymonitoring.modules.tournamenttype;

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
public class TournamentTypeService {

    private final TournamentTypeRepository tournamentTypeRepository;

    private final ObjectMapper objectMapper;

    public List<TournamentType> getList() {
        return tournamentTypeRepository.findAll();
    }

    public TournamentType getOne(Long id) {
        Optional<TournamentType> tournamentTypeOptional = tournamentTypeRepository.findById(id);
        return tournamentTypeOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public TournamentType create(TournamentType tournamentType) {
        return tournamentTypeRepository.save(tournamentType);
    }

    public TournamentType patch(Long id, JsonNode patchNode) throws IOException {
        TournamentType tournamentType = tournamentTypeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(tournamentType).readValue(patchNode);

        return tournamentTypeRepository.save(tournamentType);
    }

    public TournamentType delete(Long id) {
        TournamentType tournamentType = tournamentTypeRepository.findById(id).orElse(null);
        if (tournamentType != null) {
            tournamentTypeRepository.delete(tournamentType);
        }
        return tournamentType;
    }
}
