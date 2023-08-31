create or replace definer = root@`%` view v_purchase as
select `o`.`id`                 AS `order_id`,
       `o`.`created_time`       AS `created_time`,
       `o`.`last_modified_time` AS `last_modified_time`,
       `o`.`coupon`             AS `coupon`,
       `o`.`order_history`      AS `order_history`,
       `o`.`status`             AS `status`,
       `o`.`total_price`        AS `total_price`,
       `a`.`id`                 AS `address_id`,
       `a`.`address`            AS `address`,
       `a`.`delivery_request`   AS `delivery_request`,
       `a`.`phone_number`       AS `phone_number`,
       `a`.`user_id`            AS `user_id`,
       `a`.`recipient`          AS `recipient`
from (`t_order` `o` join `t_user_address` `a` on (`o`.`user_address_id` = `a`.`id`));