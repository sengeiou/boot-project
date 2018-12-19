
-- DROP TABLE IF EXISTS `tbl_emp`;
CREATE TABLE `tbl_emp` (
  `emp_id` INTEGER (11) NOT NULL AUTO_INCREMENT,
  `emp_name` VARCHAR(40) NOT NULL,
  `gender` CHAR(40) NOT NULL,
  `email` varchar(20) NOT NULL,
  `d_id` INTEGER(40) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept` (
  `dept_id` INTEGER (11) NOT NULL AUTO_INCREMENT,
  `dept_name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
