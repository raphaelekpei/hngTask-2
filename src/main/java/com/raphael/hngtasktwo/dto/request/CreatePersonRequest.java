package com.raphael.hngtasktwo.dto.request;


import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePersonRequest {

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String name;

}
