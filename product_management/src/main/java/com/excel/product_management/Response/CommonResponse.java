package com.excel.product_management.Response;

import lombok.*;

/**
 * A generic response class to standardize API responses.
 *
 * @param <T> the type of the data to be included in the response.
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {

    /**
     * The actual data returned in the response.
     * It can be of any type, specified when the CommonResponse is created.
     */
    private T data;

    /**
     * A message that provides additional information about the response.
     * This could be a success message, an error message, etc.
     */
    private String message;

    /**
     * A flag indicating whether the response contains an error or not.
     * True if there is an error, false otherwise.
     */
    private Boolean isError;
}
