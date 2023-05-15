use ceres;

create or replace view `ceres`.`v_status` as
    select
        count(*) `count`, 'system_5_minute' `label` from `ceres`.`systems` `sys5`
    where sys5.created >= date_add(current_timestamp, interval -5 minute)
    union all
    select
        count(*) `count`, 'system_10_minute' `label` from `ceres`.`systems` `sys`
    where sys.created >= date_add(current_timestamp, interval -10 minute)
    union all
    select
        count(*) `count`, 'system_15_minute' `label` from `ceres`.`systems` `sys`
    where sys.created >= date_add(current_timestamp, interval -15 minute)
    union all
    select
        count(*) `count`, 'system_1_day' `label` from `ceres`.`systems` `sys`
    where sys.created >= date_add(current_timestamp, interval -1 day)
    union all
    select
        count(*) `count`, 'system_30_day' `label` from `ceres`.`systems` `sys`
    where sys.created >= date_add(current_timestamp, interval -30 day)
    union all
    select
        count(*) `count`, 'market_5_minute' `label` from `ceres`.`markets` `m`
    where m.created >= date_add(current_timestamp, interval -5 minute)
    union all
    select
        count(*) `count`, 'market_10_minute' `label` from `ceres`.`markets` `m`
    where m.created >= date_add(current_timestamp, interval -10 minute)
    union all
    select
        count(*) `count`, 'market_15_minute' `label` from `ceres`.`markets` `m`
    where m.created >= date_add(current_timestamp, interval -15 minute)
    union all
    select
        count(*) `count`, 'market_1_day' `label` from `ceres`.`markets` `m`
    where m.created >= date_add(current_timestamp, interval -1 day)
    union all
    select
        count(*) `count`, 'market_30_day' `label` from `ceres`.`markets` `m`
    where m.created >= date_add(current_timestamp, interval -30 day)
    union all
    select
        count(*) `count`, 'commodity_5_minute' `label` from `ceres`.`commodities` `c`
    where c.created >= date_add(current_timestamp, interval -5 minute)
    union all
    select
        count(*) `count`, 'commodity_10_minute' `label` from `ceres`.`commodities` `c`
    where c.created >= date_add(current_timestamp, interval -10 minute)
    union all
    select
        count(*) `count`, 'commodity_15_minute' `label` from `ceres`.`commodities` `c`
    where c.created >= date_add(current_timestamp, interval -15 minute)
    union all
    select
        count(*) `count`, 'commodity_1_day' `label` from `ceres`.`commodities` `c`
    where c.created >= date_add(current_timestamp, interval -1 day)
    union all
    select
        count(*) `count`, 'commodity_30_day' `label` from `ceres`.`commodities` `c`
    where c.created >= date_add(current_timestamp, interval -30 day)
;

select * from ceres.v_status