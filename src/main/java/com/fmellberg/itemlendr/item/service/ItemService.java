package com.fmellberg.itemlendr.item.service;

import com.fmellberg.itemlendr.item.model.ItemEntity;

import java.util.List;

public interface ItemService {

    ItemEntity createItem(ItemEntity item);

    ItemEntity getItemById(long itemId);

    List<ItemEntity> getAllItems();

    ItemEntity updateItem(ItemEntity updatedItem);

    void deleteItem(long itemId);
}
