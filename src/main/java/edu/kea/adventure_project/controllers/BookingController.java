package edu.kea.adventure_project.controllers;

import edu.kea.adventure_project.models.Booking;
import edu.kea.adventure_project.models.SearchBooking;
import edu.kea.adventure_project.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Julius Panduro
 */
@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/createBooking")
    public String createBooking() {
        return "createBooking.html";
    }

    @GetMapping("/createBookingByID/{activityID}")
    public String createBookingByID(@PathVariable Long activityID, Model model){
        model.addAttribute("activityID", activityID);
        System.out.println(activityID);
        return "createBooking.html";
    }

    @PostMapping("/createBooking")
    public String createBooking(@ModelAttribute Booking booking, Model model) {
        bookingService.createNewBooking(booking);
        List<Booking> bookingList = bookingService.readAllBookings();
        model.addAttribute("booking", bookingList);
        return "redirect:/";
    }


    @GetMapping("/updateBooking/{bookingID}")
    public String updateBooking(@PathVariable Long bookingID, Model model) {
        model.addAttribute("booking", bookingService.findBookingByID(bookingID));
        return "updateBooking.html";
    }

    @PostMapping("/updateBooking")
    public String updateBooking(@ModelAttribute Booking booking) {
        bookingService.updateBooking(booking);
        return "redirect:/searchBooking";
    }


    @GetMapping("/searchBooking")
    public String searchBooking(Model model) {
        List<SearchBooking> bookingList = bookingService.searchBooking("","","","","","", "","","");
        model.addAttribute("bookingList", bookingList);
        return "searchBooking.html";
    }

    @PostMapping("/searchBooking")
    public String searchBooking(@RequestParam(value = "bookingID", required = false) String bookingID,
                                @RequestParam(value = "activityID", required = false) String activityID,
                                @RequestParam(value = "activityName", required = false) String activityName,
                                @RequestParam(value = "employeeName", required = false) String employeeName,
                                @RequestParam(value = "customerName", required = false) String customerName,
                                @RequestParam(value = "customerPhoneNumber", required = false) String customerPhoneNumber,
                                @RequestParam(value = "startDate", required = false) String startDate,
                                @RequestParam(value = "dateFrom", required = false) String dateFrom,
                                @RequestParam(value = "dateTo", required = false) String dateTo,
                                Model model) {
        List<SearchBooking> bookingList = bookingService.searchBooking(bookingID, activityID,
                activityName, employeeName, customerName, customerPhoneNumber, startDate, dateFrom, dateTo);
        model.addAttribute("bookingList", bookingList);
        return "searchBooking.html";
    }

    @GetMapping("/deleteBooking/{bookingID}")
    public String deleteActivity(@PathVariable("bookingID") Long bookingID) {
        bookingService.deleteBooking(bookingID);
        return "redirect:/searchBooking";
    }

}
