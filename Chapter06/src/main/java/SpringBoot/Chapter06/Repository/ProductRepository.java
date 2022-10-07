package SpringBoot.Chapter06.Repository;

import SpringBoot.Chapter06.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO(Data Access Object)의 역할은 스프링 데이터 jpa에서 리포지토리가 대체
public interface ProductRepository extends JpaRepository<Product,Long> {
}
