package org.example.hockeymonitoring.modules.trainingmethod;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.trainingmethod.dto.CreateTrainingMethodDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trainingmethods")
@AllArgsConstructor
public class TrainingMethodController {

    private final TrainingMethodService trainingMethodService;

    @GetMapping
    public List<TrainingMethod> getList() {
        return trainingMethodService.getList();
    }

    @GetMapping("/{id}")
    public TrainingMethod getOne(@PathVariable Long id) {
        return trainingMethodService.getOne(id);
    }

    @PostMapping
    public TrainingMethod create(@RequestBody CreateTrainingMethodDto dto) {
        return trainingMethodService.create(dto);
    }

    @PatchMapping("/{id}")
    public TrainingMethod patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return trainingMethodService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public TrainingMethod delete(@PathVariable Long id) {
        return trainingMethodService.delete(id);
    }
}
