--funcion de editar producto en inventario
CREATE OR REPLACE FUNCTION actualizar_inventario(id_producto integer, cantidad_a_restar integer) RETURNS boolean AS $$
DECLARE
    cantidad_actual integer;
BEGIN
   
    SELECT cantidad INTO cantidad_actual FROM inventario WHERE idproducto = id_producto;
    
    IF cantidad_actual >= cantidad_a_restar THEN
        
        UPDATE inventario SET cantidad = cantidad - cantidad_a_restar WHERE idproducto = id_producto;
        
        RETURN true;
    ELSE
        RETURN false;
    END IF;
END;
$$ LANGUAGE plpgsql;