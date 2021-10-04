package edu.kea.adventure_project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Christian og Joachim
 */
@Data
@Table(name = "activities")
@Entity
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activityID")
    private Long activityID;
    @Column
    private String activityName;
    @Column
    private int ageLimit;
    @Column
    private int heightLimit;
    @Column
    private int timeLimit;
    @Column
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
    private List<Booking> bookings;

    public Activity(Long activityID, String activityName, int ageLimit, int heightLimit, int timeLimit, String description) {
        this.activityID = activityID;
        this.activityName = activityName;
        this.ageLimit = ageLimit;
        this.heightLimit = heightLimit;
        this.timeLimit = timeLimit;
        this.description = description;
    }
}
