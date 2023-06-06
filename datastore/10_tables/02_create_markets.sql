use ceres;

drop table if exists `markets`;
create table `markets` (
    `marketId` bigint not null primary key,
    `systemAddress` bigint,
    `bodyId` int null,
    `name` varchar(255) null,
    `latitude` float null,
    `longitude` float null,
    `created` timestamp not null default current_timestamp,
    `updated` timestamp not null default current_timestamp on update current_timestamp
);

create index if not exists `idx_market_system` on `ceres`.`markets`(`systemAddress`);
create index if not exists `idx_market_created` on `ceres`.`markets`(`created`);
create index if not exists `idx_market_updated` on `ceres`.`markets`(`updated`);