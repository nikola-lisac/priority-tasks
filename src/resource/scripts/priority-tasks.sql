DROP SCHEMA IF EXISTS `priority_tasks`;
CREATE SCHEMA `priority_tasks` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

CREATE TABLE `priority_tasks`.`task` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `created_at` DATE NOT NULL,
  `completed` BIT(1) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;