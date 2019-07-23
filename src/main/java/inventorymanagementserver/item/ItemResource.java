package inventorymanagementserver.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/item")
public class ItemResource {

    @Autowired
    private ItemService itemService;

    @PostMapping("/insert")
    public Item insert(@RequestBody  Item item) {
        return itemService.insert(item);
    }

    @GetMapping("/findById/{id}")
    public Item findById(@PathVariable  Long id) {
        return itemService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public Item findByName(@PathVariable String name) {
        return itemService.findByName(name);
    }

    @GetMapping("/findAll")
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @PostMapping("/update")
    public Item updateItem(@RequestBody Item item) {
        return itemService.update(item);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}
