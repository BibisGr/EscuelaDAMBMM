package progresa.escueladamb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import progresa.escueladamb.entity.Alumno;

import java.util.Optional;

public interface AlumnoRepository  extends JpaRepository<Alumno, Long> {
}
