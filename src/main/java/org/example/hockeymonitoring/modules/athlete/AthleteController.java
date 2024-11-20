package org.example.hockeymonitoring.modules.athlete;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.dto.CreateAthleteDto;
import org.example.hockeymonitoring.modules.athlete.dto.UpdateAthleteDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/athletes")
@AllArgsConstructor
public class AthleteController {
    private final AthleteService athleteService;

    @GetMapping
    public List<Athlete> getAthletes() {
        return athleteService.getAllAthletes();
    }

    @PostMapping("save_athlete")
    public Athlete saveAthlete(@RequestBody CreateAthleteDto createAthleteDto) {
        return athleteService.saveAthlete(createAthleteDto);
    }

    @GetMapping("/{id}")
    public Athlete findById(@PathVariable Long id) {
        return athleteService.findById(id);
    }

    @PutMapping("update_athlete")
    public Athlete updateAthlete(@RequestBody UpdateAthleteDto updateAthleteDto) {
        return athleteService.updateAthlete(updateAthleteDto.getAthlete(), updateAthleteDto.getUserId());
    }

    @DeleteMapping("delete_athlete/{id}")
    @Transactional
    public void deleteAthlete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
    }
}
