## TODO: primaryKey, foreignKey, constraints

create table orders
(
    id           int      null,
    merchant_id  int      null,
    shopper_id   int      null,
    amount       double   null,
    create_at    datetime null,
    completed_at datetime null
);

insert into orders (id, merchant_id, shopper_id, amount, create_at, completed_at) VALUES
                                                                                      (1, 1, 1, 49.99, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (2, 1, 2, 200, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (3, 1, 3, 599, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('03/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (4, 1, 1, 49.99, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (5, 1, 2, 200, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('14/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (6, 1, 4, 599, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), null),
                                                                                      (7, 2, 1, 39.99, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (8, 2, 2, 100, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (9, 2, 3, 499, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('03/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (10, 2, 1, 39.99, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (11, 2, 2, 100, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('14/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (12, 2, 4, 499, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), null),
                                                                                      (13, 3, 1, 5, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (14, 3, 2, 50, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (15, 3, 3, 300, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('03/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (16, 3, 1, 5, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('10/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (17, 3, 2, 50, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), str_to_date('14/02/2022 10:00:00', '%d/%m/%Y %H:%i:%s')),
                                                                                      (18, 3, 4, 300, str_to_date('10/11/2021 10:00:00', '%d/%m/%Y %H:%i:%s'), null);


