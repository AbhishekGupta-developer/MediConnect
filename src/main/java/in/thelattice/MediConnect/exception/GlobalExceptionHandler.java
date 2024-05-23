package in.thelattice.MediConnect.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex) {
        Map<String, String> errorMap=new HashMap<>();
        errorMap.put("error", ex.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidations(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap=new HashMap<>();
        BindingResult result=ex.getBindingResult();
        for(FieldError error:result.getFieldErrors()){
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorMap, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String, String> errorMap=new HashMap<>();

        String message = "JSON parse error";
        Throwable cause = ex.getCause();

        if(cause instanceof InvalidFormatException) {
            InvalidFormatException ife = (InvalidFormatException) cause;
            Class<?> targetType = ife.getTargetType();

            if(targetType.isEnum()) {
                List<String> acceptedValues = List.of(targetType.getEnumConstants()).stream()
                        .map(Object::toString)
                        .collect(Collectors.toList());
                message = targetType.getSimpleName() + " can only be " + acceptedValues + ". NOTE: It's case-sensitive";
            }
        }

        errorMap.put("error", message);
        return new ResponseEntity<>(errorMap, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(CityOrDoctorNotPresentException.class)
    public ResponseEntity<?> handleCityNotPresentException(CityOrDoctorNotPresentException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatusCode.valueOf(200));
    }

}
