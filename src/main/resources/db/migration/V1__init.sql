create table student
(
    id             int unsigned auto_increment primary key,
    password       text                                 not null comment '비밀번호',
    nickname       varchar(50)                          null comment '닉네임',
    name           varchar(50)                          null comment '이름',
    phone_number   varchar(255)                         null comment '휴대 전화 번호',
    email          varchar(100)                         not null comment '학교 email',
    gender         int unsigned                         null comment '성별',
    last_logged_at timestamp                            null comment '최근 로그인 일자',
    is_deleted     tinyint(1) default 0                 not null comment '탈퇴 여부',
    created_at     timestamp  default current_timestamp not null comment '회원가입 일자(생성 일자)',
    updated_at     timestamp  default current_timestamp not null on update current_timestamp comment '업데이트 일자',
    constraint unique_student_email unique (email),
    constraint unique_student_nickname unique (nickname)
);

create table semester
(
    id       int unsigned auto_increment primary key,
    semester varchar(10) not null comment '학기',
    constraint unique_semester_semester unique (semester)
);

create table lecture
(
    id             int unsigned auto_increment primary key,
    semester_id    int unsigned                        not null comment '학기',
    code           varchar(10)                         not null comment '과목코드',
    name           varchar(50)                         not null comment '교과목명',
    credit         int                                 not null comment '학점',
    class          varchar(3)                          not null comment '분반',
    regular_number varchar(4)                          not null comment '정원',
    department     varchar(30)                         not null comment '개설학부',
    target         varchar(200)                        not null comment '대상학부',
    professor      varchar(30)                         null comment '담당교수',
    class_time     varchar(100)                        not null comment '강의시간',
    created_at     timestamp default current_timestamp not null comment '생성 일자',
    updated_at     timestamp default current_timestamp not null on update current_timestamp comment '업데이트 일자',
    constraint fk_lecture_on_semester foreign key (semester_id) references semester (id)
);

create table timetable
(
    id          int unsigned auto_increment primary key,
    student_id  int unsigned not null comment '학생 id',
    semester_id int unsigned not null comment '학기 id',
    name        varchar(255) not null comment '시간표 이름',
    is_main     tinyint(1)   not null default 0 comment '메인 시간표 여부',
    is_deleted  tinyint(1)   not null default 0 comment '시간표 삭제 여부',
    created_at  timestamp             default current_timestamp not null comment '생성 일자',
    updated_at  timestamp             default current_timestamp not null on update current_timestamp comment '수정 일자',
    constraint fk_timetable_on_student foreign key (student_id) references student (id) on delete cascade,
    constraint fk_timetable_on_semester foreign key (semester_id) references semester (id),
    index timetable_index (student_id, semester_id) using btree
);

create table timetable_lecture
(
    id           int unsigned auto_increment primary key,
    grade        int                                 null comment '성적',
    memo         varchar(255)                        null comment '메모',
    is_deleted   tinyint(1)                          null default 0 comment '삭제 여부',
    created_at   timestamp default current_timestamp not null comment '생성 일자',
    updated_at   timestamp default current_timestamp not null on update current_timestamp comment '업데이트 일자',
    lecture_id   int unsigned                        null comment '강의_id',
    timetable_id int unsigned                        not null comment '시간표 프레임 id',
    constraint fk_timetable_on_lecture foreign key (lecture_id) references lecture (id),
    constraint fk_timetable_on_timetable_lecture foreign key (timetable_id) references timetable (id) on delete cascade
);