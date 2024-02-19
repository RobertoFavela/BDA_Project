USE banco;

-- Procedimiento almacenado para actualizar el saldo de una cuenta
DELIMITER //
CREATE PROCEDURE ActualizarSaldo(
	IN p_numero_cuenta INT, 
    IN cantidad FLOAT
)
BEGIN
	UPDATE Cuentas SET saldo = saldo + cantidad WHERE numero_cuenta = p_numero_cuenta;
END//
DELIMITER ;

-- Procedimiento almacenado para crear un nuevo retiro con folio, contraseña y fecha límite automáticos
DELIMITER //
CREATE PROCEDURE CrearRetiro(
	IN p_id_operacion INT, 
    OUT p_folio INT, 
    OUT p_contrasena INT
)
BEGIN
	DECLARE v_fecha_hora_limite DATETIME;
	SET p_folio = IFNULL((SELECT MAX(folio) FROM Retiros), 1000) + 1;
	SET p_contrasena = FLOOR(RAND() * 100000000);
	SET v_fecha_hora_limite = NOW() + INTERVAL 10 MINUTE;
	INSERT INTO Retiros (id_operacion, folio, contraseña, fecha_hora_limite, estado)
	VALUES (p_id_operacion, p_folio, p_contrasena, v_fecha_hora_limite, 'Activo');
END//
DELIMITER ;

-- Procedimiento almacenado para realizar un retiro
DELIMITER //
CREATE PROCEDURE RealizarRetiro(
	IN p_folio INT, 
    IN p_contrasena INT, 
    OUT p_monto FLOAT
    )
BEGIN
    DECLARE v_id_operacion INT;
    DECLARE v_numero_cuenta INT;
    DECLARE v_saldo_actual FLOAT;  -- Variable para almacenar el saldo actual de la cuenta

    -- Obtener la información del retiro y la cuenta asociada
    SELECT Retiros.id_operacion, numero_cuenta INTO v_id_operacion, v_numero_cuenta FROM Retiros 
    INNER JOIN Operaciones ON Retiros.id_operacion = Operaciones.id_operacion
    WHERE folio = p_folio AND contraseña = p_contrasena AND estado = 'Activo';

    IF v_id_operacion IS NOT NULL THEN
        -- Obtener el monto del retiro
        SELECT monto INTO p_monto FROM Operaciones WHERE id_operacion = v_id_operacion;

        -- Obtener el saldo actual de la cuenta
        SELECT saldo INTO v_saldo_actual FROM Cuentas WHERE numero_cuenta = v_numero_cuenta;

        -- Verificar si el saldo actual es suficiente para cubrir el retiro
        IF v_saldo_actual >= p_monto THEN
            -- Realizar el retiro y actualizar el estado del retiro y el saldo de la cuenta
            UPDATE Retiros SET estado = 'Cobrado' WHERE folio = p_folio AND contraseña = p_contrasena;
            UPDATE Cuentas SET saldo = saldo - p_monto WHERE numero_cuenta = v_numero_cuenta;
        ELSE
            -- Si el saldo no es suficiente, establecer el monto en NULL y cambiar el estado de la operación a "Cancelado"
            SET p_monto = NULL;
            UPDATE Operaciones SET estado = 'Cancelado' WHERE id_operacion = v_id_operacion;
        END IF;
    ELSE
        -- Si no se encuentra el retiro, establecer el monto en NULL
        SET p_monto = NULL;
    END IF;
END//
DELIMITER ;

-- Procedimiento almacenado para insertar un nuevo cliente en la base de datos
DELIMITER //
CREATE PROCEDURE InsertarCliente(
    IN p_nombre VARCHAR(150),
    IN p_usuario VARCHAR(50),
    IN p_contraseña VARCHAR(30),
    IN p_fecha_nacimiento DATE,
    IN p_domicilio VARCHAR(50)
)
BEGIN
    DECLARE hashed_password CHAR(64);
    SET hashed_password = SHA2(p_contraseña, 256); -- Calcula el hash de la contraseña

    INSERT INTO Clientes (nombre, usuario, contraseña_hash, fecha_nacimiento, domicilio)
    VALUES (p_nombre, p_usuario, hashed_password, p_fecha_nacimiento, p_domicilio);
END//
DELIMITER ;

-- Procedimiento almacenado para verificar la contraseña de un cliente
DELIMITER //
CREATE PROCEDURE VerificarContraseña(
    IN p_usuario VARCHAR(50),
    IN p_contraseña VARCHAR(30),
    OUT p_valido BOOLEAN
)
BEGIN
    DECLARE hashed_password CHAR(64);
    DECLARE stored_password CHAR(64);

    SELECT contraseña_hash INTO stored_password FROM Clientes WHERE usuario = p_usuario;
    SET hashed_password = SHA2(p_contraseña, 256);

    IF hashed_password = stored_password THEN
        SET p_valido = TRUE;
    ELSE
        SET p_valido = FALSE;
    END IF;
END//
DELIMITER ;