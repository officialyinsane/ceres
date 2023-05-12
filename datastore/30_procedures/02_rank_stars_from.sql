use `ceres`;

delimiter $$
create or replace procedure rankStarsFrom (in `system` bigint, in min_distance float, in max_distance float, in max_records int) begin

    select `systemAddress`, `name`, `distance`, `starClass`,
        `starClass` regexp '^[KBGFOAM]$' `is_fuel_star`
        from (
        select `left_address` `systemAddress`, `name`, `starClass`,
           sqrt((`right_x` - `left_x`) * (`right_x` - `left_x`) +
                (`right_y` - `left_y`) * (`right_y` - `left_y`) +
                (`right_z` - `left_z`) * (`right_z` - `left_z`)) `distance`
        from (
             select `left`.`systemAddress` `left_address`, `left`.`name`, `left`.`starClass`, `left`.`x` `left_x`, `left`.`y` `left_y`, `left`.`z` `left_z`,
                    (select `x` from `ceres`.`systems` where `systemAddress` = `system`) right_x,
                    (select `y` from `ceres`.`systems` where `systemAddress` = `system`) right_y,
                    (select `z` from `ceres`.`systems` where `systemAddress` = `system`) right_z
             from `ceres`.`systems` `left`
        ) `d`
    ) `o`
    where distance >= min_distance
        and distance <= max_distance
    order by distance desc
    limit max_records;

end;
delimiter ;