package com.akila.example.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by akila on 8/27/17.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")  // 404
public class CustomException extends RuntimeException {

    public CustomException(String error) {
        super(error);
    }

}
