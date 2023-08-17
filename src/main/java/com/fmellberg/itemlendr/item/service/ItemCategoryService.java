package com.fmellberg.itemlendr.item.service;

import com.fmellberg.itemlendr.item.model.ItemCategoryEntity;

import java.util.List;

public interface ItemCategoryService {

    ItemCategoryEntity createItemCategory(ItemCategoryEntity itemCategory);

    ItemCategoryEntity getItemCategoryById(long categoryId);

    List<ItemCategoryEntity> getAllItemCategories();

    ItemCategoryEntity updateItemCategory(ItemCategoryEntity updatedCategory);

    void deleteItemCategory(long categoryId);
}

