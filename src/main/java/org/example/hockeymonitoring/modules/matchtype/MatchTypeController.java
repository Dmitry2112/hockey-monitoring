package org.example.hockeymonitoring.modules.matchtype;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/match-types")
@RequiredArgsConstructor
public class MatchTypeController {

    private final MatchTypeService matchTypeService;

    @GetMapping
    public List<MatchType> getList() {
        return matchTypeService.getList();
    }

    @GetMapping("/{id}")
    public MatchType getOne(@PathVariable Long id) {
        return matchTypeService.getOne(id);
    }

    @PostMapping
    public MatchType create(@RequestBody MatchType matchType) {
        return matchTypeService.create(matchType);
    }

    @PatchMapping("/{id}")
    public MatchType patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return matchTypeService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public MatchType delete(@PathVariable Long id) {
        return matchTypeService.delete(id);
    }
}
