# Dentist_JDBC_workshop
The Dentist JDBC workshop as far as we got on the workshop.
FELADAT:

Egy fogorvos ismerősünknek segítsünk a weboldalának backend részét elkészíteni. A program segítségével fogakat kell tudjunk tárolni adatbázisban, azokat visszakapni, módosítani. 

Készítsünk egy Tooth osztályt!
Legyen: ID-ja, Patient ID-ja, ToothType-ja, és egy változója, hogy volt-e tömve (isFilled)
Készítsünk schema.sql-t és data.sql-t az adatok tárolására. A data.sql tartalmazzon legalább 1 fogat minden fajtából.
Készítsünk egy ToothDao interface-t, mely tartalmazza a szükséges műveleteket
getAllTeeth
getToothById
getAllTeethForPatientById
addTooth
updateTooth
deleteTooth
Készítsünk egy ToothDaoJdbcImpl osztályt, mely megvalósítja a ToothDao interface-t JdbcTemplate segítségével
Készítsünk egy ToothMapper osztályt a RowMapper<Tooth> megvalósításához
Készítsünk egy ToothService osztályt, amely az összeköttetés lesz a Controller és a Dao között
Készítsünk egy ToothController osztályt, amely kezeli a bejövő kéréseket

Készítsünk a projecthez patient osztályt!
Legyen: ID-ja, Name-je, Age-e, Gender-e, és egy Listája a fogaival!
Módosítsuk a schema.sql-t és a data.sql-t, hogy most már patienteket is tároljon!
Készítsünk PatientDao osztályt! A következő műveleteket lehessen végrehajtani:
getAllPatients
getPatientById
addPatient
updatePatient
deletePatien
Készítsünk egy PatientDaoJdbcImpl osztályt, mely megvalósítja a PatientDao interface-t JdbcTemplate segítségével
Készítsünk PatientMapper osztályt a RowMapper<Patient> megvalósításához
Készítsünk egy PatientService osztályt, amely az összeköttetés lesz a Controller és a Dao között
Készítsünk egy PatientController osztályt, amely kezeli a bejövő kéréseket
