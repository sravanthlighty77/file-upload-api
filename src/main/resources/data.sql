DROP TABLE files_service;
DROP SEQUENCE files_id_sequence;

-------------------------------------

CREATE TABLE files_service(
	id INT PRIMARY KEY,
	file_name VARCHAR2(50),
	file_path VARCHAR2(100)
);
-------------------------------------
CREATE SEQUENCE files_id_sequence
MINVALUE 1111
START WITH 1111
INCREMENT BY 1;

-------------------------------------

SELECT * FROM FILES_SERVICE;
