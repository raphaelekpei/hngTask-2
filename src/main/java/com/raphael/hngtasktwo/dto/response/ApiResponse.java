package com.raphael.hngtasktwo.dto.response;

import com.raphael.hngtasktwo.data.model.Address;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {

    private String name;
    private String email;
    private String phoneNumber;

    private Address address;

}
