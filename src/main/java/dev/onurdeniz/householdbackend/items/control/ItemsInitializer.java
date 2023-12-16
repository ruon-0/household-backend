package dev.onurdeniz.householdbackend.items.control;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ItemsInitializer {

    private final ItemsService service;

    @EventListener(ContextRefreshedEvent.class)
    public void initializeItem() {
        //create sample item, if empty
        if (this.service.count() < 1) {
            final var item1 = new Item();
            item1.setItemName("Handcreme");
            item1.setPrice(1.99);
            item1.setVendor("DM");
            item1.setDateOfPurchase(LocalDate.of(2023, 12,16));
            item1.setDiscount(0.00);
            this.service.create(item1);

            final var item2 = new Item();
            item2.setItemName("Tee Kamille");
            item2.setPrice(0.89);
            item2.setVendor("DM");
            item2.setDateOfPurchase(LocalDate.of(2023, 12,16));
            item2.setDiscount(0.00);
            this.service.create(item2);

            final var item3 = new Item();
            item3.setItemName("Corona Maske");
            item3.setPrice(1.79);
            item3.setVendor("DM");
            item3.setDateOfPurchase(LocalDate.of(2023, 12,16));
            item3.setDiscount(0.10);
            this.service.create(item3);
        }
    }
}
