package com.example.finalprojectspringboot.repository;

import com.example.finalprojectspringboot.entity.Booking;
import com.example.finalprojectspringboot.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAll();
    List<Booking> findBookingsByCompanyId(long companyId);
}