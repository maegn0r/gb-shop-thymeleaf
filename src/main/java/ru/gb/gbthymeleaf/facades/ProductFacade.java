package ru.gb.gbthymeleaf.facades;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.api.category.api.CategoryGateway;
import ru.gb.api.category.dto.CategoryDto;
import ru.gb.api.manufacturer.api.ManufacturerGateway;
import ru.gb.api.manufacturer.dto.ManufacturerDto;
import ru.gb.api.product.api.ProductGateway;
import ru.gb.api.product.dto.ProductDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductFacade {
    private final CategoryGateway categoryGateway;
    private final ManufacturerGateway manufacturerGateway;
    private final ProductGateway productGateway;

    public Set<CategoryDto> getCategoriesByIds(Set<Long> ids){
        return ids.stream().map(id -> categoryGateway.getCategory(id).getBody()).collect(Collectors.toSet());
    }

    public ProductDto getProduct(Long id) {
        return productGateway.getProduct(id).getBody();
    }

    public List<ProductDto> getProductList() {
        return productGateway.getProductList();
    }

    public List<ManufacturerDto> getManufacturerList() {
        return manufacturerGateway.getManufacturerList();
    }

    public List<CategoryDto> getCategoryList() {
        return categoryGateway.getCategoryList();
    }

    public void handlePost(ProductDto product) {
        productGateway.handlePost(product);
    }

    public void deleteById(Long id) {
        productGateway.deleteById(id);
    }
}
