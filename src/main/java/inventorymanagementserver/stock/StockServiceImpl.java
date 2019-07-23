package inventorymanagementserver.stock;

import inventorymanagementserver.exception.InventoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock insert(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock findById(Long id) {
        String message = String.format("Stock with ID %s not found", id);
        return stockRepository.findById(id).orElseThrow(() -> new InventoryException(message));
    }

    @Override
    public Stock findByItemId(Long id) {
        String message = String.format("There's no stock for item with ID %s", id);
        Stock stock = stockRepository.findByItemId(id);
        if(stock == null){
            throw new InventoryException(message);
        }
        return stock;
    }

    @Override
    public List<Stock> findAll() {
        List<Stock> stocks = stockRepository.findAll();
        if(stocks.isEmpty()){
            throw new InventoryException("No stock/s found");
        }
        return stocks;
    }

    @Override
    public Stock update(Long stockId, int quantity) {
        Stock stock = findById(stockId);
        stock.setQuantity(quantity);
        return stockRepository.save(stock);
    }

    @Override
    public void deleteById(Long id) {
        if(!stockRepository.existsById(id)){
            String message = String.format("Stock with ID %s not found", id);
            throw new InventoryException(message);
        }
        stockRepository.deleteById(id);
    }
}
