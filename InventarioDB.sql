CREATE DATABASE InventarioDB;

USE InventarioDB;

CREATE TABLE usuarios(
ID int primary key AUTO_INCREMENT,
Nombres varchar(50),
Apellidos varchar(50),
Correo varchar(50),
Contrasena varchar(100),
Tipo_Usuario varchar(50)
);

CREATE TABLE categoria(
ID int primary key auto_increment,
id_Categoria varchar (10) unique,
Categorias varchar(30)
);



CREATE TABLE proveedores(
ID int primary key auto_increment,
Nombre_Proveedor varchar(100),
Categoria_Proveedor varchar(50),
CodigoProveedor varchar(5),
NIT varchar(20),
NRC varchar(20),
Direccion varchar(100),
Telefono varchar(20),
Calificacion int
); 



CREATE TABLE productos(
ID int primary key auto_increment,
Nombre_Producto varchar(50),
Categoria_ID int NOT NULL,
Proveedor_ID int NOT NULL,
Existencia_Min int,
Existencia_Max int,
Precio decimal(6,2),
Costo decimal(6,2),
Unidad_Medida varchar(50),
Ubicacion_Bodega varchar(100),

CONSTRAINT FK_categoriaProducto FOREIGN KEY (Categoria_ID)
REFERENCES Categoria(ID),
    
CONSTRAINT FK_proveedorProducto FOREIGN KEY (Proveedor_ID)
REFERENCES Proveedores(ID)
);

CREATE TABLE salidas(
ID int primary key auto_increment,
Producto_ID int NOT NULL,
Lote varchar(50),
Precio decimal(6,2),
Cantidad int,
Fecha_Salida date,

CONSTRAINT FK_salidaProducto FOREIGN KEY (Producto_ID)
REFERENCES Productos(ID)
);

CREATE TABLE compras(
ID int primary key auto_increment,
Producto_ID int NOT NULL,
Lote varchar(50),
Precio decimal(6,2),
Cantidad int,
Fecha_Compra date,
Fecha_vencimiento_Lote date,
Encargado varchar(100),

CONSTRAINT FK_ComprasProducto FOREIGN KEY (Producto_ID)
REFERENCES Productos(ID)
);