package com.example.finalprojectspringboot.service;

import com.example.finalprojectspringboot.entity.Booking;
import com.example.finalprojectspringboot.entity.Company;
import com.example.finalprojectspringboot.exception.ResourceNotFoundException;
import com.example.finalprojectspringboot.repository.BookingRepository;
import com.example.finalprojectspringboot.repository.CompanyRepository;
import com.example.finalprojectspringboot.request.BookingRequest;
import com.example.finalprojectspringboot.request.CompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getBookingsByCompanyId(long companyId){

        return bookingRepository.findBookingsByCompanyId(companyId);
    }
    public Booking addBooking(BookingRequest bookingRequest)
    {
        Booking booking = new Booking(bookingRequest);

        return bookingRepository.save(booking);
    }
    public Booking updateBooking(long bookingId, BookingRequest bookingRequest)
    {
        bookingRepository.findById(bookingId)
                .orElseThrow(()->new ResourceNotFoundException("booking id is not found"));

        Booking bookingToBeUpdated = new Booking(bookingRequest);
        bookingToBeUpdated.setId(bookingId);

        return bookingRepository.save(bookingToBeUpdated);

    }

    public void deleteBooking(long bookingId){
        if(bookingRepository.existsById(bookingId)){
            bookingRepository.deleteById(bookingId);
        }
        else{
            throw new ResourceNotFoundException("booking id not found");
        }
    }
}
