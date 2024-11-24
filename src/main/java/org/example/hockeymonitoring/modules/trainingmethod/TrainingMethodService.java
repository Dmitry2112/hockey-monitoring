package org.example.hockeymonitoring.modules.trainingmethod;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.trainingmethod.dto.CreateTrainingMethodDto;
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
public class TrainingMethodService {

    private final TrainingMethodRepository trainingMethodRepository;

    private final ObjectMapper objectMapper;

    private final UserService userService;

    public List<TrainingMethod> getList() {
        return trainingMethodRepository.findAll();
    }

    public TrainingMethod getOne(Long id) {
        Optional<TrainingMethod> trainingMethodOptional = trainingMethodRepository.findById(id);
        return trainingMethodOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public TrainingMethod create(CreateTrainingMethodDto dto) {
        //TODO: реализовать загрузку файла

        User user = userService.getOne(dto.getUserId());

        TrainingMethod trainingMethod = new TrainingMethod();

        trainingMethod.setTrainer(user);

        return trainingMethodRepository.save(trainingMethod);
    }

    public TrainingMethod patch(Long id, JsonNode patchNode) throws IOException {
        TrainingMethod trainingMethod = trainingMethodRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(trainingMethod).readValue(patchNode);

        return trainingMethodRepository.save(trainingMethod);
    }

    public TrainingMethod delete(Long id) {
        TrainingMethod trainingMethod = trainingMethodRepository.findById(id).orElse(null);
        if (trainingMethod != null) {
            trainingMethodRepository.delete(trainingMethod);
        }
        return trainingMethod;
    }
}
