package ru.gb.gbthymeleaf.tempDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private String address;
    private String lastname;
    private String firstname;
    private String phoneNumber;
    private String email;
}
