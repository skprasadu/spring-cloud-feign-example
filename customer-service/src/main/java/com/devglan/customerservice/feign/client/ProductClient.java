package com.devglan.customerservice.feign.client;

import com.devglan.customerservice.feign.config.CustomFeignConfig;
import com.devglan.commons.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="product-service", configuration = CustomFeignConfig.class)
public interface ProductClient {

    //@GetMapping("/products")
    @RequestLine(value = "GET /products")
    List<Product> listProducts();

    //@GetMapping("/products/{id}")
    @RequestLine(value = "GET /products/{id}")
    Product getProductById(@Param("id")  String id);

    //@PostMapping("/products")
    @RequestLine(value = "POST /products/")
    Product create(@RequestBody Product product);

    //@GetMapping("/products/customer/{custId}")
    //@RequestMapping(method = RequestMethod.GET, value = "/products/customer/{custId}") 
    @RequestLine(value = "GET /products/customer/{custId}")
    List<Product> listProductsByCustomerId(@Param("custId") String custId);
}