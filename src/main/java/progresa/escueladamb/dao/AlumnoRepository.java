package progresa.escueladamb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import progresa.escueladamb.entity.Alumno;

import java.util.Optional;

public interface AlumnoRepository  extends JpaRepository<Alumno, Long> {
    public Optional<Alumno> findById(Long id);
    public boolean existsById(Long id);
    public Optional<Alumno> findByNombre(String nombre);
    Optional<Alumno> findByApellidos(String apellidos);

    boolean existsByDni(String dni);

    Optional<Alumno> findByDni(String dni);
}
