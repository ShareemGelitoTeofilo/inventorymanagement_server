package inventorymanagementserver.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/item")
public class ItemResource {

    @Autowired
    private ItemService itemService;

    @PostMapping("/register")
    public Item registerItem(@RequestBody  Item item) throws Exception {
        return itemService.registerItem(item);
    }

    @GetMapping("/findById/{id}")
    public Item findById(@PathVariable  Long id) throws Exception {
        return itemService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public Item findByName(@PathVariable String name) throws Exception {
        return itemService.findByName(name);
    }

    @GetMapping("/findAll")
    public List<Item> findAll() throws Exception {
        return itemService.findAll();
    }

    @PostMapping("/update")
    public Item updateItem(@RequestBody Item item) throws Exception {
        return itemService.updateItem(item);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) throws Exception {
        itemService.deleteById(id);
    }

}
