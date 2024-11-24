package org.example.hockeymonitoring.modules.teamrole;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teamroles")
@AllArgsConstructor
public class TeamRoleController {

    private final TeamRoleService teamRoleService;

    @GetMapping
    public List<TeamRole> getList() {
        return teamRoleService.getList();
    }

    @GetMapping("/{id}")
    public TeamRole getOne(@PathVariable Long id) {
        return teamRoleService.getOne(id);
    }

    @PostMapping
    public TeamRole create(@RequestBody TeamRole teamRole) {
        return teamRoleService.create(teamRole);
    }

    @PatchMapping("/{id}")
    public TeamRole patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return teamRoleService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public TeamRole delete(@PathVariable Long id) {
        return teamRoleService.delete(id);
    }
}
