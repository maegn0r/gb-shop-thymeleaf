package ru.gb.gbthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.category.api.CategoryGateway;
import ru.gb.api.manufacturer.api.ManufacturerGateway;
import ru.gb.api.product.api.ProductGateway;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.gbthymeleaf.choosen.ChosenCategoriesDto;
import ru.gb.gbthymeleaf.facades.ProductFacade;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductFacade productFacade;


    @GetMapping("/all")
    public String getProductList(Model model) {
        List<ProductDto> list = productFacade.getProductList();
        model.addAttribute("products", list);
        return "product-list";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        ProductDto productDto;
        if (id != null) {
            productDto = productFacade.getProduct(id);
        } else {
            productDto = new ProductDto();
        }

        model.addAttribute("product", productDto);
        model.addAttribute("manufacturers", productFacade.getManufacturerList());
        model.addAttribute("categoriesList", productFacade.getCategoryList());
        model.addAttribute("chosenCategories", new ChosenCategoriesDto(new HashSet<>()));
        return "product-form";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute ProductDto product, @ModelAttribute ChosenCategoriesDto chosenCategoriesDto) {
        product.setCategories(productFacade.getCategoriesByIds(chosenCategoriesDto.getChosenCategory()));
        product.setManufactureDate(LocalDate.now());
        productFacade.handlePost(product);
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        productFacade.deleteById(id);
        return "redirect:/product/all";
    }
}
