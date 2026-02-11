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
insert into achievements(title, owner)
values ('ladder', 'Sjaak');

-- default profile-achievement assignments
insert into profiles_achievements(profile_id, title)
values (2, 'ladder');

-- default rooms
insert into rooms(description, owner)
values ('A deserted beach', 'Jan'),
       ('The west end of the beach', 'Sjaak'),
       ('The east end of the beach', 'Sjaak'),
       ('A forest', 'Sjaak'),
       ('A house in the tree', 'Sjaak');

-- default standard exits
insert into actions(room_id, command, destination, owner)
values (1, 'west', 2, 'Jan'),
       (1, 'east', 3, 'Jan'),
       (1, 'north', 4, 'Jan'),
       (2, 'east', 1, 'Sjaak'),
       (3, 'west', 1, 'Sjaak'),
       (4, 'south', 1, 'Sjaak');

-- default special actions
insert into actions(room_id, command, requirement, succes, fail, destination, owner)
values (3, 'up', 'ladder', 'You used the ladder to climb up.', 'You have no ladder.', 4, 'Sjaak'),
       (4, 'down', 'ladder', 'You used the ladder to climb down', 'You have no ladder.', 3, 'Sjaak');

-- default rewarded actions
insert into actions(room_id, command, succes, fail, reward, owner)
values (3, 'make ladder', 'You made a ladder.', 'You have no materials', 'ladder', 'Sjaak');

-- default creatures
insert into creatures(room_id, description, owner)
values (3, 'A squirrel', 'Sjaak'),
       (4, 'A mouse', 'Sjaak');
