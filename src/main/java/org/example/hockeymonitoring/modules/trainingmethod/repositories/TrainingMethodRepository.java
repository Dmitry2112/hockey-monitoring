package org.example.hockeymonitoring.modules.trainingmethod.repositories;

import org.example.hockeymonitoring.modules.trainingmethod.models.TrainingMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingMethodRepository extends JpaRepository<TrainingMethod, Long> { }
