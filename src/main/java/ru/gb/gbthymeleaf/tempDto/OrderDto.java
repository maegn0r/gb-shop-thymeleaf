package ru.gb.gbthymeleaf.tempDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gb.gbthymeleaf.tempDto.enums.OrderStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private OrderStatus status;
}
