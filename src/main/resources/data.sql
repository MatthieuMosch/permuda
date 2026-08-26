-- default authorization roles
insert into roles(rolename)
values ('ROLE_GOD'),
       ('ROLE_WIZARD'),
       ('ROLE_PLAYER');

-- default users authentication
insert into users(username, rolename, password)
values ('Jan', 'ROLE_GOD', '$2a$10$XB9j4Uf72XqTk1/sPtirsep4m4vBVCOYknF6YDpoDFqbYiiXuaK0u'),
       ('Sjaak', 'ROLE_WIZARD', '$2a$10$N3gBiSKG5rdruRsN7X5IxeFR2p8HFJv7VUUmywxSzM0q5qNigpRty'),
       ('Robin', 'ROLE_PLAYER', '$2a$10$GiJ49ymJtaeDmKGJux8IcOgAW0/B3KE5rteuPxBaL2YUxxB2MEL9u');

-- default users profiles
insert into profiles(username, firstname, lastname, email, bio)
values ('Jan', 'Jan', 'Permudez', 'j.permudez@permuda.pm', 'Founder'),
       ('Sjaak', 'Sjaak', 'Mus', 's.mus@permuda.pm', 'Artist'),
       ('Robin', 'Robin', 'Kruis', 'r.kruis@permuda.pm', 'Wanderer');

-- default achievements
insert into achievements(title, owner_id)
values ('ladder', 2);

-- default achievement-profile assignments
insert into achievements_profiles(title, profile_id)
values ('ladder', 2);

-- default rooms
insert into rooms(description, owner_id)
values ('A deserted beach', 1),
       ('The west end of the beach', 2),
       ('The east end of the beach', 2),
       ('A forest', 2),
       ('A house in the tree', 2);

-- default standard exits
insert into actions(room_id, command, destination_id, owner_id)
values (1, 'west', 2, 1),
       (1, 'east', 3, 1),
       (1, 'north', 4, 1),
       (2, 'east', 1, 2),
       (3, 'west', 1, 2),
       (4, 'south', 1, 2);

-- default special actions
insert into actions(room_id, command, requirement_title, succes, fail, destination_id, owner_id)
values (3, 'up', 'ladder', 'You used the ladder to climb up.', 'You have no ladder.', 4, 2),
       (4, 'down', 'ladder', 'You used the ladder to climb down', 'You have no ladder.', 3, 2);

-- default rewarded actions
insert into actions(room_id, command, succes, fail, reward_title, owner_id)
values (3, 'make ladder', 'You made a ladder.', 'You have no materials', 'ladder', 2);

-- default creatures
insert into creatures(room_id, description, owner_id)
values (3, 'A squirrel', 2),
       (4, 'A mouse', 2);
