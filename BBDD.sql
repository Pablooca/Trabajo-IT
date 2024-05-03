CREATE DATABASE trabajo_it;

USE trabajo_it;

CREATE TABLE Empleado (
    DNI VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    direccion VARCHAR(255),
    cargo VARCHAR(50),
    departamento INT NOT NULL,
    id_ascensos INT,
    contrasena VARCHAR(255) NOT NULL
);

-- Crear tabla Departamento
CREATE TABLE Departamento (
    ID INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    gerente VARCHAR(20) NOT NULL,
    descripcion VARCHAR(255)
);

ALTER TABLE Departamento
ADD CONSTRAINT FK_departamento_gerente FOREIGN KEY (gerente) REFERENCES Empleado(DNI);

ALTER TABLE Empleado
ADD CONSTRAINT FK_empleado_departamento FOREIGN KEY (departamento) REFERENCES Departamento(ID);

-- Crear tabla Evaluación
CREATE TABLE Evaluacion (
    ID INT PRIMARY KEY,
    DNI VARCHAR(20) NOT NULL,
    anyo INT NOT NULL,
    companyerismo INT NOT NULL,
    eficiencia INT NOT NULL,
    iniciativa INT NOT NULL,
    liderazgo INT NOT NULL,
    nota_media DECIMAL(3,2) NOT NULL,
    FOREIGN KEY (DNI) REFERENCES Empleado(DNI)
);

-- Crear tabla Nómina
CREATE TABLE Nomina (
    ID INT PRIMARY KEY,
    salario DECIMAL(10,2) NOT NULL,
    DNI VARCHAR(20) NOT NULL,
    FOREIGN KEY (DNI) REFERENCES Empleado(DNI)
);

-- Crear tabla Vacaciones
CREATE TABLE Vacaciones (
    ID INT PRIMARY KEY,
    DNI VARCHAR(20) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    motivo VARCHAR(255),
    FOREIGN KEY (DNI) REFERENCES Empleado(DNI)
);

-- Crear tabla Ascensos
CREATE TABLE Ascensos (
    ID INT PRIMARY KEY,
    cargo VARCHAR(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    jefe_departamento Varchar(20) NOT NULL,
    requisitos VARCHAR(255),
    FOREIGN KEY (jefe_departamento) REFERENCES Departamento(gerente)
);

ALTER TABLE Empleado
ADD CONSTRAINT FK_empleado_ascenso FOREIGN KEY (id_ascensos) REFERENCES Ascensos(ID);