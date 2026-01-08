package progresa.escueladamb.dao;

import progresa.escueladamb.entity.Inscripciones;

import java.util.List;

public interface InscripcionesRepository {
    List<Inscripciones> findByAlumnoId(Long alumnoId);
    List<Inscripciones> findByCursoId(Long cursoId);
    public boolean existsByAlumnoIdAndCursoId(Long id, Long cursoId);
}
