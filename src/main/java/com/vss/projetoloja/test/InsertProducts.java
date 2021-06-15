package com.vss.projetoloja.test;

import com.vss.projetoloja.model.Product;
import com.vss.projetoloja.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class InsertProducts {

    private ProductRepository productRepository;

    @Autowired
    public InsertProducts (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        Product p1 = new Product("Super Mario Odyssey",
                BigDecimal.valueOf(197.88),
                100,
                "super-mario-odyssey.png");

        Product p2 = new Product("Call Of Duty Infinite Warfare",
                BigDecimal.valueOf(49.99),
                80,
                "call-of-duty-infinite-warfare.png");

        Product p3 = new Product("The Witcher III Wild Hunt",
                BigDecimal.valueOf(119.5),
                250,
                "the-witcher-iii-wild-hunt.png");

        Product p4 = new Product("Call Of Duty WWII",
                BigDecimal.valueOf(249.99),
                205,
                "call-of-duty-wwii.png");

        Product p5 = new Product("Mortal Kombat XL",
                BigDecimal.valueOf(69.99),
                150,
                "mortal-kombat-xl.png");

        Product p6 = new Product("Shards of Darkness",
                BigDecimal.valueOf(71.94),
                400,
                "shards-of-darkness.png");
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));

    }

}
