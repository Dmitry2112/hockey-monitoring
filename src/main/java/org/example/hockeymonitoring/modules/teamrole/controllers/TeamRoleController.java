package org.example.hockeymonitoring.modules.teamrole.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.teamrole.models.TeamRole;
import org.example.hockeymonitoring.modules.teamrole.services.TeamRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teamroles")
@AllArgsConstructor
public class TeamRoleController {
    private final TeamRoleService teamRoleService;

    @GetMapping
    public List<TeamRole> getTeamRoles() {
        return teamRoleService.getAllTeamRoles();
    }

    @PostMapping("save_teamrole")
    public TeamRole saveTeamRole(@RequestBody TeamRole teamRole) {
        return teamRoleService.saveTeamRole(teamRole);
    }

    @GetMapping("/{id}")
    public TeamRole findById(@PathVariable Long id) {
        return teamRoleService.findById(id);
    }

    @PutMapping("update_teamrole")
    public TeamRole updateTeamRole(@RequestBody TeamRole teamRole) {
        return teamRoleService.updateTeamRole(teamRole);
    }

    @DeleteMapping("delete_teamrole/{id}")
    @Transactional
    public void deleteTeamRole(@PathVariable Long id) {
        teamRoleService.deleteTeamRole(id);
    }
}
