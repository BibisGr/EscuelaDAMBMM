package progresa.escueladamb.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progresa.escueladamb.dto.CursoDTO;
import progresa.escueladamb.dto.Mensaje;
import progresa.escueladamb.entity.Curso;
import progresa.escueladamb.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> List(){
        List<Curso> list = cursoService.getCursos();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/buscarById/{id}")
    public ResponseEntity<?> buscarById(Long id){
        if(!cursoService.existeCursoById(id)){
            return new ResponseEntity(new Mensaje("Curso no encontrado"),
                    HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(cursoService.findById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(Long id){
        if(!cursoService.existeCursoById(id)){
            return new ResponseEntity(new Mensaje("Curso no encontrado"),
                    HttpStatus.NOT_FOUND);
        }
        cursoService.deleteById(id);
        return new ResponseEntity(new Mensaje("Curso eliminado"),
                HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> crear(
            @RequestBody CursoDTO cursoDTO
            )
    {
        if(StringUtils.isBlank(cursoDTO.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre curso no puede estar vacio"),
                    HttpStatus.BAD_REQUEST);
        }
        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setCreditos(cursoDTO.getCreditos());

        cursoService.saveCurso(curso);
        return new ResponseEntity(new Mensaje("Curso creado correctamente"),
                HttpStatus.CREATED);

    }
}
