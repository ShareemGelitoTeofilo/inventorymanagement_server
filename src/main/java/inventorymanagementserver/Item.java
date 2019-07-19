package inventorymanagementserver;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Category category;
    private double price;

    protected Item(){}

    public Item(String name, String brand, String color, Category category, double price) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}
