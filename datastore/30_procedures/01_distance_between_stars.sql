use `ceres`;

drop function if exists distanceBetweenStars;
delimiter $$
create or replace procedure distanceBetweenStars (in `sys_left` bigint, in `sys_right` bigint, out `distance` float) begin

    select sqrt((`right`.`x` - `left`.`x`) * (`right`.`x` - `left`.x) +
                (`right`.`y` - `left`.`y`) * (`right`.`y` - `left`.y) +
                (`right`.`z` - `left`.`z`) * (`right`.`z` - `left`.z))
    into distance
        from `systems` as `left`
        join `systems` as `right` on `right`.`systemAddress` = sys_left
    where `left`.`systemAddress` = sys_right;

end;
delimiter ;