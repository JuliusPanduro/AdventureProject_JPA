package edu.kea.adventure_project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Julius Panduro
 */
@Data
@NoArgsConstructor
public class SearchBooking {
    private int bookingId;
    private int activityID;
    private String activityName;
    private String employeeName;
    private String customerName;
    private int customerTelephone;
    private String startDate;
    private String timeStart;
    private int timeLimit;


    public SearchBooking(int bookingId, int activityID, String activityName, String employeeName, String customerName, int customerTelephone, String startDate, String timeStart, int timeLimit) {
        this.bookingId = bookingId;
        this.activityID = activityID;
        this.activityName = activityName;
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.customerTelephone = customerTelephone;
        this.startDate = startDate;
        this.timeStart = timeStart;
        this.timeLimit = timeLimit;
    }
}
