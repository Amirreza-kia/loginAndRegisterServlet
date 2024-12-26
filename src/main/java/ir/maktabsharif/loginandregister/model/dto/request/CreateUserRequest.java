package ir.maktabsharif.loginandregister.model.dto.request;

import ir.maktabsharif.loginandregister.annotations.UniqueUsername;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreateUserRequest {
    @UniqueUsername
    @NotBlank
    private String username;
    @Size(min = 6, max = 20)
    private String password;
}
