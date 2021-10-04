package edu.kea.adventure_project.repositories;

import edu.kea.adventure_project.models.Booking;
import edu.kea.adventure_project.models.SearchBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author Julius Panduro
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Query(value = "CALL searchBooking (?, ?, ?, ?, ?, ?, ?, ?, ?)")
    List<SearchBooking> searchBooking(String BookingID, String activityID,
                                              String activityName, String employeeName, String customerName,
                                              String customerPhoneNumber,
                                              String startDate, String dateFrom, String dateTo);
}
