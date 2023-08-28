drop table if exists testfinalefinale.conticorrenti;

create table conticorrenti(
numeroConto  bigint not null,
CIN varchar (10),
ABI varchar (5),
CAB varchar (5),
nomeTitolare varchar(40),
cognomeTitolare varchar(40),
codiceFiscaleTitolare varchar(16),
primary key (numeroConto)
);

insert into conticorrenti
(numeroConto, CIN, ABI, CAB, nomeTitolare, cognomeTitolare, codiceFiscaleTitolare)
values
(111111111111, '1', '11111', '11111', 'Daniel', 'Guidolin','GDLDNL94C28L219P');