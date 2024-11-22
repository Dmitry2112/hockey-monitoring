package org.example.hockeymonitoring.modules.matchtype;

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
public class MatchTypeService {

    private final MatchTypeRepository matchTypeRepository;

    private final ObjectMapper objectMapper;

    public List<MatchType> getList() {
        return matchTypeRepository.findAll();
    }

    public MatchType getOne(Long id) {
        Optional<MatchType> matchTypeOptional = matchTypeRepository.findById(id);
        return matchTypeOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public MatchType create(MatchType matchType) {
        return matchTypeRepository.save(matchType);
    }

    public MatchType patch(Long id, JsonNode patchNode) throws IOException {
        MatchType matchType = matchTypeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(matchType).readValue(patchNode);

        return matchTypeRepository.save(matchType);
    }

    public MatchType delete(Long id) {
        MatchType matchType = matchTypeRepository.findById(id).orElse(null);
        if (matchType != null) {
            matchTypeRepository.delete(matchType);
        }
        return matchType;
    }
}
