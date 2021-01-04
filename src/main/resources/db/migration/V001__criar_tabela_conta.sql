create table conta (
	id bigint not null auto_increment,
	nome varchar(120) not null,
	email varchar(120) not null,
	cpf varchar(20) not null,
	data_nascimento datetime not null, 
	
	primary key (id)
)  engine = InnoDB default charset=utf8;