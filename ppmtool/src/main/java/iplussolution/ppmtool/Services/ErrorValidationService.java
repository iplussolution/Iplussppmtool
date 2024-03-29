package iplussolution.ppmtool.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErrorValidationService {

    public ResponseEntity<?> errorValidator(BindingResult result) {
        Map<String, String> errorMap = new HashMap<>();
        if (result.hasErrors()) {

            for (FieldError fe : result.getFieldErrors()) {
                errorMap.put(fe.getField(), fe.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
