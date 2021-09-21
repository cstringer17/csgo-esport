package com.callumstringer.csgoesport.core.match;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<Match,Long> {
}
