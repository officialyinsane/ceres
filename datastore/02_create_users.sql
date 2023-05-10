create user if not exists 'ingestor'@'%' identified by 'ingest0r'; -- TODO: prod db password safety
grant select,insert,update,delete on ceres.*  to 'ingestor'@'%';

create user if not exists 'insane'@'%' identified by 'insan3'; -- TODO: prod db password safety
grant all privileges on *.* to 'insane'@'%' with grant option;

create user if not exists 'reaper'@'%' identified by 'r3aper'; -- TODO: prod db password safety

flush privileges;
