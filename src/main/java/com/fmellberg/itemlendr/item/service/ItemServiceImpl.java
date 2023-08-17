package com.fmellberg.itemlendr.item.service;

import com.fmellberg.itemlendr.errorhandling.exceptions.ResourceNotFoundException;
import com.fmellberg.itemlendr.item.model.ItemEntity;
import com.fmellberg.itemlendr.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    @Override
    public ItemEntity createItem(ItemEntity item) {
        return itemRepository.save(item);
    }

    @Override
    public ItemEntity getItemById(long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));
    }

    @Override
    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity updateItem(ItemEntity updatedItem) {
        if (!itemRepository.existsById(updatedItem.getId())) {
            throw new ResourceNotFoundException("Item", "id", updatedItem.getId());
        }

        return itemRepository.save(updatedItem);
    }


    @Override
    public void deleteItem(long itemId) {
        if (!itemRepository.existsById(itemId)) {
            throw new ResourceNotFoundException("Item", "id", itemId);
        }

        itemRepository.deleteById(itemId);
    }
}
