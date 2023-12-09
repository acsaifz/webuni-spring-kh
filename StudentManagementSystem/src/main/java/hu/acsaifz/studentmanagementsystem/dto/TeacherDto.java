package hu.acsaifz.studentmanagementsystem.dto;

import java.time.LocalDate;

public record TeacherDto(
        long id,
        String name,
        LocalDate birthDate
) {
}
