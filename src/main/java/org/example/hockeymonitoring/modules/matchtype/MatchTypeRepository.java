package org.example.hockeymonitoring.modules.matchtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MatchTypeRepository extends JpaRepository<MatchType, Long>, JpaSpecificationExecutor<MatchType> { }