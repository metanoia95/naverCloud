-- Data source Explorer에서 com 2번 클릭해서 mysql 연결해줌.

-- 회원정보 (email. pw, tel, address)
-- 를 저장하는 테이블 생성하기

create table Member
(
	email varchar(100),
	pw varchar(100) not null,
	tel varchar(100),
	address varchar(200),
	
	constraint member_email_pk primary key(email)

);
-- 블록 지정 후 > alt + x

select * from Board


-- 게시글
-- 제목, 작성자, 작성일, 내용, 조회수, 이미지...
create table Board
(
	title varchar(100) not null,
	writer varchar(100) not null,
	content varchar(1000), 
	img varchar(200), 
	indate datetime default now(), 
	count int default 0, 
	idx int auto_increment, 
	
	
	constraint Board_idx_pk primary key(idx),
	constraint Board_writer_fk foreign key(writer) 
	references Member(email)
	
);


insert into Board(title, writer, content) 
values(
	'불타는 미래, 거기엔 오직 전쟁뿐이니.',
	'dorn',
	'게시판 만들기'
	
);

update Board
set count = 35
where writer = "romain"




