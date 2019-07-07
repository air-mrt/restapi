
    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)

    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        created_at datetime,
        product_id bigint,
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        created_at datetime,
        description longtext,
        picture_path varchar(255),
        price varchar(255),
        title varchar(255),
        user_username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       username varchar(255) not null,
        email varchar(255),
        enabled integer,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        profile_picture varchar(255),
        primary key (username)
    ) engine=InnoDB

    create table chat (
       id bigint not null,
        message varchar(255),
        posted_date datetime not null,
        user_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table chat_message (
       id bigint not null,
        message varchar(255),
        posted_date datetime,
        chat_id bigint,
        user_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table product_user (
       product_id bigint not null,
        user_id varchar(255) not null,
        primary key (product_id, user_id)
    ) engine=InnoDB

    create table user_role (
       user_id varchar(255) not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment 
       add constraint FKm1rmnfcvq5mk26li4lit88pc5 
       foreign key (product_id) 
       references product (id)

    alter table comment 
       add constraint FKmf95pbbxoggg4srfk71xfusj7 
       foreign key (user_username) 
       references user (username)

    alter table product 
       add constraint FK4lxkhq5mij7cdbho3qj7bsrbx 
       foreign key (user_username) 
       references user (username)

    alter table chat 
       add constraint FK3rey0h7240vbk7odnpw75d87o 
       foreign key (user_id) 
       references user (username)

    alter table chat_message 
       add constraint FKax7xe8g71nf0wvpoychqkqeid 
       foreign key (chat_id) 
       references chat (id)

    alter table chat_message 
       add constraint FKf7tbywofv1iojpxc1kw8c3bx7 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKs0h810dfkus35pvkhneqsp2vb 
       foreign key (user_id) 
       references user (username)

    alter table product_user 
       add constraint FKiuj2a4hfnom5nla727e3ltr48 
       foreign key (product_id) 
       references product (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext, picture_path varchar(255), price varchar(255), title varchar(255), user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext, picture_path varchar(255), price varchar(255), title varchar(255), user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext not null, picture_path varchar(255), price varchar(255) not null, title varchar(255) not null, user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime not null, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext not null, picture_path varchar(255), price varchar(255) not null, title varchar(255) not null, user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime not null, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext not null, picture_path varchar(255), price varchar(255) not null, title varchar(255) not null, user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime not null, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext not null, picture_path varchar(255), price varchar(255) not null, title varchar(255) not null, user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime not null, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext not null, picture_path varchar(255), price varchar(255) not null, title varchar(255) not null, user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime not null, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext not null, picture_path varchar(255), price varchar(255) not null, title varchar(255) not null, user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime not null, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
create table comment (id bigint not null auto_increment, content varchar(255), created_at datetime, product_id bigint, user_username varchar(255), primary key (id)) engine=MyISAM
create table product (id bigint not null auto_increment, created_at datetime, description longtext not null, picture_path varchar(255), price varchar(255) not null, title varchar(255) not null, user_username varchar(255), primary key (id)) engine=MyISAM
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=MyISAM
create table user (username varchar(255) not null, email varchar(255), enabled integer, name varchar(255), password varchar(255), phone varchar(255), profile_picture varchar(255), primary key (username)) engine=MyISAM
create table chat (id bigint not null, message varchar(255), posted_date datetime not null, user_id varchar(255) not null, primary key (id)) engine=MyISAM
create table chat_message (id bigint not null, message varchar(255), posted_date datetime not null, chat_id bigint, user_id varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table product_user (product_id bigint not null, user_id varchar(255) not null, primary key (product_id, user_id)) engine=MyISAM
create table user_role (user_id varchar(255) not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM
alter table comment add constraint FKm1rmnfcvq5mk26li4lit88pc5 foreign key (product_id) references product (id)
alter table comment add constraint FKmf95pbbxoggg4srfk71xfusj7 foreign key (user_username) references user (username)
alter table product add constraint FK4lxkhq5mij7cdbho3qj7bsrbx foreign key (user_username) references user (username)
alter table chat add constraint FK3rey0h7240vbk7odnpw75d87o foreign key (user_id) references user (username)
alter table chat_message add constraint FKax7xe8g71nf0wvpoychqkqeid foreign key (chat_id) references chat (id)
alter table chat_message add constraint FKf7tbywofv1iojpxc1kw8c3bx7 foreign key (user_id) references user (username)
alter table product_user add constraint FKs0h810dfkus35pvkhneqsp2vb foreign key (user_id) references user (username)
alter table product_user add constraint FKiuj2a4hfnom5nla727e3ltr48 foreign key (product_id) references product (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (username)
