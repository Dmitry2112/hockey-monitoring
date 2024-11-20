package org.example.hockeymonitoring.modules.trainingmethod;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.trainingmethod.dto.CreateTrainingMethodDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainingmethods")
@AllArgsConstructor
public class TrainingMethodController {
    private final TrainingMethodService trainingMethodService;

    @GetMapping
    public List<TrainingMethod> getTrainingMethods() {
        return trainingMethodService.getAllTrainingMethods();
    }

    @PostMapping("save_trainingmethod")
    public TrainingMethod saveTrainingMethod(@RequestBody CreateTrainingMethodDto createTrainingMethodDto) {
        return trainingMethodService.saveTrainingMethod(createTrainingMethodDto);
    }

    @GetMapping("/{id}")
    public TrainingMethod findById(@PathVariable Long id) {
        return trainingMethodService.findById(id);
    }

    @PutMapping("update_trainingmethod")
    public TrainingMethod updateTrainingMethod(@RequestBody TrainingMethod trainingMethod) {
        return trainingMethodService.updateTrainingMethod(trainingMethod);
    }

    @DeleteMapping("delete_trainingmethod/{id}")
    @Transactional
    public void deleteTrainingMethod(@PathVariable Long id) {
        trainingMethodService.deleteTrainingMethod(id);
    }
}
