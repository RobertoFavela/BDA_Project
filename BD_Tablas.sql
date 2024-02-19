DROP DATABASE IF EXISTS banco;
CREATE DATABASE IF NOT EXISTS banco;
USE banco;

-- Tabla para almacenar información de los clientes
CREATE TABLE IF NOT EXISTS Clientes(
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(150),
    usuario VARCHAR(50),
    contraseña_hash CHAR(64) NOT NULL, -- Almacena la contraseña ya encriptada
    fecha_nacimiento DATE NOT NULL,
    domicilio VARCHAR(50)
);

-- Tabla para almacenar información de las cuentas
CREATE TABLE IF NOT EXISTS Cuentas(
	id_cuenta INT PRIMARY KEY AUTO_INCREMENT,
	numero_cuenta INT NOT NULL UNIQUE,
	estado varchar(30) NOT NULL,
	fecha_apertura DATE NOT NULL,
	saldo float(10.2) NOT NULL,
	id_cliente int not null,
	FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Tabla para registrar las operaciones realizadas en las cuentas
CREATE TABLE IF NOT EXISTS Operaciones(
	id_operacion INT PRIMARY KEY AUTO_INCREMENT,
	tipo varchar(30) NOT NULL,
	fecha_hora datetime NOT NULL,
	monto float(10.2) NOT NULL,
	numero_cuenta int NOT NULL,
	FOREIGN KEY (numero_cuenta) REFERENCES Cuentas(numero_cuenta)
);

-- Tabla para registrar los retiros de efectivo
CREATE TABLE IF NOT EXISTS Retiros(
	id_operacion int PRIMARY KEY AUTO_INCREMENT,
	folio int NOT NULL,
	contraseña int NOT NULL,
	fecha_hora_limite datetime NOT NULL,
	estado varchar(30) not null,
	FOREIGN KEY (id_operacion) REFERENCES Operaciones(id_operacion)
);

-- Tabla para registrar las transferencias entre cuentas
CREATE TABLE IF NOT EXISTS Transferencias(
	id_operacion int PRIMARY KEY AUTO_INCREMENT,
	cuenta_envio int NOT NULL,
	FOREIGN KEY (id_operacion) REFERENCES Operaciones(id_operacion)
);

