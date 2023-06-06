use api;

drop table if exists `user`;
create table `user` (
    `id` bigint not null primary key,
    `username` varchar(45) not null,
    `enabled` bit not null default 0,
    `provider` varchar(15) not null
)