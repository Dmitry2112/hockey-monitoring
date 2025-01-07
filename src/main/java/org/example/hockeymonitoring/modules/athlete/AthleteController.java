package org.example.hockeymonitoring.modules.athlete;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.dto.CreateAthleteDto;
import org.example.hockeymonitoring.shared.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/athletes")
@AllArgsConstructor
public class AthleteController {

    private final AthleteService athleteService;

    @GetMapping
    public Response<List<Athlete>> getList() {
        List<Athlete> athletes = athleteService.getList();
        return new Response<>(athletes);
    }

    @GetMapping("/{id}")
    public Response<Athlete> getOne(@PathVariable Long id) {
        Athlete athlete = athleteService.getOne(id);
        return new Response<>(athlete);
    }

    @PostMapping
    public Response<Athlete> create(@RequestBody CreateAthleteDto dto) {
        Athlete athlete = athleteService.create(dto);
        return new Response<>(athlete);
    }

    @PatchMapping("/{id}")
    public Response<Athlete> patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Athlete athlete = athleteService.patch(id, patchNode);
        return new Response<>(athlete);
    }

    @DeleteMapping("/{id}")
    public Response<Athlete> delete(@PathVariable Long id) {
        Athlete athlete = athleteService.delete(id);
        return new Response<>(athlete);
    }
}
