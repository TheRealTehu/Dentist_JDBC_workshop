drop table if exists teeth cascade;
create table teeth(
id int PRIMARY KEY auto_increment,
patient_id int,
tooth_type VARCHAR(10) check (tooth_type in ('INCISOR', 'CANINE', 'MOLAR')),
is_filled boolean
);

create table patients(
id int PRIMARY KEY auto_increment,
name VARCHAR,
age int,
gender VARCHAR(6) check (gender in ('MALE', 'FEMALE')
);

ALTER TABLE teeth
    ADD FOREIGN KEY (patient_id)
    REFERENCES patients(id)
    ON DELETE CASCADE;