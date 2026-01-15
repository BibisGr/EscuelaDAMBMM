package progresa.escueladamb.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progresa.escueladamb.dto.AlumnoDTO;
import progresa.escueladamb.dto.Mensaje;
import progresa.escueladamb.entity.Alumno;
import progresa.escueladamb.entity.Curso;
import progresa.escueladamb.service.AlumnoService;
import progresa.escueladamb.service.CursoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Alumno>> List(){
        List<Alumno> list = alumnoService.getAlumnos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/buscarById/{id}")
    public ResponseEntity<?> buscarById(Long id){
        if(!alumnoService.existeAlumnoById(id)){
            return new ResponseEntity(new Mensaje("Alumno no encontrado"),
                    HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(alumnoService.findById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(Long id){
        if(!alumnoService.existeAlumnoById(id)){
            return new ResponseEntity(new Mensaje("Curso no encontrado"),
                    HttpStatus.NOT_FOUND);
        }
        alumnoService.deleteAlumnoById(id);
        return new ResponseEntity(new Mensaje("Curso eliminado"),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> crear(
            @RequestBody AlumnoDTO alumnoDTO
            ){
        if (StringUtils.isBlank(alumnoDTO.getNombre())){
            return  new ResponseEntity(new Mensaje("El nombre alumno no puede estar vacio")
            ,HttpStatus.BAD_REQUEST);
        }
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDTO.getNombre());
        List<Curso> cursos = new ArrayList<>();

        alumnoService.saveAlumno(alumno);
        return new ResponseEntity(new Mensaje("Alumno creado correctamente"),
                HttpStatus.CREATED);
    }

    @PostMapping("/{idAlumno}/agregar-cursos")
    public ResponseEntity<?> agregarCursosAAlumno(
            @PathVariable Long idAlumno,
            @RequestBody List<Long> cursoIds
    ){
        if(!alumnoService.existeAlumnoById(idAlumno)){
            return new ResponseEntity(new Mensaje("Alumno no encontrado"),
                    HttpStatus.NOT_FOUND);
        }
        if(cursoIds == null || cursoIds.isEmpty()){
            return  new ResponseEntity(new Mensaje("Debe proporcionar al menos un ID de curso"),
                    HttpStatus.BAD_REQUEST);
        }
        //obtener el estudiante
        Optional<Alumno> alumnoOpt =
                alumnoService.findById(idAlumno);

        if (alumnoOpt.isEmpty()){
            return new ResponseEntity(new Mensaje("Alumno no encontrado"),
                    HttpStatus.NOT_FOUND);
        }

        List<Curso> cursos = cursoService.findAllById(cursoIds);

        //verifica que el listado de cursos del alumno tenga
        //el mismo tamaño que los listado de ids proporcionados
        if(cursos.isEmpty() || cursos.size() !=cursoIds.size()){
            new ResponseEntity(new Mensaje("Uno o mas cursos no fueron encontrados"),
                    HttpStatus.BAD_REQUEST);
        }

        Alumno alumno = alumnoOpt.get();
        alumno.getCursos().addAll(cursos);
        alumnoService.saveAlumno(alumno);
        return new ResponseEntity(new Mensaje("Cursos agregados al alumno correctamente"),
                HttpStatus.OK);
    }
}
