INSERT INTO users VALUES (1, 'mkyong', 'mkyong@gmail.com');
INSERT INTO users VALUES (2, 'alex', 'alex@yahoo.com');
INSERT INTO users VALUES (3, 'joel', 'joel@gmail.com');

INSERT INTO INSTALLER_COMPANY VALUES(1, 'sapRootId1', 'admin1', 'LA', '12145125421', 'CA', 'CA', 'USA', 'ax2o6');
INSERT INTO INSTALLER_COMPANY VALUES(2, 'sapRootId2', 'admin2', 'LA', '12145125421', 'CA', 'CA', 'USA', 'ax2o6');
INSERT INTO INSTALLER_COMPANY VALUES(3, 'sapRootId3', 'admin3', 'LA', '12145125421', 'CA', 'CA', 'USA', 'ax2o6');

INSERT INTO NODE VALUES(1, 1, 'node1', null, 'LA', 'CA', 'USA', 'a3b4r', '+91-9492422536', 'note1');

INSERT INTO NODE VALUES(2, 1, 'node2', 1, 'LA', 'CA', 'USA', 'a3b4r', '+91-9492422536', 'note1');
INSERT INTO NODE VALUES(3, 1, 'node3', 1, 'LA', 'CA', 'USA', 'a3b4r', '+91-9492422536', 'note1');
INSERT INTO NODE VALUES(4, 1, 'node4', 1, 'LA', 'CA', 'USA', 'a3b4r', '+91-9492422536', 'note1');

INSERT INTO DEVICE_INFO VALUES(1, 'MR', 1, 1, 'ACTIVE', '1.0', '25', 'hana', null);

INSERT INTO DEVICE_ADDL_ATTR VALUES(1, 'attr1', 'attr1');
INSERT INTO DEVICE_ADDL_ATTR VALUES(1, 'attr2', 'attr2');

INSERT INTO DEVICE_SERVICES VALUES(1, 'stnNO1', parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'ACTIVE', 'Servc1');
INSERT INTO DEVICE_SERVICES VALUES(1, 'stnNO2', parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'ACTIVE', 'Servc2');