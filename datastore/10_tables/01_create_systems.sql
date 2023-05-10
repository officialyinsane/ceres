use ceres;

drop table if exists `systems`;
create table `systems` (
    `systemAddress` bigint not null primary key,
    `x` float not null,
    `y` float not null,
    `z` float not null,
    `name` varchar(50),
    `starClass` varchar(2)
)