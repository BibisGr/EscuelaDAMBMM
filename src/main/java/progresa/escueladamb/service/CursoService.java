package progresa.escueladamb.service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progresa.escueladamb.dao.AlumnoRepository;
import progresa.escueladamb.dao.CursoRepository;
import progresa.escueladamb.entity.Alumno;
import progresa.escueladamb.entity.Curso;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getCursos(){
        return cursoRepository.findAll();
    }
    public void saveCurso(Curso curso){
        cursoRepository.save(curso);
    }
    public void deleteById(Long id){
        cursoRepository.deleteById(id);
    }

    public boolean existeCursoById(Long id){
        return cursoRepository.existsById(id);
    }
    public boolean existeCursoByNombre(String nombre){
        return cursoRepository.existsByNombre(nombre);
    }
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }
    public Optional<Curso> findByNombre(String nombre) {
        return cursoRepository.findByNombre(nombre);
    }

    public List<Curso> findAllById(List<Long> ids) {
        return cursoRepository.findAllById(ids);
    }

}
