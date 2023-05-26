use ceres;

drop table if exists `systems`;
create table `systems` (
    `systemAddress` bigint not null primary key,
    `x` float not null,
    `y` float not null,
    `z` float not null,
    `name` varchar(50) null,
    `starClass` varchar(22) null,
    `created` timestamp not null default current_timestamp,
    `updated` timestamp not null default current_timestamp on update current_timestamp
)