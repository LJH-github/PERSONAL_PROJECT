create table t_files
(
    id          int(8) auto_increment
        primary key,
    oldFileName varchar(200) null,
    newFileName varchar(300) null,
    ext         varchar(20)  null,
    path        varchar(300) null,
    size        varchar(200) null,
    type        varchar(120) null,
    downcounts  int(6)       null,
    uploadTime  datetime     null,
    userId      int(8)       null,
    constraint t_files_t_user_id_fk
        foreign key (userId) references t_user (id)
);

INSERT INTO filemanagement.t_files (id, oldFileName, newFileName, ext, path, size, type, downcounts, uploadTime, userId) VALUES (9, 'springcloud.jpg', '202106092157290f4eed6cb7934ca99db620309a5af160.jpg', '.jpg', '/files/2021-06-09', '49332', 'image/jpeg', 0, '2021-06-09 21:57:29', 1);
create table t_user
(
    id       int(8) auto_increment
        primary key,
    username varchar(80) null,
    password varchar(80) null
);

INSERT INTO filemanagement.t_user (id, username, password) VALUES (1, 'jinghai', '123456');
INSERT INTO filemanagement.t_user (id, username, password) VALUES (2, 'xiaoli', '123456');