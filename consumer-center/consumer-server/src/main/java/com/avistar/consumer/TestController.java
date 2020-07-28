package com.avistar.consumer;

import com.avistar.provider.dto.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public ProductDTO hello(){

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setStatus(2);

        return productDTO;
    }
}
