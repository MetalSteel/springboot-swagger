-- 如果用户表存在则删除
DROP TABLE user IF EXISTS;
-- 创建用户表
CREATE TABLE user(
  id INT generated BY DEFAULT AS IDENTITY ,
  username VARCHAR(40),
  name VARCHAR(20),
  age INT(3),
  balance DECIMAL(10,2),
  PRIMARY KEY (id)
);
