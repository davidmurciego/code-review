## TODO: primaryKey, foreignKey, constraints

create table merchants
(
    id    int          null,
    name  varchar(250) null,
    email varchar(50)  null,
    cif   varchar(20)  null
);

insert into merchants (id, name, email, cif) VALUES
(1, 'Treutel, Schumm and Fadel', 'info@treutel-schumm-and-fadel.com', 'B611111111'),
(2, 'Windler and Sons', 'info@windler-and-sons.com', 'B611111112'),
(3, 'Mraz and Sons', 'info@mraz-and-sons.com', 'B611111113'),
(4, 'Cummerata LLC', 'info@cummerata-llc.com', 'B611111114');

