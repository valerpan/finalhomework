#language:ru
@api @helpdesk
Функционал: Тестирование API сервиса Helpdesk

  @positive @create-ticket
  Сценарий: Создание тикета с высоким приоритетом и проверка данных
    И сгенерировать переменные
      | title           | Не работает кнопка Отправить на форме регистрации |
      | queue           | 2                                                    |
      | description     | При нажатии на кнопку Отправить на странице регистрации ничего не происходит. |
      | priority        | 1                                                    |
      | submitter_email | ivan.petrov@company.ru                               |
      | status          | 1                                                    |

    И создать запрос
      | method | url                                               | body               |
      | POST   | https://at-sandbox.workbench.lanit.ru/api/tickets | ticket.json |
    И добавить header
      | Content-Type | application/json |
    И отправить запрос
    И статус код 201
    И извлечь данные
      | id | $.id |
    И сравнить значения
      | ${id} | != | null |

    И сгенерировать переменные
      | username | admin   |
      | password | adminat |

    И создать запрос
      | method | url                                             | body              |
      | POST   | https://at-sandbox.workbench.lanit.ru/api/login | authToken.json |
    И добавить header
      | Content-Type | application/json |
    И отправить запрос
    И статус код 200
    И извлечь данные
      | token | $.token |
    И сравнить значения
      | ${token} | != | null |

    И создать запрос
      | method | url                                               |
      | GET    | https://at-sandbox.workbench.lanit.ru/api/tickets/${id} |
    И добавить header
      | accept        | application/json |
      | Authorization | token ${token}   |
    И отправить запрос
    И статус код 200
    И извлечь данные
      | resp_title           | $.title            |
      | resp_ticket_id       | $.id               |
      | resp_submitter_email | $.submitter_email  |
    И сравнить значения
      | ${id}              | == | ${resp_ticket_id}       |
      | ${title}           | == | ${resp_title}           |
      | ${submitter_email} | == | ${resp_submitter_email} |

  @negative @status-change
  Сценарий: Негативная проверка изменения статуса тикета с ЗАКРЫТ на ОТКРЫТ
    И сгенерировать переменные
      | title           | Не открывается личный кабинет после авторизации |
      | queue           | 2                                                 |
      | description     | Пользователь вводит логин и пароль, но вместо личного кабинета открывается главная страница. |
      | priority        | 1                                                 |
      | submitter_email | test.user@domain.com                              |
      | status          | 4                                                 |

    И создать запрос
      | method | url                                               | body               |
      | POST   | https://at-sandbox.workbench.lanit.ru/api/tickets | ticket.json |
    И добавить header
      | Content-Type | application/json |
    И отправить запрос
    И статус код 201
    И извлечь данные
      | id | $.id |
    И сравнить значения
      | ${id} | != | null |

    И сгенерировать переменные
      | username | admin   |
      | password | adminat |

    И создать запрос
      | method | url                                             | body              |
      | POST   | https://at-sandbox.workbench.lanit.ru/api/login | authToken.json |
    И добавить header
      | Content-Type | application/json |
    И отправить запрос
    И статус код 200
    И извлечь данные
      | token | $.token |
    И сравнить значения
      | ${token} | != | null |

    И сгенерировать переменные
      | status | 1 |

    И создать запрос
      | method | url                                                     | body                    |
      | PUT    | https://at-sandbox.workbench.lanit.ru/api/tickets/${id} | ticket.json |
    И добавить header
      | Content-Type  | application/json |
      | Authorization | token ${token}   |
    И отправить запрос
    И статус код 422
    И извлечь данные
      | id | $.id |
    И сравнить значения
      | ${id} | != | null |
    И сравнить значения
      | ${status} | != | 1 |