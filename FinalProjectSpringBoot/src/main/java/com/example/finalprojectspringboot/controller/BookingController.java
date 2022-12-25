package com.example.finalprojectspringboot.controller;

import com.example.finalprojectspringboot.entity.Booking;
import com.example.finalprojectspringboot.entity.Company;
import com.example.finalprojectspringboot.request.BookingRequest;
import com.example.finalprojectspringboot.request.CompanyRequest;
import com.example.finalprojectspringboot.response.BookingResponse;
import com.example.finalprojectspringboot.response.CompanyResponse;
import com.example.finalprojectspringboot.service.BookingService;
import com.example.finalprojectspringboot.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins="*")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping() //when empty it maps to the url above
    @CrossOrigin(origins="*")
    public List<BookingResponse> getBookingsByCompanyId(@RequestParam(required = true) long companyId) {
        List<Booking> bookings = bookingService.getBookingsByCompanyId(companyId);
        List<BookingResponse> bookingResponses = new ArrayList<>();
        bookings.forEach(booking -> {
            BookingResponse t = new BookingResponse(booking);
            bookingResponses.add(t);
        });
        return bookingResponses;
    }
    @PostMapping()
    @CrossOrigin(origins="*")
    public BookingResponse addBooking(@Valid @RequestBody BookingRequest bookingRequest)
    {

        Booking savedBooking = bookingService.addBooking(bookingRequest);

        return new BookingResponse(savedBooking);

    }
    @PutMapping("/{id}")
    @CrossOrigin(origins="*")
    public BookingResponse updateBooking
            (@PathVariable long id,
             @Valid @RequestBody BookingRequest bookingRequest){

        Booking updatedBooking = bookingService.updateBooking(id, bookingRequest);
        return new BookingResponse(updatedBooking);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins="*")
    public void deleteBooking(@PathVariable long id)
    {
        bookingService.deleteBooking(id);
    }
}
