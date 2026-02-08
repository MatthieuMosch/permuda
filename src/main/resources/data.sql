-- authorization
insert into roles(rolename)
values ('ROLE_GOD'),
       ('ROLE_WIZARD'),
       ('ROLE_PLAYER');

-- default authentication
insert into users(username, rolename, password)
values ('Jan','ROLE_GOD', '$2a$10$XB9j4Uf72XqTk1/sPtirsep4m4vBVCOYknF6YDpoDFqbYiiXuaK0u'),
       ('Sjaak','ROLE_WIZARD', '$2a$10$N3gBiSKG5rdruRsN7X5IxeFR2p8HFJv7VUUmywxSzM0q5qNigpRty'),
       ('Robin','ROLE_PLAYER', '$2a$10$GiJ49ymJtaeDmKGJux8IcOgAW0/B3KE5rteuPxBaL2YUxxB2MEL9u');

-- default user profiles
insert into profiles(username, firstname, lastname, email, bio)
values ('Jan', 'Jan', 'Permudez', 'j.permudez@permuda.pm', 'Founder'),
       ('Sjaak', 'Sjaak', 'Mus', 's.mus@permuda.pm', 'Artist'),
       ('Robin', 'Robin', 'Kruis', 'r.kruis@permuda.pm', 'Wanderer');

-- default achievements
insert into achievements(title)
values ('ladder');

-- -- default rooms
-- insert into rooms(owner, x, y, z, description)
-- values ('Jan', '0', '0', '0', 'A deserted beach'),
--        ('Sjaak', '-1','0', '0', 'The west end of the beach' ),
--        ('Sjaak', '1','0', '0', 'The east end of the beach' ),
--        ('Sjaak', '0','1', '0', 'A forest' ),
--        ('Sjaak', '0','1', '1', 'A house in the tree' );