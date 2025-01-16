package org.example.hockeymonitoring.modules.gameplay;

import lombok.RequiredArgsConstructor;
import org.example.hockeymonitoring.modules.gameplay.dto.CreateMatchesDto;
import org.example.hockeymonitoring.modules.match.Match;
import org.example.hockeymonitoring.modules.team.Team;
import org.example.hockeymonitoring.shared.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gameplay")
@RequiredArgsConstructor
public class GameplayController {
    private final GameplayService gameplayService;

    @PostMapping("/create-matches")
    public Response<List<Match>> create(@RequestBody CreateMatchesDto dto) {
        List<Match> matches = gameplayService.createMatches(dto);
        return new Response<>(matches);
    }
}
