CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      role ENUM('USER', 'ADMIN') DEFAULT 'USER'
);

create table usuarios(

                         id bigint not null auto_increment,
                         login varchar(100) not null,
                         clave varchar(300) not null,

                         primary key(id)

);


CREATE TABLE course (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        description TEXT
);

CREATE TABLE topic (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       message LONGTEXT NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       status ENUM('OPEN', 'CLOSED') DEFAULT 'OPEN',
                       author_id BIGINT NOT NULL,
                       course_id BIGINT NOT NULL,
                       FOREIGN KEY (author_id) REFERENCES user(id),
                       FOREIGN KEY (course_id) REFERENCES course(id)
);


INSERT INTO course (id, name, description) VALUES
                                                       (1, 'Matematica', 'Matematicas simples'),
                                                       (2, 'Fisica', 'Introducción a la física básica'),
                                                       (3, 'Programación en Java', 'Conceptos básicos y avanzados de Java'),
                                                       (4, 'Historia', 'Historia del siglo XX'),
                                                       (5, 'Diseño Gráfico', 'Diseño y herramientas creativas para principiantes');


INSERT INTO user (id, name, email, password, role) VALUES
                                                               (1, 'Juan Pérez', 'juan.perez@example.com', 'hashedpassword1', 'USER'),
                                                               (2, 'Ana López', 'ana.lopez@example.com', 'hashedpassword2', 'USER'),
                                                               (3, 'Carlos García', 'carlos.garcia@example.com', 'hashedpassword3', 'USER'),
                                                               (4, 'Maria Fernández', 'maria.fernandez@example.com', 'hashedpassword4', 'ADMIN'),
                                                               (5, 'Luis Martínez', 'luis.martinez@example.com', 'hashedpassword5', 'USER');

INSERT INTO topic (id, title, message, created_at, status, author_id, course_id) VALUES
                                                                                             (1, 'Cómo resolver ecuaciones', 'Tengo problemas con ecuaciones cuadráticas, ¿alguien puede ayudar?', '2024-12-01 10:00:00', 'OPEN', 1, 1),
                                                                                             (2, 'Movimiento rectilíneo uniforme', '¿Cuál es la fórmula para calcular la distancia en un MRU?', '2024-12-02 15:30:00', 'OPEN', 2, 2),
                                                                                             (3, 'Problemas con bucles en Java', '¿Cómo funciona el bucle for en Java?', '2024-12-03 08:45:00', 'OPEN', 3, 3),
                                                                                             (4, 'Eventos históricos clave', '¿Cuáles son los eventos más importantes del siglo XX?', '2024-12-04 12:00:00', 'CLOSED', 4, 4),
                                                                                             (5, 'Mejores herramientas de diseño', '¿Qué software recomiendan para diseño gráfico?', '2024-12-05 17:20:00', 'OPEN', 5, 5);
