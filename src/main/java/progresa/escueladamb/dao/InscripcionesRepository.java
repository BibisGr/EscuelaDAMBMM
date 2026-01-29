package progresa.escueladamb.dao;

import progresa.escueladamb.entity.Inscripciones;

import java.util.List;

public interface InscripcionesRepository {
    public List<Inscripciones> findByAlumnoId(Long alumnoId);
    public List<Inscripciones> findByCursoId(Long cursoId);
    public boolean existsByAlumnoIdAndCursoId(Long id, Long cursoId);
}
