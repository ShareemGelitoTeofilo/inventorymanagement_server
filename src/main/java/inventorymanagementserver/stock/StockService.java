package inventorymanagementserver.stock;

import java.util.List;

public interface StockService {
    Stock insert(Stock stock);
    Stock findById(Long id);
    Stock findByItemId(Long id);
    List<Stock> findAll();
    Stock update(Long stockId, int quantity);
    void deleteById(Long id);
}
