
# [sql-quick-study](https://www.nowcoder.com/ta/sql-quick-study)

## 01 基础查询

### 概念：[基础查询](https://www.nowcoder.com/knowledge/intro-index?kcid=9)

- [SQL1 查询多列](https://www.nowcoder.com/practice/499b6d01eae342b2aaeaf4d0da61cab0?tpId=199&tqId=1971218&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营同学想要用户的设备 id 对应的性别、年龄和学校的数据，请你取出相应数据

  **语法：** `select 要显示的列名 from 表名; SELECT 关键字后给出多个列名，列名之间必须以逗号分隔`

  ```sql
  SELECT 
  	device_id, 
  	gender, 
  	age, 
  	university
  FROM user_profile;
  ```

- [SQL2 查询所有列](https://www.nowcoder.com/practice/f9f82607cac44099a77154a80266234a?tpId=199&tqId=1971219&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要查看用户信息表中所有的数据，请你取出相应结果

  **语法：** `select * from 表名; 在实际列名的位置使用星号（*）通配符`

  ```sql
  SELECT *
  FROM user_profile;
  ```

### 概念：[简单处理查询结果](https://www.nowcoder.com/knowledge/intro-index?kcid=10)

- [SQL3 查询结果去重](https://www.nowcoder.com/practice/82ebd89f12cf48efba0fecb392e193dd?tpId=199&tqId=1971234&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营需要查看用户来自于哪些学校，请从用户信息表中取出学校的去重数据。

  **语法：** `Distinct 关键字加在去重字段前`

  ```sql
  SELECT 
  	DISTINCT university
  FROM user_profile;
  ```

- [SQL4 查询结果限制返回行数](https://www.nowcoder.com/practice/c7ad0e2df4f647dfa5278e99894a7561?tpId=199&tqId=1971238&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营只需要查看前 2 个用户明细设备 ID 数据，请你从用户信息表 user_profile 中取出相应结果。

  **语法：** `Limit N，N代表想要限制返回的行数`

  ```sql
  SELECT 
  	device_id
  FROM user_profile
  LIMIT 2;
  ```

- [SQL5 将查询后的列重新命名](https://www.nowcoder.com/practice/0d8f49aeaf7a4e1cb7fecec980712113?tpId=199&tqId=1971243&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在你需要查看前 2 个用户明细设备 ID 数据，并将列名改为 'user_infos_example',，请你从用户信息表取出相应结果。

  **语法：** `SQL也提供了列重命名的语法--'AS'`

  ```sql
  SELECT 
  	device_id AS user_infos_example 
  FROM user_profile 
  LIMIT 2;
  ```

## 02 条件查询

### 概念：[基础排序](https://www.nowcoder.com/knowledge/intro-index?kcid=11)

- [SQL36 查找后排序](https://www.nowcoder.com/practice/cd4c5f3a64b4411eb4810e28afed6f54?tpId=199&tqId=2002632&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要取出用户信息表中的用户年龄，请取出相应数据，并按照年龄升序排序。

  **语法：** `为了明确地排序用 SELECT语句检索出的数据，可使用 ORDER BY 子句。 ORDER BY 子句取一个或多个列的名字，据此对输出进行排序。`

  ```sql
  SELECT 
  	device_id, age
  FROM user_profile
  ORDER BY age;
  ```

- [SQL37 查找后多列排序](https://www.nowcoder.com/practice/39f74706f8d94d37865a82ffb7ba67d3?tpId=199&tqId=2002633&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要取出用户信息表中的年龄和 gpa 数据，并先按照 gpa 升序排序，再按照年龄升序排序输出，请取出相应数据。

  **语法：** `列名之间用逗号分开`

  ```sql
  SELECT 
  	device_id, 
  	gpa, 
  	age
  FROM user_profile
  ORDER BY gpa, age;
  ```

- [SQL38 查找后降序排列](https://www.nowcoder.com/practice/d023ae0191e0414ca1b19451099a39f1?tpId=199&tqId=2002634&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要取出用户信息表中对应的数据，并先按照 gpa、年龄降序排序输出，请取出相应数据。

  **语法：** `进行降序排序， 必须指定DESC 关键字`

  ```sql
  SELECT 
  	device_id, 
  	gpa, 
  	age
  FROM user_profile
  ORDER BY gpa DESC, age DESC;
  ```

### 概念：[基础操作符](https://www.nowcoder.com/knowledge/intro-index?kcid=12)

- [SQL6 查找学校是北大的学生信息](https://www.nowcoder.com/practice/7858f3e234bc4d85b81b9a6c3926f49f?tpId=199&tqId=1971248&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要筛选出所有北京大学的学生进行用户调研，请你从用户信息表中取出满足条件的数据，结果返回设备 id 和学校。

  **语法：** `以使用WHERE语句对数据进行过滤`

  ```sql
  SELECT 
  	device_id, 
  	university
  FROM user_profile
  WHERE university = '北京大学';
  ```

- [SQL7 查找年龄大于 24 岁的用户信息](https://www.nowcoder.com/practice/2ae16bf2fd54415f99344e6024470d57?tpId=199&tqId=1971384&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要针对 24 岁以上的用户开展分析，请你取出满足条件的设备 ID、性别、年龄、学校。

  **语法：** `大于号SQL中的写法为 > `

  ```sql
  SELECT 
  	device_id, 
  	gender, 
  	age, 
  	university
  FROM user_profile
  WHERE age > 24;
  ```

- [SQL8 查找某个年龄段的用户信息](https://www.nowcoder.com/practice/be54223075cc43ceb20e4ce8a8e3e340?tpId=199&tqId=1971603&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要针对 20 岁及以上且 23 岁及以下的用户开展分析，请你取出满足条件的设备 ID、性别、年龄。

  **语法：** `范围值限制方法为between n1 and n2，n1和n2为要限制的区间范围`

  > 使用中需要注意两点：
  >
  > 一是 and 之前的值 需要小于 and 之后的值，不然查询会返回空结果。
  >
  > 二是在 hive sql 中结果会包括两端值，即如果语句写为 betwen 10 and 20, 那么结果中会包括取值等于 10 或 20 的数据。

  ```sql
  SELECT 
  	device_id, 
  	gender, 
  	age
  FROM user_profile
  WHERE age BETWEEN 20 AND 23;
  ```

- [SQL9 查找除复旦大学的用户信息](https://www.nowcoder.com/practice/c12a056497404d1ea782308a7b821f9c?tpId=199&tqId=1971604&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要查看除复旦大学以外的所有用户明细，请你取出相应数据

  **语法：** `不等于号在SQL中的写法为 < > 或 ！=，代表筛选出不满足某条件的数据。`

  ```sql
  SELECT 
  	device_id, 
  	gender, 
  	age, 
  	university 
  FROM user_profile 
  WHERE university <> '复旦大学';
  ```

- [SQL10 用 where 过滤空值练习](https://www.nowcoder.com/practice/08c9846a423540319eea4be44e339e35?tpId=199&tqId=1971605&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要对用户的年龄分布开展分析，在分析时想要剔除没有获取到年龄的用户，请你取出所有年龄值不为空的用户的设备 ID，性别，年龄，学校的信息。

  **语法：** `想要剔除空值数据的话，需要用一个特殊的WHERE子句，IS NOT NULL`

  ```sql
  SELECT 
  	device_id, 
  	gender, 
  	age, 
  	university
  FROM user_profile 
  WHERE age IS NOT NULL;
  ```

### 概念：[高级操作符](https://www.nowcoder.com/knowledge/intro-index?kcid=13)

- [SQL11 高级操作符练习(1)](https://www.nowcoder.com/practice/2d2e37474197488fbdf8f9206f66651c?tpId=199&tqId=1971781&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要找到男性且 GPA 在 3.5 以上(不包括 3.5)的用户进行调研，请你取出相关数据。

  **语法：** `在过滤数据时如果我们想结果同时满足多个条件，可以使用 AND 操作符给 WHERE子句附加条件`

  ```sql
  SELECT  
  	device_id, 
  	gender, 
  	age, 
  	university, 
  	gpa 
  FROM user_profile 
  WHERE gender = 'male' AND gpa > 3.5;
  ```

- [SQL12 高级操作符练习(2）](https://www.nowcoder.com/practice/25bcf6924eff417d90c8988f55675122?tpId=199&tqId=1971821&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要找到学校为北大或 GPA 在 3.7 以上(不包括 3.7)的用户进行调研，请你取出相关数据

  **语法：** `OR 操作符逻辑与 AND 操作符正好相反，在过滤数据时如果我们想要结果只需满足多个条件中的一个，可以使用OR操作符对条件进行连接`

  ```sql
  SELECT 
  	device_id, 
  	gender, 
  	age, 
  	university, 
  	gpa
  FROM user_profile
  WHERE university = '北京大学' OR gpa > 3.7;
  ```

- [SQL13 Where in 和 Not in](https://www.nowcoder.com/practice/0355033fc2244cdaa09b2bd6e794c762?tpId=199&tqId=1975665&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要找到学校为北大、复旦和山大的同学进行调研，请你取出相关数据。

  **语法：** `IN 操作符用来指定条件范围，范围中的每个条件都可以进行匹配。IN 取 一组由逗号分隔、括在圆括号中的合法值。`

  ```sql
  SELECT  
  	device_id, 
  	gender, 
  	age, 
  	university, 
  	gpa
  FROM user_profile
  WHERE university IN ('北京大学', '复旦大学', '山东大学');
  ```

- [SQL14 操作符混合运用](https://www.nowcoder.com/practice/d5ac4c878b63477fa5e5dfcb427d9102?tpId=199&tqId=1975666&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要找到 gpa 在 3.5 以上(不包括 3.5)的山东大学用户 或 gpa 在 3.8 以上(不包括 3.8)的复旦大学同学进行用户调研，请你取出相应数据

  **语法：** `WHERE 子句其实可以包含任意数目的 AND 和 OR 操作符 | SQL在处理 OR操作符前，优先处理 AND 操作符`

  ```sql
  SELECT  
  	device_id, 
  	gender, 
  	age, 
  	university, 
  	gpa
  FROM user_profile
  WHERE gpa > 3.5 AND university = '山东大学' OR (gpa > 3.8 AND university = '复旦大学');
  ```

- [SQL15 查看学校名称中含北京的用户](https://www.nowcoder.com/practice/95d9922b1e2a49de80daa491889969ee?tpId=199&tqId=1975667&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想查看所有大学中带有北京的用户的信息，请你取出相应数据。

  **语法：** `Like操作符——模糊匹配 一般最常用的通配符是 %`

  ```sql
  SELECT  
  	device_id, 
  	age, 
  	university
  FROM user_profile
  WHERE university LIKE '%北京%';
  ```

## 03 高级查询

### 概念：[计算函数](https://www.nowcoder.com/knowledge/intro-index?kcid=14)

- [SQL16 查找 GPA 最高值](https://www.nowcoder.com/practice/4e22fc5dbd16414fb2c7683557a84a4f?tpId=199&tqId=1975668&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 运营想要知道复旦大学学生 gpa 最高值是多少，请你取出相应数据

  **语法：** `MAX()返回指定列中的最大值。MAX在使用时，（）需指定要返回最大值的列名`

  ```sql
  SELECT 
  	MAX(gpa)
  FROM user_profile
  WHERE university = '复旦大学';
  ```

- [SQL17 计算男生人数以及平均 GPA](https://www.nowcoder.com/practice/7d9a7b2d6b4241dbb5e5066d7549ca01?tpId=199&tqId=1975669&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要看一下男性用户有多少人以及他们的平均 gpa 是多少，用以辅助设计相关活动，请你取出相应数据。

  **语法：** `COUNT()函数为计数函数，可利用 COUNT()确定表中行的数目或符合特定 条件的行的数目 | AVG()为平均值函数，通过对表中行数计数并计算其列值之和，求得该列的平均值`

  ```sql
  SELECT COUNT(*) AS male_num, AVG(gpa)
  FROM user_profile
  WHERE gender = 'male';
  ```

### 概念：[分组查询](https://www.nowcoder.com/knowledge/intro-index?kcid=15)

- [SQL18 分组计算练习题](https://www.nowcoder.com/practice/009d8067d2df47fea429afe2e7b9de45?tpId=199&tqId=1975670&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要对每个学校不同性别的用户活跃情况和发帖数量进行分析，请分别计算出每个学校每种性别的用户数、30 天内平均活跃天数和平均发帖数量。

  **语法：** `用 GROUP BY 分组数据`

  ```sql
  SELECT
      gender,
      university,
      COUNT(device_id) AS user_num,
      AVG(active_days_within_30) AS avg_active_day,
      AVG(question_cnt) AS avg_question_cnt
  FROM user_profile
  GROUP BY university, gender;
  ```

- [SQL19 分组过滤练习题](https://www.nowcoder.com/practice/ddbcedcd9600403296038ee44a172f2d?tpId=199&tqId=1975671&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想查看每个学校用户的平均发贴和回帖情况，寻找低活跃度学校进行重点运营，请取出平均发贴数低于 5 的学校或平均回帖数小于 20 的学校。

  **语法：** `分组查询的结果不能简单的使用Where语句进行过滤，而需要使用专门的Having语句。`

  ```sql
  SELECT
      university,
      AVG(question_cnt) AS avg_question_cnt,
      AVG(answer_cnt) AS avg_answer_cnt
  FROM user_profile
  GROUP BY university
  HAVING avg_question_cnt < 5 OR avg_answer_cnt < 20;
  ```

- [SQL20 分组排序练习题](https://www.nowcoder.com/practice/e00bbac732cb4b6bbc62a52b930cb15e?tpId=199&tqId=1975672&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要查看不同大学的用户平均发帖情况，并期望结果按照平均发帖情况进行升序排列，请你取出相应数据。

  **语法：** `分组查询结果也支持排序功能，所需要用到的语句是Order By `

  ```sql
  SELECT
      university,
      AVG(question_cnt) AS avg_question_cnt
  FROM user_profile
  GROUP BY university
  ORDER BY avg_question_cnt;
  ```

## 04 多表查询

### 概念：[子查询](https://www.nowcoder.com/knowledge/intro-index?kcid=16)

- [SQL21 浙江大学用户题目回答情况](https://www.nowcoder.com/practice/55f3d94c3f4d47b69833b335867c06c1?tpId=199&tqId=1975673&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要查看所有来自浙江大学的用户题目回答明细情况，请你取出相应数据

  **语法：** `以 IN 操作符要求的逗号分隔的格式传递给外部查询的 WHERE 子句外部查询`

  ```sql
  SELECT
      device_id,
      question_id,
      result
  FROM question_practice_detail
  WHERE device_id IN (
      SELECT 
      	device_id 
      FROM user_profile 
      WHERE university = '浙江大学'
  );
  ```

### 概念：[链接查询](https://www.nowcoder.com/knowledge/intro-index?kcid=17)

- [SQL22 统计每个学校的答过题的用户的平均答题数](https://www.nowcoder.com/practice/88aa923a9a674253b861a8fa56bac8e5?tpId=199&tqId=1975674&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 运营想要了解每个学校答过题的用户平均答题数量情况，请你取出数据。

  **问题分解：**

  > 限定条件：无；
  >
  > 每个学校：按学校分组，group by university
  >
  > 平均答题数量：在每个学校的分组内，用总答题数量除以总人数即可得到平均答题数量 count(question_id) / count(distinct device_id)。
  >
  > 表连接：学校和答题信息在不同的表，需要做连接

  ```sql
  SELECT
      university,
      COUNT(question_id) / COUNT(DISTINCT b.device_id) AS avg_answer_cnt
  FROM
  (
      SELECT 
      	device_id, 
      	university
      FROM user_profile
  )a
  JOIN
  (
      SELECT 
      	device_id, 
      	question_id
      FROM question_practice_detail
  )b
  ON a.device_id = b.device_id
  GROUP BY university;
  ```

- [SQL23 统计每个学校各难度的用户平均刷题数](https://www.nowcoder.com/practice/5400df085a034f88b2e17941ab338ee8?tpId=199&tqId=1975675&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 运营想要计算一些参加了答题的不同学校、不同难度的用户平均答题量，请你写 SQL 取出相应数据

  **问题分解：**

  > 限定条件：无；
  >
  > 不同学校、不同难度：按学校分组按难度分组，GROUP BY university, difficult_level
  >
  > 平均刷题数量：总答题数除以总人数 count(qpd.question_id) / count(distinct qpd.device_id)
  >
  > 需要联表，up 与 qpd 用 device_id 连接，qd 与 qpd 用 question_id 连接。

  ```sql
  SELECT
      university,
      difficult_level,
      COUNT(qpd.question_id) / COUNT(DISTINCT qpd.device_id) AS avg_answer_cnt
  FROM question_practice_detail AS qpd
  
  LEFT JOIN user_profile AS up
  ON up.device_id=qpd.device_id
  
  LEFT JOIN question_detail AS qd
  ON qd.question_id=qpd.question_id
  
  GROUP BY university, difficult_level;
  ```

- [SQL24 统计每个用户的平均刷题数](https://www.nowcoder.com/practice/f4714f7529404679b7f8909c96299ac4?tpId=199&tqId=1975676&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 运营想要查看参加了答题的山东大学的用户在不同难度下的平均答题题目数，请取出相应数据

  **问题分解：**

  > 限定条件：山东大学；
  >
  > 不同难度：按难度分组，group by difficult_level
  >
  > 平均刷题数量：在每个难度的分组内，用总答题数量除以总人数即可得到平均答题数量 COUNT(qpd.question_id) / COUNT(DISTINCT qpd.device_id)。
  >
  > 表连接：学校和答题信息在不同的表，需要做连接

  ```sql
  SELECT
      up.university,
      qd.difficult_level,
      COUNT(qpd.question_id) / COUNT(DISTINCT qpd.device_id) AS avg_answer_cnt
  FROM question_practice_detail AS qpd
  
  LEFT JOIN user_profile AS up
  ON up.device_id=qpd.device_id
  
  LEFT JOIN question_detail AS qd
  ON qd.question_id =  qpd.question_id
  WHERE up.university = '山东大学'
  GROUP BY qd.difficult_level;
  ```

### 概念：[组合查询](https://www.nowcoder.com/knowledge/intro-index?kcid=18)

- [SQL25 查找山东大学或者性别为男生的信息](https://www.nowcoder.com/practice/979b1a5a16d44afaba5191b22152f64a?tpId=199&tqId=1975677&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要分别查看学校为山东大学或者性别为男性的用户的 device_id、gender、age 和 gpa 数据，请取出相应结果，结果不去重。

  **语法：** `可用 UNION 操作符来组合数条 SQL 查询。利用 UNION，可给出多条 SELECT 语句，将它们的结果组合成一个结果集。| UNION 从查询结果集中自动去除了重复的行；|如果想不去重的返回所有的匹配行，可使用 UNION ALL而不是UNION`

  ```sql
  SELECT 
  	device_id, 
  	gender, 
  	age, 
  	gpa
  FROM user_profile
  WHERE university = '山东大学'
  UNION ALL
  SELECT 
  	device_id, 
  	gender, 
  	age, 
  	gpa
  FROM user_profile
  WHERE gender = 'male';
  ```

## 05 必会的常用函数

### 概念：[条件函数](https://www.nowcoder.com/knowledge/intro-index?kcid=19)

- [SQL26 计算 25 岁以上和以下的用户数量](https://www.nowcoder.com/practice/30f9f470390a4a8a8dd3b8e1f8c7a9fa?tpId=199&tqId=1975678&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要将用户划分为 25 岁以下和 25 岁及以上两个年龄段，分别查看这两个年龄段用户数量

  **语法：** `Case when`

  ```sql
  SELECT
      CASE
          WHEN age < 25 OR age IS NULL THEN '25岁以下'
          ELSE '25岁及以上'
      END age_cut, COUNT(*) number
  FROM user_profile
  GROUP BY age_cut;
  ```

- [SQL27 查看不同年龄段的用户明细](https://www.nowcoder.com/practice/ae44b2b78525417b8b2fc2075b557592?tpId=199&tqId=1975679&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要将用户划分为 20 岁以下，20-24 岁，25 岁及以上三个年龄段，分别查看不同年龄段用户的明细情况，请取出相应数据。（注：若年龄为空请返回其他。）

  **语法：** `Case when`

  ```sql
  SELECT
      device_id, gender,
      CASE
          WHEN age < 20 THEN '20岁以下'
          WHEN age < 25 THEN '20-24岁'
          WHEN age >= 25 THEN '25岁及以上'
      	ELSE '其他'
      END age_cut
  FROM user_profile;
  ```

### 概念：[日期函数](https://www.nowcoder.com/knowledge/intro-index?kcid=20)

- [SQL28 计算用户 8 月每天的练题数量](https://www.nowcoder.com/practice/847373e2fe8d47b4a2c294bdb5bda8b6?tpId=199&tqId=1975680&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要计算出 2021 年 8 月每天用户练习题目的数量，请取出相应数据。

  **语法：** `SQL为此提供了对应的年、月、日提取函数，分别为 year(), month(), day()。`

  ```sql
  SELECT 
  	DAY(date) AS day, 
  	COUNT(question_id) AS question_cnt
  FROM question_practice_detail
  WHERE MONTH(date)=8 AND YEAR(date)=2021
  GROUP BY date;
  ```

- [SQL29 计算用户的平均次日留存率](https://www.nowcoder.com/practice/126083961ae0415fbde061d7ebbde453?tpId=199&tqId=1975681&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要查看用户在某天刷题后第二天还会再来刷题的平均概率。请你取出相应数据。

  **语法：** `语法为date_add(string startdate, interval int day) ，返回开始日期startdate增加days天后的日期`

  ```sql
  SELECT 
  	COUNT(date2) / COUNT(date1) AS avg_ret
  FROM (
      SELECT
          DISTINCT qpd.device_id,
          qpd.date AS date1,
          uniq_date.date AS date2
      FROM question_practice_detail AS qpd
      LEFT JOIN(
          SELECT
              DISTINCT device_id, 
          	date
          FROM question_practice_detail
      )AS uniq_date
      ON qpd.device_id = uniq_date.device_id AND date_add(qpd.date, interval 1 day)=uniq_date.date
  )as next_date;
  ```

### 概念：[文本函数](https://www.nowcoder.com/knowledge/intro-index?kcid=21)

- [SQL30 统计每种性别的人数](https://www.nowcoder.com/practice/f04189f92f8d4f6fa0f383d413af7cb8?tpId=199&tqId=1975682&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营举办了一场比赛，收到了一些参赛申请，表数据记录形式如下所示，现在运营想要统计每个性别的用户分别有多少参赛者，请取出相应结果

  **语法：** `SUBSTRING_INDEX函数用于将字符串依据某个指定分隔符进行切分，并返回指定位置分隔符前的字符。`

  ```sql
  SELECT
      SUBSTRING_INDEX(profile,  ",", -1) AS gender,
      COUNT(*) AS number
  FROM user_submit
  GROUP BY gender;
  ```

- [SQL32 截取出年龄](https://www.nowcoder.com/practice/b8d8a87fe1fc415c96f355dc62bdd12f?tpId=199&tqId=1975684&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营举办了一场比赛，收到了一些参赛申请，表数据记录形式如下所示，现在运营想要统计每个年龄的用户分别有多少参赛者，请取出相应结果

  ```sql
  SELECT
      SUBSTRING_INDEX(SUBSTRING_INDEX(profile,  ",", 3), ",", -1) AS age,
      COUNT(*) AS number
  FROM user_submit
  GROUP BY age;
  ```

- [SQL31 提取博客 URL 中的用户名](https://www.nowcoder.com/practice/26c8715f32e24d918f15db69518f3ad8?tpId=199&tqId=1975683&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 对于申请参与比赛的用户，blog_url 字段中 url 字符后的字符串为用户个人博客的用户名，现在运营想要把用户的个人博客用户字段提取出单独记录为一个新的字段，请取出所需数据。

  ```sql
  SELECT
      device_id,
      SUBSTRING_INDEX(blog_url, "/", -1) AS user_name
  FROM user_submit;
  ```

### 概念：[窗口函数](https://www.nowcoder.com/knowledge/intro-index?kcid=22)

- [SQL33 找出每个学校 GPA 最低的同学](https://www.nowcoder.com/practice/90778f5ab7d64d35a40dc1095ff79065?tpId=199&tqId=1980672&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要找到每个学校 gpa 最低的同学来做调研，请你取出每个学校的最低 gpa。

  **语法：** `窗口函数 row_number() over partition by`

  ```sql
  SELECT
      device_id,
      university,
      gpa
  FROM (
      SELECT *,
      row_number() over (PARTITION BY university ORDER BY gpa) AS rn
      FROM user_profile
  )AS rn_min
  WHERE rn_min.rn = 1;
  ```

## 06 综合练习

### 概念：综合练习

- [SQL34 统计复旦用户 8 月练题情况](https://www.nowcoder.com/practice/53235096538a456b9220fce120c062b3?tpId=199&tqId=1980673&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要了解复旦大学的每个用户在 8 月份练习的总题目数和回答正确的题目数情况，请取出相应明细数据，对于在 8 月份没有练习过的用户，答题数结果返回 0.

  **问题分解：**

  > 限定条件：复旦大学（来自表 user_profile.university），8 月份练习情况（来自表 question_practice_detail.date）
  >
  > 从 date 中取 month：用 month 函数即可；
  >
  > 总题目：count(question_id)
  >
  > 正确的题目数：sum(if(qpd.result='right', 1, 0))
  >
  > 按列聚合：需要输出每个用户的统计结果，因此加上 group by up.device_id

  ```sql
  SELECT
      up.device_id,
      up.university,
      COUNT(question_id) AS question_cnt,
      SUM(IF(qpd.result='right', 1, 0)) AS right_question_cnt
  FROM user_profile AS up
  LEFT JOIN question_practice_detail AS qpd
  ON up.device_id = qpd.device_id AND MONTH(qpd.date) = 8
  WHERE up.university = '复旦大学'
  GROUP BY up.device_id;
  ```

- [SQL35 浙大不同难度题目的正确率](https://www.nowcoder.com/practice/d8a4f7b1ded04948b5435a45f03ead8c?tpId=199&tqId=1980674&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要了解浙江大学的用户在不同难度题目下答题的正确率情况，请取出相应数据，并按照准确率升序输出。

  **问题分解：**

  > 浙江大学 user_profile.university
  >
  > 正确率：avg(if(qpd.result='right', 1, 0))
  >
  > 并按照准确率升序输出(默认): ORDER BY correct_rate
  >
  > 不同难度题目,加上: GROUP BY difficult_level

  ```sql
  SELECT
      qd.difficult_level,
      AVG(IF(qpd.result = 'right', 1, 0))AS correct_rate
  FROM question_practice_detail AS qpd
  LEFT JOIN user_profile AS up
  ON up.device_id = qpd.device_id
  LEFT JOIN question_detail AS qd
  ON qpd.question_id = qd.question_id
  WHERE up.university = '浙江大学'
  GROUP BY difficult_level
  ORDER BY correct_rate;
  ```

- [SQL39 21 年 8 月份练题总数](https://www.nowcoder.com/practice/b8f30b239b454ed490367b53ea95607d?tpId=199&tqId=2002640&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)

  **题目：** 现在运营想要了解 2021 年 8 月份所有练习过题目的总用户数和练习过题目的总次数，请取出相应结果

  ```sql
  SELECT
      COUNT(DISTINCT device_id) AS did_cnt,
      COUNT(*) AS question_cnt
  FROM question_practice_detail
  WHERE MONTH(date) = 8 AND YEAR(date) = 2021;
  ```

