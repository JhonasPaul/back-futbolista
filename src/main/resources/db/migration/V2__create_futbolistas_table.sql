CREATE TABLE IF NOT EXISTS futbolistas
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    posicion_id      BIGINT       NOT NULL,
    apellidos        VARCHAR(250) NOT NULL,
    caracteristicas  VARCHAR(250) NOT NULL,
    fecha_nacimiento DATE         NOT NULL,
    nombres          VARCHAR(250) NOT NULL,
    FOREIGN KEY (posicion_id) REFERENCES posiciones (id)
);