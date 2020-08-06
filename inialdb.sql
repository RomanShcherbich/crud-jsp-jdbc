DROP TABLE `crud_jsp_jdbc_demo`.`users`;

CREATE TABLE `users`
(
    `id`      int(3)      NOT NULL AUTO_INCREMENT,
    `name`    varchar(30) NOT NULL,
    `email`   varchar(30) NOT NULL,
    `country` varchar(30) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO `crud_jsp_jdbc_demo`.`users`
    (`name`, `email`, `country`)
VALUES
       ('Ivam', 'rfew@gdd.cw', 'Belur'),
       ('Ricardo', 'spain@gdd.cw', 'Spain');