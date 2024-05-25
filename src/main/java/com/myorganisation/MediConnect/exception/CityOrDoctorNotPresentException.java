package com.myorganisation.MediConnect.exception;

public class CityOrDoctorNotPresentException extends RuntimeException {
    public CityOrDoctorNotPresentException(String message) {
        super(message);
    }
}
