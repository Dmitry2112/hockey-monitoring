package org.example.hockeymonitoring.modules.tournament;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.tournament.dto.CreateTournamentDto;
import org.example.hockeymonitoring.shared.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tournaments")
@RequiredArgsConstructor
public class TournamentController {

    private final TournamentService tournamentService;

    @GetMapping
    public Response<List<Tournament>> getList() {
        List<Tournament> tournaments = tournamentService.getList();
        return new Response<>(tournaments);
    }

    @GetMapping("/{id}")
    public Response<Tournament> getOne(@PathVariable Long id) {
        Tournament tournament = tournamentService.getOne(id);
        return new Response<>(tournament);
    }

    @PostMapping
    public Response<Tournament> create(@RequestBody CreateTournamentDto dto) {
        Tournament tournament = tournamentService.create(dto);
        return new Response<>(tournament);
    }

    @PatchMapping("/{id}")
    public Response<Tournament> patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Tournament tournament = tournamentService.patch(id, patchNode);
        return new Response<>(tournament);
    }

    @DeleteMapping("/{id}")
    public Response<Tournament> delete(@PathVariable Long id) {
        Tournament tournament = tournamentService.delete(id);
        return new Response<>(tournament);
    }
}
