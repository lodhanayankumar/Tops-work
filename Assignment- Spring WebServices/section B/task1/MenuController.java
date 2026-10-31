
package com.example.foodmenu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    // In-memory food menu
    private List<MenuItem> menu = new ArrayList<>();

    // Constructor: Add three default food items
    public MenuController() {
        menu.add(new MenuItem(1, "Pizza", 250.00));
        menu.add(new MenuItem(2, "Burger", 120.00));
        menu.add(new MenuItem(3, "Paneer Tikka", 220.00));
    }

//get all food items
    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menu;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(
            @PathVariable int id) {

        for (MenuItem item : menu) {
            if (item.getId() == id) {
                return ResponseEntity.ok(item);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem newItem) {

        menu.add(newItem);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(newItem);
    }
}
