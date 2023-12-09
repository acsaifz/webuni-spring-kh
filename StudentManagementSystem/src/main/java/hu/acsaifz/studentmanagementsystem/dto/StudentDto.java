package hu.acsaifz.studentmanagementsystem.dto;

import java.time.LocalDate;

public record StudentDto(
        long id,
        String name,
        LocalDate birthDate,
        int semester
) {

}
