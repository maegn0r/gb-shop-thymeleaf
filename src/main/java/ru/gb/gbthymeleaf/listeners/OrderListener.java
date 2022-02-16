package ru.gb.gbthymeleaf.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.gb.api.events.OrderEvent;
import ru.gb.api.order.dto.OrderDto;
import ru.gb.gbthymeleaf.config.JmsConfig;
import ru.gb.gbthymeleaf.sender.ShopMailSender;


@RequiredArgsConstructor
@Component
public class OrderListener {

    private final JmsTemplate jmsTemplate;
    private final ShopMailSender mailSender;

    @JmsListener(destination = JmsConfig.ORDER_CHANGED)
    public void listen(@Payload OrderEvent orderEvent) {
        OrderDto orderDto = orderEvent.getOrderDto();
        String text = String.format("Order №%d change status to %s", orderDto.getId(), orderDto.getStatus().getTitle());
        mailSender.sendMail(orderDto.getMail(), "Order status changed", text);
    }
}