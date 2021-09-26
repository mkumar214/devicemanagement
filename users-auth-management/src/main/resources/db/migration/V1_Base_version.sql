-- khooju_user_management.users definition

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `emailid` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- khooju_user_management.user_profile definition

CREATE TABLE `user_profile` (
  `id` bigint NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKuganfwvnbll4kn2a3jeyxtyi` (`user_id`),
  CONSTRAINT `FKuganfwvnbll4kn2a3jeyxtyi` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- khooju_user_management.user_credentails definition

CREATE TABLE `user_credentails` (
  `id` bigint NOT NULL,
  `contact_verified` bit(1) DEFAULT NULL,
  `email_verified` bit(1) DEFAULT NULL,
  `failed_login_attempt` int DEFAULT NULL,
  `is_account_locked` bit(1) DEFAULT NULL,
  `last_valid_login` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- khooju_user_management.system_roles definition

CREATE TABLE `system_roles` (
  `id` bigint NOT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- khooju_user_management.privilege definition

CREATE TABLE `privilege` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- khooju_user_management.users_addresses definition

CREATE TABLE `users_addresses` (
  `users_id` bigint NOT NULL,
  `address_type` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street1` varchar(255) DEFAULT NULL,
  `street2` varchar(255) DEFAULT NULL,
  KEY `FKqmitmtu33rjv24itwynru6429` (`users_id`),
  CONSTRAINT `FKqmitmtu33rjv24itwynru6429` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- khooju_user_management.users_roles definition

CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKqxe5mcxpk0379gnrtvmxfyodg` (`role_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKqxe5mcxpk0379gnrtvmxfyodg` FOREIGN KEY (`role_id`) REFERENCES `system_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





