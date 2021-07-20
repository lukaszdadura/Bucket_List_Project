INSERT INTO bucket_list.users (admin, email, password, username) VALUES (true, 'admin@admin.pl', 'admin', 'admin');
INSERT INTO bucket_list.users (admin, email, password, username) VALUES (false, 'user1@user.pl', 'user1', 'user1');
INSERT INTO bucket_list.users (admin, email, password, username) VALUES (false, 'user2@user.pl', 'user2', 'user2');
INSERT INTO bucket_list.users (admin, email, password, username) VALUES (false, 'user3@user.pl', 'user3', 'user3');

INSERT INTO bucket_list.categories (points, type) VALUES (10, 'cooking');
INSERT INTO bucket_list.categories (points, type) VALUES (20, 'sport');
INSERT INTO bucket_list.categories (points, type) VALUES (30, 'social');
INSERT INTO bucket_list.categories (points, type) VALUES (50, 'wild');

INSERT INTO bucket_list.achievements (description, name) VALUES ('Zjadłem 20 nuggetsów w 5 minut', 'Nuggets challange');
INSERT INTO bucket_list.achievements (description, name) VALUES ('Przejechałem 30 km na rowerze', 'Pierwsze 30 km');
INSERT INTO bucket_list.achievements (description, name) VALUES ('Skoczyłem na bungee', 'Bungee');

INSERT INTO bucket_list.user_achievement (created, due_date, evidence, achievement_id, user_id) VALUES ('2020-01-01', '2020-02-01', 'blob', 1, 1);
INSERT INTO bucket_list.user_achievement (created, due_date, evidence, achievement_id, user_id) VALUES ('2020-01-01', '2020-02-01', 'blob', 2, 1);
INSERT INTO bucket_list.user_achievement (created, due_date, evidence, achievement_id, user_id) VALUES ('2020-01-01', '2020-02-01', 'blob', 3, 1);
INSERT INTO bucket_list.user_achievement (created, due_date, evidence, achievement_id, user_id) VALUES ('2020-01-01', '2020-02-01', 'blob', 3, 4);
INSERT INTO bucket_list.user_achievement (created, due_date, evidence, achievement_id, user_id) VALUES ('2020-01-01', '2020-02-01', 'blob', 3, 5);
INSERT INTO bucket_list.user_achievement (created, due_date, evidence, achievement_id, user_id) VALUES ('2020-01-01', '2020-02-01', 'blob', 1, 5);


INSERT INTO bucket_list.achievements_category_list (achievement_id, category_list_id) VALUES (1, 1);
INSERT INTO bucket_list.achievements_category_list (achievement_id, category_list_id) VALUES (2, 2);
INSERT INTO bucket_list.achievements_category_list (achievement_id, category_list_id) VALUES (3, 4);

SELECT * FROM bucket_list.user_achievement WHERE user_id = 1

