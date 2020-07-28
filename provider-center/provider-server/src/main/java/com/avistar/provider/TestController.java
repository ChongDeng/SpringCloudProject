package com.avistar.provider;

import com.avistar.provider.dto.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/hello")
    public ProductDTO ext() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setStatus(1);

        return productDTO;
    }

}
