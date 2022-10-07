package SpringBoot.Chapter06.Data.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ChangeProductNameDto {
    private Long number;
    private String name;
}
