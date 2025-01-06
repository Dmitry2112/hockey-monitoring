package org.example.hockeymonitoring.modules.athlete;

import jakarta.persistence.*;
import lombok.Data;
import org.example.hockeymonitoring.modules.category.Category;
import org.example.hockeymonitoring.modules.trainingmethod.TrainingMethod;
import org.example.hockeymonitoring.modules.user.User;

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

    @Enumerated(EnumType.STRING)
    private TeamRole teamRole;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private int rating;
    private String gender;
    private int positionNumber;
}
