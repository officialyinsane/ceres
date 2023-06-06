use ceres;

drop table if exists `commodities`;
create table `commodities` (
    `marketCommodity` varchar(255) not null primary key,
    `marketId` bigint,
    `systemAddress` bigint,
    `isProhibited` bit default false,
    `buyPrice` int null,
    `demand` int null,
    `demandBracket` int null,
    `meanPrice` int null,
    `name` varchar(255) null,
    `sellPrice` int null,
    `stock` int null,
    `stockBracket` int null,
    `created` timestamp not null default current_timestamp,
    `updated` timestamp not null default current_timestamp on update current_timestamp
);

create index if not exists `idx_commodity_market` on `ceres`.`commodities`(`marketId`);
create index if not exists `idx_commodity_system` on `ceres`.`commodities`(`systemAddress`);
create index if not exists `idx_commodity_created` on `ceres`.`commodities`(`created`);
create index if not exists `idx_commodity_updated` on `ceres`.`commodities`(`updated`);