package org.example.hockeymonitoring.modules.team;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.team.dto.AddAthletesDto;
import org.example.hockeymonitoring.shared.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public Response<List<Team>> getList() {
        List<Team> teams = teamService.getList();
        return new Response<>(teams);
    }

    @GetMapping("/{id}")
    public Response<Team> getOne(@PathVariable Long id) {
        Team team = teamService.getOne(id);
        return new Response<>(team);
    }

    @PostMapping
    public Response<Team> create(@RequestBody Team team) {
        Team createdTeam = teamService.create(team);
        return new Response<>(createdTeam);
    }

    @PatchMapping("/{id}")
    public Response<Team> patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Team team = teamService.patch(id, patchNode);
        return new Response<>(team);
    }

    @DeleteMapping("/{id}")
    public Response<Team> delete(@PathVariable Long id) {
        Team team = teamService.delete(id);
        return new Response<>(team);
    }

    @PatchMapping("/{id}/add-athletes")
    public Response<Team> addAthletes(@PathVariable Long id, @RequestBody AddAthletesDto dto) {
        Team team = teamService.addAthletes(id, dto);
        return new Response<>(team);
    }
}
