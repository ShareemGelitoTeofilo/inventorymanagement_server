package inventorymanagementserver.stock;

import java.util.List;

public interface StockService {
    Stock insert(Stock stock);
    Stock findById(Long id) throws Exception;
    Stock findByItemId(Long id) throws Exception;
    List<Stock> findAll() throws Exception;
    Stock update(Stock stock) throws Exception;
}
