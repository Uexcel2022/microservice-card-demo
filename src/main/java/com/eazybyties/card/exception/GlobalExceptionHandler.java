package com.eazybyties.card.exception;

import com.eazybyties.card.dto.ErrorResponseDto;
import io.micrometer.common.lang.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        Map<String, Object> validatedErrors = new LinkedHashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        fieldErrors.forEach((FieldError)->{
            String fieldName = FieldError.getField();
            String errorMessage = FieldError.getDefaultMessage();
            validatedErrors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(validatedErrors,HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto>
    handleResourceNotFoundException(final ResourceNotFoundException e, WebRequest request) {
      ErrorResponseDto notFoundErrorResponse = new ErrorResponseDto(
              request.getDescription(false),HttpStatus.NOT_FOUND,
              e.getMessage(),LocalDateTime.now());
      return new ResponseEntity<>(notFoundErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CardExistsException.class)
    public ResponseEntity<ErrorResponseDto>
    handleCardExistException(final CardExistsException e, WebRequest request) {
        ErrorResponseDto mobileNumberExistsErrorResponse = new ErrorResponseDto(
                request.getDescription(false),HttpStatus.BAD_REQUEST,
                e.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(mobileNumberExistsErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CardNotValidException.class)
    public ResponseEntity<ErrorResponseDto>
    handleCardNotValidException(final CardNotValidException e, WebRequest request) {
        ErrorResponseDto mobileNumberExistsErrorResponse = new ErrorResponseDto(
                request.getDescription(false),HttpStatus.BAD_REQUEST,
                e.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(mobileNumberExistsErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto>
    handleInternalServerError(final Exception e, WebRequest request) {
        ErrorResponseDto mobileNumberExistsErrorResponse = new ErrorResponseDto(
                request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(mobileNumberExistsErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
