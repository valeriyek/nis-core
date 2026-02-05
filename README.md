
# NIS Core

Минимальный прототип информационного сервиса для подбора квартир под военную ипотеку (НИС).

Проект на **Java 21 + Spring Boot 3.3**, с разделением по сущностям:

- `Bank` — банки с максимальной суммой кредита (`maxLoanAmount`) и ставкой процента.
- `Developer` — застройщики с регионом, названием и идентификатором.
- `Apartment` — квартиры с площадью, этажом, ценой и связью с застройщиком.

---

## Архитектура

```
ru.nis
├─ bank
│   ├─ model/       # Bank.java
│   ├─ repository/  # BankRepository.java
│   ├─ service/     # BankService.java
│   └─ controller/  # BankController.java
├─ developer
│   ├─ model/       # Developer.java
│   ├─ repository/  # DeveloperRepository.java
│   ├─ service/     # DeveloperService.java
│   └─ controller/  # DeveloperController.java
├─ apartment
│   ├─ model/       # Apartment.java
│   ├─ repository/  # ApartmentRepository.java
│   ├─ service/     # ApartmentService.java
│   └─ controller/  # ApartmentController.java
└─ selection
    ├─ dto/         # SelectionRequest.java
    ├─ service/     # SelectionService.java (фасад)
    │               # ApartmentFilterService.java
    │               # BankFilterService.java
    └─ controller/  # SelectionController.java
```

---

## Установка и запуск

1. **Клонировать репозиторий:**
```bash
git clone https://github.com/valeriyek/nis-core.git
cd nis-core
```

2. **Собрать проект:**
```bash
./mvnw clean install
```

3. **Запустить Spring Boot приложение:**
```bash
./mvnw spring-boot:run
```

> Приложение запускается на `http://localhost:8080`.

---

## Использование Selection API

### Эндпоинт:

```
POST /api/selection
```

### Body (JSON):

```json
{
  "bankId": 1,
  "developerId": 2,
  "minArea": 40,
  "maxArea": 80,
  "maxPrice": 9000000
}
```

### Пример ответа:

```json
[
  {
    "id": 5,
    "area": 55,
    "floor": 7,
    "price": 8200000,
    "developer": {
      "id": 2,
      "name": "ПИК",
      "region": "Москва"
    }
  }
]
```

---

## Как добавлять данные

1. **Через Postman / REST API** для сущностей:
    - `POST /api/banks` — добавить банки
    - `POST /api/developers` — добавить застройщиков
    - `POST /api/apartments` — добавить квартиры (с привязкой к застройщику)

2. **Пример JSON для Apartment:**

```json
{
  "area": 55,
  "floor": 7,
  "price": 8200000,
  "developerId": 2
}
```

---

## Планы на следующие шаги

- Добавить сущность **Participant** для учета стажа службы и условий кредита
- Вынести фильтры в **JPA Specification** для гибкой фильтрации
- Подключить **агрегацию данных из внешних источников** (CSV, API, web scraping)
- Добавить **историю подбора квартир для участников**

---

## Технологии

- Java 21
- Spring Boot 3.3
- Spring Data JPA
- H2 / любая другая СУБД
- Maven
