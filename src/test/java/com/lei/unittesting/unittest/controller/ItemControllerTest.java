package com.lei.unittesting.unittest.controller;

import com.lei.unittesting.unittest.business.ItemBussinessService;
import com.lei.unittesting.unittest.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value=ItemController.class)
class ItemControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBussinessService bussinessService;

    @Test
    void dummyItem_basic() throws Exception{
        //call GET "/hello-world" application/json
        RequestBuilder request= MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc
                .perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        //assertEquals("Hello World", result.getResponse().getContentAsString());
        //assertJsonEqual(String expected, String actual, boolean strict)
        // verify "Hello World"
    }

    @Test
    void itemFromBusinessService() throws Exception{

        when(bussinessService.retrieveHardcodedItem()).thenReturn(new Item(2,"Item2",10,10));


        //call GET "/hello-world" application/json
        RequestBuilder request= MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc
                .perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{\"id\": 2,\"name\":\"Item2\",\"price\":10,\"quantity\":10}"))
                .andReturn();



        //assertEquals("Hello World", result.getResponse().getContentAsString());
        //assertJsonEqual(String expected, String actual, boolean strict)
        // verify "Hello World"
    }

    @Test
    public void retrieveAllItems_basic() throws Exception{
        when(bussinessService.retrieveAllItems()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10),
                new Item(3,"Item3",20,20)));


        //call GET "/hello-world" application/json
        RequestBuilder request= MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc
                .perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("[{\"id\": 2,\"name\":\"Item2\",\"price\":10,\"quantity\":10}, {\"id\": 3,\"name\":\"Item3\",\"price\":20,\"quantity\":20}]"))
                .andReturn();
    }


}