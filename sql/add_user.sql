use CSDLPTTH01_BT1;
GO
CREATE LOGIN democsdlpt1 WITH PASSWORD = 'democsdlpt123@';
go
CREATE USER democsdlpt1 FOR LOGIN democsdlpt1;
go
GRANT select,insert,update,delete,execute TO democsdlpt1;