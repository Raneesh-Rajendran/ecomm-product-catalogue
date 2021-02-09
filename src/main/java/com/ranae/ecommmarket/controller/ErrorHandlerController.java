package com.ranae.ecommmarket.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global error handler
 */
@RestControllerAdvice
public class ErrorHandlerController implements ErrorController {

    private static final String PATH = "/error";

    @GetMapping(value = PATH)
    public String error() {
        return "Some unexpected error occurred";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}