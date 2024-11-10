package org.example.hockeymonitoring.modules.trainingmethod.models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.hockeymonitoring.modules.user.models.User;

@Data
@Entity
@Table(name = "training_methods")
public class TrainingMethod {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private User trainer;
}
