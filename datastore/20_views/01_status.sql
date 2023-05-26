use ceres;

create or replace view `ceres`.`v_status` as

    select
        'systems' `label`,
        count(*) `total`,
        sum(created >= date_add(current_timestamp, interval -5 minute)) `5min`,
        sum(created >= date_add(current_timestamp, interval -10 minute)) `10min`,
        sum(created >= date_add(current_timestamp, interval -15 minute)) `15min`,
        sum(created >= date_add(current_timestamp, interval -1 day)) `day`,
        sum(created >= date_add(current_timestamp, interval -30 day)) `30day`,
        sum(created >= date_add(current_timestamp, interval -60 day)) `60day`,
        sum(created >= date_add(current_timestamp, interval -90 day)) `90day`
    from ceres.systems
    union all select
        'markets' `label`,
        count(*) `total`,
        sum(created >= date_add(current_timestamp, interval -5 minute)) `5min`,
        sum(created >= date_add(current_timestamp, interval -10 minute)) `10min`,
        sum(created >= date_add(current_timestamp, interval -15 minute)) `15min`,
        sum(created >= date_add(current_timestamp, interval -1 day)) `day`,
        sum(created >= date_add(current_timestamp, interval -30 day)) `30day`,
        sum(created >= date_add(current_timestamp, interval -60 day)) `60day`,
        sum(created >= date_add(current_timestamp, interval -90 day)) `90day`
    from ceres.markets
    union all select
        'commodities' `label`,
        count(*) `total`,
        sum(created >= date_add(current_timestamp, interval -5 minute)) `5min`,
        sum(created >= date_add(current_timestamp, interval -10 minute)) `10min`,
        sum(created >= date_add(current_timestamp, interval -15 minute)) `15min`,
        sum(created >= date_add(current_timestamp, interval -1 day)) `day`,
        sum(created >= date_add(current_timestamp, interval -30 day)) `30day`,
        sum(created >= date_add(current_timestamp, interval -60 day)) `60day`,
        sum(created >= date_add(current_timestamp, interval -90 day)) `90day`
    from ceres.commodities
;