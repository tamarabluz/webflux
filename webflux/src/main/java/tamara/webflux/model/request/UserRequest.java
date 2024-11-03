package tamara.webflux.model.request;

import jakarta.validation.constraints.*;
import tamara.webflux.validation.TrimString;

public record UserRequest(

        @TrimString
        @NotBlank(message = "must not be null or empty")
        @Size(min=3, max = 50, message = "must be between 3 and 50 characters")
        String name,


        @TrimString
        @NotBlank(message = "must not be null or empty")
        @Email(message = "invalid")
        String email,

        @TrimString
        @NotBlank(message = "must not be null or empty")
        @Size(min=8, max = 50,  message = "must have at least 8 characters")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
                message = "Password must contain at least one uppercase letter and one special character")
        String password
){}