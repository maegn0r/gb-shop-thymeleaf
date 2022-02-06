package ru.gb.gbthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.api.product.api.ProductGateway;
import ru.gb.api.product.dto.ProductDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductGateway productGateway;

    @GetMapping("/all")
    public String getProductList(Model model) {
        System.out.println("in product");
        List<ProductDto> list = productGateway.getProductList();
        model.addAttribute("products", list);
        return "product-list";
    }

//    @GetMapping
//    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
//        Product product;
//        if (id != null) {
//            product = productService.findById(id);
//        } else {
//            product = new Product();
//        }
//        model.addAttribute("product", product);
//        return "product-form";
//    }
//
//    @PostMapping
//    public String saveProduct(Product product) {
//        product.setManufactureDate(LocalDate.now());
//        productService.save(product);
//        return "redirect:/product/all";
//    }
//
//    @GetMapping("/delete")
//    public String deleteById(@RequestParam(name = "id") Long id) {
//        productService.deleteById(id);
//        return "redirect:/product/all";
//    }
}
