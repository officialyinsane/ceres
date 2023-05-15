truncate ceres.commodities;
select count(*) from ceres.commodities;

select * from ceres.commodities
         where created <> commodities.updated
         order by stock desc

select s.name systemName, m.name marketName,
       c.name commodity, c.buyPrice, c.demand, c.sellPrice, c.stock
    from ceres.systems s
    join ceres.markets m on s.systemAddress = m.systemAddress
    join ceres.commodities c on c.marketId = m.marketId
;

select distinct name from ceres.commodities order by name desc

select distinct marketId from commodities
    where marketId not in (select distinct marketId from markets)