package ru.gb.gbthymeleaf.tempDto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderStatus {
    NEW("Новый"), IN_PROGRESS("В процессе"), FINISHED("Завершён");

    private final String title;
}
