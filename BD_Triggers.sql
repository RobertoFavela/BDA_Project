USE banco;

-- Trigger que evita cambiar el estado de una cuenta si tiene saldo distinto de cero
DELIMITER //
CREATE TRIGGER before_update_estado_cuenta
BEFORE UPDATE ON Cuentas
FOR EACH ROW
BEGIN
	IF NEW.estado = 'Inactiva' AND (SELECT saldo FROM Cuentas WHERE numero_cuenta = NEW.numero_cuenta) <> 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede cambiar el estado de la cuenta debido a que el saldo es distinto de 0';
	END IF;
END//
DELIMITER ;

-- Trigger que verifica si el saldo es suficiente para realizar una operación antes de insertarla
DELIMITER //
CREATE TRIGGER before_insert_operacion
BEFORE INSERT ON Operaciones
FOR EACH ROW
BEGIN
	DECLARE saldo_actual FLOAT;
	SELECT saldo INTO saldo_actual FROM Cuentas WHERE numero_cuenta = NEW.numero_cuenta;
	IF saldo_actual < NEW.monto THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saldo insuficiente para realizar la operación';
	END IF;
END//
DELIMITER ;

-- Trigger que actualiza los saldos después de una transferencia
DELIMITER //
CREATE TRIGGER after_insert_transferencia
AFTER INSERT ON Transferencias
FOR EACH ROW
BEGIN
	DECLARE monto_operacion FLOAT;
	SELECT monto INTO monto_operacion FROM Operaciones WHERE id_operacion = NEW.id_operacion;
	UPDATE Cuentas SET saldo = saldo - monto_operacion WHERE numero_cuenta = (SELECT numero_cuenta FROM Operaciones WHERE id_operacion = NEW.id_operacion);
	UPDATE Cuentas SET saldo = saldo + monto_operacion WHERE numero_cuenta = NEW.cuenta_envio;
END//
DELIMITER ;