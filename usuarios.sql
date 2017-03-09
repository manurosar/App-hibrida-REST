- COMO ROOT PARA CREAR LA BBDD Y EL USUARIO

-- Mostrar los CHARSETs instalados:
SHOW CHARACTER SET;
-- Mostrar COLLATIONS instalados:
SHOW COLLATION;
-- CREAMOS LA BBDD PARA UTF-8 COLLATION EN ESPAÑOL
CREATE DATABASE gestion_pedido  
    CHARACTER SET utf8 COLLATE utf8_spanish_ci;


-- CREAMOS EL USUARIO 
DROP USER damuser05;
CREATE USER damuser05 IDENTIFIED BY 'damuser';

-- DAMOS PERMISOS EN LA BBDD PARA EL NUEVO USUARIO
grant all privileges on gestion_pedido.* to 'damuser05'@'%' identified by 'damuser';
grant all privileges on gestion_pedido.* to 'damuser05'@'localhost' identified by 'damuser';
flush privileges;