package ru.gb.gbthymeleaf.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import ru.gb.gbthymeleaf.api.AuthApi;
import ru.gb.gbthymeleaf.api.ProductApi;
import ru.gb.gbthymeleaf.api.UserApi;

@Configuration
@EnableFeignClients(basePackageClasses = {AuthApi.class, UserApi.class, ProductApi.class})
public class AppConfig {
}
