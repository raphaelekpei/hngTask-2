package com.raphael.hngtasktwo.dto.response;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

    private Long id;
    private String message;
    private boolean isSuccess;


}
