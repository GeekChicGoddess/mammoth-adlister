USE adlister_db;



INSERT INTO users
(username, password, email)
VALUES
  ('padma', 'dragon', 'padma@mail.com');

INSERT INTO users
(username, password, email)
VALUES
  ('sebastian', 'prirate', 'sebastian@mail.com');

INSERT INTO users
(username, password, email)
VALUES
  ('crystal', 'pistol', 'crystal@mail.com');

INSERT INTO users
(username, password, email)
VALUES
  ('aaron', 'worlddominator', 'aaron@mail.com');

INSERT INTO users
(username, password, email)
VALUES
  ('roger', 'airbender', 'roger@mail.com');

INSERT INTO ads
(user_id, title, description)
VALUES
  (1, 'desk', 'large and sturdy');

INSERT INTO ads
(user_id, title, description)
VALUES
  (2, 'chair', 'swivels!  super fun!');

INSERT INTO ads
(user_id, title, description)
VALUES
  (3, 'computer', 'excellent for gaming');

INSERT INTO ads
(user_id, title, description)
VALUES
  (4, 'sofa', 'high quality.  great shape');

INSERT INTO ads
(user_id, title, description)
VALUES
  (5, 'car', 'vroom vroom!');