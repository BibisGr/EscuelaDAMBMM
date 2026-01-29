package progresa.escueladamb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import progresa.escueladamb.entity.Curso;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    public  Optional<Curso> findByNombre(String nombre);
    public  boolean existsByNombre(String nombre);
}
