package org.example.hockeymonitoring.modules.tournament;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.tournament.dto.CreateTournamentDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tournaments")
@RequiredArgsConstructor
public class TournamentController {

    private final TournamentService tournamentService;

    @GetMapping
    public List<Tournament> getList() {
        return tournamentService.getList();
    }

    @GetMapping("/{id}")
    public Tournament getOne(@PathVariable Long id) {
        return tournamentService.getOne(id);
    }

    @PostMapping
    public Tournament create(@RequestBody CreateTournamentDto dto) {
        return tournamentService.create(dto);
    }

    @PatchMapping("/{id}")
    public Tournament patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return tournamentService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public Tournament delete(@PathVariable Long id) {
        return tournamentService.delete(id);
    }
}
