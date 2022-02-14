## TODO: primaryKey, foreignKey, constraints

create table fees
(
    id           int    null,
    amount_base  double null,
    amount_limit double null,
    percentage   double null
);

insert into fees (id, amount_base, amount_limit, percentage) VALUES
                                                                 (1, 0, 50, 1),
                                                                 (2, 50, 300, 0.95),
                                                                 (3, 300, 9999999, 0.85);