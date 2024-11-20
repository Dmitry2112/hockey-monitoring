package org.example.hockeymonitoring.modules.team;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public List<Team> getList() {
        return teamService.getList();
    }

    @GetMapping("/{id}")
    public Team getOne(@PathVariable Long id) {
        return teamService.getOne(id);
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        return teamService.create(team);
    }

    @PatchMapping("/{id}")
    public Team patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return teamService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public Team delete(@PathVariable Long id) {
        return teamService.delete(id);
    }
}
