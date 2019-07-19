package inventorymanagementserver.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock insert(Stock stock) {
        return stockRepository.save(stock);
    }
}
