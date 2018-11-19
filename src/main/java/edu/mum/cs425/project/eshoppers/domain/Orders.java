package edu.mum.cs425.project.eshoppers.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_id")
    @NotEmpty
    private String orderId;

    @Column(name = "order_date")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    @Column(name = "quantity")
    @NotNull
    private Long quantity;

    @Column(name = "price")
    @NotNull
    private Double price;

    @ManyToOne
    private Customer customer;

    @OneToOne
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Product.class)
    private Product product;

    public Orders(){}

    public Orders(@NotEmpty String orderId, @NotNull LocalDate orderDate, @NotNull Long quantity, @NotNull Double price) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.price = price;
    }
}