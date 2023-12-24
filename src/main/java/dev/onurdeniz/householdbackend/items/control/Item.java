package dev.onurdeniz.householdbackend.items.control;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
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
    private Double price;
    @NotNull
    private LocalDate dateOfPurchase;
    private Double discount;
}
