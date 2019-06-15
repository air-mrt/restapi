drop schema airmart;
create schema airmart;
use airmart;
#add schema here

#initial data to run
INSERT INTO role (role) VALUES ('USER'), ('ADMIN'), ('SUPER');
#create user only at first time
create user 'airmart_user'@'localhost' identified by 'airmart_user';
grant select on airmart.* to 'airmart_user'@'localhost';
grant insert on airmart.* to 'airmart_user'@'localhost';
grant update on airmart.* to 'airmart_user'@'localhost';
grant delete on airmart.* to 'airmart_user'@'localhost';