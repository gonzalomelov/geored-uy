insert into person (dtype, id, email, islogged, lastname, name, password) values ('SuperAdmin', 1, 'a@a.com', false, 'a', 'a', 'password');
insert into person (dtype, id, email, islogged, lastname, name, password) values ('AdminCompany', 2, 'b@b.com', false, 'b', 'b', 'password');
insert into company (id, description, name, admincompany_id) values (3, '', 'b1', 2);
select setval('hibernate_sequence', 4);