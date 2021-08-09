create table players
(
    id               bigint auto_increment,
    name             varchar(255),
    birth_date       date,
    player_position varchar(255),
    team_id        bigint,
    primary key (id),
    foreign key (team_id) REFERENCES teams(id)
);