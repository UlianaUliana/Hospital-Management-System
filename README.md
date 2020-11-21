# Hospital-Management-System
You need Lombok plugin installed
## Build the project:
mvn clean install
## Run the program:
java -jar target/hospital-management-system-1.0-SNAPSHOT.jar server hospital-management-system.yml
## Call in browser
GetAllDoctors:
http://localhost:8080/application/doctors
getDoctorById:
http://localhost:8080/application/doctors/c70f812b-8525-450d-8dc7-98e4892c89c6
getAllDoctorsBySpecialty:
http://localhost:8080/application/doctors/specialty?specialty=Endocrinologist
deleteDoctor:
http://localhost:8080/application/doctors/delete/c70f812b-8525-450d-8dc7-98e4892c89c6
-
getAllPatients:
http://localhost:8080/application/patients
getPatientById:
http://localhost:8080/application/patients/f4221dfe-885b-42c7-af2e-c04db44fd048
deletePatient:
http://localhost:8080/application/patients/delete/f4221dfe-885b-42c7-af2e-c04db44fd048

"/my/path?param1=value1&param2=value2"