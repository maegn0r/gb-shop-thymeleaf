package ru.gb.gbthymeleaf.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.api.security.dto.UserDto;

@FeignClient(url = "localhost:8081/api/v1/user", value = "UserApi")
public interface UserApi {
    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    ResponseEntity<?> handlePost(@Validated @RequestBody UserDto userDto);
}
