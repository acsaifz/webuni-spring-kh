package hu.acsaifz.studentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionType;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistoryData<T> {
    private T data;
    private RevisionType revType;
    private int rev;
    private LocalDateTime date;


}
