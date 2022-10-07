package SpringBoot.Chapter06.Service;

import SpringBoot.Chapter06.Data.DTO.ProductDto;
import SpringBoot.Chapter06.Data.DTO.ProductResponseDto;
import SpringBoot.Chapter06.Repository.ProductRepository;

public interface ProductService {
    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);
    ProductResponseDto changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
