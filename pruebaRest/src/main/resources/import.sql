insert into regiones (id, nombre) values (1, "América");
insert into regiones (id, nombre) values (2, "Europa");
insert into regiones (id, nombre) values (3, "Asia");
insert into regiones (id, nombre) values (4, "Africa");
insert into regiones (id, nombre) values (5, "Oceanía");

insert into clientes (region_id, nombre, apellido, email, create_at) values (1, 'nom1', 'ap1', 'em1@il', '2020-01-01');
insert into clientes (region_id, nombre, apellido, email, create_at) values (1, 'nom2', 'ap2', 'em2@il', '2020-01-02');
insert into clientes (region_id, nombre, apellido, email, create_at) values (2, 'nom3', 'ap3', 'em3@il', '2020-01-03');
insert into clientes (region_id, nombre, apellido, email, create_at) values (2, 'nom4', 'ap4', 'em4@il', '2020-01-04');
insert into clientes (region_id, nombre, apellido, email, create_at) values (3, 'nom5', 'ap5', 'em5@il', '2020-01-05');
insert into clientes (region_id, nombre, apellido, email, create_at) values (3, 'nom6', 'ap6', 'em6@il', '2020-01-06');
insert into clientes (region_id, nombre, apellido, email, create_at) values (4, 'nom7', 'ap7', 'em7@il', '2020-01-07');
insert into clientes (region_id, nombre, apellido, email, create_at) values (4, 'nom8', 'ap8', 'em8@il', '2020-01-08');
insert into clientes (region_id, nombre, apellido, email, create_at) values (5, 'nom9', 'ap9', 'em9@il', '2020-01-09');
insert into clientes (region_id, nombre, apellido, email, create_at) values (5, 'nom10', 'ap10', 'em10@il', '2020-01-10');
insert into clientes (region_id, nombre, apellido, email, create_at) values (5, 'nom11', 'ap11', 'em11@il', '2020-01-11');

insert into usuarios (username, password, enabled, nombre, apellidos, email) values ('andres', '$2a$10$ZJAQs3Ltu6D3PectmFr4qOUxdUdksuHQ.s35iBzIx3ZgmxD8yiSAm', 1, 'andres', 'guzman', 'correo@correo.es');
insert into usuarios (username, password, enabled, nombre, apellidos, email) values ('admin', '$2a$10$rKYKA06NsYviU801M7B/pe9cdYap0h2fk2.D2f.QA7e4A83saeYYm', 1, 'nombre', 'apellido', 'em@i.l');

insert into roles (nombre) values ('ROLE_USER');
insert into roles (nombre) values ('ROLE_ADMIN');

insert into usuarios_roles (usuario_id, roles_id) values (1,1);
insert into usuarios_roles (usuario_id, roles_id) values (2,2);
insert into usuarios_roles (usuario_id, roles_id) values (2,1);

insert into productos (nombre, precio, create_at) values ('prod1', 100, NOW());
insert into productos (nombre, precio, create_at) values ('prod2', 200, NOW());
insert into productos (nombre, precio, create_at) values ('prod3', 300, NOW());
insert into productos (nombre, precio, create_at) values ('prod4', 400, NOW());
insert into productos (nombre, precio, create_at) values ('prod5', 500, NOW());
insert into productos (nombre, precio, create_at) values ('prod6', 600, NOW());
insert into productos (nombre, precio, create_at) values ('prod7', 700, NOW());
insert into productos (nombre, precio, create_at) values ('prod8', 800, NOW());
insert into productos (nombre, precio, create_at) values ('prod9', 900, NOW());
insert into productos (nombre, precio, create_at) values ('prod10', 1000, NOW());
insert into productos (nombre, precio, create_at) values ('prod11', 1100, NOW());
insert into productos (nombre, precio, create_at) values ('prod12', 1200, NOW());
insert into productos (nombre, precio, create_at) values ('prod13', 1300, NOW());
insert into productos (nombre, precio, create_at) values ('prod14', 1400, NOW());
insert into productos (nombre, precio, create_at) values ('prod15', 1500, NOW());
insert into productos (nombre, precio, create_at) values ('prod16', 1600, NOW());
insert into productos (nombre, precio, create_at) values ('prod17', 1700, NOW());
insert into productos (nombre, precio, create_at) values ('prod18', 1800, NOW());
insert into productos (nombre, precio, create_at) values ('prod19', 1900, NOW());
insert into productos (nombre, precio, create_at) values ('prod20', 2000, NOW());

insert into facturas (descripcion, observacion, cliente_id, create_at) values('Factura1', null, 1, NOW());
insert into facturas_items (cantidad, factura_id, producto_id) values (1, 1, 1);
insert into facturas_items (cantidad, factura_id, producto_id) values (1, 1, 2);
insert into facturas_items (cantidad, factura_id, producto_id) values (2, 1, 3);
insert into facturas_items (cantidad, factura_id, producto_id) values (3, 1, 4);
insert into facturas_items (cantidad, factura_id, producto_id) values (5, 1, 5);
insert into facturas_items (cantidad, factura_id, producto_id) values (8, 1, 6);

insert into facturas (descripcion, observacion, cliente_id, create_at) values('Factura2', null, 2, NOW());
insert into facturas_items (cantidad, factura_id, producto_id) values (13, 2, 7);
insert into facturas_items (cantidad, factura_id, producto_id) values (21, 2, 8);
insert into facturas_items (cantidad, factura_id, producto_id) values (34, 2, 9);

insert into facturas (descripcion, observacion, cliente_id, create_at) values('Factura3', null, 2, NOW());
insert into facturas_items (cantidad, factura_id, producto_id) values (55, 3, 10);
insert into facturas_items (cantidad, factura_id, producto_id) values (89, 3, 11);
insert into facturas_items (cantidad, factura_id, producto_id) values (114, 3, 12);
