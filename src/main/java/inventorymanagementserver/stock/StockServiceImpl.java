package inventorymanagementserver.stock;

import inventorymanagementserver.exception.InventoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final static String NOT_FOUND = "Stock/s not found";
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock insert(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock findById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new InventoryException(NOT_FOUND));
    }

    @Override
    public Stock findByItemId(Long id) {
        Stock stock = stockRepository.findByItemId(id);
        if(stock == null){
            throw new InventoryException(NOT_FOUND);
        }
        return stock;
    }

    @Override
    public List<Stock> findAll() {
        List<Stock> stocks = stockRepository.findAll();
        if(stocks.isEmpty()){
            throw new InventoryException(NOT_FOUND);
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
            throw new InventoryException(NOT_FOUND);
        }
        stockRepository.deleteById(id);
    }
}
