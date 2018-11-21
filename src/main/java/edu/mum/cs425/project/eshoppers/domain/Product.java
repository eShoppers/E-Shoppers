package edu.mum.cs425.project.eshoppers.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name")
    @NotEmpty(message = "*Please provide product name")
    private String productName;

    @Column(name = "quantity")
    @NotNull(message = "*Please provide product quantity")
    private int quantity;

    //@Column(name = "unit_price")
    @NotNull(message = "*Please provide product unit price")
    private Double unitPrice;

    // @Column(name = "description")
    @NotEmpty(message = "*Please provide product description")
    private String description;

    @Lob
    @Column(name="product_pic")
    private byte[] productPic;

    @ManyToOne
    private Catalog catalog;


    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getProductPic() {
        return productPic;
    }

    public void setProductPic(byte[] productPic) {
        this.productPic = productPic;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                '}';
    }
}