set foreign_key_checks = 0;

delete from conta;

set foreign_key_checks = 1;

alter table conta auto_increment = 1;

insert into conta (id, nome, email, cpf, data_nascimento) values (1, 'Maiane', 'maiane@gmail.com', '123456789', UTC_TIMESTAMP);
insert into conta (id, nome, email, cpf, data_nascimento) values (2, 'Maiane Samara', 'mai@gmail.com', '123456789', UTC_TIMESTAMP);
insert into conta (id, nome, email, cpf, data_nascimento) values (3, 'May', 'may@gmail.com', '123456789', UTC_TIMESTAMP);


