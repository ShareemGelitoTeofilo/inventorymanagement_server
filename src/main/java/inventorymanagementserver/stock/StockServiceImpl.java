package inventorymanagementserver.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock insert(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock findById(Long id) throws Exception {
        String message = String.format("Stock with ID %s not found", id);
        return stockRepository.findById(id).orElseThrow(() -> new Exception(message));
    }

    @Override
    public Stock findByItemId(Long id) throws Exception {
        String message = String.format("There's no stock for item with ID %s", id);
        Stock stock = stockRepository.findByItemId(id);
        if(stock == null){
            throw new Exception(message);
        }
        return stock;
    }

    @Override
    public List<Stock> findAll() throws Exception {
        List<Stock> stocks = stockRepository.findAll();
        if(stocks == null ||  stocks.isEmpty()){
            throw new Exception("No stocks found");
        }
        return stocks;
    }

    @Override
    public Stock update(Stock stock) throws Exception {
        Stock existingStock = findById(stock.getId());
        existingStock.setQuantity(stock.getQuantity());
        return stockRepository.save(existingStock);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        findById(id);
        stockRepository.deleteById(id);
    }
}
