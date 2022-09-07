package com.lei.unittesting.unittest.model;

import javax.persistence.*;

@Entity
@Table(name="item")
public class Item {
    @Id
    @Column(name="id")
    private int id;
    @Column
    private String name;
    @Column
    private int price;

    @Column
    private int quantity;

    //don't want the value field to be stored in the database
    @Transient
    private int value;

    protected Item() {
    }

    public Item(int id, String name, int price, int quantity) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        return String.format("Item[%d, %s, %d, %d]", id, name,price,quantity);
    }

}
