package org.example.hockeymonitoring.hockeyplayer.models;

import lombok.Getter;

/**
 * Паттерн Static factory method
 */
@Getter
public class HockeyMatch {
    private final String title;
    private final String description;
    private final String specificRules;

    private HockeyMatch(String title, String description, String specificRules) {
        this.title = title;
        this.description = description;
        this.specificRules = specificRules;
    }

    public static HockeyMatch basic(String title, String description) {
        return new HockeyMatch(title, description, null);
    }

    public static HockeyMatch specific(String title, String description, String specificRules) {
        return new HockeyMatch(title, description, specificRules);
    }
}
