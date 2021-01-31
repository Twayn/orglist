create table org_type (
    id   bigint       not null auto_increment,
    type varchar(255) not null,
    primary key (id)
);

create table org (
    id          bigint       not null auto_increment,
    org_name    varchar(255) not null,
    org_type_id bigint       null,
    primary key (id),
    foreign key (org_type_id) references org_type(id)
);

create table audit (
    id        bigint       not null auto_increment,
    date      timestamp    not null,
    type      varchar(255) not null,
    user_name varchar(255) not null,
    primary key (id)
);