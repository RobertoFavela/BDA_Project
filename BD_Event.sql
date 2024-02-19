USE banco;

-- Evento que actualiza el estado de los retiros caducados cada minuto
DELIMITER //
CREATE EVENT ActualizarEstadoRetiros
ON SCHEDULE EVERY 1 MINUTE
DO
BEGIN
	UPDATE Retiros SET estado = 'Caducado'
	WHERE estado = 'Activo' AND fecha_hora_limite < NOW();
END//
DELIMITER ;