--CONSULTAS DE EJEMPLO
--Lista de productos con detalle y habilitado
select 
	P.productId [ID de Producto], 
	p.Description [Descripcion],
	Case when p.Enabled=1 then 'Si' else 'No' end [Habilitado]
from Products as P

--Mesas en Ocupadas
select T.TableId, T.Code, T.Location
from [Tables] as T
	inner join Orders as O on o.TableId=T.TableId and O.State<>'C'

--Mesas Libres
select Distinct T.TableId, T.Code, T.Location, LastValueForTable.LastValue
from [Tables] as T
	left join ( 
	           select [Tables].TableId, TablesState.LastValue
			   from [Tables]
			   left join (
			              Select distinct Orders.TableId, LAST_value([State]) OVER (Partition by TableId order by TableId) as LastValue
						  from Orders 
		                 ) as TablesState on TablesState.TableId = [Tables].TableId
			  ) as LastValueForTable on LastValueForTable.TableID=T.TableId
where LastValueForTable.LastValue is null or LastValueForTable.LastValue not in ('E','I')

-- Todos los pedidos cerrados y no cerrados con el gasto actual, fecha Ingreso, Fecha Cierre
select 
	O.OrderId [Id de Orden], 
	SUM (OD.Quantity * P.Price) [Total Actual], 
	O.State [Estado],
	O.CreateDate [Fecha de Pedido], 
	case when O.CloseDate = Cast('01-01-1800' as DateTime2) then 'No Cerro' else Cast(O.CloseDate as varchar) end [Fecha de Cierre]
from Orders as O
	left join OrderDetails as OD on  OD.OrderId = o.OrderId
	left join Products as P on OD.ProductId=P.ProductId
group by O.OrderId, o.CreateDate, O.CloseDate, O.State

-- Todos los pedidos activos y sus Items con precio unit y subtotal, informa clientes y fecha de pedido y cierre
---- Son los pedidos que aun no fueron cerrados
select 
	O.OrderId as [Numero de Orden], 
	o.ClientId as [Numero de Cliente],
	case when c.IsGuest=1 then 'No' else 'Si' end as [Cliente Registrado], 
	c.UserName as [Nombre Cliente], 
	od.ProductId as [Id de Producto], 
	op.description as [Opcion],
	od.quantity as [Cantidad], 
	p.description as [Descripcion], 
	p.price as [Precio Unitario], 
	p.price * od.quantity as [Subtotal], 
	o.CreateDate as [Fecha de Pedido], 
	o.closeDate as [Fecha de Cierre]
from Orders O
	left join OrderDetails od on od.OrderId=O.OrderId
	left join Products p on p.ProductId=od.ProductId
	Left Join Clients c on o.clientId = c.ClientId
	Left JOin Options op on op.optionId = Od.OptionId
where o.state <> 'C'