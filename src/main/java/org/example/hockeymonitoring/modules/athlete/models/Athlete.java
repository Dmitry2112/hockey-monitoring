package org.example.hockeymonitoring.modules.athlete.models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.hockeymonitoring.modules.trainingmethod.models.TrainingMethod;
import org.example.hockeymonitoring.modules.user.models.User;

@Data
@Entity
@Table(name = "athletes")
public class Athlete {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "training_method_id")
    private TrainingMethod trainingMethod;

    private int rating;
    private String gender;
    private int positionNumber;
}
