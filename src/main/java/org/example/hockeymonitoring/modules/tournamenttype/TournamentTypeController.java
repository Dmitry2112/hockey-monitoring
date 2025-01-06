package org.example.hockeymonitoring.modules.tournamenttype;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tournament-types")
@RequiredArgsConstructor
public class TournamentTypeController {

    private final TournamentTypeService tournamentTypeService;

    @GetMapping
    public List<TournamentType> getList() {
        return tournamentTypeService.getList();
    }

    @GetMapping("/{id}")
    public TournamentType getOne(@PathVariable Long id) {
        return tournamentTypeService.getOne(id);
    }

    @PostMapping
    public TournamentType create(@RequestBody TournamentType tournamentType) {
        return tournamentTypeService.create(tournamentType);
    }

    @PatchMapping("/{id}")
    public TournamentType patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return tournamentTypeService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public TournamentType delete(@PathVariable Long id) {
        return tournamentTypeService.delete(id);
    }
}
