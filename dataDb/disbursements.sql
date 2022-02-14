## TODO: primaryKey, foreignKey, constraints

create table disbursements
(
    id            int auto_increment,
    order_id      int         null,
    merchant_id   int         null,
    week          varchar(6)  null,
    disbur_amount double      null,
    percentage    double      null,
    state         varchar(25) null,
    constraint disbursements_id_uindex
        unique (id),
    constraint disbursements_unique_order_od
        unique (order_id)
);