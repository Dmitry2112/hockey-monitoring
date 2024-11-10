package org.example.hockeymonitoring.modules.trainingmethod.services;

import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.trainingmethod.dto.CreateTrainingMethodDto;
import org.example.hockeymonitoring.modules.trainingmethod.models.TrainingMethod;
import org.example.hockeymonitoring.modules.trainingmethod.repositories.TrainingMethodRepository;
import org.example.hockeymonitoring.modules.user.models.User;
import org.example.hockeymonitoring.modules.user.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingMethodService {
    private final TrainingMethodRepository trainingMethodRepository;
    private final UserService userService;

    public List<TrainingMethod> getAllTrainingMethods() {
        return trainingMethodRepository.findAll();
    }

    public TrainingMethod saveTrainingMethod(CreateTrainingMethodDto createTrainingMethodDto) {
        //TODO: реализовать загрузку файла

        User user = userService.findById(createTrainingMethodDto.getUserId());
        TrainingMethod trainingMethod = new TrainingMethod();
        trainingMethod.setTrainer(user);

        return trainingMethodRepository.save(trainingMethod);
    }

    public TrainingMethod findById(Long id) {
        return trainingMethodRepository.findById(id).orElse(null);
    }

    public TrainingMethod updateTrainingMethod(TrainingMethod trainingMethod) {
        return trainingMethodRepository.save(trainingMethod);
    }

    public void deleteTrainingMethod(Long id) {
        trainingMethodRepository.deleteById(id);
    }
}
