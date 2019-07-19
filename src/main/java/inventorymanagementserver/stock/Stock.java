package inventorymanagementserver.stock;

import inventorymanagementserver.item.Item;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Item item;
    private int quantity;

    protected Stock() {}

    public Stock(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
