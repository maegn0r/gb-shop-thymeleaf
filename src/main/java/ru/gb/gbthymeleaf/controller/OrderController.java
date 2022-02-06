package ru.gb.gbthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.gbthymeleaf.choosen.ChosenCategoriesDto;
import ru.gb.gbthymeleaf.tempDto.OrderDto;
import ru.gb.gbthymeleaf.tempDto.OrderInfo;
import ru.gb.gbthymeleaf.tempDto.enums.OrderStatus;

import java.util.HashSet;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    public static final List<OrderDto> dummyOrders = List.of(new OrderDto(1L, OrderStatus.NEW),
            new OrderDto(2L, OrderStatus.IN_PROGRESS),
            new OrderDto(3L, OrderStatus.IN_PROGRESS),
            new OrderDto(4L, OrderStatus.FINISHED),
            new OrderDto(5L, OrderStatus.NEW));

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("orders", dummyOrders);
        return "order-list";
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("order", new OrderInfo());
        return "order-form";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute OrderInfo order){
        //todo
        System.out.println(order);
        return "redirect:/product/all";
    }
}
