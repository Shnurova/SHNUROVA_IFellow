# language: ru

Функция: Логирование в Jira

  Структура сценария: Успешнае Авторизация
    Когда залогиниться под пользователем "<login>" с паролем "<password>"
    Тогда отображается профиль

    Примеры:
      | login | password  |
      | AT15  | Qwerty123 |