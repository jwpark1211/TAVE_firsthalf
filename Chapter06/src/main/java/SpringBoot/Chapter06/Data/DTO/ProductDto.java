package SpringBoot.Chapter06.Data.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
