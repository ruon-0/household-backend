package dev.onurdeniz.householdbackend.boundary;

import dev.onurdeniz.householdbackend.control.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoMapper {

    ItemDto map(Item item) {
        if (item == null) {
            return null;
        } else {
            final var newItem = new ItemDto();
            newItem.setId(item.getId());
            newItem.setItemName(item.getItemName());
            newItem.setVendor(item.getVendor());
            newItem.setPrice(item.getPrice());
            newItem.setDateOfPurchase(item.getDateOfPurchase());
            newItem.setDiscount(item.getDiscount());
            return newItem;
        }
    }

    Item map(ItemDto item, Long id) {
        if (item == null) {
            return null;
        } else {
            final var newItem = new Item();
            newItem.setId(id);
            newItem.setItemName(newItem.getItemName());
            newItem.setVendor(item.getVendor());
            newItem.setPrice(item.getPrice());
            newItem.setDateOfPurchase(item.getDateOfPurchase());
            newItem.setDiscount(item.getDiscount());
            return newItem;
        }
    }
}
