package dev.onurdeniz.householdbackend.items.control;

import dev.onurdeniz.householdbackend.items.entity.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemEntityMapper {
    ItemEntity map(Item item) {
        if (item == null) {
            return null;
        } else {
            ItemEntity newItem = new ItemEntity();
            newItem.setId(item.getId());
            newItem.setItemName(item.getItemName());
            newItem.setVendor(item.getVendor());
            newItem.setPrice(item.getPrice());
            newItem.setDateOfPurchase(item.getDateOfPurchase());
            newItem.setDiscount(item.getDiscount());
            return newItem;
        }
    }

    Item map(ItemEntity item) {
        if (item == null) {
            return null;
        } else {
            Item newItem = new Item();
            newItem.setId(item.getId());
            newItem.setItemName(item.getItemName());
            newItem.setVendor(item.getVendor());
            newItem.setPrice(item.getPrice());
            newItem.setDateOfPurchase(item.getDateOfPurchase());
            newItem.setDiscount(item.getDiscount());
            return newItem;
        }
    }
}
