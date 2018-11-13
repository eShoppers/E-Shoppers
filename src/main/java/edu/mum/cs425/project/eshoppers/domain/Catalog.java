package edu.mum.cs425.project.eshoppers.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import java.util.ArrayList;
import java.util.List;



@Entity
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @NotEmpty(message="Please Provide catalogName")
	private String catalogName;

    @OneToMany//(mappedBy = "catalog", cascade = CascadeType.PERSIST)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Product.class)
	private List<Product> products=new ArrayList<Product>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Catalog{" +
				"id=" + id +
				", catalogName='" + catalogName + '\'' +
				", products=" + products +
				'}';
	}
}
