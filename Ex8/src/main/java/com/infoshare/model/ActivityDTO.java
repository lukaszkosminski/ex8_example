package com.infoshare.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    @NotEmpty(message = "Description can't be empty!")
    private String description;
    private Category category;
    private Priority priority;
    @NotNull(message = "You didn't set a date!")
    @FutureOrPresent(message = "Deadline must be a date in the present or in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
}
