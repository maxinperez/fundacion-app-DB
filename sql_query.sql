-- a) Devolver por cada programa, el total de aportes mensuales
SELECT id_programa_aporta, SUM(monto) FROM Aporta
GROUP BY id_programa_aporta;

-- b) Devolver los donantes que aportan a más de dos programas.
SELECT *
FROM Donante
WHERE dni_donante IN (
    SELECT dni_aporta
    FROM Aporta
    GROUP BY dni_aporta
    HAVING COUNT(id_programa_aporta) > 2
);

-- c) Listado de Donantes con aportes mensuales y los datos de los medios de
-- pago..
SELECT d.dni_donante, d.cuil, d.ocupacion, a.frecuencia, a.monto, mp.id_pago, mp.nombre_titular, mp.tipo, tc.numero_tarjeta, tc.fecha_vencimiento as fv_credito, 
td.cbu, td.fecha_vencimiento as fv_debito, td.nombre_banco, td.tipo_cuenta
FROM Donante as d
JOIN Aporta as a ON d.dni_donante = a.dni_aporta
JOIN medio_pago as mp ON a.id_mp = mp.id_pago
LEFT JOIN tarjeta_credito as  tc ON mp.id_pago = tc.id_tarjeta_credito
LEFT JOIN tarjeta_debito as td ON mp.id_pago = td.id_tarjeta_debito
WHERE a.frecuencia = 'Mensual';

