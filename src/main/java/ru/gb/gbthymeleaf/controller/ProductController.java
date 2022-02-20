package ru.gb.gbthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.category.api.CategoryGateway;
import ru.gb.api.manufacturer.api.ManufacturerGateway;
import ru.gb.api.product.api.ProductGateway;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.gbthymeleaf.choosen.ChosenCategoriesDto;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductGateway productGateway;
    private final ManufacturerGateway manufacturerGateway;
    private final CategoryGateway categoryGateway;


    @GetMapping("/all")
    public String getProductList(Model model) {
        List<ProductDto> list = productGateway.getProductList();
        model.addAttribute("products", list);
        return "product-list";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        ProductDto productDto;
        if (id != null) {
            productDto = productGateway.getProduct(id).getBody();
        } else {
            productDto = new ProductDto();
        }

        model.addAttribute("product", productDto);
        model.addAttribute("manufacturers", manufacturerGateway.getManufacturerList());
        model.addAttribute("categoriesList", categoryGateway.getCategoryList());
        model.addAttribute("chosenCategories", new ChosenCategoriesDto(new HashSet<>()));
        return "product-form";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute ProductDto product, @ModelAttribute ChosenCategoriesDto chosenCategoriesDto) {
        product.setCategories(chosenCategoriesDto.getChosenCategory().stream().map(id -> categoryGateway.getCategory(id).getBody()).collect(Collectors.toSet()));
        product.setManufactureDate(LocalDate.now());
        productGateway.handlePost(product);
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        productGateway.deleteById(id);
        return "redirect:/product/all";
    }
}
