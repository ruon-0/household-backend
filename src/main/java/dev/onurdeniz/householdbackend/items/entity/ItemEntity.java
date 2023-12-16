package dev.onurdeniz.householdbackend.items.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Size(min=2)
    private String itemName;
    @NotNull
    @Size(min=2)
    private String vendor;
    @NotNull
    @Size(min=2)
    private Double price;
    @NotNull
    @Size(min=2)
    private LocalDate dateOfPurchase;
    @Size(min=2)
    private Double discount;

}
