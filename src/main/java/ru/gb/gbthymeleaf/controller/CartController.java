package ru.gb.gbthymeleaf.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.api.category.dto.CategoryDto;
import ru.gb.api.product.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    public static final List<ProductDto> dummyProducts = List.of(ProductDto.builder().id(1L).title("Product1").cost(BigDecimal.valueOf(30)).build(),
            ProductDto.builder().id(2L).title("Product2").cost(BigDecimal.valueOf(20)).build());

    @GetMapping
    public String getCartProductList(Model model) {
        model.addAttribute("cartProducts", dummyProducts);
        return "cart-product-list";
    }

    @GetMapping("/addToCart")
    public String addProductToCart(@RequestParam(name = "productId") Long productId) {
       // todo
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteProductFromCart(@RequestParam(name = "id") Long id) {
        // todo
        return "redirect:/cart";
    }
    @GetMapping("/increase")
    public String increaseProductsCountInCart(@RequestParam(name = "id") Long id) {
        // todo
        return "redirect:/cart";
    }
}

