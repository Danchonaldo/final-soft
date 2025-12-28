# Clinic Appointment System (Spring Boot)

Учебный проект: **система записи к врачу**.

## Роли
- `ROLE_ADMIN` — управление пользователями/профилями, просмотр всех данных
- `ROLE_DOCTOR` — просмотр расписания по врачу, создание медицинских записей
- `ROLE_PATIENT` — создание записей на приём, просмотр своих записей/истории

## Сущности (6)
- `User` — аккаунт (email, password, fullName)
- `Permission` — роли/права (ROLE_ADMIN / ROLE_DOCTOR / ROLE_PATIENT)
- `Doctor` — профиль врача (User + specialization, cabinet, phone)
- `Patient` — профиль пациента (User + iin, birthDate, phone)
- `Appointment` — запись на приём (Doctor + Patient + datetime/status/reason)
- `MedicalRecord` — мед. запись по конкретному приёму (Appointment + diagnosis/treatment/notes)

## DB + migrations
- PostgreSQL (docker-compose)
- Liquibase: `src/main/resources/db/changelog/db.changelog-master.xml`

### Поднять БД
```bash
docker-compose up -d
```

## Запуск
```bash
./gradlew bootRun
```

## Тестовые аккаунты (пароль везде `1234`)
- admin@clinic.kz (ADMIN)
- doctor@clinic.kz (DOCTOR)
- patient@clinic.kz (PATIENT)

## REST API (основные)
### Users
- `POST /api/users/register` — регистрация (по умолчанию назначается ROLE_PATIENT)
- `GET /api/users` — список (ADMIN)
- `PUT /api/users/{id}/profile?fullName=...` — редактирование профиля
- `PUT /api/users/{id}/change-password?oldPass=...&newPass=...`
- `DELETE /api/users/{id}` — удалить (ADMIN)

### Doctors
- `POST /api/doctors` — создать (ADMIN)
- `GET /api/doctors` — список (auth)
- `GET /api/doctors/{id}` — детали (auth)
- `DELETE /api/doctors/{id}` — удалить (ADMIN)

### Patients
- `POST /api/patients` — создать (ADMIN)
- `GET /api/patients` — список (ADMIN)
- `GET /api/patients/{id}` — детали (auth)
- `DELETE /api/patients/{id}` — удалить (ADMIN)

### Appointments
- `POST /api/appointments` — создать (PATIENT/ADMIN)
- `GET /api/appointments` — все (ADMIN)
- `GET /api/appointments/{id}` — детали (auth)
- `GET /api/appointments/doctor/{doctorId}` — по врачу (DOCTOR/ADMIN)
- `GET /api/appointments/patient/{patientId}` — по пациенту (PATIENT/ADMIN)
- `DELETE /api/appointments/{id}` — удалить (ADMIN)

### Medical Records
- `POST /api/records` — создать (DOCTOR/ADMIN)
- `GET /api/records` — все (ADMIN)
- `GET /api/records/{id}` — детали (auth)
- `GET /api/records/doctor/{doctorId}` — по врачу (DOCTOR/ADMIN)
- `GET /api/records/patient/{patientId}` — по пациенту (PATIENT/ADMIN)
- `DELETE /api/records/{id}` — удалить (ADMIN)

## Notes
Проект создан по структуре: **Entity → DTO → Mapper(MapStruct) → Repository → Service → Controller**.
