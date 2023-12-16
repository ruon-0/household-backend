package dev.onurdeniz.householdbackend.control;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Item {
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
