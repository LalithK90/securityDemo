package com.spring.securityDemo.util;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Service
public class DateTimeAgeService {

    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public int getAge(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        return Period.between(dateOfBirth, today).getYears();
    }
}
