package ru.gb.gbthymeleaf.utils;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.gb.api.product.dto.ProductDto;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@NoArgsConstructor
@Data
public class Cart {
    private Set<ProductDto> products;
    private String token;

    @PostConstruct
    public void init() {
        products = new HashSet<>();
    }

    public void addProduct(ProductDto p) {
        products.add(p);
    }
    public void removeProduct(ProductDto p) {
        products.remove(p);
    }

    public void clear() {
        products.clear();
    }
}
