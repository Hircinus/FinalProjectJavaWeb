package com.example.finalprojectspringboot.entity;

import com.example.finalprojectspringboot.request.BookingRequest;
import com.example.finalprojectspringboot.request.CompanyRequest;
import com.example.finalprojectspringboot.service.CompanyService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "bookings")
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "clientName")
    private String clientName;
    @Column(name = "description")
    private String description;
    @Column(name="company_id")
    private long companyId;
    public Booking(BookingRequest bookingRequest) {
        this.clientName = bookingRequest.getClientName();
        this.description = bookingRequest.getDescription();
        this.companyId = bookingRequest.getCompanyId();
    }
}
