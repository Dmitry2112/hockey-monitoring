package org.example.hockeymonitoring.modules.user.repositories;

import org.example.hockeymonitoring.modules.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
