-- select db
USE fundacion;

INSERT INTO Padrino (dni, nombre, apellido, direccion, email, fecha_nacimiento, facebook, cod_postal, telefono_fijo, telefono_celular)
VALUES
(41234567, 'Carlos', 'Pérez', 'Lamadrid 0918', 'carlos.perez@gmail.com', '1980-06-15', 'carlosp', 1406, 1144556677, 1167891234),
(23456789, 'Ana', 'García', 'Av. Siempre Viva 742', 'ana.garcia@yahoo.com', '1992-11-23', 'anag', 1425, 1144332211, 1156784321),
(35123049, 'Luis', 'Martínez', 'Mitre 456', 'luis.martinez@hotmail.com', '1985-01-10', 'luism', 1414, 1133221100, 1177654433);

INSERT INTO Contacto (dni_contacto, fecha_alta, fecha_baja, fecha_rechazo, fecha_primer_contacto, estado)
VALUES
(41234567, '2024-01-01', NULL, NULL, '2023-12-20', 'adherido'),
(23456789, '2023-06-15', '2024-04-10', NULL, '2023-06-01', 'baja'),
(35123049, '2022-03-10', NULL, '2022-03-20', '2022-03-01', 'error');

INSERT INTO Donante (dni_donante, cuil, ocupacion)
VALUES
(41234567, 24412345679, 'Contador'),
(23456789, 27234567890, 'Docente');

INSERT INTO Programa (nombre, descripcion)
VALUES
('Educación', 'Becas escolares'),
('Salud', 'Atención médica primaria'),
('Alimentación', 'Desayunos y almuerzos');

INSERT INTO medio_pago (nombre_titular, tipo)
VALUES
('Carlos Pérez', 'credito');

INSERT INTO tarjeta_credito (id_tarjeta_credito, numero_tarjeta, fecha_vencimiento, nombre_titular)
VALUES
(LAST_INSERT_ID(), 4111222233334444, '12/26', 'Carlos Pérez');

INSERT INTO medio_pago (nombre_titular, tipo)
VALUES
('Ana García', 'debito');

INSERT INTO tarjeta_debito (id_tarjeta_debito, cbu, fecha_vencimiento, nombre_banco, tipo_cuenta)
VALUES
(LAST_INSERT_ID(), '2850590940090412345671', '11/25', 'Banco Nación', 'Caja de Ahorro');

INSERT INTO Aporta (dni_aporta, id_programa_aporta, id_mp, frecuencia, monto)
VALUES
(41234567, 1, 1, 'Mensual', 5000),
(41234567, 2, 1, 'Mensual', 4000),
(41234567, 3, 1, 'Mensual', 8000),
(23456789, 2, 2, 'Semanal', 1500);


