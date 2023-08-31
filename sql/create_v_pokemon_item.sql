create or replace definer = root@`%` view v_pokemon_item as
select concat('p', `t_pokemon`.`id`) AS `id`,
       `t_pokemon`.`number`          AS `number`,
       `t_pokemon`.`name`            AS `name`,
       `t_pokemon`.`description`     AS `description`,
       `t_pokemon`.`price`           AS `price`,
       `t_pokemon`.`type`            AS `type`
from `t_pokemon`
union all
select concat('i', `t_item`.`id`) AS `id`,
       `t_item`.`number`          AS `number`,
       `t_item`.`name`            AS `name`,
       `t_item`.`description`     AS `description`,
       `t_item`.`price`           AS `price`,
       `t_item`.`type`            AS `type`
from `t_item`;
