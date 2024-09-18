package org.example.hockeymonitoring.hockeyplayer.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HockeyPlayer {
    private String name;
    private String email;
    private int age;
}
