package com.fmellberg.itemlendr.item.controller;

import com.fmellberg.itemlendr.item.model.ItemCategoryEntity;
import com.fmellberg.itemlendr.item.service.ItemCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item-category")
@RequiredArgsConstructor
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    @PostMapping("/create")
    public ResponseEntity<ItemCategoryEntity> createItemCategory(@RequestBody ItemCategoryEntity itemCategory) {
        ItemCategoryEntity createdCategory = itemCategoryService.createItemCategory(itemCategory);
        return ResponseEntity.ok(createdCategory);
    }

    @GetMapping("/get/{categoryId}")
    public ResponseEntity<ItemCategoryEntity> getItemCategoryById(@PathVariable Long categoryId) {
        ItemCategoryEntity category = itemCategoryService.getItemCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ItemCategoryEntity>> getAllItemCategories() {
        List<ItemCategoryEntity> categories = itemCategoryService.getAllItemCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemCategoryEntity> updateItemCategory(@RequestBody ItemCategoryEntity updatedCategory) {
        ItemCategoryEntity updated = itemCategoryService.updateItemCategory(updatedCategory);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> deleteItemCategory(@PathVariable Long categoryId) {
        itemCategoryService.deleteItemCategory(categoryId);
        return ResponseEntity.ok("Item category deleted");
    }
}

