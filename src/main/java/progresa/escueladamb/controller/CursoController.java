package progresa.escueladamb.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progresa.escueladamb.dto.AlumnoDTO;
import progresa.escueladamb.dto.CursoDTO;
import progresa.escueladamb.dto.Mensaje;
import progresa.escueladamb.entity.Alumno;
import progresa.escueladamb.entity.Curso;
import progresa.escueladamb.service.AlumnoService;
import progresa.escueladamb.service.CursoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
//    listar todos los usuarios
    public ResponseEntity<List<Curso>> List() {
        List<Curso> list = cursoService.getCursos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/buscarById/{id}")
    public ResponseEntity<?> buscarById(
            @PathVariable Long id
    ) {
        if (!cursoService.existeCursoById(id)) {
            return new ResponseEntity((new
                    Mensaje("No existe un estudiante con ese id")),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(cursoService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrar(
            @PathVariable Long id
    ){
        if(!cursoService.existeCursoById(id)){
            return new ResponseEntity((new
                    Mensaje("No existe un estudiante con ese id")),
                    HttpStatus.BAD_REQUEST);
        }
        cursoService.deleteById(id);
        return new ResponseEntity((new
                Mensaje("Estudiante Eliminado Correctamente")),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(
            @RequestBody CursoDTO cursoDTO
    ){
        if(StringUtils.isBlank(cursoDTO.getNombre())){
            return new ResponseEntity((new
                    Mensaje("El nombre es obligatorio")),
                    HttpStatus.BAD_REQUEST);
        }
        if(cursoService.existeCursoByNombre(cursoDTO.getNombre())){
            return new ResponseEntity((new
                    Mensaje("Ese curso ya existe")),
                    HttpStatus.BAD_REQUEST);
        }

        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setCreditos(cursoDTO.getCreditos());

        cursoService.saveCurso(curso);
        return new ResponseEntity((new
                Mensaje("Curso creado correctamente")),
                HttpStatus.OK);
    }
}
