package org.example.hockeymonitoring.hockeyplayer.services;

import org.example.hockeymonitoring.hockeyplayer.models.HockeyPlayer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Паттерн Singleton
 */
@Service
public class HockeyPlayerService {
    private HockeyPlayerService() {}

    private static final HockeyPlayerService INSTANCE = new HockeyPlayerService();

    public static HockeyPlayerService getInstance() {
        return INSTANCE;
    }

    public List<HockeyPlayer> getAllHockeyPlayers() {
        return List.of(
                HockeyPlayer.builder().name("Dima").email("test1@mail.com").age(21).build(),
                HockeyPlayer.builder().name("Andrey").email("test2@mail.com").age(20).build(),
                HockeyPlayer.builder().name("Alexey").email("test3@mail.com").age(25).build()
        );
    }
}