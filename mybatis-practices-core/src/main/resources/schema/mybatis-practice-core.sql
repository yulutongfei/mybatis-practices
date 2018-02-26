drop DATABASE if EXISTS mybatis;
create database if not EXISTS mybatis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use mybatis;

create TABLE if not EXISTS t_country(

  country_id BIGINT not null AUTO_INCREMENT,
  country_name VARCHAR(255) NULL ,
  country_code VARCHAR(255),
  PRIMARY KEY (country_id)
);

insert into t_country(country_name,country_code)values('中国','CN'),('美国','US'),('俄罗斯','RU'),('英国','GB'),('法国','FR');

select * from t_country;