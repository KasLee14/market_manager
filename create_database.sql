create database chain_supermarket;
use chain_supermarket;

drop table if exists supermarket;
create table supermarket(
	supermarket_id varchar(20),
	supermarket_name varchar(255),
    address varchar(255),
    contact_number varchar(20),
    primary key (supermarket_id)
);

drop table if exists dept;
create table dept(
	dept_id varchar(20),
	dept_name varchar(255),
    address varchar(255),
    contact_number varchar(20),
    supermarket_id varchar(20),
    primary key (dept_id),
    constraint fk_dept_s foreign key (supermarket_id) references supermarket(supermarket_id)
);

drop table if exists emp;
create table emp(
	emp_id varchar(20),
	emp_name varchar(255),
    post varchar(255),
    phone_number varchar(20),
    salary DECIMAL(10,2),
    dept_id varchar(20),
    primary key (emp_id),
    constraint fk_emp_dept foreign key (dept_id) references dept(dept_id)
);




