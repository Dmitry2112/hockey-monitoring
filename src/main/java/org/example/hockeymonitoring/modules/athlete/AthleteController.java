package org.example.hockeymonitoring.modules.athlete;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.dto.CreateAthleteDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/athletes")
@AllArgsConstructor
public class AthleteController {

    private final AthleteService athleteService;

    @GetMapping
    public List<Athlete> getList() {
        return athleteService.getList();
    }

    @GetMapping("/{id}")
    public Athlete getOne(@PathVariable Long id) {
        return athleteService.getOne(id);
    }

    @PostMapping
    public Athlete create(@RequestBody CreateAthleteDto dto) {
        return athleteService.create(dto);
    }

    @PatchMapping("/{id}")
    public Athlete patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return athleteService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public Athlete delete(@PathVariable Long id) {
        return athleteService.delete(id);
    }
}
