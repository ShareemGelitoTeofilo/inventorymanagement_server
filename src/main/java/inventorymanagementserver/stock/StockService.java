package inventorymanagementserver.stock;

public interface StockService {
    Stock insert(Stock stock);
    Stock findById(Long id) throws Exception;
    Stock findByItemId(Long id) throws Exception;
}
