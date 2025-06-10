-- for development 
-- delete db if exists
DROP DATABASE IF EXISTS fundacion;

-- create db from zero
CREATE DATABASE fundacion;

-- select db
USE fundacion;


CREATE TABLE Padrino (
	dni INTEGER PRIMARY KEY NOT NULL,
	nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    direccion VARCHAR(20) NOT NULL,
    email VARCHAR(45) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    facebook VARCHAR(20) NOT NULL, 
    cod_postal INTEGER NOT NULL,
    telefono_fijo VARCHAR(20) NOT NULL,
    telefono_celular VARCHAR(20) NOT NULL
);


CREATE TABLE Contacto (
    dni_contacto INTEGER PRIMARY KEY,
	fecha_alta DATE NOT NULL,
    fecha_baja DATE,
    fecha_rechazo DATE,
    fecha_primer_contacto DATE NOT NULL,
    estado VARCHAR(45) NOT NULL,
    CONSTRAINT fk_padrinoContacto FOREIGN KEY (dni_contacto) REFERENCES Padrino(dni)
);

-- Crear tabla Donante
CREATE TABLE Donante (
    dni_donante INTEGER PRIMARY KEY,
	cuil BIGINT NOT NULL,
    ocupacion VARCHAR(45),
    CONSTRAINT fk_padrinoDonante FOREIGN KEY (dni_donante) REFERENCES Padrino(dni)
    ON DELETE CASCADE
);

DELIMITER $$

CREATE TRIGGER delete_donante
AFTER DELETE ON Donante
FOR EACH ROW
BEGIN
    DECLARE v_nombre VARCHAR(20);
    DECLARE v_apellido VARCHAR(20);
    DECLARE v_direccion VARCHAR(20);
    DECLARE v_email VARCHAR(45);
    DECLARE v_fecha_nacimiento DATE;
    DECLARE v_facebook VARCHAR(20);
    DECLARE v_cod_postal INT;
    DECLARE v_telefono_fijo INT;
    DECLARE v_telefono_celular INT;

    
    SELECT nombre, apellido, direccion, email, fecha_nacimiento, facebook, cod_postal, telefono_fijo, telefono_celular
    INTO v_nombre, v_apellido, v_direccion, v_email, v_fecha_nacimiento, v_facebook, v_cod_postal, v_telefono_fijo, v_telefono_celular
    FROM Padrino
    WHERE dni = OLD.dni_donante;

    
    INSERT INTO Auditoria_Donante (
        dni_donante, nombre_donante, apellido_donante, direccion_donante,
        email_donante, fecha_nacimiento_donante, facebook_donante,
        cod_postal_donante, telefono_fijo_donante, telefono_celular_donante,
        cuil_donante, ocupacion_donante, usuario
    ) VALUES (
        OLD.dni_donante, v_nombre, v_apellido, v_direccion,
        v_email, v_fecha_nacimiento, v_facebook,
        v_cod_postal, v_telefono_fijo, v_telefono_celular,
        OLD.cuil, OLD.ocupacion, USER()
    );
END$$

DELIMITER ;


-- Crear tabla Programa
CREATE TABLE Programa (
	id_programa INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre  VARCHAR(20) NOT NULL,
    descripcion VARCHAR(30) NOT NULL
);

-- simulacion de herencia, cada vez que registramos un medio de pago se busca el ultimo id, este es el que se guarda en la tabla correspondiente
-- es decir, estan sincronizados los id y no repetidos, dependen estrictamente de medio_pago, 
CREATE TABLE medio_pago (
  id_pago INTEGER PRIMARY KEY AUTO_INCREMENT,
  nombre_titular VARCHAR(40) NOT NULL,
  tipo ENUM ('debito', 'credito') NOT NULL
);

CREATE TABLE tarjeta_credito (
  id_tarjeta_credito INTEGER PRIMARY KEY,
  numero_tarjeta BIGINT NOT NULL,
  fecha_vencimiento VARCHAR(5) NOT NULL,
  nombre_titular VARCHAR(40) NOT NULL,
  CONSTRAINT fk_tarjeta_credito FOREIGN KEY (id_tarjeta_credito)
    REFERENCES medio_pago(id_pago)
    ON DELETE CASCADE
);

CREATE TABLE tarjeta_debito (
  id_tarjeta_debito INTEGER PRIMARY KEY,
  cbu VARCHAR(30) NOT NULL,
  fecha_vencimiento VARCHAR(5) NOT NULL,
  nombre_banco VARCHAR(20) NOT NULL,
  tipo_cuenta VARCHAR(20) NOT NULL,
  CONSTRAINT fk_tarjeta_debito FOREIGN KEY (id_tarjeta_debito)
    REFERENCES medio_pago(id_pago)
    ON DELETE CASCADE
);


-- Crear tabla Aporta
CREATE TABLE Aporta (
	dni_aporta INTEGER NOT NULL,
    id_programa_aporta INTEGER NOT NULL,
    id_mp INTEGER,
	PRIMARY KEY(dni_aporta, id_programa_aporta),
    frecuencia ENUM ('Semanal', 'Mensual') NOT NULL,
    monto INTEGER NOT NULL,
    CONSTRAINT fk_dniDonante FOREIGN KEY (dni_aporta) REFERENCES Donante(dni_donante),
	CONSTRAINT fk_idPrograma FOREIGN KEY (id_programa_aporta) REFERENCES Programa(id_programa),
    CONSTRAINT fk_idmp FOREIGN KEY (id_mp) REFERENCES medio_pago(id_pago)
    ON DELETE SET NULL
);
