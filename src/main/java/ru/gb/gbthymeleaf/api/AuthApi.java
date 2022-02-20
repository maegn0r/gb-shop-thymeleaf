package ru.gb.gbthymeleaf.api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.api.security.dto.AuthenticationUserDto;


@FeignClient(url = "localhost:8081/api/v1/auth/login", value = "AuthApi")
public interface AuthApi {

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    ResponseEntity<?> login(@RequestBody AuthenticationUserDto authenticationUserDto);
}
