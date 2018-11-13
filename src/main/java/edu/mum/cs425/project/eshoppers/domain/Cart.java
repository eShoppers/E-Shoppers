package edu.mum.cs425.project.eshoppers.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;
import java.util.ArrayList;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cart")
public class Cart {
       
       @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;
       private long customerId;
       @NotNull
       private int quantity;

		@OneToMany//(mappedBy = "cart", cascade = CascadeType.PERSIST)
		@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Product.class)
        private List<Product> products=new ArrayList<Product>();

		//private double price;
        public Cart()
		{

		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			id = id;
		}
		public long getCustomerid() {
			return customerId;
		}
		public void setCustomerid(long customerid) {
			this.customerId = customerid;
		}
		public int getQuality() {
			return quantity;
		}
		public void setQuality(int quantity) {
			this.quantity = quantity;
		}
		public List<Product> getProducts() {
			return products;
		}
		public void setProducts(List<Product> products) {
			this.products = products;
		}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", customerId=" + customerId +
				", quality=" + quantity +
				", products=" + products +
				'}';
	}
}
