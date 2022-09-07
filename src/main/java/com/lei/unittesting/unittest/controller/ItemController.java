package com.lei.unittesting.unittest.controller;
import com.lei.unittesting.unittest.business.ItemBussinessService;
import com.lei.unittesting.unittest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemBussinessService bussinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){

        return new Item(1,"Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){

        return bussinessService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> allItemFromDatabase(){
        return bussinessService.retrieveAllItems();
    }



}
