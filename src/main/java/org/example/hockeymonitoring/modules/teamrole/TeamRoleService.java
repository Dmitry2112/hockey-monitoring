package org.example.hockeymonitoring.modules.teamrole;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamRoleService {
    private final TeamRoleRepository teamRoleRepository;

    public List<TeamRole> getAllTeamRoles() {
        return teamRoleRepository.findAll();
    }

    public TeamRole saveTeamRole(TeamRole teamRole) {
        return teamRoleRepository.save(teamRole);
    }

    public TeamRole findById(Long id) {
        return teamRoleRepository.findById(id).orElse(null);
    }

    public TeamRole updateTeamRole(TeamRole teamRole) {
        return teamRoleRepository.save(teamRole);
    }

    public void deleteTeamRole(Long id) {
        teamRoleRepository.deleteById(id);
    }
}
