package inventorymanagementserver.item;

import inventorymanagementserver.category.Category;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String color;
    @OneToOne
    private Category category;
    private double price;

    protected Item(){}

    public Item(String name, String brand, String color, Category category, double price) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.category = category;
        this.price = price;
    }
}
