package org.example.hockeymonitoring.modules.athlete.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HockeyPlayer {
    private String name;
    private String email;
    private int age;
}
