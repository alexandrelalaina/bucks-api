package com.bucks.bucksapi.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author rodolfo-chicone
 * @version : $<br/>
 * : $
 * @since 01/05/2021 15:30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GenericResponse {
    @JsonIgnore
    private HttpStatus httpStatus;

    @JsonProperty(defaultValue = "false")
    private boolean success;
    private String message;
    private Object data;

    public static GenericResponse createGenericResponse(
            final HttpStatus httpStatus,
            final boolean success,
            final String message,
            final Object data) {
        return GenericResponse.builder()
                .httpStatus(httpStatus)
                .success(success)
                .message(message)
                .data(data)
                .build();
    }
}
