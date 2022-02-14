## TODO: primaryKey, foreignKey, constraints

create table shoppers
(
    id    int          null,
    name  varchar(250) null,
    email varchar(50)  null,
    nif   varchar(20)  null
);

insert into shoppers (id, name, email, nif) VALUES
(1, 'Olive Thompson', 'olive.thompson@not_gmail.com', '411111111Z'),
(2, 'Virgen Anderson', 'virgen.anderson@not_gmail.com', '411111112Z'),
(3, 'Reagan Auer', 'reagan.auer@not_gmail.com', '411111113Z'),
(4, 'Shanelle Satterfield', 'shanelle.satterfield@not_gmail.com', '411111114Z');
