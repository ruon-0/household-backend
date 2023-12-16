package dev.onurdeniz.householdbackend.items.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository  extends JpaRepository<ItemEntity, Long> {
}
