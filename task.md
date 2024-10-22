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

### Задание 8. Adapter
В классе [`HockeyPlayerAdapter`](src/main/java/examples/patterns/structure/adapter/HockeyPlayerAdapter.java) реализован паттерн adapter

Это можно определить по следующим признакам:
1. Класс (адаптер) имплементирует интерфейс [`TeamCaptain`](src/main/java/examples/patterns/structure/adapter/TeamCaptain.java), позволяющий отдавать команды.
2. Класс (адаптер) включает в себя класс [`HockeyPlayer`](src/main/java/examples/patterns/structure/adapter/HockeyPlayer.java), который, в свою очередь, не имплементирует интерфейс [`TeamCaptain`](src/main/java/examples/patterns/structure/adapter/TeamCaptain.java), но имеет метод `saySomething`, позволяющий что-то сказать своей команде.
3. Класс (адаптер) переопределяет метод интерфейса [`TeamCaptain`](src/main/java/examples/patterns/structure/adapter/TeamCaptain.java), вызывая в нем методы класса [`HockeyPlayer`](src/main/java/examples/patterns/structure/adapter/HockeyPlayer.java).
   
В этом класс реализован паттерн adapter, для того, чтобы можно было вызывать методы игрока в методах, где требуется капитан.
Это позволяет удобно наделять игрока из команды возможностями капитана.

### Задание 9. Bridge
В классе [`Judge`](src/main/java/examples/patterns/structure/bridge/Judge.java) реализован паттерн bridge

Это можно определить по следующим признакам:
1. Абстрактный класс (абстракция) [`Judge`](src/main/java/examples/patterns/structure/bridge/Judge.java), включает в себя [`JudgeLevel`](src/main/java/examples/patterns/structure/bridge/JudgeLevel.java) (реализация).
2. Класс [`Judge`](src/main/java/examples/patterns/structure/bridge/Judge.java) и интерфейс [`JudgeLevel`](src/main/java/examples/patterns/structure/bridge/JudgeLevel.java) имеют независимые иерархии наследования.
3. Класс [`Judge`](src/main/java/examples/patterns/structure/bridge/Judge.java) имеет несколько реализаций [`ChiefJudge`](src/main/java/examples/patterns/structure/bridge/ChiefJudge.java) и [`VideoJudge`](src/main/java/examples/patterns/structure/bridge/VideoJudge.java), а интерфейс [`JudgeLevel`](src/main/java/examples/patterns/structure/bridge/JudgeLevel.java) имеет реализации [`CityJudge`](src/main/java/examples/patterns/structure/bridge/CityJudge.java) и [`RegionJudge`](src/main/java/examples/patterns/structure/bridge/RegionJudge.java). Эти реализации можно комбинировать в зависимости от уровня матча, не создавая при этом множество классов по типу `ChiefCityJudge`.

В этом классе реализован паттерн bridge, для того, чтобы не создавать множество классов, например при увеличении количества
уровней матчей или видов судей. Также паттерн bridge позволяет независимо работать над двумя иерархиями абстракции и
реализации.

### Задание 10. Composite
В классе [`HockeyTeam`](src/main/java/examples/patterns/structure/composite/HockeyTeam.java) реализован паттерн composite

Это можно определить по следующим признакам:
1. Интерфейс [`HockeyStructureElement`](src/main/java/examples/patterns/structure/composite/HockeyStructureElement.java), который описывает базовую операцию `registerOnGame` и операции с компонентом `addHockeyStructureElement` и `hockeyStructureElements`.
2. Классы [`HockeyTeam`](src/main/java/examples/patterns/structure/composite/HockeyTeam.java) и [`HockeyPlayer`](src/main/java/examples/patterns/structure/composite/HockeyPlayer.java), которые представляют собой узел и лист соответственно. Они оба реализуют интерфейс [`HockeyStructureElement`](src/main/java/examples/patterns/structure/composite/HockeyStructureElement.java), но [`HockeyPlayer`](src/main/java/examples/patterns/structure/composite/HockeyPlayer.java) реализует базовую операцию, а [`HockeyTeam`](src/main/java/examples/patterns/structure/composite/HockeyTeam.java) реализует операции с компонентом
3. Класс [`HockeyTeam`](src/main/java/examples/patterns/structure/composite/HockeyTeam.java) содержит поле `private final List<HockeyStructureElement> children` для хранения дочерних элементов.

В этом классе реализован паттерн composite, для того, чтобы представить древовидную структуру хоккейной команды. Паттерн
composite также позволяет клиентскому коду не задумываться о том, работает он с листом или с узлом, так как оба класса
реализуют один интерфейс [`HockeyStructureElement`](src/main/java/examples/patterns/structure/composite/HockeyStructureElement.java)

### Задание 11. Decorator
В классе [`Mood`](src/main/java/examples/patterns/structure/decorator/Mood.java) реализован паттерн decorator

Это можно определить по следующим признакам:
1. Интерфейс [`Judge`](src/main/java/examples/patterns/structure/decorator/Judge.java), который представляет собой компонент.
2. Абстрактный класс [`Mood`](src/main/java/examples/patterns/structure/decorator/Mood.java), который представляет собой декоратор, который содержит поле типа [`Judge`](src/main/java/examples/patterns/structure/decorator/Judge.java) и реализует метод интерфейса, вызывая в нем метод декарируемого объекта.
3. Класс [`MainJudge`](src/main/java/examples/patterns/structure/decorator/MainJudge.java), который представляет собой конкретный компонент.
4. Класс [`GoodMood`](src/main/java/examples/patterns/structure/decorator/GoodMood.java), который представляет собой конкретный декоратор (хорошее настроение), наследуется от [`Mood`](src/main/java/examples/patterns/structure/decorator/Mood.java). Декоратор вызывает метод базового класса, изменяя его поведение.
5. Класс [`BadMood`](src/main/java/examples/patterns/structure/decorator/BadMood.java), который представляет собой конкретный декоратор (плохое настроение), наследуется от [`Mood`](src/main/java/examples/patterns/structure/decorator/Mood.java) Декоратор вызывает метод базового класса, изменяя его поведение.

В этом классе реализован паттерн decorator, для того, чтобы изменять поведение судьи в зависимости от его настроения,
не изменяя сам класс судьи.
