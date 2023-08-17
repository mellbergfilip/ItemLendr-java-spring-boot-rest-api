package com.fmellberg.itemlendr.item.controller;

import com.fmellberg.itemlendr.item.model.ItemEntity;
import com.fmellberg.itemlendr.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemEntity item) {
        ItemEntity createdItem = itemService.createItem(item);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/get/{itemId}")
    public ResponseEntity<ItemEntity> getItemById(@PathVariable Long itemId) {
        ItemEntity item = itemService.getItemById(itemId);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ItemEntity>> getAllItems() {
        List<ItemEntity> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemEntity> updateItem(@RequestBody ItemEntity updatedItem) {
        ItemEntity updated = itemService.updateItem(updatedItem);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.ok("Item deleted");
    }
}
