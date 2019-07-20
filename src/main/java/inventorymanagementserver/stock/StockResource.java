package inventorymanagementserver.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/stock")
public class StockResource {

    @Autowired
    private StockService stockService;

    @PostMapping("/insert")
    public Stock insert(@RequestBody Stock stock) {
        return stockService.insert(stock);
    }

    @GetMapping("/findById/{id}")
    public Stock findById(@PathVariable Long id) throws Exception {
        return stockService.findById(id);
    }

    @GetMapping("/findByItemId/{id}")
    public Stock findByItemId(@PathVariable Long id) throws Exception {
        return stockService.findByItemId(id);
    }

    @GetMapping("/findAll")
    public List<Stock> findAll() throws Exception {
        return stockService.findAll();
    }

    @PostMapping("/update")
    public Stock update(@RequestBody Stock stock) throws Exception {
        return stockService.update(stock);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) throws Exception {
        stockService.deleteById(id);
    }
}
