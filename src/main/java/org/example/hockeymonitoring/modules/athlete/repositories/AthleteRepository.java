package org.example.hockeymonitoring.modules.athlete.repositories;

import org.example.hockeymonitoring.modules.athlete.models.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> { }
