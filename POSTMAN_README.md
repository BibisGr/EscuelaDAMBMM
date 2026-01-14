# Colecciones de Postman - EscuelaDAMB API

Este directorio contiene las colecciones de Postman para probar todos los endpoints de la aplicación EscuelaDAMB.

## 📁 Archivos Disponibles

- **Alumnos_Collection.postman_collection.json** - Colección de endpoints para gestión de alumnos
- **Cursos_Collection.postman_collection.json** - Colección de endpoints para gestión de cursos

## 🚀 Cómo Importar en Postman

1. Abre Postman
2. Haz clic en el botón **"Import"** (esquina superior izquierda)
3. Selecciona la pestaña **"File"**
4. Arrastra y suelta los archivos `.json` o haz clic en **"Upload Files"**
5. Selecciona los archivos de colección que deseas importar
6. Haz clic en **"Import"**

## 📋 Endpoints Disponibles

### Alumnos API

#### 1. **GET** `/alumnos/lista`
Obtiene la lista completa de todos los alumnos.

**Respuesta de ejemplo:**
```json
[
  {
    "id": 1,
    "nombre": "Juan",
    "apellidos": "Pérez García",
    "fechaNaciemiento": "2000-05-15",
    "dni": "12345678A",
    "email": "juan.perez@email.com",
    "cursos": []
  }
]
```

#### 2. **GET** `/alumnos/buscarById/{id}`
Busca un alumno específico por su ID.

**Parámetros:**
- `id` (path): ID del alumno

**Respuestas:**
- **200 OK**: Alumno encontrado
- **400 Bad Request**: No existe un estudiante con ese id

#### 3. **POST** `/alumnos/crear`
Crea un nuevo alumno.

**Body de ejemplo:**
```json
{
  "nombre": "María",
  "apellidos": "González López",
  "fechaNaciemiento": "1999-08-20",
  "dni": "87654321B",
  "email": "maria.gonzalez@email.com"
}
```

**Respuestas:**
- **200 OK**: Estudiante Creado Correctamente
- **400 Bad Request**: El nombre es obligatorio

#### 4. **DELETE** `/alumnos/delete/{id}`
Elimina un alumno por su ID.

**Parámetros:**
- `id` (path): ID del alumno a eliminar

**Respuestas:**
- **200 OK**: Estudiante Eliminado Correctamente
- **400 Bad Request**: No existe un estudiante con ese id

#### 5. **POST** `/alumnos/{alumnoId}/agregar-cursos`
Agrega una lista de cursos a un alumno.

**Parámetros:**
- `alumnoId` (path): ID del alumno

**Body de ejemplo:**
```json
[1, 2, 3]
```

**Respuestas:**
- **200 OK**: Cursos agregados correctamente al estudiante
- **400 Bad Request**: 
  - No existe un estudiante con ese id
  - Debe proporcionar al menos un ID de curso
  - Uno o más cursos no fueron encontrados

---

### Cursos API

#### 1. **GET** `/cursos/lista`
Obtiene la lista completa de todos los cursos.

**Respuesta de ejemplo:**
```json
[
  {
    "id": 1,
    "nombre": "Programación Java",
    "creditos": 6
  },
  {
    "id": 2,
    "nombre": "Bases de Datos",
    "creditos": 5
  }
]
```

#### 2. **GET** `/cursos/buscarById/{id}`
Busca un curso específico por su ID.

**Parámetros:**
- `id` (path): ID del curso

**Respuestas:**
- **200 OK**: Curso encontrado
- **400 Bad Request**: No existe un estudiante con ese id

#### 3. **POST** `/cursos/crear`
Crea un nuevo curso.

**Body de ejemplo:**
```json
{
  "nombre": "Programación Java",
  "creditos": 6
}
```

**Respuestas:**
- **200 OK**: Curso creado correctamente
- **400 Bad Request**: 
  - El nombre es obligatorio
  - Ese curso ya existe

#### 4. **DELETE** `/cursos/delete/{id}`
Elimina un curso por su ID.

**Parámetros:**
- `id` (path): ID del curso a eliminar

**Respuestas:**
- **200 OK**: Estudiante Eliminado Correctamente
- **400 Bad Request**: No existe un estudiante con ese id

## 🔧 Configuración

Las colecciones están preconfiguradas con:
- **Base URL**: `http://localhost:8080`
- **Content-Type**: `application/json`

Si tu aplicación corre en un puerto diferente, puedes modificar la variable `baseUrl` en cada colección.

## 💡 Ejemplos de Uso

### Flujo Completo de Trabajo

1. **Crear Cursos**
   ```
   POST /cursos/crear
   Body: {"nombre": "Java Avanzado", "creditos": 8}
   ```

2. **Crear Alumno**
   ```
   POST /alumnos/crear
   Body: {"nombre": "Pedro", "apellidos": "Martínez", ...}
   ```

3. **Listar Cursos** (para obtener IDs)
   ```
   GET /cursos/lista
   ```

4. **Agregar Cursos al Alumno**
   ```
   POST /alumnos/1/agregar-cursos
   Body: [1, 2, 3]
   ```

5. **Verificar Alumno con Cursos**
   ```
   GET /alumnos/buscarById/1
   ```

## 📝 Notas

- Cada colección incluye ejemplos de respuestas exitosas y errores comunes
- Los IDs en los ejemplos son ilustrativos, usa los IDs reales de tu base de datos
- Asegúrate de que la aplicación Spring Boot esté corriendo antes de probar los endpoints
- Todas las respuestas de error están documentadas con sus mensajes correspondientes

## ⚠️ Requisitos

- Postman instalado (Desktop o Web)
- Aplicación EscuelaDAMB corriendo en `localhost:8080`
- Base de datos configurada y conectada

## 🆘 Soporte

Si encuentras algún problema con las colecciones:
1. Verifica que la aplicación esté corriendo
2. Confirma que el puerto sea el correcto (8080 por defecto)
3. Revisa los logs de la aplicación para más detalles sobre errores

