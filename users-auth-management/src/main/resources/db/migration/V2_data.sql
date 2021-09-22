INSERT INTO khooju_user_management.system_roles (id, rolename) VALUES (1, 'SYSTEM ADMISNISTRATOR');
INSERT INTO khooju_user_management.system_roles (id, rolename) VALUES (2, 'Accountant');

INSERT INTO khooju_user_management.users
(created_by, created_date, last_modified_by, last_modified_date, contact_number, emailid, password, username)
VALUES('', now(), , , '0123456789', 'contact@contact.com', '', '$2a$10$Dpl8ZXEBMTLkvka3aNtxkuLr6UJ5kWPjRCw8Zq7hVSU1xgMIm2An.');


INSERT INTO khooju_user_management.users_roles (user_id, role_id) VALUES(1, 1);

