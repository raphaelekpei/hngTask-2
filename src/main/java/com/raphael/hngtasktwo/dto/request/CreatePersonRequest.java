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

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @NotEmpty(message = "This field is required")
    @Email(message = "This field must be a valid email address")
    private String email;

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @NotEmpty(message = "This field is required")
    @Pattern(regexp = "^(\\+234|0)[0-9]{10}$")
    private String phoneNumber;

    @NotNull(message = "This field is required")
    private Integer houseNumber;

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String streetName;

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String city;

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String state;

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String country;

    @NotNull(message = "This field is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
}
