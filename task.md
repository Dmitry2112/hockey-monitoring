### Задание 2. Singleton
Класс [`HockeyPlayerService`](src/main/java/org/example/hockeymonitoring/hockeyplayer/services/HockeyPlayerService.java) реализован как singleton (На данный момент реализован максимально простой класс для демонстрации паттерна)

Это можно определить по следующим признакам:
1. Метод `getInstance` возвращает экземпляр класса `HockeyPlayerService`, который создан как `static final` поле.
2. Приватный конструктор, который исключает возможность создать экземпляр класса `HockeyPlayerService` извне.

Этот класс реализован как singleton, потому что является общим сервисом на все приложение по работе с хоккеистами.
Нет необходимости создавать и управлять несколькими экземплярами этого класса. К тому же в нем может быть реализован
InMemory кэш, который опять же должен быть единым на все приложение, иначе может произойти рассинхронизация данных.

### Задание 3. Prototype
Класс [`HockeyPlayer`](src/main/java/examples/patterns/creation/prototype/HockeyPlayer.java) реализован как prototype

Это можно определить по следующим признакам:
1. Метод `copy` создает экземпляр класса `HockeyPlayer`, который является его точной копией.

Этот класс реализован как prototype, для того, чтобы можно было быстро и с наименьшим количеством кода создавать
несколько копий игроков. Это можно использовать, например, для тестирования, чтобы быстро сгенерировать команду.

### Задание 4. Static factory method
В классе [`HockeyMatch`](src/main/java/org/example/hockeymonitoring/hockeyplayer/models/HockeyMatch.java) реализован static factory method

Это можно определить по следующим признакам:
1. Приватный конструктор.
2. Метод `basic`, который создает базовый экземпляр класса `HockeyMatch`.
3. Метод `specific`, который создает экземпляр класса `HockeyMatch` с особыми правилами.

В Этом классе реализован static factory method, для того, чтобы можно было создавать матч с различными параметрами
(например правилами) без ограничений, накладываемых конструктором.

### Задание 5. Builder
Класс [`HockeyTeamBuilder`](src/main/java/org/example/hockeymonitoring/hockeyteam/models/HockeyTeamBuilder.java) реализован как builder

Это можно определить по следующим признакам:
1. Закрытый конструктор, который вызывается в классе [`HockeyTeam`](src/main/java/org/example/hockeymonitoring/hockeyteam/models/HockeyTeam.java) в теле метода `builder`.
2. Дублирование всех полей класса [`HockeyTeam`](src/main/java/org/example/hockeymonitoring/hockeyteam/models/HockeyTeam.java).
3. Наличие методов по типу `public HockeyTeamBuilder name(String name) {...}` для каждого поля, которые накапливают данные в полях билдера и возвращают this.
4. Метод `build`, в теле которого вызывается конструктор класса [`HockeyTeam`](src/main/java/org/example/hockeymonitoring/hockeyteam/models/HockeyTeam.java), в который в качестве параметров передаются поля билдера, и возвращается только что созданный экземпляр класса [`HockeyTeam`](src/main/java/org/example/hockeymonitoring/hockeyteam/models/HockeyTeam.java).

Этот класс реализован как builder, для того, чтобы можно было быстро и удобно создавать объект команды, сохраняя читаемость
кода даже при большом количестве полей.

### Задание 6. Factory method
В классе [`Notificator`](src/main/java/org/example/hockeymonitoring/notification/Notificator.java) реализован паттерн factory method

Это можно определить по следующим признакам:
1. Интерфейс [`Notification`](src/main/java/org/example/hockeymonitoring/notification/Notification.java), который представляет продукт.
2. Абстрактный класс [`Notificator`](src/main/java/org/example/hockeymonitoring/notification/Notificator.java), который представляет создателя и содержит метод `sendNotification` (операция с продуктом), вызывающий внутри себя метод по созданию продукта `createNotification` (фабричный метод).
3. Классы [`HockeyPlayerNotification`](src/main/java/org/example/hockeymonitoring/notification/HockeyPlayerNotification.java) и [`TrainerNotification`](src/main/java/org/example/hockeymonitoring/notification/TrainerNotification.java), которые представляют конкретные продукты.
4. Классы [`HockeyPlayerNotificator`](src/main/java/org/example/hockeymonitoring/notification/HockeyPlayerNotificator.java) и [`TrainerNotificator`](src/main/java/org/example/hockeymonitoring/notification/TrainerNotificator.java), которые представляют конкретных создателей.

В этом классе реализован factory method, для того, чтобы можно было удобно применять одну и ту же операцию
(например отправка уведомления) к объектам разных классов, реализующих один интерфейс.

### Задание 7. Abstract factory
Интерфейс [`HockeyGameFactory`](src/main/java/examples/patterns/creation/abstractfactory/HockeyGameFactory.java) представляет собой abstract factory

Это можно определить по следующим признакам:
1. Методы `newRules` и `newPrize`, которые отвечают за создание абстрактных объектов.
2. Классы [`CityHockeyGameFactory`](src/main/java/examples/patterns/creation/abstractfactory/CityHockeyGameFactory.java) и [`RegionHockeyGameFactory`](src/main/java/examples/patterns/creation/abstractfactory/RegionHockeyGameFactory.java), которые являются реализациями абстрактной фабрики и уже создают конкретные объекты.
3. Наличие интерфейсов абстрактных продуктов по типу [`Rules`](src/main/java/examples/patterns/creation/abstractfactory/Rules.java) и их конкретных реализаций в виде [`CityRules`](src/main/java/examples/patterns/creation/abstractfactory/CityRules.java).

В этом примере паттерн абстрактная фабрика помогает создавать необходимые связанные объекты (правила и приз)
из одного семейства (городская или региональная игра).
