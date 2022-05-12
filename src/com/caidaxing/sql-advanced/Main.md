> [sql-advanced](https://www.nowcoder.com/ta/sql-advanced)

- 01 增删改操作

  > 概念：插入记录

  - [SQL1 插入记录（一）](https://www.nowcoder.com/practice/5d2a42bfaa134479afb9fffd9eee970c?tpId=240&tqId=2221797&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ==注：连续插入两条记录 |
    指令是 values <row1>,<row2>...多行之间用逗号隔开；|
    interval 时间间隔关键字，常和 date_add() 或 date_sub() 搭配使用==

    ```sql
    INSERT INTO exam_record(uid, exam_id, start_time, submit_time, score)
    VALUES(1001, 9001, '2021-09-01 22:11:12', '2021-09-01 22:11:12' +INTERVAL 50 minute, 90),
    (1002, 9002, '2021-09-04 07:01:02', NULL,NULL);
    ```

  - [SQL2 插入记录（二）](https://www.nowcoder.com/practice/9681abf28745468c8adacb3b029a18ce?tpId=240&tqId=2223554&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ==注：insert into 新表名 select \* from 旧表名 where 1 的用法==

    ```sql
    INSERT INTO
        exam_record_before_2021(uid, exam_id, start_time, submit_time, score)
    SELECT
        uid,
        exam_id,
        start_time,
        submit_time,
        score
        FROM exam_record
        WHERE YEAR(submit_time) <2021;
    ```

  - [SQL3 插入记录（三）](https://www.nowcoder.com/practice/978bcee6530a430fb0be716423d84082?tpId=240&tqId=2223556&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ==注：==

    > replace into 跟 insert into 功能类似，不同点在于：replace into 首先尝试插入数据到表中，
    >
    > 如果发现表中已经有此行数据（根据主键或者唯一索引判断）则先删除此行数据，然后插入新的数据；
    >
    > 否则，直接插入新数据。
    >
    > 要注意的是：插入数据的表必须有主键或者是唯一索引！否则的话，replace into 会直接插入数据，这将导致表中出现重复的数据。

    ```sql
    REPLACE INTO examination_info
    VALUES(NULL,9003,'SQL','hard',90,'2021-01-01 00:00:00');
    ```

  > 概念：更新记录

  - [SQL4 更新记录（一）](https://www.nowcoder.com/practice/bfe8ad2bddc540fc911614aa648868b3?tpId=240&tqId=2223557&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    UPDATE examination_info SET tag = 'Python' WHERE tag = 'PYTHON';
    ```

  - [SQL5 更新记录（二）](https://www.nowcoder.com/practice/0c2e81c6b62e4a0f848fa7693291defc?tpId=240&tqId=2223560&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    UPDATE exam_record
    SET submit_time  = '2099-01-01 00:00:00', score = 0
    WHERE start_time < '2021-09-01 00:00:00' AND score IS NULL;
    ```

  > 概念：删除记录

  - [SQL6 删除记录（一）](https://www.nowcoder.com/practice/d331359c5ca04a3b87f06b97da42159c?tpId=240&tqId=2223561&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ==注：==

    > 时间差：
    >
    > TIMESTAMPDIFF(interval, time_start, time_end)可计算 time_start-time_end 的时间差，单位以指定的 interval 为准，常用可选：
    >
    > SECOND 秒
    >
    > MINUTE 分钟（返回秒数差除以 60 的整数部分）
    >
    > HOUR 小时（返回秒数差除以 3600 的整数部分）
    >
    > DAY 天数（返回秒数差除以 3600\*24 的整数部分）
    >
    > MONTH 月数
    >
    > YEAR 年数

    ```sql
    DELETE FROM exam_record
    WHERE TIMESTAMPDIFF(MINUTE, start_time, submit_time) < 5
        AND score < 60;
    ```

  - [SQL7 删除记录（二）](https://www.nowcoder.com/practice/964c9f7fffbb4ab18b507cfed4111b4a?tpId=240&tqId=2223562&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    DELETE FROM exam_record
    WHERE TIMESTAMPDIFF(MINUTE, start_time, submit_time) < 5
        OR submit_time IS NULL
        ORDER BY start_time
        LIMIT 3;
    ```

  - [SQL8 删除记录（三）](https://www.nowcoder.com/practice/3abefc6fc73e4f219dad0ab66e6b1e3f?tpId=240&tqId=2223563&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    **题目：** 请删除 exam_record 表中所有记录，并重置自增主键。

    ==注：==

    > truncate table 在功能上，与不带 where 字句的 delete 语句相同；二者均删除表中的全部行，但 truncate table 比 delete 速度更快，且使用的系统和事务日志资源少。 truncate 删除表中的所有行，但表的结构及其列，约束，索引等保持不变。新行标识所用的技术值重置为该列的种子。如果想保留标识计数值，轻盖拥 delete 。如果要删除表定义及其数据，请使用 drop table 语句。

    ```sql
    TRUNCATE TABLE exam_record;
    ```

- 02 表与索引操作

  > 概念：表的创建、修改与删除

  - [SQL9 创建一张新表](https://www.nowcoder.com/practice/a61ee5519d14444aa99e530309a8e043?tpId=240&tqId=2223564&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    CREATE TABLE IF NOT EXISTS user_info_vip (
        id INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
        uid INT(11) NOT NULL COMMENT '用户ID',
        nick_name VARCHAR(64) COMMENT '昵称',
        achievement INT(11) DEFAULT 0 COMMENT '成就值',
        `level` INT(11) COMMENT '用户等级',
        job VARCHAR(32) COMMENT '职业方向',
        register_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
        PRIMARY KEY(id),
        UNIQUE KEY(uid)
    );
    ```

  - [SQL10 修改表](https://www.nowcoder.com/practice/d08209df6f464cebafda5dfd5de03fce?tpId=240&tqId=2223567&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    ALTER TABLE user_info
    ADD school VARCHAR(15) AFTER `level`,
    CHANGE job profession VARCHAR(10),
    MODIFY achievement INT(11) DEFAULT 0;
    ```

  - [SQL11 删除表](https://www.nowcoder.com/practice/df2f634a53324bbd9369fe6723fedc49?tpId=240&tqId=2223568&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    DROP TABLE IF EXISTS exam_record_2011, exam_record_2012, exam_record_2013, exam_record_2014;
    ```

  > 概念：索引的创建、删除

  - [SQL12 创建索引](https://www.nowcoder.com/practice/f2ea9ccf33c740d58576608940981807?tpId=240&tqId=2223570&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    CREATE
        INDEX idx_duration ON examination_info(duration);
    CREATE
        UNIQUE INDEX uniq_idx_exam_id ON examination_info(exam_id);
    CREATE
        FULLTEXT INDEX full_idx_tag ON examination_info(tag);
    ```

  - [SQL13 删除索引](https://www.nowcoder.com/practice/4963f6d63dde48d787aaa2b43460fb4b?tpId=240&tqId=2223573&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    DROP INDEX uniq_idx_exam_id ON examination_info;

    DROP INDEX full_idx_tag ON examination_info;
    ```

- 03 聚合分组查询

  > 概念：聚合函数

  - [SQL14 SQL 类别高难度试卷得分的截断平均值](https://www.nowcoder.com/practice/a690f76a718242fd80757115d305be45?tpId=240&tqId=2180959&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ==注：保留 1 位小数：round(..., 1)==

    ```sql
    SELECT
        ei.tag,
        ei.difficulty,
        ROUND((SUM(score) - MAX(score) - MIN(score)) / (COUNT(score)-2), 1) AS clip_avg_score
    FROM exam_record AS er
    JOIN examination_info AS ei
    ON er.exam_id = ei.exam_id
    WHERE ei.tag = 'SQL' AND ei.difficulty = 'hard';
    ```

  - [SQL15 统计作答次数](https://www.nowcoder.com/practice/45a87639110841b6950ef6a12d20175f?tpId=240&tqId=2180960&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    SELECT
        COUNT(start_time) AS total_pv,
        COUNT(submit_time) AS complete_pv,
        COUNT(DISTINCT exam_id AND score IS NOT NULL) AS complete_exam_cnt
    FROM exam_record;
    ```

  - [SQL16 得分不小于平均分的最低分](https://www.nowcoder.com/practice/3de23f1204694e74b7deef08922805b2?tpId=240&tqId=2180961&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ==注：先算出平均数，再判断>=平均数的最小值==

    ```sql
    SELECT
        MIN(er.score) AS min_score_over_avg
    FROM exam_record AS er
    JOIN examination_info AS ei
    ON er.exam_id = ei.exam_id
    WHERE ei.tag = 'SQL'
    AND score >= (SELECT AVG(er1.score)
                  FROM exam_record AS er1
                  JOIN examination_info AS ei1
                  ON er1.exam_id = ei1.exam_id
                  WHERE tag = 'SQL'
                  );
    ```

  > 概念：分组查询

  - [SQL17 平均活跃天数和月活人数](https://www.nowcoder.com/practice/9e2fb674b58b4f60ac765b7a37dde1b9?tpId=240&tqId=2183005&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ==注：date_format() 通过这个函数匹配'%Y%m'年份和月份==

    ```sql
    SELECT
        DATE_FORMAT(submit_time, '%Y%m') AS `month`,
        ROUND((COUNT(DISTINCT uid, DAY(submit_time))) / COUNT(DISTINCT uid), 2) AS avg_active_days,
        COUNT(DISTINCT uid) AS mau
    FROM exam_record
    WHERE YEAR(start_time) = 2021 AND submit_time IS NOT NULL
    GROUP BY `month`;
    ```

  - [SQL18 月总刷题数和日均刷题数](https://www.nowcoder.com/practice/f6b4770f453d4163acc419e3d19e6746?tpId=240&tqId=2183006&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ==注：Mysql 中有一个 with rollup 是用来在分组统计数据的基础上再进行统计汇总，即用来得到 group by 的汇总信息；
    COALESCE()函数，这个函数主要用来进行空值处理==

    ```sql
    SELECT COALESCE (DATE_FORMAT(submit_time, "%Y%m"),"2021汇总") AS submit_month,
        COUNT(submit_time) AS month_q_cnt,
        ROUND(COUNT(submit_time)/MAX(DAY(last_day(submit_time))),3) AS avg_day_q_cnt
    FROM practice_record
    WHERE YEAR(submit_time) = 2021
    GROUP BY DATE_FORMAT(submit_time, "%Y%m") WITH ROLLUP;
    ```

  - [SQL19 未完成试卷数大于 1 的有效用户](https://www.nowcoder.com/practice/46cb7a33f7204f3ba7f6536d2fc04286?tpId=240&tqId=2183007&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    SELECT
        uid,
        COUNT(incomplete) AS incomplete_cnt,
        COUNT(complete) AS complete_cnt,
        group_concat(DISTINCT concat_ws(':', date(start_time), tag) SEPARATOR ';') AS detail
    FROM (
        SELECT uid, tag, start_time,
            if(submit_time is null, 1, null) AS incomplete,
            if(submit_time is null, null, 1) AS complete
        FROM exam_record
        LEFT JOIN examination_info using(exam_id)
        WHERE year(start_time) = 2021
    ) AS exam_complete_rec
    GROUP BY uid
    HAVING complete_cnt >= 1 AND incomplete_cnt BETWEEN 2 AND 4
    ORDER BY incomplete_cnt DESC;

    ```

- 04 多表查询

  > 概念：嵌套子查询

  - [SQL20 月均完成试卷数不小于 3 的用户爱作答的类别](https://www.nowcoder.com/practice/b1d13efcfa0c4ecea517afbdb9090845?tpId=240&tqId=2183022&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    **题目:** 请从表中统计出 “当月均完成试卷数”不小于 3 的用户们爱作答的类别及作答次数，按次数降序输出。

    **问题分解：**

    > - 第一步：先查询 月均完成试卷数不小于 3 的用户
    >
    >   限定条件: 存在**提交时间**才算有效数据 `WHERE submit_time IS NOT NULL`
    >   按用户分组 `GROUP BY uid`
    >   统计当前用户完成试卷总数 `COUNT(exam_id)`
    >   统计该用户有完成试卷的月份数 `COUNT(DISTINCT DATE_FORMAT(start_time, "%Y%m"))`
    >   分组后过滤 `HAVING COUNT(exam_id) / COUNT(DISTINCT DATE_FORMAT(start_time, "%Y%m")) >= 3`
    >
    > - 第二步：筛选之后，按 examination_info 表的 tag 进行分组统计，最后降序输出
    >   关联试卷作答记录表和试卷信息表。知识点：`join examination_info using(exam_id)`
    >   筛选满足条件的用户。知识点：`where uid in (...)`
    >   按类别分组： `GROUP BY tag`
    >   作答次数： `COUNT(tag)`
    >   按次数降序输出：`ORDER BY tag_cnt DESC`

    ```sql
    SELECT
      tag,
      COUNT(tag) AS tag_cnt
    FROM exam_record AS er
    LEFT JOIN examination_info AS ei
    ON er.exam_id = ei.exam_id
    WHERE er.uid IN
        (
            SELECT uid
            FROM exam_record
            WHERE submit_time IS NOT NULL
            GROUP BY uid
            HAVING COUNT(exam_id) / COUNT(DISTINCT DATE_FORMAT(start_time, "%Y%m")) >= 3
        )
    GROUP BY tag
    ORDER BY tag_cnt DESC;
    ```

  - [SQL21 试卷发布当天作答人数和平均分](https://www.nowcoder.com/practice/5b58e89556dc4153a79d8cf8c08ba499?tpId=240&tqId=2183023&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    **题目:** 请计算每张 SQL 类别试卷发布后，当天 5 级以上的用户作答的人数 uv 和平均分 avg_score，按人数降序，相同人数的按平均分升序。

    **问题分解:**

    > 限定条件：SQL 类别，当天 level 5 级以上的用户
    >
    > 每张试卷：按 exam_id 试卷 ID 分组， group by exam_id
    >
    > 答题人数： COUNT(DISTINCT er.uid) AS uv 去重重复答题人数
    >
    > 平均分(保留 1 位小数)：在每个试卷分组内，当天参与答题人总得分除以当天参与答题人数 ROUND(AVG(er.score), 1)
    >
    > 按人数降序，相同人数的按平均分升序: ORDER BY uv DESC, avg_score ASC;
    >
    > 表连接：等级、试卷类别和分数都在不同的表里，需要做连接

    ```sql
    SELECT
      ei.exam_id,
      COUNT(DISTINCT er.uid) AS uv,
      ROUND(AVG(er.score), 1) AS avg_score
    FROM exam_record AS er
    LEFT JOIN examination_info AS ei
    ON ei.exam_id = er.exam_id
    LEFT JOIN user_info AS ui
    ON ui.uid = er.uid
    WHERE ei.tag = 'SQL' AND ui.level > 5 AND date_format(ei.release_time,"%Y%m%d")=date_format(er.start_time,"%Y%m%d")
    GROUP BY ei.exam_id
    ORDER BY uv DESC, avg_score ASC;
    ```

  - [SQL22 作答试卷得分大于过 80 的人的用户等级分布](https://www.nowcoder.com/practice/5bc77e3a3c374ad6a92798f0ead4c744?tpId=240&tqId=2183024&ru=/ta/sql-advanced&qru=/ta/sql-advanced/question-ranking)

    ```sql
    SELECT
        ui.level AS `level`,
        COUNT(DISTINCT er.uid) AS level_cnt
    FROM exam_record AS er
    LEFT JOIN examination_info AS ei
    ON er.exam_id = ei.exam_id
    LEFT JOIN user_info AS ui
    ON er.uid = ui.uid
    WHERE score > 80 AND tag = 'SQL'
    GROUP BY `level`
    ORDER BY level_cnt DESC, `level` DESC;
    ```

  > 概念：合并查询

  - [SQL23 每个题目和每份试卷被作答的人数和次数](https://www.nowcoder.com/practice/203d0aed8928429a8978185d9a03babc?tpId=240)

    **题目：** 请统计每个题目和每份试卷被作答的人数和次数，分别按照"试卷"和"题目"的 uv & pv 降序显示

    **问题分解：**

    > 分别统计每个题目和每份试卷被回答的人数和次数
    >
    > 以 试卷作答记录表 exam_record 为例：
    >
    > > 每张试卷：按 exam_id 试卷 ID 分组， group by exam_id
    > > 回答人数： count(distinct uid) uv 去重重复答题人数
    > > 回答次数： count(uid) as pv 作答次数，不用去重
    > > 照"试卷"uv & pv 降序显示排序：order by uv desc, pv desc
    >
    > 选择出来的结果上下连接起来，所以需要使用到 UNION，这里两个查询之间不需要去重，所以可以使用 UNION ALL

    ```sql
    select
        tid, uv, pv
    from (
        select
            exam_id as tid,
            count(distinct uid) uv,
            count(uid) as pv
        from exam_record
        group by exam_id
        order by uv desc, pv desc
    ) as exam
    UNION ALL
    select
        tid, uv, pv
    from (
        select
            question_id as tid,
            count(distinct uid) uv,
            count(uid) as pv
        from practice_record
        group by question_id
        order by uv desc, pv desc
    ) as practice;
    ```

  - [SQL24 分别满足两个活动的人](https://www.nowcoder.com/practice/a126cea91d7045e399b8ecdcadfb326f?tpId=240)

    **题目：** 输出 2021 年里，所有每次试卷得分都能到 85 分的人以及至少有一次用了一半时间就完成高难度试卷且分数大于 80 的人的 id 和活动号，按用户 ID 排序输出。

    **问题分解：**

    > 限定条件：2021 年
    >
    > 找出满足活动 1 的人
    > 每次试卷得分都能到 85 分(筛选最低分>=85 的分组): having min(score) >= 85
    >
    > 找出满足活动 2 的人
    >
    > 筛选至少有一次用了一半时间就完成的记录： timestampdiff(minute, er.start_time, er.submit_time) < ei.duration / 2
    > 难度限定：ei.difficulty = 'hard'
    > 分数大于 80：er.score > 80

    ```sql
    select
        uid,
        'activity1' as activity
    from exam_record
    where year(submit_time) = 2021
    group by uid
    having min(score) >= 85
    union
    select
        distinct uid,
        'activity2' as activity
    from exam_record er
    join examination_info ei
    on er.exam_id = ei.exam_id
    where year(er.submit_time) = 2021 and ei.difficulty = 'hard' and er.score > 80
    and timestampdiff(minute, er.start_time, er.submit_time) < ei.duration / 2
    order by uid
    ```

  > 概念：连接查询

- 05 窗口函数

- 06 其他常用操作
