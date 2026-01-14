package progresa.escueladamb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import progresa.escueladamb.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByNombre(String nombre);

    Optional<Curso> findByNombre(String nombre);
}
