create table `goal`(
	`id` Integer primary key auto_increment,
    `goal_name` varchar(50),
    `target_dollar_amount` double,
    `current_dollar_amount` double,
    `creation_date` timestamp,
    `target_date` timestamp,
    `description` varchar(500),
    `steps` varchar(200),
    `profile_id` varchar(50)
);