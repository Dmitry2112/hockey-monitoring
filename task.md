### Задание 2. Singleton
Класс [`HockeyPlayerService`](src/main/java/org/example/hockeymonitoring/modules/athlete/services/HockeyPlayerService.java) реализован как singleton (На данный момент реализован максимально простой класс для демонстрации паттерна)

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
В классе [`HockeyMatch`](src/main/java/org/example/hockeymonitoring/modules/athlete/models/HockeyMatch.java) реализован static factory method

Это можно определить по следующим признакам:
1. Приватный конструктор.
2. Метод `basic`, который создает базовый экземпляр класса `HockeyMatch`.
3. Метод `specific`, который создает экземпляр класса `HockeyMatch` с особыми правилами.

В Этом классе реализован static factory method, для того, чтобы можно было создавать матч с различными параметрами
(например правилами) без ограничений, накладываемых конструктором.

### Задание 5. Builder
Класс [`HockeyTeamBuilder`](src/main/java/org/example/hockeymonitoring/modules/hockeyteam/models/HockeyTeamBuilder.java) реализован как builder

Это можно определить по следующим признакам:
1. Закрытый конструктор, который вызывается в классе [`HockeyTeam`](src/main/java/org/example/hockeymonitoring/modules/hockeyteam/models/HockeyTeam.java) в теле метода `builder`.
2. Дублирование всех полей класса [`HockeyTeam`](src/main/java/org/example/hockeymonitoring/modules/hockeyteam/models/HockeyTeam.java).
3. Наличие методов по типу `public HockeyTeamBuilder name(String name) {...}` для каждого поля, которые накапливают данные в полях билдера и возвращают this.
4. Метод `build`, в теле которого вызывается конструктор класса [`HockeyTeam`](src/main/java/org/example/hockeymonitoring/modules/hockeyteam/models/HockeyTeam.java), в который в качестве параметров передаются поля билдера, и возвращается только что созданный экземпляр класса [`HockeyTeam`](src/main/java/org/example/hockeymonitoring/modules/hockeyteam/models/HockeyTeam.java).

Этот класс реализован как builder, для того, чтобы можно было быстро и удобно создавать объект команды, сохраняя читаемость
кода даже при большом количестве полей.

### Задание 6. Factory method
В классе [`Notificator`](src/main/java/org/example/hockeymonitoring/modules/notification/Notificator.java) реализован паттерн factory method

Это можно определить по следующим признакам:
1. Интерфейс [`Notification`](src/main/java/org/example/hockeymonitoring/modules/notification/Notification.java), который представляет продукт.
2. Абстрактный класс [`Notificator`](src/main/java/org/example/hockeymonitoring/modules/notification/Notificator.java), который представляет создателя и содержит метод `sendNotification` (операция с продуктом), вызывающий внутри себя метод по созданию продукта `createNotification` (фабричный метод).
3. Классы [`HockeyPlayerNotification`](src/main/java/org/example/hockeymonitoring/modules/notification/HockeyPlayerNotification.java) и [`TrainerNotification`](src/main/java/org/example/hockeymonitoring/modules/notification/TrainerNotification.java), которые представляют конкретные продукты.
4. Классы [`HockeyPlayerNotificator`](src/main/java/org/example/hockeymonitoring/modules/notification/HockeyPlayerNotificator.java) и [`TrainerNotificator`](src/main/java/org/example/hockeymonitoring/modules/notification/TrainerNotificator.java), которые представляют конкретных создателей.

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

### Задание 12. Facade
В классе [`RegisterService`](src/main/java/examples/patterns/structure/facade/RegisterService.java) реализован паттерн facade

Это можно определить по следующим признакам:
1. Классы [`NotificationService`](src/main/java/examples/patterns/structure/facade/NotificationService.java), [`HockeyTeamService`](src/main/java/examples/patterns/structure/facade/HockeyTeamService.java), [`StatusService`](src/main/java/examples/patterns/structure/facade/StatusService.java) выполняют полезные операции, которые необходимы для регистрации игрока на игру.
2. Класс [`RegisterService`](src/main/java/examples/patterns/structure/facade/RegisterService.java), который содержит внутри себя классы, выполняющие полезные операции по регистрации игрока на игру. Также в этом классе реализован метод `registerOnGame`, в котором описана вся логика по регистрации на игру.
   
В этом классе реализован паттерн facade, для того, чтобы упростить процесс регистрации игрока на игру для клиентского кода.
Благодаря паттерну facade можно сложную логику регистрации и правильный порядок вызова методов полезных классов реализовать
в удобных для использования методах класса-фасада

### Задание 13. Flyweight
В классе [`Shape`](src/main/java/examples/patterns/structure/flyweight/Shape.java) реализован паттерн flyweight

Это можно определить по следующим признакам:
1. Класс [`Shape`](src/main/java/examples/patterns/structure/flyweight/Shape.java) (приспособленец) содержит в себе поле `Type`, что представляет собой разделяемую часть данных о фигуре.
2. Класс [`ShapeOptions`](src/main/java/examples/patterns/structure/flyweight/ShapeOptions.java), представляет неразделяемые данные, которые будут уникальны для каждой из фигур.
3. Класс [`Palette`](src/main/java/examples/patterns/structure/flyweight/Palette.java) (фабрика приспособленцев) отвечает за создание, хранение и предоставление приспособленцев.
   
В этом классе реализован паттерн flyweight, для того, чтобы снизить потребление памяти при создании большого количества
одинаковых объектов, разделяя общие данные, например, тип фигуры.

### Задание 14. Proxy
В классе [`TournamentResultsTableProxy`](src/main/java/examples/patterns/structure/proxy/TournamentResultsTableProxy.java) реализован паттерн proxy

Это можно определить по следующим признакам:
1. Главный класс [`TournamentResultsTable`](src/main/java/examples/patterns/structure/proxy/TournamentResultsTable.java) выполняет долгую и сложную работу в методе `getResults` - читает данные из потенциально большого файла. В клиентском коде этот метод вызывается каждый раз при печати результатов.
2. Класс proxy [`TournamentResultsTableProxy`](src/main/java/examples/patterns/structure/proxy/TournamentResultsTableProxy.java), реализует тот же интерфейс [`TournamentResults`](src/main/java/examples/patterns/structure/proxy/TournamentResults.java), что и главный класс.
3. Класс proxy [`TournamentResultsTableProxy`](src/main/java/examples/patterns/structure/proxy/TournamentResultsTableProxy.java) включает в себя главный класс [`TournamentResultsTable`](src/main/java/examples/patterns/structure/proxy/TournamentResultsTable.java).
4. Класс proxy [`TournamentResultsTableProxy`](src/main/java/examples/patterns/structure/proxy/TournamentResultsTableProxy.java) при первом вызове метода `getResults` вызывает метод главного класса и сохраняет результат в `resultsCache`, чтобы при последующих вызовах возвращать результат из него.

В этом классе реализован паттерн proxy, для того, чтобы оптимизировать процесс получения результатов для печати, не
меняя при этом клиентский код.

### Задание 15. Chain of responsibility
В классе [`HandlerBase`](src/main/java/examples/patterns/behavior/chainofresponsibility/HandlerBase.java) реализован паттерн chain of responsibility

Это можно определить по следующим признакам:
1. Базовый класс [`HandlerBase`](src/main/java/examples/patterns/behavior/chainofresponsibility/HandlerBase.java), который реализует интерфейс [`Handler`](src/main/java/examples/patterns/behavior/chainofresponsibility/Handler.java), в котором описаны методы по обработке и передачи контекста следующему обработчику.
2. Класс [`ChangeRatingHandler`](src/main/java/examples/patterns/behavior/chainofresponsibility/ChangeRatingHandler.java) (конкретный обработчик), который наследуется от [`HandlerBase`](src/main/java/examples/patterns/behavior/chainofresponsibility/HandlerBase.java).
3. Класс [`ChangeTeamNameHandler`](src/main/java/examples/patterns/behavior/chainofresponsibility/ChangeTeamNameHandler.java) (конкретный обработчик), который наследуется от [`HandlerBase`](src/main/java/examples/patterns/behavior/chainofresponsibility/HandlerBase.java).
4. Класс [`ChangeCategoryHandler`](src/main/java/examples/patterns/behavior/chainofresponsibility/ChangeCategoryHandler.java) (конкретный обработчик), который наследуется от [`HandlerBase`](src/main/java/examples/patterns/behavior/chainofresponsibility/HandlerBase.java).
5. Класс [`Athlete`](src/main/java/examples/patterns/behavior/chainofresponsibility/Athlete.java), который представляет собой контекст.
   
В этом классе реализован паттерн chain of responsibility, для того, чтобы можно было по цепочке независимо изменять объект.
Данный паттерн позволяет в дальнейшем без проблем добавлять новые обработчики.

### Задание 16. Command
В классе [`NotificationCommand`](src/main/java/examples/patterns/behavior/command/NotificationCommand.java) реализован паттерн command

Это можно определить по следующим признакам:
1. Абстрактный класс [`NotificationCommand`](src/main/java/examples/patterns/behavior/command/NotificationCommand.java), который представляет собой команду, включает в себя сервис, методы, которого будут выполняться конкретными командами и один абстрактный метод `execute`.
2. Класс [`NotificationService`](src/main/java/examples/patterns/behavior/command/NotificationService.java) (receiver), представляет собой сервис, который выполняет полезную работу.
3. Класс [`EmailNotificationCommand`](src/main/java/examples/patterns/behavior/command/EmailNotificationCommand.java) (конкретная команда), который наследуется от [`NotificationCommand`](src/main/java/examples/patterns/behavior/command/NotificationCommand.java) и вызывает метод сервиса `sendEmailNotification`.
4. Класс [`SmsNotificationCommand`](src/main/java/examples/patterns/behavior/command/SmsNotificationCommand.java) (конкретная команда), который наследуется от [`NotificationCommand`](src/main/java/examples/patterns/behavior/command/NotificationCommand.java) и вызывает метод сервиса `sendSmsNotification`.
5. Класс [`NotificationCommandSource`](src/main/java/examples/patterns/behavior/command/NotificationCommandSource.java) (invoker), с помощью которого вызываются команды.

В этом классе реализован паттерн command, для того, чтобы сделать классы receiver и invoker независимыми. Также этот
паттерн позволяет удобно сохранять историю команд в виде списка объектов.

### Задание 17. Interpreter
Интерфейс [`Expression`](src/main/java/examples/patterns/behavior/interpreter/Expression.java) представляет паттерн interpreter

Это можно определить по следующим признакам:
1. Интерфейс [`Expression`](src/main/java/examples/patterns/behavior/interpreter/Expression.java), который представляет собой абстрактное выражение с одним методом `interpret`.
2. Класс [`TerminalExpression`](src/main/java/examples/patterns/behavior/interpreter/TerminalExpression.java) представляет собой терминальное выражение.
3. Класс [`AndExpression`](src/main/java/examples/patterns/behavior/interpreter/AndExpression.java) представляет собой нетерминальное выражение.
4. Класс [`OrExpression`](src/main/java/examples/patterns/behavior/interpreter/OrExpression.java) представляет собой нетерминальное выражение.

В этом примере реализован паттерн interpreter, для того, чтобы определять тип или конкретную роль судьи. Также паттерн
interpreter позволяет легко добавлять новые правила и расширять систему

### Задание 18. Iterator
В классе [`AwardsIterator`](src/main/java/examples/patterns/behavior/iterator/HockeyPlayer.java) реализован паттерн iterator

Это можно определить по следующим признакам:
1. Интерфейс [`Iterable`](src/main/java/examples/patterns/behavior/iterator/Iterable.java), который представляет собой агрегат с одним методом `getIterator`.
2. Класс [`HockeyPlayer`](src/main/java/examples/patterns/behavior/iterator/HockeyPlayer.java) (конкретный агрегат) представляет игрока, у которого есть поле `awards` - список его наград.
3. Интерфейс [`Iterator`](src/main/java/examples/patterns/behavior/iterator/Iterator.java), который представляет собой интерфейс итератора с методами `hasNext` и `next`.
4. Класс [`AwardsIterator`](src/main/java/examples/patterns/behavior/iterator/HockeyPlayer.java) (конкретный итератор) представляет собой итератор по наградам игрока.

В этом примере реализован паттерн iterator, для того, чтобы удобно перебирать награды игрока, не раскрывая внутреннего
устройства этого объекта, который потенциально может быть довольно сложным.

### Задание 19. Mediator
В классе [`SuperTeam`](src/main/java/examples/patterns/behavior/mediator/SuperTeam.java) реализован паттерн mediator

Это можно определить по следующим признакам:
1. Интерфейс [`Team`](src/main/java/examples/patterns/behavior/mediator/Team.java), который представляет интерфейс медиатора с одним методом `sendMessage`.
2. Класс [`SuperTeam`](src/main/java/examples/patterns/behavior/mediator/SuperTeam.java) (конкретный медиатор) представляет команду, которая включает в себя капитана команды и игроков, и отвечает за их взаимодействие.
3. Интерфейс [`TeamMember`](src/main/java/examples/patterns/behavior/mediator/TeamMember.java) (абстрактный коллега), который представляет собой интерфейс члена команды.
4. Классы [`TeamCaptain`](src/main/java/examples/patterns/behavior/mediator/TeamCaptain.java) и [`HockeyPlayer`](src/main/java/examples/patterns/behavior/mediator/HockeyPlayer.java) (конкретные коллеги) представляют собой капитана команды и игрока, между которыми происходит взаимодействие.

В этом примере реализован паттерн mediator, для того, чтобы обеспечить взаимодействие множества объектов
(капитана, игроков, возможно тренера и тд.) без необходимости ссылаться друг на друга. Это позволяет устранить
сильную связность между ними.

### Задание 20. Memento
В классе [`Commit`](src/main/java/examples/patterns/behavior/memento/Project.java) реализован паттерн memento

Это можно определить по следующим признакам:
1. Класс [`Project`](src/main/java/examples/patterns/behavior/memento/Project.java) является хозяином и имеет методы создания хранителя и восстановления состояния по хранителю.
2. Класс [`Commit`](src/main/java/examples/patterns/behavior/memento/Project.java) является хранителем и сохраняет состояние проекта.
3. Класс [`Repo`](src/main/java/examples/patterns/behavior/memento/Repo.java) является посыльным и хранит словарь с коммитами. Имеет методы сохранения и восстановления проекта по хэшу коммита.
   
В этом примере реализован паттерн memento, для того, чтобы вынести внутреннее состояние проекта за его
пределы для последующего возможного восстановления без нарушения принципа инкапсуляции.

### Задание 21. Observer
Интерфейс [`Observer`](src/main/java/examples/patterns/behavior/observer/Observer.java) представляет паттерн observer

Это можно определить по следующим признакам:
1. Интерфейс [`Observer`](src/main/java/examples/patterns/behavior/observer/Observer.java) представляет абстрактного наблюдателя.
2. Классы [`BlueFan`](src/main/java/examples/patterns/behavior/observer/BlueFan.java) и [`RedFan`](src/main/java/examples/patterns/behavior/observer/RedFan.java) представляют собой конкретных наблюдателей.
3. Класс [`Score`](src/main/java/examples/patterns/behavior/observer/Score.java) представляет собой субъект, который при изменении оповещает наблюдателей.
   
В этом примере реализован паттерн observer, для того, чтобы определить связь между счетом матча и болельщиками команд.
Паттерн observer позволяет при измении счета оповестить об этом всех болельщиков, чтобы те, в свою очередь, каким-либо
образом отреагировали на это.

### Задание 22. State
Интерфейс [`Mood`](src/main/java/examples/patterns/behavior/state/Mood.java) представляет паттерн state

Это можно определить по следующим признакам:
1. Интерфейс [`Mood`](src/main/java/examples/patterns/behavior/state/Mood.java) представляет абстрактное состояние.
2. Подклассы перечислимого типа [`TrainerMood`](src/main/java/examples/patterns/behavior/state/TrainerMood.java) представляют собой конкретные состояния.
3. Класс [`Trainer`](src/main/java/examples/patterns/behavior/state/Trainer.java) представляет собой контекст, который содержит состояние и может его менять.
   
В этом примере реализован паттерн state, для того, чтобы тренер мог менять свое поведение в зависимости
от внутреннего состояния. Также паттерн state позволяет изменять это состояние динамически во время выполнения

### Задание 23. Strategy
Enum [`TeamRole`](src/main/java/examples/patterns/behavior/strategy/TeamRole.java) представляет паттерн strategy

Это можно определить по следующим признакам:
1. Подклассы перечислимого типа [`TeamRole`](src/main/java/examples/patterns/behavior/strategy/TeamRole.java) представляют конкретные стратегии.
2. Класс [`HockeyPlayer`](src/main/java/examples/patterns/behavior/strategy/HockeyPlayer.java) представляет собой контекст, который содержит стратегию и ведет себя в соответствии с ней.

В этом примере реализован паттерн strategy, для того, чтобы определить различные виды поведения игрока отдельно от
класса игрока. Паттерн Strategy позволяет изменять эти поведения независимо от клиентского класса

### Задание 24. Template method
В классе [`TournamentRegistrar`](src/main/java/examples/patterns/behavior/templatemethod/TournamentRegistrar.java) реализован паттерн template method
Это можно определить по следующим признакам:

1. Абстрактный класс [`TournamentRegistrar`](src/main/java/examples/patterns/behavior/templatemethod/TournamentRegistrar.java) содержит шаблонный final метод `register`, внутри которого вызываются методы, которые переопределяют дочерние классы для изменения поведения.
2. Классы [`MaleTournamentRegistrar`](src/main/java/examples/patterns/behavior/templatemethod/MaleTournamentRegistrar.java) и [`FemaleTournamentRegistrar`](src/main/java/examples/patterns/behavior/templatemethod/FemaleTournamentRegistrar.java) переопределяют методы `getSuperDocuments` и `addPlayerInTeam`.
   
В этом примере реализован паттерн template method, для того, чтобы изменить поведение регистрации на турнир для мужчин
и женщин, при этом не меняя саму структуру этого процесса. Также паттерн template method позволяет устранить дублирование
кода засчет переопределения методов классами наследниками

### Задание 25. Visitor
Интерфейс [`SportCommission`](src/main/java/examples/patterns/behavior/visitor/SportCommission.java) представляет паттерн visitor

Это можно определить по следующим признакам:
1. Интерфейс [`SportCommission`](src/main/java/examples/patterns/behavior/visitor/SportCommission.java) представляет абстрактного посетителя с набором методов по обработке элементов различных типов.
2. Классы [`FederalSportCommission`](src/main/java/examples/patterns/behavior/visitor/FederalSportCommission.java) и [`HockeySportCommission`](src/main/java/examples/patterns/behavior/visitor/HockeySportCommission.java) предствляют конкретных посетителей.
3. Интерфейс [`HockeyElement`](src/main/java/examples/patterns/behavior/visitor/HockeyElement.java) представляет абстрактный элемент
4. Классы [`HockeyPlayer`](src/main/java/examples/patterns/behavior/visitor/HockeyPlayer.java), [`Judge`](src/main/java/examples/patterns/behavior/visitor/Judge.java) и [`Trainer`](src/main/java/examples/patterns/behavior/visitor/Trainer.java) представляют конкретные элементы

В этом примере реализован паттерн visitor, для того, чтобы выполнить операции проверки над объектами некоторой хоккейной
структуры. Паттерн visitor позволяет добавить эти операции, при этом не изменяя сами классы объектов
