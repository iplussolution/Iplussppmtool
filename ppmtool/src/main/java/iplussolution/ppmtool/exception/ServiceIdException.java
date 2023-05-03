package iplussolution.ppmtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceIdException extends RuntimeException{

    public ServiceIdException(String message){
        super(message);
    }
}
