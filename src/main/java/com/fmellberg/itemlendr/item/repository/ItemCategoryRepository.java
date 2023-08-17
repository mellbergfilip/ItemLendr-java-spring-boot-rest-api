package com.fmellberg.itemlendr.item.repository;

import com.fmellberg.itemlendr.item.model.ItemCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategoryEntity,Long> {
}
