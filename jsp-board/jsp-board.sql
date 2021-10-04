create table board (
id INTEGER(5) auto_increment primary key,
title VARCHAR(50) NOT NULL,
writer VARCHAR(50) NOT NULL,
content TEXT NOT NULL,
hits INTEGER(10) DEFAULT '0',
reg_date timestamp default now(),
upd_date timestamp default now()
);

create table member (
user_no INTEGER(5) auto_increment primary key,
user_id varchar(50) not null,
user_pw varchar(100) not null,
user_name varchar(100) not null,
reg_date timestamp default now(),
upd_date timestamp default now(),
enabled char(1) default '1'
);

create table member_auth(
user_no integer(5) not null,
auth varchar(50) not null
);

create table reply(
id INTEGER(5) auto_increment primary key,
user_no INTEGER(5) NOT NULL,
board_no INTEGER(5) NOT NULL,
reply TEXT NOT NULL,
ref INTEGER(5) default '0',
step INTEGER(5) default '0',
ref_order INTEGER(5) default '0',
parent_id INTEGER(50) default '0',
reg_date timestamp default now(),
upd_date timestamp default now()
);

ALTER TABLE member_auth add constraint fk_member_auth_user_no
foreign key (user_no) references member(user_no);

ALTER TABLE reply add constraint fk_reply_user_no
foreign key (user_no) references member(user_no);

ALTER TABLE reply add constraint fk_reply_board_no
foreign key (board_no) references board(id);