package inventorymanagementserver.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public Stock findById(@PathVariable Long id) {
        return stockService.findById(id);
    }

    @GetMapping("/findByItemId/{id}")
    public Stock findByItemId(@PathVariable Long id) {
        return stockService.findByItemId(id);
    }

    @GetMapping("/findAll")
    public List<Stock> findAll() {
        return stockService.findAll();
    }

    @PostMapping("/update")
    public Stock update(@Param("stockId") Long stockId, @Param("quantity") int quantity) {
        return stockService.update(stockId, quantity);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        stockService.deleteById(id);
    }
}
