
-- Table: public."Employee"

DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee
(
  emp_id integer,
  emp_fname character varying,
  emp_mname character varying,
  emp_lname character varying,
  designation character varying,
  dob date,
  doj date,
  emp_type character varying
);

ALTER TABLE public."Employee"
  OWNER TO postgres;

