package org.example.hockeymonitoring.modules.match;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.match.dto.CreateMatchDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public List<Match> getList() {
        return matchService.getList();
    }

    @GetMapping("/{id}")
    public Match getOne(@PathVariable Long id) {
        return matchService.getOne(id);
    }

    @PostMapping
    public Match create(@RequestBody CreateMatchDto dto) {
        return matchService.create(dto);
    }

    @PatchMapping("/{id}")
    public Match patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return matchService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public Match delete(@PathVariable Long id) {
        return matchService.delete(id);
    }
}
