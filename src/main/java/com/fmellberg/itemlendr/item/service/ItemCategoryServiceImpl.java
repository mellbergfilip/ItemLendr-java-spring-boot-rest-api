package com.fmellberg.itemlendr.item.service;

import com.fmellberg.itemlendr.errorhandling.exceptions.ResourceNotFoundException;
import com.fmellberg.itemlendr.item.model.ItemCategoryEntity;
import com.fmellberg.itemlendr.item.repository.ItemCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemCategoryServiceImpl implements ItemCategoryService {

    private final ItemCategoryRepository itemCategoryRepository;

    @Override
    public ItemCategoryEntity createItemCategory(ItemCategoryEntity itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategoryEntity getItemCategoryById(long categoryId) {
        return itemCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("ItemCategory", "id", categoryId));
    }

    @Override
    public List<ItemCategoryEntity> getAllItemCategories() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategoryEntity updateItemCategory(ItemCategoryEntity updatedCategory) {
        if (!itemCategoryRepository.existsById(updatedCategory.getId())) {
            throw new ResourceNotFoundException("ItemCategory", "id", updatedCategory.getId());
        }

        return itemCategoryRepository.save(updatedCategory);
    }

    @Override
    public void deleteItemCategory(long categoryId) {
        if (!itemCategoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("ItemCategory", "id", categoryId);
        }

        itemCategoryRepository.deleteById(categoryId);
    }
}

