package ru.gb.gbthymeleaf.api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.gb.api.product.dto.ProductDto;
import java.util.List;


@FeignClient(url = "localhost:8081/api/v1/product", value = "ProductApi")
public interface ProductApi {
    @GetMapping
    List<ProductDto> getProductList(@RequestHeader("Authorization") String bearerToken);
}

