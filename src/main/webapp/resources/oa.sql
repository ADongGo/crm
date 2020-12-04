/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.62 : Database - oa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `oa`;

/*Table structure for table `analysis` */

DROP TABLE IF EXISTS `analysis`;

CREATE TABLE `analysis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `simpledis` varchar(320) DEFAULT NULL,
  `detaileddis` varchar(320) DEFAULT NULL,
  `addtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `remark` varchar(320) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `analysis_ibfk_1` FOREIGN KEY (`id`) REFERENCES `project` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `analysis` */

insert  into `analysis`(`id`,`proname`,`title`,`simpledis`,`detaileddis`,`addtime`,`updatetime`,`remark`) values (1,'人力资源管理系统','人力资源管理系统需求分析','该分析为最终需求','可以进行人力资管理','2019-06-09','2019-06-09','请参考需求分析'),(2,'ERP管理系统','ERP管理系统需求分析','该ERP可以实现很多功能','该ERP可以实现很多功能','2019-06-09','2019-06-09','该ERP可以实现很多功能'),(3,'OA自动办公系统','OA自动办公系统需求分析','可以实现员工管理','可以实现让员工的考勤、打卡、邮箱、办公等功能。','2019-06-09','2019-06-09','参考需求分析'),(4,'财务核算系','财务核算系需求分','包括月财务核算等','包括月财务核算等','2019-06-13','2019-06-13','包括月财务核算等'),(5,'国税务报税系统','国税务服税系需求分析','报务系统','很多','2020-03-04','2020-03-04','无'),(6,'医药信息管理系统','医药管理系统需求分析','药品管理系','对药品和种类进行管理','2019-06-17','2019-06-17','无'),(7,'电子商务平台','电子商务平台需求分析','它是一个商务平台软件。','dfsfsdfs','2019-11-07','2019-11-07','dsfdsfsdf'),(11,'ccc','ccc需求分析','很好','很好','2020-08-02','2020-08-02','好'),(13,'oa办公系统','办公系统需求分析','无','无','2020-08-02','2020-08-02','无'),(15,'财务核算系统','财务核算需求分析','这是一个财务工作流程','是一个财务核算系统','2020-03-10','2020-03-10','无');

/*Table structure for table `archives` */

DROP TABLE IF EXISTS `archives`;

CREATE TABLE `archives` (
  `dnum` varchar(64) NOT NULL,
  `landline` varchar(32) DEFAULT NULL COMMENT '固话',
  `school` varchar(32) DEFAULT NULL COMMENT '毕业院校',
  `zhuanye` varchar(32) DEFAULT NULL COMMENT '专业',
  `sosperson` varchar(32) DEFAULT NULL COMMENT '紧急联系人',
  `biyedate` date DEFAULT NULL COMMENT '毕业时间',
  `zzmm` varchar(32) DEFAULT NULL COMMENT '政治面貌',
  `minzu` varchar(32) DEFAULT NULL COMMENT '民族',
  `xueli` varchar(32) DEFAULT NULL COMMENT '学历',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `emp_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`dnum`),
  KEY `emp_fk` (`emp_fk`),
  CONSTRAINT `archives_ibfk_1` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `archives` */

insert  into `archives`(`dnum`,`landline`,`school`,`zhuanye`,`sosperson`,`biyedate`,`zzmm`,`minzu`,`xueli`,`email`,`emp_fk`) values ('bx331a89dddcc','010-88128721','武汉大学','计算机科与技术','张小宁','2019-02-02','中共党员','汉','大学本科','zhangsan@126.com',1),('dau4fadfjlaeopvlvlsdjfjdsl01','0100-011','清华大学','计算机科学与技术','纪春美','2010-06-30','群众','汉','大学本科','190293018@qq.com',2),('dau4fadfjlaeopvlvlsdjfjdsl02','0100-012','华中师范大学','计算机科学与技术','李小志','2012-06-20','党员','汉','研究生','cctv01@qq.com',3);

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_fk` int(11) DEFAULT NULL,
  `attname` varchar(32) DEFAULT NULL,
  `attdis` varchar(128) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `path` varchar(128) DEFAULT NULL,
  `uploadtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhdq50yhhjhdiyfm03xjohqlki` (`pro_fk`),
  CONSTRAINT `attachment_ibfk_1` FOREIGN KEY (`pro_fk`) REFERENCES `project` (`pid`),
  CONSTRAINT `FKhdq50yhhjhdiyfm03xjohqlki` FOREIGN KEY (`pro_fk`) REFERENCES `project` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `attachment` */

insert  into `attachment`(`id`,`pro_fk`,`attname`,`attdis`,`remark`,`path`,`uploadtime`,`updatetime`) values (13,6,'药品种类说明','介绍药品的种类进行详细的说明','无','file/6/9/933d5c94-13b2-4fb6-8372-7c12c2829012&attatchmentinfo.xls','2019-06-18','2019-06-18'),(14,1,'人力资源系统权限','人力资源系权限的说明','无','file/13/8/ab374c87-1ed8-46d9-ad39-8f191796f10e&maven.txt','2019-06-18','2019-06-18'),(15,7,'电子商务系统附件','关于bug的修正','无','F:\\attachment\\file\\15\\11\\4818ceac-da3a-49c1-bce4-38be5710a9d3&JSR303.txt','2019-09-26','2019-09-26'),(16,12,'修正一些bug','关于bug的修正','dddd','E:\\attachment\\file\\-389195849\\-97298963\\05a834a7-3f08-49cc-a34d-f8fda16e27a5&附件3  专项扣除附加项100问.doc','2019-11-08','2019-11-08'),(17,7,'修正一些bug','关于bug的修正111','','E:\\attachment\\file\\4\\13\\62c714fb-2c76-4207-9d53-fbf97d851307&offline_FtnInfo.txt','2019-11-08','2019-11-08'),(18,15,'财务分析图','关于bug的修正999','无','E:\\attachment\\file\\7\\9\\342d4c25-7633-4044-b83d-0050b70d2455&排课.png','2020-03-13','2020-03-13'),(19,15,'财务流程控制图','修正一些不规范的流程','','E:\\attachment\\file\\13\\3\\ac2a5ed5-14f5-49d6-90c5-82312344c317&更换CTS云教学系统申请单.doc','2020-03-16','2020-03-16'),(20,11,'七龙珠','很好看','无','D:\\AAA_date\\workspace\\attachment\\file\\2\\8\\ea3d3654-88cc-4912-bffb-b51383b7503e&timg (1).jpg','2020-08-03','2020-08-03');

/*Table structure for table `baoxiao` */

DROP TABLE IF EXISTS `baoxiao`;

CREATE TABLE `baoxiao` (
  `bxid` varchar(64) NOT NULL,
  `paymode` varchar(32) DEFAULT NULL COMMENT '类型',
  `totalmoney` double DEFAULT NULL COMMENT '总金额',
  `bxtime` date DEFAULT NULL COMMENT '报销时间',
  `bxremark` varchar(100) DEFAULT NULL COMMENT '报销备注',
  `bxstatus` int(11) DEFAULT NULL COMMENT '报销状态 1，2，3',
  `emp_fk` int(11) DEFAULT NULL COMMENT '发起报销人',
  `caiwu_fk` int(11) DEFAULT NULL COMMENT '处理报销人',
  `result` varchar(255) DEFAULT NULL,
  `shenpiDate` datetime DEFAULT NULL,
  PRIMARY KEY (`bxid`),
  KEY `emp_fk` (`emp_fk`),
  KEY `caiwu_fk` (`caiwu_fk`),
  CONSTRAINT `baoxiao_ibfk_1` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`),
  CONSTRAINT `baoxiao_ibfk_2` FOREIGN KEY (`caiwu_fk`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `baoxiao` */

insert  into `baoxiao`(`bxid`,`paymode`,`totalmoney`,`bxtime`,`bxremark`,`bxstatus`,`emp_fk`,`caiwu_fk`,`result`,`shenpiDate`) values ('165280c5-8113-463a-90d3-aa8829127abb','办公采购',20000,'2020-08-24','太好了',3,1,1,'同意','2020-08-06 20:33:20'),('28746771-a485-4d34-b1b4-1e0f770c2f2d','办公采购',999999,'2020-08-24','真的好贵',3,1,7,'可以','2020-08-05 21:07:03'),('3de80198-5d2e-4d91-8c40-a58bd4623b09','其他',10000,'2020-08-03','有点多',1,1,NULL,NULL,NULL),('4519612e-6ab2-4e9a-ae70-378cc4169329','办公采购',1500,'2020-03-05','开发1部门采购打印机和打印纸1500元',1,2,NULL,NULL,NULL),('925766c9-ddb7-4f46-b721-dac1864ba341','出差票据',122121,'2020-08-21','加油',1,1,NULL,NULL,NULL),('a162e7fd-575b-4931-9dae-47fb124ed06a','办公采购',3000,'2020-03-17','开发1部门购买了一台服务器，金额3000元',3,1,7,'同意','2020-03-18 16:37:54'),('b7b747d6-bfee-4434-9efb-22a77d60b814','出差票据',1000,'2020-03-25','去长沙火车票500元，回北京火车票500元，总计：1000元',3,13,7,'同意','2020-03-26 15:09:19'),('fb3ffc3c-1798-498f-8c21-56c9f3e96942','出差票据',2000,'2020-03-13','去重庆出差的火车票：801元\r\n重庆应打的费用398元\r\n从重应往北京的火车票：801元',3,1,7,'同意','2020-03-18 16:32:15');

/*Table structure for table `comparison` */

DROP TABLE IF EXISTS `comparison`;

CREATE TABLE `comparison` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(32) DEFAULT NULL,
  `turnonver` double DEFAULT NULL,
  `targetmoney` double DEFAULT NULL,
  `plan` varchar(100) DEFAULT NULL,
  `disparity` varchar(100) DEFAULT NULL,
  `emp_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `emp_fk` (`emp_fk`),
  CONSTRAINT `comparison_ibfk_1` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comparison` */

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comname` varchar(128) DEFAULT NULL,
  `companyperson` varchar(32) DEFAULT NULL,
  `comaddress` varchar(128) DEFAULT NULL,
  `comphone` varchar(32) DEFAULT NULL,
  `camera` varchar(128) DEFAULT NULL,
  `present` varchar(128) DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `addtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`comname`,`companyperson`,`comaddress`,`comphone`,`camera`,`present`,`remark`,`addtime`) values (17,'百度','张辉','北京市海淀区上地软件园','13910199113','010-88167124','提供搜索、广告。','无','2019-06-09'),(18,'北京其久软件有限公司','王强','北京市石景山区万寿路1号','13511021782','010-87127910','税务软件','无','2019-06-09'),(19,'北京字节跳动有限公司','张千','北京市海淀区学清路112号','18611012762','010-77217634','内容推送','无','2019-06-08'),(20,'湖南常欣药业有限责任公司','叶子豪','湖南省长沙市芙蓉区118号','18121871209','0731-88129812','生产药业品','无','2019-06-16'),(21,'中公教育科技股份有限公司','白霖尧','白霖尧','13310912431','010-67128910','是一家非常好的公司','无','2019-09-24'),(22,'河北新龙科技股份有限公司','陈大军','河北省石家庄市体育南大街','13210089102','010-8726120','专门从事Crm软件开发','无','2019-09-24'),(26,'新华软件','赵会志','北京市五方桥','13011032109','010-1111111','ddd','ddd','2019-11-05'),(27,'北京东华软件有限公司','齐雄','北京市西直门大街55号','13812348919','010-88129082','这是一个软件公司','无11','2020-03-11'),(28,'王氏集团','王辰','陕西省西安市未央路','15240337178','123456','adad','adad','2020-07-30');

/*Table structure for table `datacollect` */

DROP TABLE IF EXISTS `datacollect`;

CREATE TABLE `datacollect` (
  `daid` int(11) NOT NULL AUTO_INCREMENT,
  `dacname` varchar(32) DEFAULT NULL COMMENT '目标公司名称',
  `daturnover` double DEFAULT NULL COMMENT '营业额',
  `datime` date DEFAULT NULL COMMENT '年度',
  `dabusiness` varchar(128) DEFAULT NULL COMMENT '主要业务',
  `dasuperiority` varchar(128) DEFAULT NULL COMMENT '优势',
  `dainforiority` varchar(128) DEFAULT NULL COMMENT '劣势',
  `dasort` int(11) DEFAULT NULL COMMENT '行业排名',
  `empcount` int(11) DEFAULT NULL COMMENT '员工数量',
  `buildtime` date DEFAULT NULL COMMENT '企业创建时间',
  `remark` varchar(256) DEFAULT NULL COMMENT '简单描述',
  `daother` varchar(128) DEFAULT NULL COMMENT '其他',
  PRIMARY KEY (`daid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `datacollect` */

insert  into `datacollect`(`daid`,`dacname`,`daturnover`,`datime`,`dabusiness`,`dasuperiority`,`dainforiority`,`dasort`,`empcount`,`buildtime`,`remark`,`daother`) values (21,'浪潮集团',10,'2012-01-01','软件研发,电脑组装','国家扶持','自主能力较差',1,3000,'1980-09-09','创建时间较长，市场比较稳定','2012年-浪潮集团详细调研说明书.doc'),(22,'浪潮集团',11,'2013-01-01','软件研发,电脑组装','国家扶持','自主能力较差',2,3001,'1980-09-09','创建时间较长，市场比较稳定','2013年-浪潮集团详细调研说明书.doc'),(23,'浪潮集团',12,'2014-01-01','软件研发,电脑组装','国家扶持','自主能力较差',2,3002,'1980-09-09','创建时间较长，市场比较稳定','2014年-浪潮集团详细调研说明书.doc'),(24,'浪潮集团',13,'2015-01-01','软件研发,服务器生产','国家扶持','自主能力较差',3,3003,'1980-09-09','创建时间较长，市场比较稳定','2015年-浪潮集团详细调研说明书.doc'),(25,'浪潮集团',14,'2016-01-01','软件研发,军工服务器生产','国家扶持','自主能力较差',4,3004,'1980-09-09','创建时间较长，市场比较稳定','2016年-浪潮集团详细调研说明书.doc'),(26,'浪潮集团',15,'2017-01-01','软件研发,云计算','国家扶持','自主能力较差',2,3005,'1980-09-09','创建时间较长，市场比较稳定','2017年-浪潮集团详细调研说明书.doc'),(27,'浪潮集团',16,'2018-01-01','软件研发，云计算,边缘计算','国家扶持,部门较多','自主能力较差',2,3006,'1980-09-09','创建时间较长，市场比较稳定','2018年-浪潮集团详细调研说明书.doc'),(28,'东华软件',8,'2012-01-01','金融软件开发','自主研发能力强','区域限制严重',8,2000,'1985-01-01','软件业务较为强悍,其他业务交差','2012年-东华软件详细调研说明书.doc'),(29,'东华软件',9,'2012-01-02','金融软件开发','自主研发能力强','区域限制严重',9,2001,'1985-01-01','软件业务较为强悍,其他业务交差','2013年-东华软件详细调研说明书.doc'),(30,'东华软件',10,'2012-01-03','金融软件开发','自主研发能力强','区域限制严重',10,2002,'1985-01-01','软件业务较为强悍,其他业务交差','2014年-东华软件详细调研说明书.doc'),(31,'东华软件',11,'2012-01-04','金融软件开发','自主研发能力强','区域限制严重',11,2003,'1985-01-01','软件业务较为强悍,其他业务交差','2015年-东华软件详细调研说明书.doc'),(32,'东华软件',12,'2012-01-05','金融软件开发','自主研发能力强','区域限制严重',12,2004,'1985-01-01','软件业务较为强悍,其他业务交差','2016年-东华软件详细调研说明书.doc'),(33,'东华软件',13,'2012-01-06','金融软件开发','自主研发能力强','区域限制严重',13,2005,'1985-01-01','软件业务较为强悍,其他业务交差','2017年-东华软件详细调研说明书.doc'),(34,'东华软件',14,'2012-01-07','金融软件开发','自主研发能力强','区域限制严重',14,2006,'1985-01-01','软件业务较为强悍,其他业务交差','2018年-东华软件详细调研说明书.doc');

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(32) DEFAULT NULL,
  `dlocation` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`deptno`,`dname`,`dlocation`) values (10,'开发部','北京'),(20,'市场部','北京'),(30,'财务部','北京');

/*Table structure for table `email` */

DROP TABLE IF EXISTS `email`;

CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  `sendtime` datetime DEFAULT NULL,
  `emp_fk` int(11) DEFAULT NULL,
  `emp_fk2` int(11) DEFAULT NULL,
  `emailcontent` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbwdib3s3ugq70b5h2ocn0rfvb` (`emp_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `email` */

insert  into `email`(`id`,`title`,`sendtime`,`emp_fk`,`emp_fk2`,`emailcontent`) values (19,'关于疫情通知','2020-03-20 11:48:09',1,2,'ssxxxxxx'),(20,'保险','2020-03-20 11:52:04',1,2,'ttttt');

/*Table structure for table `emp_role` */

DROP TABLE IF EXISTS `emp_role`;

CREATE TABLE `emp_role` (
  `erid` int(11) NOT NULL AUTO_INCREMENT,
  `role_fk` int(11) DEFAULT NULL,
  `emp_fk` int(11) DEFAULT NULL,
  `erdis` varchar(32) DEFAULT NULL COMMENT '员工和角色的描述',
  PRIMARY KEY (`erid`),
  KEY `emp_fk` (`emp_fk`),
  KEY `role_fk` (`role_fk`),
  CONSTRAINT `emp_role_ibfk_1` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`),
  CONSTRAINT `emp_role_ibfk_2` FOREIGN KEY (`role_fk`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

/*Data for the table `emp_role` */

insert  into `emp_role`(`erid`,`role_fk`,`emp_fk`,`erdis`) values (61,17,2,NULL),(63,20,3,NULL),(64,20,4,NULL),(65,20,5,NULL),(66,20,6,NULL),(67,18,7,NULL),(68,16,9,NULL),(69,20,10,NULL),(70,20,11,NULL),(75,20,13,NULL),(76,17,14,NULL),(105,16,1,NULL);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(32) DEFAULT NULL,
  `esex` varchar(32) DEFAULT NULL,
  `eage` int(11) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `pnum` varchar(32) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `p_fk` int(11) DEFAULT NULL,
  `d_fk` int(11) DEFAULT NULL,
  `l_fk` int(11) DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FKt4aodqf7acjpmo7iejdmg3k78` (`p_fk`),
  KEY `d_fk` (`d_fk`),
  KEY `l_fk` (`l_fk`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`p_fk`) REFERENCES `position` (`id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`d_fk`) REFERENCES `dept` (`deptno`),
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`l_fk`) REFERENCES `level` (`jid`),
  CONSTRAINT `FKt4aodqf7acjpmo7iejdmg3k78` FOREIGN KEY (`p_fk`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`eid`,`ename`,`esex`,`eage`,`telephone`,`hiredate`,`pnum`,`username`,`password`,`remark`,`p_fk`,`d_fk`,`l_fk`,`pic`) values (1,'张三','男',22,'13577818911','1990-12-12','1','zhangsan','96e79218965eb72c92a549dd5a330112','aaaa',4,10,5,'/pic/4/9/0b67b4c8-36bb-4a3f-a8f9-47470177968c&1.jpg'),(2,'李四','女',28,'34324324','1992-10-10','1','lisi','96e79218965eb72c92a549dd5a330112','dddd',4,10,4,'/pic/5/9/67cc3fec-f432-4321-bffc-1e10936795ef&2.jpg'),(3,'陈梦晗','男',21,'131414141','1990-10-10','1','chengmenghan','96e79218965eb72c92a549dd5a330112','cccc',4,10,2,'/pic/7/9/787d1bac-c1f6-4da3-831c-110a503d790a&4.jpg'),(4,'董吉鹏','男',24,'3432432432','1992-10-10','1','dongjipeng','96e79218965eb72c92a549dd5a330112','ddddd',1,10,3,'/pic/8/10/aa753d85-63f4-4887-9497-a760a4fd4569&5.jpg'),(5,'刘岳龙','男',22,'432324324','1990-11-11','1','liuyuelong','96e79218965eb72c92a549dd5a330112','eeee',1,10,3,'/pic/5/1/36f424f7-63c6-4854-9cf7-7dbafbc6f35b&pic.png'),(6,'马力','男',25,'34535435','1990-12-12','1','mali','96e79218965eb72c92a549dd5a330112','fffff',1,10,3,'/pic/4/9/5c49d7f0-851a-4e77-aa66-982c9ababd14&1.jpg'),(7,'王翠花','女',28,'353454354','1990-12-19','1','wangcuihua','96e79218965eb72c92a549dd5a330112','aaaaaa',7,30,5,'/pic/4/1/8867be77-ed83-43c3-bbdd-0ccbb95c4c2d&mei.jpg'),(9,'李中扬','男',30,'3453243','2019-11-13','23011854533','lizhongyang','96e79218965eb72c92a549dd5a330112','ssss',1,10,5,'/pic/5/9/56081380-f47e-4673-ab4d-95e70b822430&u=3962805517,413692801&fm=26&gp=0.jpg'),(10,'白霖尧','男',22,'2342143324','2019-11-19','23011854533','bailingyao','96e79218965eb72c92a549dd5a330112','ddddd',1,10,1,'/pic/2/4/54cd99f3-1e1c-4565-b7c6-066da33d1225&www.png'),(11,'赵会志','男',22,'2342143324','2019-06-05','23011854533','zhaohuizhi','96e79218965eb72c92a549dd5a330112','sssss',1,10,1,'/pic/12/3/ac1d6984-4fe9-4dc7-a0f1-e7048f142e1a&无标题.png'),(13,'李成艺','男',22,'13314216722','2020-03-19','2301185453311','lichengyi','96e79218965eb72c92a549dd5a330112','新员工',1,10,1,'/pic/2/4/98f2d059-f052-4b30-b59a-521d15721690&10.jpg'),(14,'王辰','男',18,'15240337178','2020-08-05','12313123124131','wangchen','96e79218965eb72c92a549dd5a330112','真的很强',3,10,4,'/pic/4/5/f159a2a3-d957-49ed-920c-45419b87494e&a.jpg'),(17,'哈哈哈哈','女',12,'1231314','2020-08-13','12414234','hhhh','d41d8cd98f00b204e9800998ecf8427e','affka',5,20,3,''),(18,'孙国强','男',220,'4567890','2020-08-05','1234567890','admin','e3ceb5881a0a1fdaad01296d7554868d','eaad',2,10,1,'/pic/9/6/97d2411c-a07a-4ed4-a5a9-3112167f69a5&f.jpg');

/*Table structure for table `evaluate` */

DROP TABLE IF EXISTS `evaluate`;

CREATE TABLE `evaluate` (
  `evaid` int(11) NOT NULL AUTO_INCREMENT,
  `forumFk` int(11) NOT NULL,
  `empFk` int(11) NOT NULL,
  `evaidFk` int(11) DEFAULT NULL,
  `evacontent` text,
  `updatetime` datetime DEFAULT NULL,
  `evatime` datetime DEFAULT NULL,
  `evastatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`evaid`),
  KEY `forumFk` (`forumFk`),
  KEY `empFk` (`empFk`),
  CONSTRAINT `evaluate_ibfk_1` FOREIGN KEY (`forumFk`) REFERENCES `forumpost` (`forumid`),
  CONSTRAINT `evaluate_ibfk_2` FOREIGN KEY (`empFk`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `evaluate` */

insert  into `evaluate`(`evaid`,`forumFk`,`empFk`,`evaidFk`,`evacontent`,`updatetime`,`evatime`,`evastatus`) values (1,1,2,NULL,'你要在哪租房子？','2019-06-21 21:08:07','2019-06-21 21:08:12',NULL),(2,1,3,NULL,'你想多少钱租？','2019-06-21 21:13:48','2019-06-21 21:13:50',NULL),(3,1,1,1,'袁家岭地铁口','2019-06-22 21:11:04','2019-06-22 21:11:09',NULL),(7,1,4,2,'1000块钱','2019-06-22 00:00:59','2019-06-22 00:01:04',NULL),(8,1,6,NULL,'<p><span style=\"font-family: ����; font-size: 12px; background-color: rgb(255, 255, 255);\">一室二厅吗？好奢侈！</span></p>','2019-06-22 00:00:00','2019-06-22 00:00:00',NULL),(9,1,7,NULL,'<p>在地铁口租房子好，方便！</p>','2019-06-25 10:38:09','2019-06-25 10:38:09',NULL),(11,1,5,2,'<p>大帅哥！！！！</p>','2019-06-25 19:53:29','2019-06-25 19:53:29',NULL),(12,9,2,NULL,'<p>你什么结婚？<br/></p>','2019-10-10 09:59:51','2019-10-10 09:59:51',NULL),(13,9,7,NULL,'<p>你在哪举办婚礼。<br/></p>','2019-10-10 10:01:08','2019-10-10 10:01:08',NULL),(14,9,6,13,'<p>关你什么事？你怎么那么贱！<br/></p>','2019-10-10 10:03:54','2019-10-10 10:03:54',NULL),(15,1,2,3,'<p>qqqqq</p>','2019-10-10 17:18:47','2019-10-10 17:18:47',NULL),(16,9,10,14,'<p>你怎么这样说话啊，太伤人心了！<img src=\"http://img.baidu.com/hi/jx2/j_0067.gif\"/></p>','2019-11-14 18:48:19','2019-11-14 18:48:19',NULL),(17,9,4,NULL,'<p>好事！恭喜！<img src=\"http://img.baidu.com/hi/jx2/j_0009.gif\"/></p>','2019-11-15 09:51:55','2019-11-15 09:51:55',NULL),(18,9,4,16,'<p>你说的太对了！支持，语言不能伤人！<img src=\"http://img.baidu.com/hi/jx2/j_0013.gif\"/></p>','2019-11-15 09:52:50','2019-11-15 09:52:50',NULL),(19,10,2,NULL,'<p>都有什么岗位？</p>','2020-03-23 16:28:53','2020-03-23 16:28:53',NULL),(20,10,5,19,'<p>应该java工程岗位比较多。</p>','2020-03-23 16:30:17','2020-03-23 16:30:17',NULL),(21,9,1,18,'<p>我也觉得<br/></p>','2020-08-08 18:59:44','2020-08-08 18:59:44',NULL),(22,9,1,21,'<p>哈哈哈哈哈哈哈</p>','2020-08-08 19:01:48','2020-08-08 19:01:48',NULL);

/*Table structure for table `forumpost` */

DROP TABLE IF EXISTS `forumpost`;

CREATE TABLE `forumpost` (
  `forumid` int(11) NOT NULL AUTO_INCREMENT,
  `forumtitle` varchar(255) DEFAULT NULL,
  `forumcontent` text,
  `createtime` datetime DEFAULT NULL,
  `stats` int(11) DEFAULT NULL,
  `empFk3` int(11) NOT NULL,
  PRIMARY KEY (`forumid`),
  KEY `empFk3` (`empFk3`),
  CONSTRAINT `forumpost_ibfk_1` FOREIGN KEY (`empFk3`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `forumpost` */

insert  into `forumpost`(`forumid`,`forumtitle`,`forumcontent`,`createtime`,`stats`,`empFk3`) values (1,'我要租房子','<p>在袁家岭地铁口附近，租一个二室一厅的房子！</p>','2019-06-24 14:21:32',1,1),(2,'搬教师啦','<p>今天我搬教室了，新教室非漂亮！</p>','2019-06-24 14:24:56',1,1),(3,'bbb','<p>ccccc</p>','2019-06-24 14:27:17',1,1),(4,'fffff','<p>fffff</p>','2019-06-24 14:34:30',1,1),(5,'aaaa','<p>aaaaaa</p>','2019-06-24 14:59:50',1,1),(6,'ddddd','<p>ddddd</p>','2019-06-24 14:59:59',1,1),(7,'ggggg','<p>ggggggg</p>','2019-06-24 15:00:09',1,1),(8,'wwwww','<p>wwwwwww</p>','2019-06-24 15:00:28',1,1),(9,'田盼龙要结婚了','<p>欢迎大家参加婚礼。</p>','2019-10-09 14:02:47',1,1),(10,'中关村软件园招聘会','<p>2020年03月27日，在北京中关村软件园将有一个大型的招聘会。欢迎大家参加！</p><p><img width=\"530\" height=\"340\" src=\"http://api.map.baidu.com/staticimage?center=116.309026,40.052069&zoom=16&width=530&height=340&markers=116.304535,40.053339\"/></p>','2020-03-23 10:02:02',1,1),(11,'关于把硬盘上的目录映射成一个路径','<ol class=\" list-paddingleft-2\" style=\"list-style-type: decimal;\"><li><p>把硬盘图片所在的路径进行映射 E:\\attachment\\file</p><p>&lt;Context path=&quot;/pic&quot; docBase=&quot;E:/attachment/file&quot; reloadable=&quot;true&quot;/&gt;</p></li><li><p>把数据库中的pic字段的值</p><p>&nbsp;/pic/13/3/1.jpg</p></li><li><p>修改idear的tomcat设置</p><p>把 deploy application configured in tomcat instance打上对勾</p></li><li><p>启重tomcat<br/></p><p><br/></p></li></ol>','2020-03-23 14:46:32',1,2),(12,'Java第三阶段快要结束了','<p>小伙伴有什么想法？</p>','2020-03-25 16:04:15',1,13),(13,'你好','<p>你好</p>','2020-08-09 17:46:11',1,1),(14,'哈哈哈哈','<p>哈哈哈哈</p>','2020-08-09 17:47:16',1,1);

/*Table structure for table `function` */

DROP TABLE IF EXISTS `function`;

CREATE TABLE `function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(32) DEFAULT NULL,
  `analysisname` varchar(32) DEFAULT NULL,
  `modele_fk` int(11) DEFAULT NULL,
  `functionname` varchar(32) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `simpledis` varchar(256) DEFAULT NULL,
  `detaileddis` varchar(256) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjonpxsiii6o3xv16nttvg500w` (`modele_fk`),
  CONSTRAINT `FKjonpxsiii6o3xv16nttvg500w` FOREIGN KEY (`modele_fk`) REFERENCES `module` (`id`),
  CONSTRAINT `function_ibfk_1` FOREIGN KEY (`modele_fk`) REFERENCES `module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `function` */

insert  into `function`(`id`,`proname`,`analysisname`,`modele_fk`,`functionname`,`level`,`simpledis`,`detaileddis`,`remark`) values (1,'人力资源管理系统','人力资源管理系统需求分析',6,'员工考勤功能','中','对员工进行考勤记录','上班时间  上午9:00 下午：18：00','无'),(2,'人力资源管理系统','人力资源管理系统需求分析',6,'员工请假功能','中','员工可以进行请假制度','同工可以倒休和请假','无'),(3,'人力资源管理系统','人力资源管理系统需求分析',6,'员工增删改查功能','中','无','无','无'),(4,'医药信息管理系统','医药管理系统需求分析',9,'药品的分类管理功能','中','对药品的种类进行管理','对药品的种类进行管理,中程药、处方药等','无'),(5,'国税务报税系统','国税务服税系需求分析',11,'报税统计功能','高','无','无','无'),(6,'电子商务平台','电子商务平台需求分析',13,'商品模块的添加','中','对商品进行添加功能','何存商品的各个属性','无'),(7,'财务核算系统','财务核算需求分析',14,'登陆功能','中','财务系统中的一个普通用户登陆功能','登陆','无'),(8,'ERP管理系统','ERP管理系统需求分析',16,'拦截器','高','无','无','无'),(9,'国税务报税系统','国税务服税系需求分析',11,'退出登录','高','无','无','无');

/*Table structure for table `indexvalue` */

DROP TABLE IF EXISTS `indexvalue`;

CREATE TABLE `indexvalue` (
  `in_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '对标的具体内容id',
  `in_turnover` double DEFAULT NULL COMMENT '目标营业额',
  `in_business` varchar(128) DEFAULT NULL COMMENT '主要业务方向',
  `comname_fk` int(11) DEFAULT NULL COMMENT '对比企业名称',
  `in_remark` varchar(256) DEFAULT NULL COMMENT '简单说明',
  `in_file` varchar(128) DEFAULT NULL COMMENT '附件',
  `emp_fk5` int(11) DEFAULT NULL COMMENT '指标制定人',
  `in_starttime` date DEFAULT NULL COMMENT '开始时间',
  `in_endtime` date DEFAULT NULL COMMENT '截止时间',
  `in_updatetime` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`in_id`),
  KEY `comname_fk` (`comname_fk`),
  KEY `emp_fk5` (`emp_fk5`),
  CONSTRAINT `indexvalue_ibfk_1` FOREIGN KEY (`comname_fk`) REFERENCES `datacollect` (`daid`),
  CONSTRAINT `indexvalue_ibfk_2` FOREIGN KEY (`emp_fk5`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `indexvalue` */

insert  into `indexvalue`(`in_id`,`in_turnover`,`in_business`,`comname_fk`,`in_remark`,`in_file`,`emp_fk5`,`in_starttime`,`in_endtime`,`in_updatetime`) values (1,20,'金融软件开发',24,'我们也有很多客户，虽然客户每个业务盈利少，但项目多。此可以实现。','E:\\attachment\\file\\maven.txt',7,'2019-06-01','2019-12-31',NULL),(2,5,'软件研发',27,'压标耐酸地面sfsdfdsfds','E:\\attachment\\file\\工作表.xls',1,'2019-06-27','2020-01-24',NULL),(3,2,'软件研发',27,'','E:\\attachment\\file\\何峰-Java(1).doc',1,'2020-03-25','2020-03-29',NULL),(4,10,'很好的方向',34,'真的很好的项目','E:\\attachment\\file\\',1,'2020-08-04','2020-08-21',NULL);

/*Table structure for table `level` */

DROP TABLE IF EXISTS `level`;

CREATE TABLE `level` (
  `jid` int(11) NOT NULL AUTO_INCREMENT,
  `jname` varchar(32) DEFAULT NULL,
  `jdis` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`jid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `level` */

insert  into `level`(`jid`,`jname`,`jdis`) values (1,'p1','实习生'),(2,'p2','初级程序员'),(3,'p3','高级程序员'),(4,'p4','项目经理'),(5,'p5','管理');

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(32) DEFAULT NULL,
  `analysis_fk` int(11) DEFAULT NULL,
  `modname` varchar(32) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `simpledis` varchar(256) DEFAULT NULL,
  `detaileddis` varchar(256) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK986a0ufpo55087x7uc0ous7nb` (`analysis_fk`),
  CONSTRAINT `FK986a0ufpo55087x7uc0ous7nb` FOREIGN KEY (`analysis_fk`) REFERENCES `analysis` (`id`),
  CONSTRAINT `module_ibfk_1` FOREIGN KEY (`analysis_fk`) REFERENCES `analysis` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `module` */

insert  into `module`(`id`,`proname`,`analysis_fk`,`modname`,`level`,`simpledis`,`detaileddis`,`remark`) values (6,'1',1,'员工管理模块','中','对员工信息进行管理','员工模块包括：增、改、删、查等功能。','无'),(7,'1',1,'部门管理模块','中','建立部门','对部门的增、删、改查','无'),(8,'1',1,'工资模块','中','对工资进行管理','详细列表工资条信息','无'),(9,'6',6,'药品管理模块','中','对药品进行管理','对药进行详细描述','无'),(11,'5',5,'报务模块','高','这是一个报税模块','这是一个报税模块','这是一个报税模块'),(12,'7',7,'员工管理模块','高','xxxxx','xxxx','xxxcxc'),(13,'7',7,'商品模块','高','xxxx','SSS','SSSS'),(14,'15',15,'帐户的登陆模块','高','财务系统的登陆模块','用户需要输入用户名和密码进行登陆验证','无'),(15,'15',15,'账号的退出模块','低','用户进行注销的模块','用户登陆退出，我们把session失效，系退出系统，转到登陆界面','无'),(16,'2',2,'很棒的模块','高','无','无','无');

/*Table structure for table `msg` */

DROP TABLE IF EXISTS `msg`;

CREATE TABLE `msg` (
  `msgid` int(11) NOT NULL AUTO_INCREMENT,
  `sendp` int(32) DEFAULT NULL,
  `recvp` int(32) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  `msgcontent` varchar(32) DEFAULT NULL,
  `msgtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`msgid`),
  KEY `sendp` (`sendp`),
  KEY `recvp` (`recvp`),
  CONSTRAINT `msg_ibfk_1` FOREIGN KEY (`sendp`) REFERENCES `employee` (`eid`),
  CONSTRAINT `msg_ibfk_2` FOREIGN KEY (`recvp`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `msg` */

insert  into `msg`(`msgid`,`sendp`,`recvp`,`mark`,`msgcontent`,`msgtime`) values (16,1,2,NULL,'eeeeee','2020-03-20 16:54:00');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `nid` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(32) DEFAULT NULL,
  `remark` text,
  `ndate` date DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`nid`,`ntitle`,`remark`,`ndate`) values (1,'关于清明放假的通知','清明节放假','2019-06-21'),(2,'关于端午放假的通知','端午根据国家的规定和要求进行端午放假。','2019-06-21'),(3,'关于纪律考勤的通告','近期由于有一些员工，非法签到，给公司带来的一些不好影响，从明天开始，对于考勤进行严格管理。','2019-06-21'),(4,'国庆大阅兵结束','国庆大阅兵结束，各个交通恢复正常。','2019-10-08'),(5,'关于春节放假通知','各部门：\r\n           今天春节放假一个月，做好放假的准备。','2019-10-08'),(6,'关于元旦的放假通知','放假','2019-11-13'),(8,'关于疫情期间工作的通知','<p>各学院、各部门：</p><p><br/></p><p><span style=\"color: rgb(255, 0, 0);\">&nbsp; &nbsp; &nbsp;<strong> &nbsp;疫情就是命令，防控就是责任</strong>。<span style=\"color: rgb(0, 0, 0);\">新型冠状病毒感染肺炎疫情的防控工作正处于关键时期，防疫阻击战刻不容缓、不容松懈。经学校研究决定，再次重申，2019-2020学年第二学期开学时间和后续安排将另行通知，全体师生员工务必不要提前返校。</span></span></p><p><br/></p><p><span style=\"color: rgb(0, 0, 0);\">&nbsp; &nbsp; &nbsp; &nbsp;确需由外地返回珠海校内居住的教职员工，应提前向所在单位主要负责人报备，由单位负责人上报新型冠状病毒感染的肺炎疫情防控工作办公室获得批准后方可返校。返校后应按照《</span><strong><span style=\"color: rgb(255, 0, 0);\">关于加强疫情防控期间校门管理的通知</span></strong>》（<strong><span style=\"color: rgb(255, 0, 0);\">北理珠新型冠状病毒肺炎防控工作办公室1号</span></strong>）及相关文件要求，服从安排，配合做好疫情防控工作。其中，乘火车、飞机、轮船、公共汽车等公共交通工具返校的，应按要求居家隔离14天以上。现身处湖北等疫情集中区域的教职员工务必等学校返校通知，切勿提前自行返校。</p><p><br/></p><p>&nbsp; &nbsp; &nbsp; &nbsp;学校已在全校各单位实行覆盖所有师生员工的日报告信息制度，请全体师生员工积极配合，及时报告自己的实际情况。</p><p><br/></p><p>&nbsp; &nbsp; &nbsp; &nbsp;疫情防控，人人有责。全体师生员工要在居住地点自行合理安排工作和学习，自觉落实好疫情防控要求。让我们戮力同心，为坚决打赢疫情防控阻击战作出自己应有的贡献。<br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;北京理工大珠海学院</p><p style=\"text-align: right;\">新型冠状病毒感染的肺炎疫情防控工作办公室</p><p style=\"text-align: right;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;2020年02月15日</p><p><br/></p>','2020-03-19');

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`name`) values (1,'初级开发工程师'),(2,'中级开发工程师'),(3,'高级开发工程师'),(4,'项目经理'),(5,'项目总监'),(6,'其它'),(7,'财务主管');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(128) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `comper` varchar(64) DEFAULT NULL,
  `emp_fk1` int(11) DEFAULT NULL,
  `empcount` int(11) DEFAULT NULL,
  `starttime` date DEFAULT NULL,
  `buildtime` date DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `emp_fk` int(11) NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `emp_fk1` (`emp_fk1`),
  KEY `FKtirudsu3khj865hrqeamn153y` (`customer_id`),
  KEY `FKj4vtyyp6ew24vggobfcmav1be` (`emp_fk`),
  CONSTRAINT `FKj4vtyyp6ew24vggobfcmav1be` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`),
  CONSTRAINT `FKtirudsu3khj865hrqeamn153y` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`pid`,`pname`,`customer_id`,`comper`,`emp_fk1`,`empcount`,`starttime`,`buildtime`,`cost`,`level`,`endtime`,`remark`,`emp_fk`) values (1,'人力资源管理系统',18,'王强',0,5,'2019-06-13','2019-06-07',30,'紧急','2019-06-27','无',1),(2,'ERP管理系统',19,'张千一',0,10,'2019-06-27','2019-06-07',300,'紧急','2019-07-26','无',2),(3,'OA自动办公系统',17,'张辉',0,20,'2019-06-18','2019-06-27',100,'紧急','2019-07-30','无',1),(4,'财务核算系',18,'王强',0,20,'2019-06-14','2019-06-05',300,'一般','2019-07-30','不急，慢慢做',1),(5,'国税务报税系统',18,'王强',0,20,'2019-06-04','2019-06-04',200,'紧急','2019-06-27','报税系统',2),(6,'医药信息管理系统',20,'叶子豪',NULL,10,'2019-06-19','2019-06-07',10,'一般','2019-07-25','无',1),(7,'电子商务平台',18,'王强',NULL,10,'2019-09-03','2019-09-11',300,'一般','2019-09-09','无',1),(11,'ccc',17,'张辉',NULL,10,'2019-11-20','2019-11-05',30,'紧急','2019-10-29','dddd',1),(12,'新华公办系统',26,'赵会志',NULL,10,'2019-11-04','2019-10-30',30,'紧急','2019-11-11','dddd',1),(13,'oa办公系统',18,'王强',NULL,10,'2020-03-04','2020-03-14',30,'紧急','2020-03-24','aaaa',1),(14,'电子商务平台2',19,'张千一',NULL,10,'2019-11-12','2019-11-07',30,'紧急','2019-12-03','',2),(15,'财务核算系统',21,'白霖尧',NULL,9,'2020-03-20','2020-03-02',300,'暂缓','2020-08-31','财务核算系统是一套财务应用软件，可以进行财务统计，每月的图表生成。',2),(16,'信息管理系统',28,'王辰',NULL,10,'2020-07-07','2020-07-31',10,'紧急','2020-08-02','无',1),(17,'打卡考勤系统',18,'王强',NULL,10,'2020-07-27','2020-07-28',22,'一般','2020-07-27','无',3);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rolename` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `roledis` varchar(32) DEFAULT NULL COMMENT '角色描述',
  `status` int(11) DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleid`,`rolename`,`roledis`,`status`) values (16,'管理员','管理员拥用全部资源',1),(17,'项目经理','项目经理拥用大分部资源',1),(18,'务财总监','务财总监拥用部分资源',1),(19,'人力总监','人力资源有一部分资源',1),(20,'普通员工','普通员工有较少资源',1),(23,'王辰','你好',1);

/*Table structure for table `role_sources` */

DROP TABLE IF EXISTS `role_sources`;

CREATE TABLE `role_sources` (
  `rsid` int(11) NOT NULL AUTO_INCREMENT,
  `rsdis` varchar(32) DEFAULT NULL COMMENT '角色和资源的描述',
  `sid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rsid`),
  KEY `roleid` (`roleid`),
  KEY `sid` (`sid`),
  CONSTRAINT `role_sources_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `role_sources_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `sources` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=619 DEFAULT CHARSET=utf8;

/*Data for the table `role_sources` */

insert  into `role_sources`(`rsid`,`rsdis`,`sid`,`roleid`) values (353,NULL,1,16),(354,NULL,2,16),(355,NULL,9,16),(356,NULL,10,16),(357,NULL,11,16),(358,NULL,12,16),(359,NULL,13,16),(360,NULL,3,16),(361,NULL,14,16),(362,NULL,15,16),(363,NULL,16,16),(364,NULL,17,16),(365,NULL,18,16),(366,NULL,19,16),(367,NULL,20,16),(368,NULL,21,16),(369,NULL,4,16),(370,NULL,27,16),(371,NULL,32,16),(372,NULL,33,16),(373,NULL,28,16),(374,NULL,29,16),(375,NULL,34,16),(376,NULL,39,16),(377,NULL,40,16),(378,NULL,41,16),(379,NULL,35,16),(380,NULL,43,16),(381,NULL,44,16),(382,NULL,51,16),(383,NULL,47,16),(384,NULL,53,16),(385,NULL,54,16),(386,NULL,1,17),(387,NULL,2,17),(388,NULL,9,17),(389,NULL,10,17),(390,NULL,11,17),(391,NULL,12,17),(392,NULL,13,17),(393,NULL,3,17),(394,NULL,14,17),(395,NULL,15,17),(396,NULL,19,17),(397,NULL,21,17),(398,NULL,4,17),(399,NULL,27,17),(400,NULL,32,17),(401,NULL,33,17),(402,NULL,28,17),(403,NULL,29,17),(404,NULL,34,17),(405,NULL,39,17),(406,NULL,35,17),(407,NULL,43,17),(408,NULL,44,17),(409,NULL,51,17),(410,NULL,47,17),(411,NULL,53,17),(412,NULL,54,17),(428,NULL,1,19),(429,NULL,3,19),(430,NULL,17,19),(431,NULL,18,19),(432,NULL,19,19),(433,NULL,21,19),(434,NULL,4,19),(435,NULL,27,19),(436,NULL,32,19),(437,NULL,33,19),(438,NULL,34,19),(439,NULL,39,19),(440,NULL,47,19),(441,NULL,53,19),(442,NULL,54,19),(496,NULL,1,18),(497,NULL,3,18),(498,NULL,17,18),(499,NULL,19,18),(500,NULL,20,18),(501,NULL,21,18),(502,NULL,4,18),(503,NULL,27,18),(504,NULL,32,18),(505,NULL,33,18),(506,NULL,34,18),(507,NULL,39,18),(508,NULL,47,18),(509,NULL,53,18),(510,NULL,54,18),(540,NULL,1,20),(541,NULL,2,20),(542,NULL,13,20),(543,NULL,3,20),(544,NULL,16,20),(545,NULL,19,20),(546,NULL,21,20),(547,NULL,4,20),(548,NULL,27,20),(549,NULL,32,20),(550,NULL,33,20),(551,NULL,47,20),(552,NULL,53,20),(553,NULL,54,20),(592,NULL,1,23),(593,NULL,2,23),(594,NULL,9,23),(595,NULL,10,23),(596,NULL,11,23),(597,NULL,12,23),(598,NULL,13,23),(599,NULL,4,23),(600,NULL,27,23),(601,NULL,32,23),(602,NULL,33,23),(603,NULL,28,23),(604,NULL,29,23),(605,NULL,34,23),(606,NULL,39,23),(607,NULL,40,23),(608,NULL,41,23),(609,NULL,47,23),(610,NULL,53,23),(611,NULL,54,23),(612,NULL,55,23);

/*Table structure for table `sources` */

DROP TABLE IF EXISTS `sources`;

CREATE TABLE `sources` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(128) DEFAULT NULL COMMENT '资源路径',
  `remark` varchar(32) DEFAULT NULL COMMENT '资源备注',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Data for the table `sources` */

insert  into `sources`(`id`,`name`,`url`,`remark`,`pid`,`icon`) values (1,'oa办公协同系统',NULL,'系统名称',0,NULL),(2,'项目管理',NULL,'项目管理',1,NULL),(3,'日常办公',NULL,'日常办公',1,NULL),(4,'消息管理',NULL,'信息箱',1,NULL),(9,'基本信息管理','/project/project-base','项目基本信息',2,NULL),(10,'需求分析管理','/project/project-need','项目需求分析',2,NULL),(11,'模块管理','/project/project-model','模块管理',2,NULL),(12,'功能管理','/project/project-function','功能管理',2,NULL),(13,'附件管理','/attachment/queryAttachments','附件管理',2,NULL),(14,'创建任务','/office/task-add','创建任务',3,NULL),(15,'任务信息','/office/task/getTaskByEmployee','任务信息',3,NULL),(16,'我的任务','/office/task/getMyTaskByEmployee','我的任务',3,NULL),(17,'通知公告','/office/notice/notice','通知公告',3,NULL),(18,'档案管理','/office/archives/archives','档案管理',3,NULL),(19,'我的档案','/office/archives/myarchives','我的档案',3,NULL),(20,'报销审批','/baoxiao/getBaoxiaoByStatus/1','报销审批',3,NULL),(21,'我的报销','/baoxiao/queryBaoxiao','我的报销',3,NULL),(27,'我的邮箱','/message/email/email','仅仅使用javamail发送邮件就ok啦',4,NULL),(28,'客户信息管理',NULL,'管理客户信息',1,NULL),(29,'客户信息','/cus/customer','客户信息的统计',28,NULL),(32,'消息推送','/message/message-give','消息推送',4,NULL),(33,'论坛','/forumpost/show','论坛',4,NULL),(34,'系统管理',NULL,'系统管理',1,NULL),(35,'对标管理',NULL,'对标管理',1,NULL),(39,'员工管理','/emp/user','人员管理',34,NULL),(40,'菜单资源管理','/resource/resource','权限维护',34,NULL),(41,'角色管理','/role/role','角色管理',34,NULL),(43,'设定指标','/duibiao/showIndexvalue','设定指标',35,NULL),(44,'目标营业额分析','/duibiao/forward/duibiao-result','目标营业额分析',35,NULL),(47,'我的信息',NULL,NULL,1,NULL),(51,'对标信息管理','/duibiao/showDatacollect',NULL,35,NULL),(53,'信息查看','/office/archives/myarchives',NULL,47,NULL),(54,'修改密码','/emp/modpassword',NULL,47,NULL),(55,'aaa','/aaaa/cccc','很好',1,NULL);

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `starttime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `define` varchar(256) DEFAULT NULL,
  `fun_fk` int(11) DEFAULT NULL,
  `emp_fk2` int(11) DEFAULT NULL,
  `emp_fk` int(11) NOT NULL,
  `tasktitle` varchar(256) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '值为:0,1,2',
  PRIMARY KEY (`id`),
  KEY `emp_fk2` (`emp_fk2`),
  KEY `FK8pqhf0pdn5r478vp69g6sip3` (`fun_fk`),
  KEY `FKcpxt4jxiaoqj5nwny5ai74drj` (`emp_fk`),
  CONSTRAINT `FK8pqhf0pdn5r478vp69g6sip3` FOREIGN KEY (`fun_fk`) REFERENCES `function` (`id`),
  CONSTRAINT `FKcpxt4jxiaoqj5nwny5ai74drj` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`fun_fk`) REFERENCES `function` (`id`),
  CONSTRAINT `task_ibfk_3` FOREIGN KEY (`emp_fk2`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `task` */

insert  into `task`(`id`,`starttime`,`endtime`,`level`,`define`,`fun_fk`,`emp_fk2`,`emp_fk`,`tasktitle`,`remark`,`status`) values (9,'2020-03-17','2020-03-19','中',NULL,1,1,1,'员工考勤功能任务','员工考勤功能。。。。。',3),(10,'2020-03-17','2020-03-18','低',NULL,2,1,1,'请假功能','请假',1),(11,'2020-03-20','2020-03-23','高',NULL,6,3,1,'商品模块功能','无',3),(14,'2020-07-28','2020-08-06','中',NULL,4,4,1,'很好','很好',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
