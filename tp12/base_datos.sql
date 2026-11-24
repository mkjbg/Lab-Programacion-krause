CREATE DATABASE IF NOT EXISTS ejercitacion12;
USE ejercitacion12;

CREATE TABLE IF NOT EXISTS estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    apellido VARCHAR(60) NOT NULL,
    dni INT NOT NULL,
    curso VARCHAR(30) NOT NULL
);

-- Ejecutar esta línea solamente si se quiere comenzar nuevamente
-- con una tabla vacía y que los nuevos registros reciban IDs desde 1:
-- TRUNCATE TABLE estudiantes;
