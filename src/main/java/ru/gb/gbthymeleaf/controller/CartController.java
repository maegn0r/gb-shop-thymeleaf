package ru.gb.gbthymeleaf.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.api.product.api.ProductGateway;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.gbthymeleaf.utils.Cart;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final ProductGateway productGateway;
    private Cart cart;

    @GetMapping
    public String getCartProductList(Model model) {
        List<ProductDto> list = cart.getProducts().stream().collect(Collectors.toList());
        model.addAttribute("cartProducts", list);
        return "cart-product-list";
    }

    @GetMapping("/addToCart")
    public String addProductToCart(@RequestParam(name = "id") Long id) {
        ProductDto productDto = cart.getProducts().stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        if (productDto == null) {
            ProductDto productFromDb = productGateway.getProduct(id).getBody();
            cart.addProduct(productFromDb);
        }
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteProductFromCart(@RequestParam(name = "id") Long id) {
        ProductDto productDto = cart.getProducts().stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        if (productDto != null) {
            cart.removeProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/increase")
    public String increaseProductsCountInCart(@RequestParam(name = "id") Long id) {
        // todo
        return "redirect:/cart";
    }
}

