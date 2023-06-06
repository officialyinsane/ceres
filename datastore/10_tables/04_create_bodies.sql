use ceres;

drop table if exists `bodies`;
create table `bodies` (
    `bodyIdentity` varchar(32) not null primary key,
    `bodyId` int not null,
    `name` varchar(255) not null,
    `systemAddress` bigint not null,
    `created` timestamp not null default current_timestamp,
    `updated` timestamp not null default current_timestamp on update current_timestamp
);

create index if not exists `idx_bodies_name` on `ceres`.`bodies`(`name`);
create index if not exists `idx_bodies_system` on `ceres`.`bodies`(`systemAddress`);
create index if not exists `idx_bodies_created` on `ceres`.`bodies`(`created`);
create index if not exists `idx_bodies_updated` on `ceres`.`bodies`(`updated`);

-- TODO: Foreign keys