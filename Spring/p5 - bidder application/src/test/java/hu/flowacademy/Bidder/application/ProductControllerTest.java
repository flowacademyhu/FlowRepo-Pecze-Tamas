package hu.flowacademy.Bidder.application;

import static org.hamcrest.Matchers.is;
import hu.flowacademy.Bidder.application.Controller.ProductController;
import hu.flowacademy.Bidder.application.Domain.Product;
import hu.flowacademy.Bidder.application.Service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void givenProducts_whenProducts_thenReturnJsonArray() throws Exception {
        Product productShouldBeFound = new Product("Cucc","Jo cucc", 100,
                new Date(2017,02,20, 06,06,06),
                new Date(2017,02,20, 06,06,06));
        List<Product> allProductsShouldBeFound = Arrays.asList(productShouldBeFound);
        given(productService.getAll()).willReturn(allProductsShouldBeFound);

        mvc.perform(get("/products/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].productDesc",is(productShouldBeFound.getProductDesc())));
    }
}
