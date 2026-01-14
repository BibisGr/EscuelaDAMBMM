package progresa.escueladamb.controller;

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
//    listar todos los usuarios
    public ResponseEntity<List<Alumno>> List() {
        List<Alumno> list = alumnoService.getAlumnos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/buscarById/{id}")
    public ResponseEntity<?> buscarById(
            @PathVariable Long id
    ) {
        if (!alumnoService.existeAlumnoById(id)) {
            return new ResponseEntity((new
                    Mensaje("No existe un estudiante con ese id")),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(alumnoService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrar(
            @PathVariable Long id
    ){
        if(!alumnoService.existeAlumnoById(id)){
            return new ResponseEntity((new
                    Mensaje("No existe un estudiante con ese id")),
                    HttpStatus.BAD_REQUEST);
        }
        alumnoService.deleteAlumnoByID(id);
        return new ResponseEntity((new
                Mensaje("Estudiante Eliminado Correctamente")),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(
            @RequestBody AlumnoDTO alumnoDTO
    ){
        if(StringUtils.isBlank(alumnoDTO.getNombre())){
            return new ResponseEntity((new
                    Mensaje("El nombre es obligatorio")),
                    HttpStatus.BAD_REQUEST);
        }
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDTO.getNombre());
        List<Curso> cursos = new ArrayList<>();
//        for (CursoDTO cursoDTO :
//                alumnoDTO.getCursos()){
//            Curso curso = new Curso();
//            curso.setNombre(cursoDTO.getNombre());
//            curso.setCreditos(alumno.getCreditos());
//
////            curso.setAlumnos(alumno); //aqui se establece la relacion 1 a muchos
////            inscripciones.add(inscripcion);
//        }
//        estudiante.setInscripciones(inscripciones);
        alumnoService.saveAlumno(alumno);
        return new ResponseEntity((new
                Mensaje("Estudiante Creado Correctamente")),
                HttpStatus.OK);

    }

    @PostMapping("/{alumnoId}/agregar-cursos")
    public ResponseEntity<?> agregarCursosAAlumno(
            @PathVariable Long alumnoId,
            @RequestBody List<Long> cursosIds
    ) {
        // Validar que el alumno existe
        if (!alumnoService.existeAlumnoById(alumnoId)) {
            return new ResponseEntity((new
                    Mensaje("No existe un estudiante con ese id")),
                    HttpStatus.BAD_REQUEST);
        }

        // Validar que se proporcionaron IDs de cursos
        if (cursosIds == null || cursosIds.isEmpty()) {
            return new ResponseEntity((new
                    Mensaje("Debe proporcionar al menos un ID de curso")),
                    HttpStatus.BAD_REQUEST);
        }

        // Obtener el alumno
        Optional<Alumno> alumnoOpt = alumnoService.findById(alumnoId);
        if (alumnoOpt.isEmpty()) {
            return new ResponseEntity((new
                    Mensaje("Error al obtener el estudiante")),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Buscar todos los cursos usando CursoService
        List<Curso> cursos = cursoService.findAllById(cursosIds);

        // Validar que todos los cursos existen
        if (cursos.isEmpty() || cursos.size() != cursosIds.size()) {
            return new ResponseEntity((new
                    Mensaje("Uno o más cursos no fueron encontrados")),
                    HttpStatus.BAD_REQUEST);
        }

        // Agregar cursos al alumno
        Alumno alumno = alumnoOpt.get();
        alumno.getCursos().addAll(cursos);
        alumnoService.saveAlumno(alumno);

        return new ResponseEntity((new
                Mensaje("Cursos agregados correctamente al estudiante")),
                HttpStatus.OK);
    }
}
