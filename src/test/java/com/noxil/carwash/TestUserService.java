package com.noxil.carwash;

import com.noxil.carwash.entity.Product;
import com.noxil.carwash.entity.User;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.service.ProductService;
import com.noxil.carwash.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Order(1)
    @Test
    void testCreate() throws BaseException {
//        User user = userService.create(
//                TestData.email,
//                TestData.username,
//                TestData.password,
//                TestData.firstname,
//                TestData.lastname);
//        Assertions.assertNotNull(user);
//        Assertions.assertNotNull(user.getId());
//        Assertions.assertEquals(user.getEmail(),TestData.email);
//        Assertions.assertEquals(user.getUsername(),TestData.username);
//        Assertions.assertEquals(user.getFirstname(),TestData.firstname);
//        Assertions.assertEquals(user.getLastname(),TestData.lastname);
//        boolean chkpassword = userService.matchPassword(TestData.password, user.getPassword());
//        Assertions.assertTrue(chkpassword);
    }

    void testUpdate() {

    }

    void testDelete() {

    }
    @Order(2)
    @Test
    void testCreateProduct() throws BaseException{
//        Product product = productService.create(ProductData.name,ProductData.detail,ProductData.price);
//        Assertions.assertNotNull(product);
//        Assertions.assertNotNull(product.getId());
//        Assertions.assertEquals(product.getName(),ProductData.name);
//        Assertions.assertEquals(product.getDetail(),ProductData.detail);
//        Assertions.assertEquals(product.getPrice(),ProductData.price);
    }

    @Order(3)
    @Test
    void testCreateQueque() throws BaseException{
        Optional<User>  user = userService.findByEmail(TestData.email);
        Optional<Product>  product = productService.findByName(ProductData.name);
        Assertions.assertTrue(user.isPresent());
        Assertions.assertTrue(product.isPresent());
    }

    interface TestData {
        String email = "pong@g.com";
        String username = "pkp";
        String password = "12345678";
        String firstname = "pong";
        String lastname = "test";
    }

    interface ProductData {
        String name = "wash";
        String detail = "Wash a car";
        float price = 120;
    }
}
