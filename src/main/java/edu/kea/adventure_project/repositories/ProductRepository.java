package edu.kea.adventure_project.repositories;

import edu.kea.adventure_project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Julius Panduro
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
