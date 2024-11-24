package org.example.hockeymonitoring.modules.tournamenttype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TournamentTypeRepository extends JpaRepository<TournamentType, Long>, JpaSpecificationExecutor<TournamentType> { }
