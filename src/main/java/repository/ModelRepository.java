package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
