use ceres;

drop table if exists `markets`;
create table `markets` (
    `marketId` bigint not null primary key,
    `systemAddress` bigint,
    `bodyId` int null,
    `name` varchar(255) null,
    `latitude` float null,
    `longitude` float null
);

create index `idx_market_system` on `ceres`.`markets`(`systemAddress`)