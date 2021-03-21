use master;
go

if not Exists(Select * from sys.databases where name = 'DB_BANCO')
Begin
Create database DB_BANCO;
End;
go

Use DB_BANCO
Go

if OBJECT_ID('Banco') is null
Create Table Banco
(
	codigo   varchar(10),
	nome     varchar(255),
	web_site varchar(255)
);
Go

--Truncate table Banco
Select * From Banco;