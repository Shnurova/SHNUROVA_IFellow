# Rest API

Автотесты для [Reqres](https://reqres.in)
и [RickAndMorty](https://rickandmortyapi.com/api/)

## Использование

```bash
# Скопировать репозиторий
$ git clone https://github.com/Shnurova/SHNUROVA_IFellow.git && cd SHNUROVA_IFellow
# Переключить ветку
$ gut checkout FHW_API
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
- [Cucumber](https://cucumber.io/)
- [Allure](https://allurereport.org/)
