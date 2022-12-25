package com.example.finalprojectspringboot.response;

import com.example.finalprojectspringboot.entity.Booking;
import com.example.finalprojectspringboot.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private long id;
    private String clientName;
    private String description;
    private long companyId;
    public BookingResponse(Booking booking) {
        this.id = booking.getId();
        this.clientName = booking.getClientName();
        this.description = booking.getDescription();
        this.companyId = booking.getCompanyId();
    }
}
