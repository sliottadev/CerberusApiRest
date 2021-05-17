USE CerberusTest
--=======================================================================--
--				CARGA INICIAL EMPRESA EJEMPLO					         --
--=======================================================================--
--Carga Categorias
--delete categories
--DBCC CHECKIDENT (categories, RESEED, 0)
Insert into categories values
	('0001','Hamburguesas'),
	('0002','Bebidas sin Alcohol'),
	('0003','Tragos'),
	('0004','Cervezas'),
	('0005','Pizzas'),
	('0006','Miselaneas'),
	('0000','Promociones'),
	('0007','Empanadas')


--Carga Productos sin Imagenes
--delete Products
--DBCC CHECKIDENT (Products, RESEED, 0)
Insert Into Products ([Description], Details, price, HasOptions, [Enabled], categoryId, createDate)
values
	--Hamburguesas
	--[Description],		  Details,																  price,  HasOptions, [Enabled], categoryId, createDate
	('Hamburguesa Completa', '220g de carne Vacuna con jamon, queso cheddar, lechuga, tomate, huevo', 340.00, 0,          1,         1,          Cast(GetDate() as DateTime2)),
	('Hamburguesa c/Queso',  '220g de carne Vacuna con queso cheddar', 220.00, 0, 1, 1, Cast(GetDate() as DateTime2)),
	('Hamburguesa de Pollo Completa', '220g de carne de Pollo con jamon, queso cheddar, lechuga, tomate, huevo', 340.00, 0, 1, 1, Cast(GetDate() as DateTime2)),
	('Hamburguesa de Pescado', '220g de carne de salmón con jamon, queso cheddar, lechuga, tomate, huevo', 340.00, 0, 0, 1, Cast(GetDate() as DateTime2)),
	--Bebidas sin Alcohol
	('Botella 600 Linea CocaCola', '', 120.00, 1, 1, 2, Cast(GetDate() as DateTime2)), --tiene Opciones
	('Agua Mineral Glaciar s/Gas', '', 110.00, 0, 1, 2, Cast(GetDate() as DateTime2)), 
	('Agua Mineral Glaciar c/Gas', '', 110.00, 0, 1, 2, Cast(GetDate() as DateTime2)), 
	('Agua Mineral Villa del Sur c/Gas', '', 110.00, 0, 0, 2, Cast(GetDate() as DateTime2)),
	('Lata Speed', '', 125.00, 0, 1, 2, Cast(GetDate() as DateTime2)),
	--Tragos
	('Margarita', 'Jugo de Lima, Triple Sec, Tequila, sal, hielo', 180.00, 0, 1, 3, Cast(GetDate() as DateTime2)),
	('Daikiri Frutilla', 'Pulpa de frutilla, Ron, jugo de limon, azucar, licor', 180.00, 0, 1, 3, Cast(GetDate() as DateTime2)),
	('Bloody Mary', 'Jugo de tomate, Vodka, Salsa Tabasco, Limon', 180.00, 0, 1, 3, Cast(GetDate() as DateTime2)),
	('Fernet-Cola', 'Fernet, CocaCola y Hielo', 180.00, 0, 1, 3, Cast(GetDate() as DateTime2)),
	--Cervezas
	('Chopp Amber Ale', 'Sabor a Malta y Lupulo', 150.00, 0, 1, 4, Cast(GetDate() as DateTime2)),
	('Chopp Scout', 'Sabor Cafe Chocolate y sabores tostados', 150.00, 0, 1, 4, Cast(GetDate() as DateTime2)),
	('Chopp IPA', 'Intenso Sabor a Lupulo', 150.00, 0, 1, 4, Cast(GetDate() as DateTime2)),
	('Chopp Blonde Ale', 'Sabor a Malta suave y Lupulo Semi Amargo', 150.00, 0, 1, 4, Cast(GetDate() as DateTime2)),
	--Pizzas
	('Calabresa Grande', 'Muzzarella y Peperoni', 280.00, 0, 1, 5, Cast(GetDate() as DateTime2)),
	('Muzzarella Grande', 'Muzzarella y Aceitunas', 250.00, 0, 1, 5, Cast(GetDate() as DateTime2)),
	('Fugazzeta', 'Queso y Cebolla', 320.00, 0, 1, 5, Cast(GetDate() as DateTime2)),
	--Micelaneas
	('Picada de fiambres para 4', 'Variedad de Fiambre y Quesos', 780.00, 0, 1, 6, Cast(GetDate() as DateTime2)),
	('Quesadillas', '', 320.00, 0, 1, 6, Cast(GetDate() as DateTime2)),
	('Matambre a la Pizza para 4', 'Matambre con muzzarella, salsa de tomate y aceitunas', 900.00, 0, 1, 6, Cast(GetDate() as DateTime2)),
	--Empanadas
	('Empanada al Horno', 'Empanada al Horno Varios Sabores', 75.00, 1, 1, 8, Cast(GetDate() as DateTime2)),
	--Promociones
	('PROMO 001 - Pizza Muzzarella + 4 Chopps Cerveza', '', 1300.00, 0, 1, 7, Cast(GetDate() as DateTime2)), --Promo
	--Cerveza General Invisible en Menu
	('Chopp Cerveza a Eleccion', '', 150.00, 0, 0, 4, Cast(GetDate() as DateTime2))
--select * from products

-- Carga Opciones de Producto
--delete options
--DBCC CHECKIDENT (options, RESEED, 0)
insert into options ([description], Details, price, productId, enabled, CreateDate)
values
	('Coca-Cola','',120.00, 5, 1, Cast(GetDate() as DateTime2)),
	('Sprite','',120.00, 5, 1, Cast(GetDate() as DateTime2)),
	('Fanta','',120.00, 5, 1, Cast(GetDate() as DateTime2)),
	('Acuarius','',120.00, 5, 1, Cast(GetDate() as DateTime2)),
	('Empanada de Carne','Carne cortada a cuchillo, aceitunas y especias',75.00, 24, 1, Cast(GetDate() as DateTime2)),
	('Empanada de Pollo','Pollo y especias',75.00, 24, 1, Cast(GetDate() as DateTime2)),
	('Empanada de Jamon y Queso','Jamon, Muzzarella y aceitunas',75.00, 24, 1, Cast(GetDate() as DateTime2))
go
--select * from options

--Actualizo campo EsPromo
update products set isPromo=1
where categoryId=7

--Carga PromotionsItems
insert into PromotionsItems (productId, OptionId, Quantity, PromotionId) 
values
	(19, null, 1, 25), --muzza grande
	(26, null, 4, 25) --Cerveza a Eleccion (Se debe definir opciones)


--Carga de Roles
--DBCC CHECKIDENT (Roles, RESEED, 0)
insert into Roles values
	('Administrador Total'),
	('Mesero'),
	('Auditor')

--Carga de Permisos
insert into [permissions] (rolId, CanManegeProducts, CanManagePromotions, CanManageOrders)
values
	(1,1,1,1),
	(2,0,0,1),
	(3,0,0,0)

--Carga de Usuarios
Insert Into Users (UserName, PIN, RolId, CreateDate, LastConnection)
values
	('Matias Giordano', '0000', 1, Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)),
	('Matias Fida', '1111', 1, Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)),
	('Seb Liotta', '2222', 1, Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)),
	('Mesero 1', '9999', 2, Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)),
	('Mesero 2', '9999', 2, Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)),
	('Auditor 1', '9999', 3, Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)),
	('Auditor 2', '9999', 3, Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2))

--Carga de Mesas
Insert into [Tables] (Code, Location, Enabled, Visible, Deleted)
values
 ('A001','Planta Baja', 1, 1, 0),
 ('A002','Planta Baja', 1, 1, 0),
 ('A003','Planta Baja', 1, 1, 0),
 ('A004','Planta Baja', 0, 0, 1),
 ('B001','Primer Piso', 0, 1, 0),
 ('B002','Primer Piso', 0, 0, 0)
--select * from tables

--Carga de Meseros
Insert Into Waiters (Code, Name, Details, deleted)
values
	('0001', 'Juan', '', 0),
	('0002', 'Carlos', '', 0),
	('0003', 'German', '', 0),
	('0004', 'Martha', '', 0),
	('0005', 'Juliana', '', 0),
	('0006', 'Priscila', '', 1)
--select * from waiters

--Carga de Clientes
--delete Clients
--DBCC CHECKIDENT (Clients, RESEED, 0)
insert Into Clients(UserName, Mail, Pass, IsGuest, LoginFacebook, LoginGoogle, CreateDate)
values
	('Raul', '', '3001', 1, 0, 0, Cast(GetDate() as DateTime2)), --Invitado
	('Daniela', '', '3008', 1, 0, 0, Cast(GetDate() as DateTime2)), --Invitado
	('Hernan', '', '2001', 1, 0, 0, Cast(GetDate() as DateTime2)), --Invitado
	('Christian', '', '7005', 1, 0, 0, Cast(GetDate() as DateTime2)), --Invitado
	('Seph', 'sebs.liotta@gmail.com', '12345678', 0, 0, 0, Cast(GetDate() as DateTime2)), --Registrado
	('MatiG', 'mati.gio@gmail.com', '87654321', 0, 0, 0, Cast(GetDate() as DateTime2)), --Registrado
	('MatiF', 'mati.fida@gmail.com', '98765432', 0, 0, 0, Cast(GetDate() as DateTime2)), --Registrado
	('Julian', 'jmedina@gmail.com', '8000', 1, 0, 0, Cast(GetDate() as DateTime2))  --Invitado

--Carga de Detalle Clientes
--delete ClientDetails
--DBCC CHECKIDENT (ClientDetails, RESEED, 0)
Insert Into ClientDetails (ClientId, FirstName, LastName, [Address], City, Country, GMCoord, ZipCode, Phone, WhatsAppPhone, IsMailSubscribed, IsWhatsAppSubscribed, LastSession)
values
	(5, 'Sebastian', 'Liotta', 'Franco 2865', 'CABA', 'Argentina', null, '1419', '11 6566-2323', '11 6566-2323', 1, 0, Cast(GetDate() as DateTime2)),
	(6, 'Matias', 'Giordano', 'Unknowed', 'Unknowed', 'Argentina?', null, '0000', '11 4022-2240', '11 4022-2240', 1, 1, Cast(GetDate() as DateTime2)),
	(7, 'Matias', 'Fida', 'Calle de Caballito', 'CABA', 'Argentina', null, '1725', '11 6565-6565', '11 6868-6868', 0, 0, Cast(GetDate() as DateTime2))

--Carga de Ordenes
--delete orders
--DBCC CHECKIDENT (orders, RESEED, 0)
insert into orders (TableId, WaiterId, ClientId, [State], BonusPorc, PartialPayment, CreateDate, CloseDate)
values
	(1, 6, 1, 'C', 0,  0.00,   Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)), --cerrado
	(3, 2, 2, 'C', 0,  0.00,   Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)), --cerrado
	(3, 2, 5, 'C', 0,  0.00,   Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)), --cerrado
	(4, 5, 1, 'C', 0,  0.00,   Cast(GetDate() as DateTime2), Cast(GetDate() as DateTime2)), --cerrado
	(2, 3, 5, 'E', 0,  600.00, Cast(GetDate() as DateTime2), Cast('01-01-1800' as DateTime2)), --Entregado
	(1, 1, 2, 'I', 10, 0.00,   Cast(GetDate() as DateTime2), Cast('01-01-1800' as DateTime2)), --preparando
	(6, 3, 2, 'I', 0,  0.00,   Cast(GetDate() as DateTime2), Cast('01-01-1800' as DateTime2)) --preparando
--select * from orders

--Carga de Detalles de Orden
-- I:Ingresado, P:Produciendo, E:Entregado, C:Cancelado
--delete OrderDetails
--DBCC CHECKIDENT (OrderDetails, RESEED, 0)
--select * from Orders
insert into OrderDetails (OrderId, ProductId, OptionId, Quantity, [State], BonusPorc, Rewarded)
values
	-- pedido 1
	(1, 2, null, 2, 'E', 0, 0), --2 hamburguesas
	(1, 15, null, 1, 'E', 0, 0), --1 Chopp Scout
	(1, 17, null, 1, 'E', 0, 0), -- 1 Chopp Blonde Ale
	--pedido 2
	(2, 18, null, 1, 'E', 0, 0), --1 Calabresa Grande
	(2, 21, null, 1, 'E', 0, 0), --1 Picada de fiambres para 4
	(2, 5, 1, 2, 'E', 0, 0),     --2 coca-cola
	(2, 15, null, 1, 'E', 0, 0),  --1 Chopp Scout
	(2, 11, null, 1, 'E', 0, 0),   --1 Daikiri Frutilla
	--Pedido 3
	(3, 24, 5, 2, 'E', 0, 0), --2 Empanada de Carne
	(3, 24, 6, 2, 'E', 0, 0), --2 Empanada de Pollo
	(3, 24, 7, 2, 'E', 0, 0), --2 Empanada de Jamon y Queso
	(3, 5, 1, 3, 'E', 0, 0),  --3 coca-cola
	--Pedido 4
	(4, 25, null, 2, 'E', 10, 0),  --2 Promo 001 + 10% desc
	--pedido 5 --este tiene un pago parcial de $600
	(5, 3, null, 2, 'E', 0, 0), --2 hamburguesas pollo completa
	(5, 14, null, 5, 'E', 0, 0), --5 Chopp Amber Ale
	--pedido 6 --Este pedido no fue entregado aun esta siendo preparado
	(6, 11, null, 2, 'P', 0, 0), --2 daikiri
	(6, 12, null, 2, 'P', 0, 0), --2 Bloody Mary
	(6, 19, null, 2, 'P', 0, 0), --2 Muzzarella Grande
	--pedido 7 --Este pedido no fue entregado aun esta siendo preparado
	(7, 23, null, 1, 'P', 0, 0), --1 Matambre a la Pizza para 4
	(7, 5, 4, 2, 'P', 0, 0),     --2 Acuarius
	(7, 5, 3, 2, 'P', 0, 0)     --2 Fanta
