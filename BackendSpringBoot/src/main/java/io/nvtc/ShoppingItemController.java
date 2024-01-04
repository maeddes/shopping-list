package io.nvtc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ShoppingItemController {

    @Autowired
    private ShoppingItemRepository shoppingItemRepository;

    @GetMapping
    public List<ShoppingItem> getShoppingItems() {
        return shoppingItemRepository.findAll();
    }

    @PostMapping
    public ShoppingItem createShoppingItem(@RequestBody ShoppingItem item) {
        return shoppingItemRepository.save(item);
    }

    @PostMapping("/{name}")
    public ShoppingItem createShoppingItem(@PathVariable String name) {
        return shoppingItemRepository.save(new ShoppingItem(name));
    }

    @GetMapping("/{name}")
    public ShoppingItem getShoppingItemByName(@PathVariable String name) {
        return shoppingItemRepository.findById(name).orElse(null);
    }

    @PutMapping("/{name}")
    public ShoppingItem updateShoppingItem(@PathVariable String name, @RequestBody ShoppingItem item) {
        return shoppingItemRepository.save(item);
    }

    @DeleteMapping("/{name}")
    public void deleteShoppingItem(@PathVariable String name) {
        shoppingItemRepository.deleteById(name);
    }
}
