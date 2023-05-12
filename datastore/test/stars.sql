-- count stars
select count(*) from ceres.systems;

select * from ceres.systems limit 10;

select * from ceres.systems where name = 'Sol'; -- 10477373803
select s.* from `ceres`.`systems` s
    where 40 < x and x > -40
        and 40 < y > -40
        and 40 < z > -40;

call rankStarsFrom(10477373803 /*Sol*/, 30, 45, 1000)

select 1