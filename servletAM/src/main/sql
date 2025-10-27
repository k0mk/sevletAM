drop database if exists JSP_AM;
create database JSP_AM;
use JSP_AM;

create table article(
	id int unsigned primary key auto_increment
	, regDate datetime not null
	, updateDate datetime not null
	, title varchar(100) not null
	, content text not null
);
select * from article
order by id desc;

INSERT INTO article (regDate, updateDate, title, content) VALUES (
    NOW(),
    NOW(),
    '첫 번째 테스트 게시글',
    '이것은 첫 번째 게시글의 내용입니다. 데이터베이스 테스트를 위해 작성되었습니다.'
);
INSERT INTO article (regDate, updateDate, title, content) VALUES (
    NOW(),
    NOW(),
    '두 번째 게시글: 데이터베이스 연습',
    '두 번째 게시글은 좀 더 기술적인 내용을 담을 수 있습니다. 예를 들어, SQL 쿼리 연습이나 데이터 모델링에 대한 설명 등이 될 수 있겠죠.'
);
INSERT INTO article (regDate, updateDate, title, content) VALUES (
    NOW(),
    NOW(),
    '세 번째 샘플 기사 제목',
    '세 번째 기사는 짧고 간결하게 작성해보았습니다. 핵심 정보만 전달하는 목적입니다.'
);
INSERT INTO article (regDate, updateDate, title, content) VALUES (
    NOW(),
    NOW(),
    '네 번째 글: 마무리 테스트',
    '마지막으로 네 번째 게시글입니다. 모든 칼럼에 데이터가 잘 들어갔는지 확인해보세요. 특히 `regDate`와 `updateDate`는 `NOW()` 함수를 사용하여 현재 시간이 기록됩니다.'
);