package edu.kea.adventure_project.services;

import edu.kea.adventure_project.models.Activity;
import edu.kea.adventure_project.models.Booking;
import edu.kea.adventure_project.models.SearchBooking;
import edu.kea.adventure_project.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Julius Panduro
 */
@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public void createNewBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public List<Booking> readAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking findBookingByID(Long bookingID) {
        return bookingRepository.findById(bookingID).orElseThrow(); //todo make an exception to handle Activity not found
    }

    public void updateBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public void deleteBooking(Long bookingID) {
        bookingRepository.deleteById(bookingID);
    }

    public List<SearchBooking> searchBooking(String bookingID, String activityID,
                                             String activityName, String employeeName,
                                             String customerName, String customerPhoneNumber,
                                             String startDate, String dateFrom, String dateTo) {
       return bookingRepository.searchBooking(bookingID, activityID, activityName, employeeName,
                customerName, customerPhoneNumber,
                startDate, dateFrom, dateTo);
    }

  /*  public List<SearchBooking> searchBooking(String bookingID, String activityID,
                                             String activityName, String employeeName,
                                             String customerName, String customerPhoneNumber,
                                             String startDate, String dateFrom, String dateTo) {
        return bookingRepository.searchBooking(bookingID,
                activityID, activityName, employeeName,
                customerName, customerPhoneNumber, startDate,
                dateFrom, dateTo);
    }

   */
}
