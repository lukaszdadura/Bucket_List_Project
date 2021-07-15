package pl.lukaszdadura.bucketlistproject.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RegisterDto {

    @NotNull
    private String username;
    @NotNull
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
