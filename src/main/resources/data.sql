insert into Users(id, first_name, last_name, age,create_at,update_at)
values(1, 'siva ramakrishna','koppula',28,CURRENT_DATE,CURRENT_DATE);

insert into Cart(id, user_id, price, qty)
values (1, 1, 0 , 0);

insert into Product(product_id, product_name, product_price, genre, authour, publication)
values
(101, 'Programming In Ansi C', 560, '8st', 'balaguru swami', 'McGraw Hill India'),
(102, 'rich dad poor dad', 230, '1th', ' Robert Kiyosaki', 'Warner Books'),
(103, 'BELIEVE IN YOURSELF’: LIFE LESSONS FROM VIVEKANANDA', 399, '1th', 'DR Nanditha Krishna', 'Aleph Book Company');

insert into Product(product_id, product_name, product_price, type, brand, design)
values (104, 'Kurtas', 351, 'Kurta', 'Vasant Apparel', 'Women Embroidered Rayon Anarkali Kurta  (Yellow)'),
       (105, 'SherwaniS', 31000, 'Sherwani', 'Aza Fashions', 'White Spectrum Linen Satin Achkan Set');                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                