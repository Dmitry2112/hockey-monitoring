package org.example.hockeymonitoring.modules.match;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.match.dto.CreateMatchDto;
import org.example.hockeymonitoring.shared.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public Response<List<Match>> getList() {
        List<Match> matches = matchService.getList();
        return new Response<>(matches);
    }

    @GetMapping("/{id}")
    public Response<Match> getOne(@PathVariable Long id) {
        Match match = matchService.getOne(id);
        return new Response<>(match);
    }

    @PostMapping
    public Response<Match> create(@RequestBody CreateMatchDto dto) {
        Match match = matchService.create(dto);
        return new Response<>(match);
    }

    @PatchMapping("/{id}")
    public Response<Match> patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Match match = matchService.patch(id, patchNode);
        return new Response<>(match);
    }

    @DeleteMapping("/{id}")
    public Response<Match> delete(@PathVariable Long id) {
        Match match = matchService.delete(id);
        return new Response<>(match);
    }
}
