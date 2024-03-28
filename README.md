# Тесты для Jira Education

Автотесты для [Jira Education](https://edujira.ifellow.ru)

## Использование

```bash
# Скопировать репозиторий
$ git clone https://github.com/Shnurova/SHNUROVA_IFellow.git && cd SHNUROVA_IFellow
# Переключить ветку
$ gut checkout FHW_UI
# Запуск тестов
$ mvn clean test
# Сгенерировать отчёт
$ mvn allure:report
# запуск сервера с результатом
$ mvn allure:serve
```

## Используемые библиотеки

- [Junit5](https://junit.org/junit5/)
- [Selenide](https://ru.selenide.org/)
- [Allure](https://allurereport.org/)
