package org.example.hockeymonitoring.modules.trainingmethod;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.trainingmethod.dto.CreateTrainingMethodDto;
import org.example.hockeymonitoring.shared.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/training-methods")
@AllArgsConstructor
public class TrainingMethodController {

    private final TrainingMethodService trainingMethodService;

    @GetMapping
    public Response<List<TrainingMethod>> getList() {
        List<TrainingMethod> trainingMethods = trainingMethodService.getList();
        return new Response<>(trainingMethods);
    }

    @GetMapping("/{id}")
    public Response<TrainingMethod> getOne(@PathVariable Long id) {
        TrainingMethod trainingMethod = trainingMethodService.getOne(id);
        return new Response<>(trainingMethod);
    }

    @PostMapping
    public Response<TrainingMethod> create(@RequestBody CreateTrainingMethodDto dto) {
        TrainingMethod trainingMethod = trainingMethodService.create(dto);
        return new Response<>(trainingMethod);
    }

    @PatchMapping("/{id}")
    public Response<TrainingMethod> patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        TrainingMethod trainingMethod = trainingMethodService.patch(id, patchNode);
        return new Response<>(trainingMethod);
    }

    @DeleteMapping("/{id}")
    public Response<TrainingMethod> delete(@PathVariable Long id) {
        TrainingMethod trainingMethod = trainingMethodService.delete(id);
        return new Response<>(trainingMethod);
    }
}
