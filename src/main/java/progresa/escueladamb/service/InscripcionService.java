package progresa.escueladamb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progresa.escueladamb.dao.AlumnoRepository;
import progresa.escueladamb.dao.CursoRepository;

@Service
@Transactional
public class InscripcionService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoRepository cursoRepository;
}
