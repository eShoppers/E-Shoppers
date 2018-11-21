package edu.mum.cs425.project.eshoppers.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.ArrayList;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cart")
@ToString
public class Cart {
       
       @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;

       @OneToOne
       @JoinColumn(name="cid")
	   private Customer customer;
       //private long customerId;

       @NotNull
       private int quantity;

		@OneToOne//(mappedBy = "cart", cascade = CascadeType.PERSIST)
       // @JoinColumn(name="id")
        private Product product;

        public Cart() {}

    public Cart(Customer customer, @NotNull int quantity, Product product) {
        this.customer = customer;
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
