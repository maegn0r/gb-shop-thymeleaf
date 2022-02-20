package ru.gb.gbthymeleaf.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.order.api.OrderGateway;
import ru.gb.api.order.dto.OrderDto;
import ru.gb.gbthymeleaf.utils.Cart;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderGateway orderGateway;
    private Cart cart;

    @GetMapping("/all")
    public String getOrderList(Model model) {
        List<OrderDto> orderDtoList = orderGateway.getOrderList();
        model.addAttribute("orders", orderDtoList);
        return "order-list";
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("order", new OrderDto());
        return "order-form";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute OrderDto orderDto){
        orderDto.setProducts(cart.getProducts());
        orderDto.setDeliveryDate(LocalDate.now());
        orderGateway.handlePost(orderDto);
        cart.clear();
        return "redirect:/product/all";
    }
}
