package com.cifp.cifpcrud.exception;

import java.time.LocalDateTime;

public record ErrorResponse(int status, String mensaje, LocalDateTime timestamp) {
}
