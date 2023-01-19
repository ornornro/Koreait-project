package com.korit.library.exception;

import com.korit.library.web.dto.CMRespDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@AllArgsConstructor
@Getter
public class CustomLikeException extends RuntimeException {
    private Map<String, String> errorMap;
}
