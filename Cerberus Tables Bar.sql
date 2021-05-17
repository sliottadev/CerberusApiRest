CREATE DATABASE CerberusTest
GO
USE CerberusTest
GO
--=======================================================================--
--				PRODUCTOS Y RELACIONES                                   --
--=======================================================================--
CREATE TABLE Categories (
	CategoryId int primary key identity(1,1),
	Code varchar(4) not null,
	[Description] varchar(30) not null,
)

CREATE TABLE Images (
	ImageId int primary key identity(1,1),
	[Description] varchar(30),
	[FileName] varchar(255),
	[Data] Image not null,
)

CREATE TABLE Products (
	ProductId int primary key identity(1,1),
	[Description] varchar(50) not null,
	Details varchar(MAX),
	Price Decimal(9,3) not null,
	HasOptions bit not null default 0,
	[Enabled] bit not null default 1,
	CreateDate DateTime2 not null,
	ModifyDate DateTime2 not null default '01-01-1800',
	DeleteDate DateTime not null default '01-01-1800',
	IsPromo bit not null default 0,
	--solo si es promo
	StartDate DateTime2 default '01-01-1800' ,
	EndDate DateTime2 default '01-01-1800',
	HourStart DateTime2 default '01-01-1800',
	HourEnd DateTime2 default '01-01-1800',
	[Days] varchar(7) default '1111111',
	--FK
	CategoryId int,
	ImageId int,
	CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId),
	CONSTRAINT FK_PRODUCT_IMAGE FOREIGN KEY (ImageId) REFERENCES Images(ImageId)
)

CREATE TABLE Options (
	OptionId int primary key identity(1,1),
	[Description] varchar(50) not null,
	Details varchar(MAX),
	Price Decimal(9,3) not null,
	CreateDate DateTime2 not null,
	ModifyDate DateTime2 not null default '01-01-1800',
	DeleteDate DateTime not null default '01-01-1800',
	[Enabled] bit not null default 1,
	--FK
	ProductId int not null, --ProducttoPadre
	ImageId int,
	CONSTRAINT FK_OPTION_PRODUCT FOREIGN KEY (ProductId) REFERENCES Products(ProductId),
	CONSTRAINT FK_OPTION_IMAGE FOREIGN KEY (ImageId) REFERENCES Images(ImageId)
)

CREATE TABLE PromotionsItems (
	PromotionItemsId int primary Key identity(1,1),
	Quantity int not null default 1,
	--FK
	PromotionId int, --ProductoPadre
	ProductId int,
	OptionId int,
	CONSTRAINT FK_PROMOTIONITEM_PRODUCT_PROMO FOREIGN KEY (PromotionId) REFERENCES Products(ProductId),
	CONSTRAINT FK_PROMOTIONITEM_PRODUCT FOREIGN KEY (ProductId) REFERENCES Products(ProductId),
	CONSTRAINT FK_PROMOTIONITEM_OPTION FOREIGN KEY (OptionId) REFERENCES Options(OptionId)
)

--=======================================================================--
--				USUARIOS Y PERMISOS                                      --
--=======================================================================--

CREATE TABLE Roles (
	RolId Int primary Key identity(1,1),
	[Description] varchar(30),
)

CREATE TABLE [Permissions](
	PermissionsId int primary key identity(1,1),
	CanManegeProducts bit not null default 1,
	CanManagePromotions bit not null default 1,
	CanManageOrders bit not null default 1,
	--FK
	RolId int,
	CONSTRAINT FK_PERMISSION_ROL FOREIGN KEY (RolId) REFERENCES Roles(RolId)
)

CREATE TABLE [Users] (
	UserId int primary Key identity(1,1),
	UserName varchar(60),
	PIN varchar(4),
	LastConnection DateTime2 not null,
	CreateDate DateTime2 not null,
	ModifyDate DateTime2 not null default '01-01-1800',
	DeleteDate DateTime not null default '01-01-1800',
	--FK
	ImageId int,
	RolId int,
	CONSTRAINT FK_USER_IMAGE FOREIGN KEY (ImageId) REFERENCES Images(ImageId),
	CONSTRAINT FK_USER_ROL FOREIGN KEY (RolId) REFERENCES Roles(RolId)
)

--=======================================================================--
--				CLIENTES Y DETALLES                                      --
--=======================================================================--

--drop table clients
--drop table OrderDetails
--drop table  [Orders]
--drop table [Tables]
--drop table Waiters
--drop table [ClientDetails]

CREATE TABLE [Clients](
	ClientId int primary Key identity(1,1),
	UserName varchar(30) not null,
	Mail varchar(255),
	Pass varchar(15),
	IsGuest bit not null default 1,
	LogInFacebook bit not null default 0,
	LogInGoogle bit not null default 0,
	CreateDate DateTime2 not null,
	ModifyDate DateTime2 not null default '01-01-1800',
	DeleteDate DateTime not null default '01-01-1800',
	--FK
	ImageId int,
	CONSTRAINT FK_CLIENT_IMAGE FOREIGN KEY (ImageId) REFERENCES Images(ImageId)
)

CREATE TABLE [ClientDetails](
	ClientDetailId int primary key identity(1,1),
	FirstName varchar(50) not null,
	LastName varchar(50) not null,
	[Address] varchar(50) not null,
	City varchar(50) not null,
	Country varchar(50) not null,
	GMCoord varchar(MAX), --Corrdenadas de GoogleMaps (Promociones por zona)
	ZipCode varchar(8),
	Phone varchar(255),
	WhatsAppPhone varchar(255),
	IsMailSubscribed bit not null default 0,
	IsWhatsAppSubscribed bit not null default 0,
	LastSession DateTime2 not null,
	--FK
	ClientId int not null
	CONSTRAINT FK_CLIENTDETAIL_CLIENT FOREIGN KEY (ClientId) REFERENCES Clients(ClientId)
)

--=======================================================================--
--				MESAS MESEROS PEDIDOS                                    --
--=======================================================================--

CREATE TABLE [Tables](
	TableId int primary Key Identity(1,1),
	Code varchar(6) not null, --codigo de mesa (nuemro)
	[Location] varchar(255),
	[Enabled] bit not null default 1,
	[Visible] bit not null default 1,
	Deleted bit not null default 0
)

CREATE TABLE Waiters( --meseros
	WaiterId int primary Key identity(1,1),
	[Code] varchar(4) not null,
	[Name] varchar(30) not null,
	Details varchar(255),
	Deleted bit not null default 0 --Uso para futurasa purgas (afecta la auditoria)
)

--drop table orders
CREATE TABLE [Orders] (
	OrderId int primary key identity(1,1),
	PartialPayment Decimal(9,3),
	State varchar(1), --I=Ingersado, E=Entregado, C=Cerrado, P=Pagado 
	BonusPorc int, --porcentaje bonificacion en total de pedido
	CreateDate DateTime2 not null,
	CloseDate DateTime2 not null default '01-01-1800',
	ModifyDate DateTime2 not null default '01-01-1800',
	DeleteDate DateTime not null default '01-01-1800',
	--FK
	ClientId int,
	TableId int, --Si es nulo, es para llevar/no ocupa mesa
	WaiterId int,
	CONSTRAINT FK_ORDER_CLIENT FOREIGN KEY (ClientId) REFERENCES Clients(ClientId),
	CONSTRAINT FK_ORDER_TABLE FOREIGN KEY (TableId) REFERENCES [Tables](TableId),
	CONSTRAINT FK_ORDER_WAITER FOREIGN KEY (WaiterId) REFERENCES Waiters(WaiterId)
)

CREATE TABLE OrderDetails(
	OrderDetailId int primary Key identity(1,1),
	Quantity Int,
	Rewarded bit not null default 0, --bonificado
	BonusPorc int, --porcentaje de descuento en este item
	[State] varchar(1), -- I:Ingresado, P:Produciendo, E:Entregado, C:Cancelado
	--FK
	OrderId int not null, --orden padre
	ProductId int not null,
	OptionId int, --si el producto tiene Opciones se busca el item de Opcion
	CONSTRAINT FK_ORDERDETAILS_ORDER FOREIGN KEY (OrderId) REFERENCES Orders(OrderId),
	CONSTRAINT FK_ORDERDETAILS_PRODUCT FOREIGN KEY (ProductId) REFERENCES Products(ProductId),
	CONSTRAINT FK_ORDERDETAILS_OPTION FOREIGN KEY (OptionId) REFERENCES Options(OptionId)
)

