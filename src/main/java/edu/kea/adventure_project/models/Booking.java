package edu.kea.adventure_project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Julius Panduro
 */
@Data
@NoArgsConstructor
@Table(name = "bookings")
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;

    @Column
    private String employeeName;

    @Column
    private String customerName;

    @Column
    private int customerTelephone;

    @Column
    private String startDate;

    @Column
    private String timeStart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activityID")
    private Activity activity;

}
