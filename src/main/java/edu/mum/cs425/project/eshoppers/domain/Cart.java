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
	   private Customer customer;
       //private long customerId;

       @NotNull
       private int quantity;

		@OneToMany//(mappedBy = "cart", cascade = CascadeType.PERSIST)
		@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Product.class)
        private List<Product> products=new ArrayList<Product>();

        public Cart() {}

    public Cart(Customer customer, @NotNull int quantity, List<Product> products) {
        this.customer = customer;
        this.quantity = quantity;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
