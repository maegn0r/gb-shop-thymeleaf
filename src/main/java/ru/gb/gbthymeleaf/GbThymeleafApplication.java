package ru.gb.gbthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.gb.api", "ru.gb.gbthymeleaf"})
public class GbThymeleafApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GbThymeleafApplication.class, args);

//        ProductService productService = context.getBean(ProductService.class);
//
//
//        Product молоко = Product.builder()
//                .title("Молоко")
//                .cost(new BigDecimal(100))
//                .manufactureDate(LocalDate.now())
//                .status(Status.ACTIVE)
//                .build();
//
//        Product savedProduct = productService.save(молоко);
//
//        savedProduct.setTitle("Батон");
//
//        productService.save(savedProduct);
//
//        System.out.println(productService.findAll());
//
//        System.out.println(productService.findById(1L));
//
//        productService.deleteById(1L);

//        System.out.println(productService.findById(savedProduct.getId()));


    }

}
