
# ForoHub

**ForoHub** es una API RESTful desarrollada con **Spring Boot** que facilita la gestión de foros en línea, permitiendo la creación, administración y participación en tópicos y respuestas de manera eficiente.

## Características Principales 🚀

- **Gestión de Tópicos**: Crea, actualiza, elimina y visualiza tópicos en el foro.
- **Respuestas a Tópicos**: Participa en discusiones respondiendo a los tópicos existentes.
- **Autenticación y Autorización**: Seguridad implementada mediante **JWT (JSON Web Tokens)** para garantizar que solo usuarios autorizados accedan a ciertas funcionalidades.
- **Gestión de Usuarios**: Registro y manejo de perfiles de usuario.
- **Documentación Interactiva**: Explora y prueba los endpoints de la API utilizando **Swagger UI**.

## Tecnologías Utilizadas 🛠️

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Flyway**
- **Swagger UI**

## Instalación y Configuración ⚙️

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/enriquevaldivia1988/ForoHub.git
   cd ForoHub
   ```

2. **Configura la base de datos**:

   - Crea una base de datos en MySQL llamada `forohub`.
   - Actualiza las credenciales de la base de datos en el archivo `src/main/resources/application.properties`:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/forohub
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     ```

3. **Ejecuta las migraciones de Flyway** para configurar las tablas necesarias:

   ```bash
   mvn flyway:migrate
   ```

4. **Compila y ejecuta la aplicación**:

   ```bash
   mvn spring-boot:run
   ```

## Documentación de la API 📖

Una vez que la aplicación esté en funcionamiento, puedes acceder a la documentación interactiva de la API a través de **Swagger UI** en la siguiente URL:

```
http://localhost:8080/swagger-ui/index.html
```

Aquí podrás explorar los distintos endpoints disponibles, probar las funcionalidades y comprender mejor cómo interactuar con la API.

## Endpoints Principales 🔗

### Authentication
- **POST** `/login`: Authenticate a user and receive a JWT token.

### Users
- **POST** `/users`: Crear un nuevo usuario.
- **GET** `/users/{id}`: Obtener un usuario por ID.
- **GET** `/users`: Obtener todos los usuarios.
- **DELETE** `/users/{id}`: Eliminar un usuario por ID.

### Courses
- **POST** `/courses`: Crear un nuevo curso.
- **GET** `/courses/{id}`: Obtener un curso por ID.
- **GET** `/courses`: Obtener todos los cursos.
- **DELETE** `/courses/{id}`: Eliminar un curso por ID.

### Topics
- **POST** `/topics`: Crear un nuevo tópico.
- **GET** `/topics/{id}`: Obtener un tópico por ID.
- **GET** `/topics`: Obtener todos los tópicos.
- **GET** `/topics/search`: Buscar tópicos por nombre del curso y año.
- **DELETE** `/topics/{id}`: Eliminar un tópico por ID.
- **PUT** `/topics/{id}`: Actualizar un tópico por ID.

## Contribuciones 🤝

¡Las contribuciones son bienvenidas! Si deseas mejorar ForoHub, por favor:

1. **Haz un fork** del repositorio.
2. **Crea una nueva rama** para tu funcionalidad o corrección:

   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```

3. **Realiza tus cambios** y asegúrate de que el código pase todas las pruebas.
4. **Envía un pull request** detallando los cambios realizados.

## Licencia 📄

Este proyecto está bajo la **Licencia MIT**. Consulta el archivo `LICENSE` para más detalles.

---

¡Gracias por utilizar ForoHub! Esperamos que esta herramienta facilite la gestión y participación en foros de discusión. Si tienes alguna pregunta o sugerencia, no dudes en contactarnos. 😊
