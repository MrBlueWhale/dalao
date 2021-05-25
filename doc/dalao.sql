
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
                        `aid` int(10) NOT NULL AUTO_INCREMENT COMMENT '管理员表主键',
                        `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '头像',
                        `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                        `admin_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员用户名',
                        `tel_num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
                        `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
                        `admin_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员秘钥',
                        `join_date` datetime NOT NULL COMMENT '注册时间',
                        PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for adminkey
-- ----------------------------
DROP TABLE IF EXISTS `adminkey`;
CREATE TABLE `adminkey`  (
                           `akid` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员秘钥表主键',
                           `admin_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员秘钥',
                           PRIMARY KEY (`akid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest`  (
                          `cid` int(0) NOT NULL AUTO_INCREMENT COMMENT '比赛表主键',
                          `contest_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '比赛名称',
                          `sponsor_id` int(0) NOT NULL COMMENT '举办方id',
                          `contest_intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '比赛简介',
                          `registration_start_time` datetime NOT NULL COMMENT '报名起始时间',
                          `registration_end_time` datetime NOT NULL COMMENT '报名截止时间',
                          `compete_start_time` datetime NOT NULL COMMENT '比赛起始时间',
                          `compete_end_time` datetime NOT NULL COMMENT '比赛截止时间',
                          `page_view` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览量',
                          `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型（个人赛 组队赛等）',
                          `category` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类别（电子&自动化 计算机&信息技术  数学  数学建模 机器人 程序设计...）',
                          `entry_fee` int(0) NOT NULL COMMENT '报名费',
                          `rank` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '级别（校、省、国）',
                          `audience` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '参赛对象（全国 中学 大学 etc）',
                          `contest_status` int(0) NOT NULL COMMENT '比赛状态',
                          PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
                       `id` bigint(0) NOT NULL COMMENT 'id',
                       `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '测试' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES (1, '测试');

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification`  (
                               `nid` int(0) NOT NULL AUTO_INCREMENT COMMENT '比赛通知表主键',
                               `contest_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '比赛id',
                               `release_time` datetime NOT NULL COMMENT '发布时间',
                               `notify_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
                               `promulgator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发布人',
                               PRIMARY KEY (`nid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for participant
-- ----------------------------
DROP TABLE IF EXISTS `participant`;
CREATE TABLE `participant`  (
                              `pid` int(0) NOT NULL AUTO_INCREMENT COMMENT '参赛者表主键',
                              `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
                              `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                              `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '头像地址',
                              `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
                              `gender` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
                              `university` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学校',
                              `college` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院系',
                              `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业',
                              `grade` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '年级',
                              `student_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学号',
                              `tel_num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
                              `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                              `id_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
                              `join_date` datetime NOT NULL COMMENT '注册时间',
                              `account_status` int(0) NOT NULL COMMENT '账号状态：0(正常) 1(异常)',
                              PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
                        `rpid` int(0) NOT NULL AUTO_INCREMENT COMMENT '回复表主键',
                        `rid` int(0) NOT NULL COMMENT '该回复对应的评论id',
                        `from_id` int(0) NOT NULL COMMENT '发布该条回复的用户id',
                        `to_id` int(0) NOT NULL COMMENT '被回复用户的id',
                        `reply_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '回复的内容',
                        `like` int(0) NOT NULL DEFAULT 0 COMMENT '点赞量',
                        `reply_date` datetime NOT NULL COMMENT '回复时间',
                        PRIMARY KEY (`rpid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
                         `rid` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论表主键',
                         `contest_id` int(0) NOT NULL COMMENT '比赛id',
                         `reviewer_id` int(0) NOT NULL COMMENT '评论者id',
                         `review_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
                         `review_date` datetime NOT NULL COMMENT '评论时间',
                         `like` int(0) NOT NULL COMMENT '点赞量',
                         PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sponsor
-- ----------------------------
DROP TABLE IF EXISTS `sponsor`;
CREATE TABLE `sponsor`  (
                          `sid` int(0) NOT NULL AUTO_INCREMENT COMMENT '比赛主办方表主键',
                          `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '头像',
                          `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构名称',
                          `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '机构地址',
                          `tel_num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
                          `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
                          `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                          `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
                          `identity_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '认证状态：未认证、受理中、已认证',
                          `join_date` datetime NOT NULL COMMENT '注册时间',
                          `account_status` int(0) NOT NULL COMMENT '账号状态：0(正常) 1(异常)',
                          PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
                       `tid` int(0) NOT NULL AUTO_INCREMENT COMMENT '队伍表主键',
                       `contest_id` int(0) NOT NULL COMMENT '比赛id',
                       `team_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '队伍名称',
                       `uni_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校名称',
                       `uni_addr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校地址',
                       `zone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '赛区',
                       `instructor_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导老师姓名',
                       `instructor_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导老师电话',
                       `instructor_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导老师邮箱',
                       `instructor_prof` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导老师职务',
                       `leader_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '队长手机号',
                       `member1_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '队员1手机号',
                       `member2_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '队员2手机号',
                       `member3_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '队员3手机号',
                       PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
                       `id` bigint(0) NOT NULL COMMENT 'id',
                       `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
                       `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '测试' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, '测试', 'password');

SET FOREIGN_KEY_CHECKS = 1;

-- 管理员秘钥表增加是否激活字段
--

ALTER TABLE `dalao`.`adminkey`
    ADD COLUMN `if_used` int(0) NOT NULL COMMENT '是否已经使用' AFTER `admin_key`;


ALTER TABLE `dalao`.`participant`
    MODIFY COLUMN `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址' AFTER `password`;

CREATE TABLE `dalao`.`ban_account`  (
                                     `bid` bigint(0) NOT NULL COMMENT '数据id',
                                     `reason` varchar(255) NULL COMMENT '封禁原因',
                                     `bannedTime` datetime(0) NULL COMMENT '封禁时间',
                                     `interval` varchar(255) NULL,
                                     `uid` bigint(0) NOT NULL COMMENT '被封禁用户id',
                                     `note` varchar(255) NULL COMMENT '备注',
                                     `releaseTime` datetime(0) NULL COMMENT '解封时间',
                                     PRIMARY KEY (`bid`)
);


INSERT INTO contest
(`cid`, `contest_name`, `sponsor_id`, `contest_intro`, `registration_start_time`, `registration_end_time`, `compete_start_time`, `compete_end_time`, `page_view`, `type`, `category`, `entry_fee`, `rank`, `audience`, `contest_status`)
VALUES
(1, '2021年全国大学生数据统计与分析竞赛', 1, '在大数据时代背景下，统计学作为大数据分析领域的基础显得尤为重要。为了帮助学生更好的学习和应用数据统计与分析的知识，促进统计、计算机、数学等相关专业的发展，培养具有数据分析与应用型人才，提升高校毕业生的就业竞争力，经研究决定，河北省现场统计学会、四川省现场统计学会等联合发起“全国大学生数据统计与分析竞赛”（以下简称“竞赛”），为我国数据统计与分析行业提供人才支持，夯实人才队伍基础。', '2021/4/12 00:00:00', '2021/5/21 00:00:00', '2021/5/27 00:00:00', '2021/5/30 00:00:00', 10, '组队赛', '\r\n\r\n    数学 计算机&信息技术\r\n\r\n数学 计算机&信息技术', 150, ' 全国性', '全国', 0);

INSERT INTO contest
(`cid`, `contest_name`, `sponsor_id`, `contest_intro`, `registration_start_time`, `registration_end_time`, `compete_start_time`, `compete_end_time`, `page_view`, `type`, `category`, `entry_fee`, `rank`, `audience`, `contest_status`)
VALUES
(2, '2021年全国大学生技术竞赛', 2, '为贯彻习总书记在十九大报告中关于“推动互联网、大数据、人工智能和实体经济深度融合”以及“善于运用互联网技术和信息化手段开展工作”等讲话精神，引导高校在校生学习掌握计算机与互联网知识，提高计算机的技能应用能力，全国大学生计算机技能应用大赛将于2021年3月至7月举办，通过参赛激发学生学习计算机知识、技术的兴趣和潜能，提升运用信息技术解决实际问题的综合实践能力、创新创业能力和团队合作精神，并促进学校进一步深化改革，提高电子、信息、通信等相关学科的教育质量。\r\n本次大赛是推动计算机教育实践平台建设的具体举措之一，目的是提高大学生综合素质，具体落实、进一步推动高校本科面向 21 世纪的计算机教学的知识体系、课程体系、教学内容和教学方法的改革，引导学生踊跃参加课外科技活动，为培养德智体美全面发展、具备运用信息技术解决实际问题的综合实践能力、创新创业能力以及团队合作意识的人才服务。\r\n为贯彻习总书记在十九大报告中关于“推动互联网、大数据、人工智能和实体经济深度融合”以及“善于运用互联网技术和信息化手段开展工作”等讲话精神，引导高校在校生学习掌握计算机与互联网知识，提高计算机的技能应用能力，全国大学生计算机技能应用大赛将于2021年3月至7月举办，通过参赛激发学生学习计算机知识、技术的兴趣和潜能，提升运用信息技术解决实际问题的综合实践能力、创新创业能力和团队合作精神，并促进学校进一步深化改革，提高电子、信息、通信等相关学科的教育质量。\r\n本次大赛是推动计算机教育实践平台建设的具体举措之一，目的是提高大学生综合素质，具体落实、进一步推动高校本科面向 21 世纪的计算机教学的知识体系、课程体系、教学内容和教学方法的改革，引导学生踊跃参加课外科技活动，为培养德智体美全面发展、具备运用信息技术解决实际问题的综合实践能力、创新创业能力以及团队合作意识的人才服务。\r\n为贯彻习总书记在十九大报告中关于“推动互联网、大数据、人工智能和实体经济深度融合”以及“善于运用互联网技术和信息化手段开展工作”等讲话精神，引导高校在校生学习掌握计算机与互联网知识，提高计算机的技能应用能力，全国大学生计算机技能应用大赛将于2021年3月至7月举办，通过参赛激发学生学习计算机知识、技术的兴趣和潜能，提升运用信息技术解决实际问题的综合实践能力、创新创业能力和团队合作精神，并促进学校进一步深化改革，提高电子、信息、通信等相关学科的教育质量。\r\n本次大赛是推动计算机教育实践平台建设的具体举措之一，目的是提高大学生综合素质，具体落实、进一步推动高校本科面向 21 世纪的计算机教学的知识体系、课程体系、教学内容和教学方法的改革，引导学生踊跃参加课外科技活动，为培养德智体美全面发展、具备运用信息技术解决实际问题的综合实践能力、创新创业能力以及团队合作意识的人才服务。\r\n', '2021/5/20 00:00:00', '2021/5/30 00:00:00', '2021/5/20 00:00:00', '2021/5/22 00:00:00', 30, '个人赛', 'Word、Excel、PPT、C语言、C++、Java', 200, '全国性', '全国', 1);

INSERT INTO contest
(`cid`, `contest_name`, `sponsor_id`, `contest_intro`, `registration_start_time`, `registration_end_time`, `compete_start_time`, `compete_end_time`, `page_view`, `type`, `category`, `entry_fee`, `rank`, `audience`, `contest_status`)
VALUES
(3, '2021年第五届“普译奖”全国大学生翻译比赛', 3, '2021年第五届“普译奖”全国大学生翻译比赛', '2021/5/29 00:00:00', '2021/6/6 00:00:00', '2021/5/30 00:00:00', '2021/6/5 00:00:00', 100, '组队赛', '英语', 300, '全国性', '全国', 0);

INSERT INTO contest
(`cid`, `contest_name`, `sponsor_id`, `contest_intro`, `registration_start_time`, `registration_end_time`, `compete_start_time`, `compete_end_time`, `page_view`, `type`, `category`, `entry_fee`, `rank`, `audience`, `contest_status`)
VALUES
(4, '2021年高教社杯全国大学生数学建模竞赛', 3, '为了培养学生的创新意识及运用数学方法和计算机技术解决实际问题的能力，中国工业与应用数学学会全国大学生数学建模竞赛组委会决定举办2021高教社杯全国大学生数学建模竞赛（以下简称竞赛），欢迎各高等院校按照竞赛章程、参赛规则及有关规定组织同学报名参赛。\r\n\r\n为了培养学生的创新意识及运用数学方法和计算机技术解决实际问题的能力，中国工业与应用数学学会全国大学生数学建模竞赛组委会决定举办2021高教社杯全国大学生数学建模竞赛（以下简称竞赛），欢迎各高等院校按照竞赛章程、参赛规则及有关规定组织同学报名参赛。\r\n\r\n为了培养学生的创新意识及运用数学方法和计算机技术解决实际问题的能力，中国工业与应用数学学会全国大学生数学建模竞赛组委会决定举办2021高教社杯全国大学生数学建模竞赛（以下简称竞赛），欢迎各高等院校按照竞赛章程、参赛规则及有关规定组织同学报名参赛。\r\n\r\n为了培养学生的创新意识及运用数学方法和计算机技术解决实际问题的能力，中国工业与应用数学学会全国大学生数学建模竞赛组委会决定举办2021高教社杯全国大学生数学建模竞赛（以下简称竞赛），欢迎各高等院校按照竞赛章程、参赛规则及有关规定组织同学报名参赛。\r\n\r\n', '2021/6/1 00:00:00', '2021/6/30 00:00:00', '2021/6/5 00:00:00', '2021/6/27 00:00:00', 66, '个人赛', '数学', 120, '省级', '全四川省', 1);


INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (1, '/image/sponsor-avatar/ia_100000030.png', 'test1', 'test1', '19981481120', '2971529737@qq.com', '123qwe', '比赛主办方测试账号1 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '未认证', '2021-05-19 20:10:09', 1);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (2, '/image/sponsor-avatar/avatar2.jpg', 'test2', 'test2', '19981481120', '2971529737@qq.com', '123yur', '比赛主办方测试账号2 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '审核中', '2021-05-19 20:11:09', 1);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (3, '/image/sponsor-avatar/avatar3.jpg', 'test3', 'test3', '19981481120', '2971529737@qq.com', '111111', '比赛主办方测试账号3 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '未认证', '2021-05-19 20:11:09', 1);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (4, '/image/sponsor-avatar/avatar4.jpg', 'test4', 'test4', '19981481120', '2971529737@qq.com', '321321', '比赛主办方测试账号4 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。 ', '已认证', '2021-05-19 20:12:09', 0);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (5, '/image/sponsor-avatar/avatar5.jpg', 'test5', 'test5', '19981481120', '2971529737@qq.com', '123123', '比赛主办方测试账号5 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '未认证', '2021-05-19 20:13:09', 0);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (6, '/image/sponsor-avatar/avatar6.jpg', 'test6', 'test6', '19981481120', '2971529737@qq.com', '123456', '比赛主办方测试账号6 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '已认证', '2021-05-19 20:14:09', 0);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (7, '/image/sponsor-avatar/avatar.jpg', 'test7', 'test7', '19981481120', '2971529737@qq.com', '123123', '比赛主办方测试账号7 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '审核中', '2021-05-19 20:15:09', 0);



INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51363431575588864, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 01:39:56', NULL, 3, '规范化发过后好好 ', '2021-05-30 01:39:39', 1, '[1, 4, 2, 5]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51363431575588865, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-24 01:39:56', NULL, 3, '规范化发过后好好 ', '2021-05-30 01:39:39', 1, '[1, 4, 2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51363431575588866, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-25 01:39:56', NULL, 3, '规范化发过后好好 ', '2021-05-30 01:39:39', 1, '[1, 4]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51363431575588867, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-26 01:39:56', NULL, 3, '规范化发过后好好 ', '2021-05-30 01:39:39', 1, '[1]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51570147961475072, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 15:21:21', NULL, 1, 'yjthjjjghjhj', '2021-05-28 15:21:12', 1, '[1, 4, 2, 5]');



##################  目前数据库数据汇总
############ 主办方表
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (1, '/image/sponsor-avatar/ia_100000030.png', 'test1', 'test1', '19981481120', '2971529737@qq.com', '123qwe', '比赛主办方测试账号1 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '未认证', '2021-05-19 20:10:09', 1);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (2, '/image/sponsor-avatar/avatar2.jpg', 'test2', 'test2', '19981481120', '2971529737@qq.com', '123yur', '比赛主办方测试账号2 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '审核中', '2021-05-19 20:11:09', 1);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (3, '/image/sponsor-avatar/avatar3.jpg', 'test3', 'test3', '19981481120', '2971529737@qq.com', '111111', '比赛主办方测试账号3 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '未认证', '2021-05-19 20:11:09', 1);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (4, '/image/sponsor-avatar/avatar4.jpg', 'test4', 'test4', '19981481120', '2971529737@qq.com', '321321', '比赛主办方测试账号4 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。 ', '已认证', '2021-05-19 20:12:09', 0);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (5, '/image/sponsor-avatar/avatar5.jpg', 'test5', 'test5', '19981481120', '2971529737@qq.com', '123123', '比赛主办方测试账号5 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '未认证', '2021-05-19 20:13:09', 0);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (6, '/image/sponsor-avatar/avatar6.jpg', 'test6', 'test6', '19981481120', '2971529737@qq.com', '123456', '比赛主办方测试账号6 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '已认证', '2021-05-19 20:14:09', 0);
INSERT INTO `dalao`.`sponsor`(`sid`, `avatar`, `name`, `address`, `tel_num`, `email`, `password`, `intro`, `identity_status`, `join_date`, `account_status`) VALUES (7, '/image/sponsor-avatar/avatar.jpg', 'test7', 'test7', '19981481120', '2971529737@qq.com', '123123', '比赛主办方测试账号7 四川省畜牧兽医学会的前身，是四川省自然科学学会畜牧兽医专业组，1958年11月自然科学学会和科普协会合并成立四川省科学技术协会之后，畜牧兽医专业组在杨兴业、丘祥聘、王正杓、曹振华等几位老专家的倡议下组建而成。经过两年的筹备工作，四川省畜牧兽医学会于1960年底宣告正式成立，召开了第一次会员代表大会，选出了省农牧厅副厅长张敏为第一届理事会理事长。', '审核中', '2021-05-19 20:15:09', 1);

INSERT INTO `dalao`.`participant`(`pid`, `nickname`, `password`, `avatar`, `name`, `gender`, `university`, `college`, `major`, `grade`, `student_id`, `tel_num`, `email`, `id_number`, `join_date`, `account_status`) VALUES (1, 'jinn', '123', '/image/avatar.jpg', '明锦22', '男', '四川大学', '软件学院', '软件工程', '本科二年级', '2018141463022', '15348553796', '527383740@qq.com', '52262320000125', '2021-05-21 08:59:18', 0);
INSERT INTO `dalao`.`contest`(`cid`, `contest_name`, `sponsor_id`, `contest_intro`, `registration_start_time`, `registration_end_time`, `compete_start_time`, `compete_end_time`, `page_view`, `type`, `category`, `entry_fee`, `rank`, `audience`, `contest_status`) VALUES (1, '2021年全国大学生数据统计与分析竞赛', 1, '在大数据时代背景下，统计学作为大数据分析领域的基础显得尤为重要。为了帮助学生更好的学习和应用数据统计与分析的知识，促进统计、计算机、数学等相关专业的发展，培养具有数据分析与应用型人才，提升高校毕业生的就业竞争力，经研究决定，河北省现场统计学会、四川省现场统计学会等联合发起“全国大学生数据统计与分析竞赛”（以下简称“竞赛”），为我国数据统计与分析行业提供人才支持，夯实人才队伍基础。', '2021-04-12 00:00:00', '2021-05-21 00:00:00', '2021-05-22 00:00:00', '2021-05-30 00:00:00', 10, '组队赛', '\r\n\r\n    数学 计算机&信息技术\r\n\r\n数学 计算机&信息技术', 150, ' 全国性', '全国', 0);
INSERT INTO `dalao`.`contest`(`cid`, `contest_name`, `sponsor_id`, `contest_intro`, `registration_start_time`, `registration_end_time`, `compete_start_time`, `compete_end_time`, `page_view`, `type`, `category`, `entry_fee`, `rank`, `audience`, `contest_status`) VALUES (2, '2021年全国大学生英语竞赛', 2, 'XXX', '2021-05-22 07:25:48', '2021-05-22 07:25:51', '2021-05-22 07:25:55', '2021-05-22 07:25:57', 11, '组队赛', '英语', 100, '全国性', '全国', 0);

###############  用户封禁表
#
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51363431575588864, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 01:39:56', NULL, 3, '规范化发过后好好 ', '2021-05-30 01:39:39', 1, '[1, 4, 2, 5]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51363431575588865, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-24 01:39:56', NULL, 3, '规范化发过后好好 ', '2021-05-30 01:39:39', 1, '[1, 4, 2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51363431575588866, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-25 01:39:56', NULL, 3, '规范化发过后好好 ', '2021-05-30 01:39:39', 1, '[1, 4]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51363431575588867, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-26 01:39:56', NULL, 3, '规范化发过后好好 ', '2021-05-30 01:39:39', 1, '[1]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51570147961475072, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 15:21:21', NULL, 1, 'yjthjjjghjhj', '2021-05-28 15:21:12', 1, '[1, 4, 2, 5]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51571471427964928, '显示有人在进行或企图进行自我伤害', '2021-05-23 15:26:37', NULL, 2, 'fghhhnh', '2021-05-29 15:26:29', 1, '[1, 4]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51670745113300992, '描述了毒品、枪支、管制物品的买卖', '2021-05-23 22:01:04', NULL, 7, '活该！', '2021-05-31 22:00:31', 1, '[1, 4, 2, 5]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51670745113300993, '描述了毒品、枪支、管制物品的买卖', '2021-05-23 22:01:04', NULL, 7, '活该！', '2021-05-31 22:00:31', 1, '[4, 2, 5]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51913213201223680, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 15:21:21', NULL, 1, 'hgfhh', '2021-05-31 14:04:23', 1, '[1, 4]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51917846460108800, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 15:21:21', NULL, 1, 'dgfhgf', NULL, 1, '[[]]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51918006078541824, '未经授权使用，侵犯版权或商标权', '2021-05-24 14:23:37', NULL, 1, 'fthfgh', '2021-05-31 14:23:28', 1, '[1, 4]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51918098424532992, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 15:21:21', NULL, 1, 'dgfhgf', '2021-05-31 14:23:53', 1, '[[]]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51918305371492352, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 15:21:21', NULL, 1, 'dgfhgf', '2021-05-31 14:23:53', 1, '[[]]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51918803503812608, '未经授权使用，侵犯版权或商标权', '2021-05-24 14:26:47', NULL, 1, 'ghjghj', '2021-05-31 14:26:38', 1, '[2, 5]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51918862857408512, '侮辱或攻击他人的宗教、种族或性取向', '2021-05-23 15:21:21', NULL, 1, 'ghjhgj', NULL, 1, '[]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51920022666350592, '存在主张暴力或虐待人或动物的内容', '2021-05-24 14:40:44', NULL, 1, 'hjkj', '2021-05-31 14:31:25', 1, '[1, 4, 2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51922312185909248, '存在主张暴力或虐待人或动物的内容', '2021-05-24 14:40:44', NULL, 1, 'fhgjfgh', '2021-05-31 14:40:31', 1, '[1, 4, 2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51928690837295104, '存在主张暴力或虐待人或动物的内容', '2021-05-24 14:40:44', NULL, 1, '解禁1', '2021-05-31 15:05:53', 1, '[4, 2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51929795495333888, '存在主张暴力或虐待人或动物的内容', '2021-05-24 14:40:44', NULL, 1, '解禁 删除比赛', '2021-05-30 15:10:09', 1, '[2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51935906491404288, '存在主张暴力或虐待人或动物的内容', '2021-05-24 14:40:44', NULL, 1, '规划局规划就', '2021-05-31 15:34:39', 1, '[]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51935990847246336, '未经授权使用，侵犯版权或商标权', '2021-05-24 15:35:05', NULL, 1, '通用', '2021-05-31 15:34:55', 1, '[1, 4, 2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51936054688747520, '未经授权使用，侵犯版权或商标权', '2021-05-24 15:35:05', NULL, 1, '1', '2021-05-25 15:34:39', 1, '[4, 2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51936097189629952, '未经授权使用，侵犯版权或商标权', '2021-05-24 15:35:05', NULL, 1, '2', '2021-05-25 15:34:39', 1, '[2]');
INSERT INTO `dalao`.`ban_account`(`bid`, `reason`, `bannedTime`, `interval`, `uid`, `note`, `releaseTime`, `user_type`, `ban_type`) VALUES (51936131415150592, '未经授权使用，侵犯版权或商标权', '2021-05-24 15:35:05', NULL, 1, '3', '2021-05-25 15:34:39', 1, '[]');






