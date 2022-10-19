insert into patients(name, age, gender) values ('First Patient', 30, 'MALE');
insert into patients(name, age, gender) values ('Female Patient', 21, 'FEMALE');
insert into patients(name, age, gender) values ('Toothles Patient', 66, 'MALE');

insert into teeth(patient_id, tooth_type, is_filled) values (1, 'INCISOR', false);
insert into teeth(patient_id, tooth_type, is_filled) values (1, 'CANINE', false);
insert into teeth(patient_id, tooth_type, is_filled) values (1, 'MOLAR', true);

insert into teeth(patient_id, tooth_type, is_filled) values (2, 'CANINE', true);
insert into teeth(patient_id, tooth_type, is_filled) values (2, 'MOLAR', true);