drop schema airmart;
create schema airmart;
create user 'airmart_user'@'localhost' identified by 'airmart_user';
grant select on airmart.* to 'airmart_user'@'localhost';
grant insert on airmart.* to 'airmart_user'@'localhost';
grant update on airmart.* to 'airmart_user'@'localhost';
grant delete on airmart.* to 'airmart_user'@'localhost';