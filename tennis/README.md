# DiUS Tennis Challenge

> For a description of this challenge, please have a look at https://gist.github.com/codingricky/6502931

## BUILDING AND COMPILING

This solution uses [Gradle](https://gradle.org/) as build mechanism. It's shipped with an embedded Gradle installation, hence, to run its tests, simply open a command shell and
  issue `./gradlew test` at the root directory. Analogously, to build a package, use `./gradlew jar`.

## MY APPROACH TO THIS CHALLENGE

My idea in this challenge was to use the ATDD (Acceptance Test Driven Development) style. I'm not sure this term was originally coined by Kent Beck in his
  book [Extreme Programming Explained](https://www.amazon.com/Extreme-Programming-Explained-Embrace-Change/dp/0321278658), but the approach recommended in it
  is certainly compliant with ATDD.

To be more specific, the first thing I did was define a broad and thorough set of acceptance criteria for the solution. In this case, the acceptance tests would interact only
  with `Game` class, as exemplified in the challenge description. Later on, I would break the "production" code into smaller pieces in a test-driven fashion.

Back to acceptance tests, for every new acceptance test added to the suite, I would run all tests, let them fail and add the bare minimum "production" code that would make it pass.
  You can see such tests and "production" code being added until commit hash `44a956e12b5acaa5aff9eb6689d74fe783d94d10`. Along this process, I wasn't really concerned about the
  quality of such "production" code; my point was moving fast in the definition of the acceptance tests so that I would end up with a test suite that would
  enable me to completely refactor `Game` implementation with whatever code while remaining assured that the behaviour of the solution wouldn't change.

By the end of such exercise, I basically had two classes: `AcceptanceTests` under `/src/test/groovy` and `Game` under `/src/main/groovy`. At this point, `Game` was basically a
  monolith, being responsible for all kinds of tasks: figuring out the proper score to display (e.g.: "15-0", "Deuce", "Advantage player 1", ...), holding the points
  scored by each player, their names, among others. It was time to rely on my test suite to start breaking those responsibilities.

Figuring out how to display a proper score seemed to me like the hardest part. So it was the first thing I tackled. According to the Strategy pattern definition
  on [Wikipedia](https://en.wikipedia.org/wiki/Strategy_pattern), this pattern is meant to be used when you need to choose between variations of a given algorithm at runtime.
  In this case, in my interpretation, there were several variations of the same logic; in other words, I needed to implement different ways of displaying the game score,
  depending on how many points each player had scored at a given point in time. It seemed to make sense to me to use the Strategy pattern.

And so I've started by creating different concrete classes to take care of displaying a regular score (e.g.: "15-0", "30-15", ...), displaying a deuce, an advantage to player
  and a player victory. I've created an interface called `ScoreDisplayStrategy` to abstract all of these different possibilities.

The second step was decoupling `Game` from the instantiation of such strategies. Therefore I created `ScoreDisplayStrategyFactory`, which would hold all possible variations of
  `ScoreDisplayStrategy` and would use polymorphism to decide which concrete class to use for displaying the current score.

But up to this point `Game` was still holding information about players names and points. Hence, the next (and, supposedly, final) step would be moving such a responsibility to a separate
  class, which I called `Score`. At this point `Game` had become much shorter and easier to read.

After looking at the code, I noticed that it could be a bit hard for a reader of the `ScoreDisplayStrategy` to understand the rules that govern each situation of the `Game`. For
  instance, it seemed a bit odd to me that if a reader wanted to know the rules that define whether someone won the game, or how would a Deuce take place, that person would need
  to look into the implementations of a method called `isApplicableToScore` inside class which purpose are to define a strategy to display a `Score`. Hence, I decided to further
  improve the code and move such rules into classes with the `-Rules` suffix. This way, if one wanted to know about the rules of the game, all it took was looking into the classes
  available in the `rules` package.

And that was the actual final step, which presents you the code as currently is.

*Remark*: One thing I find important to highlight is that, in a real world scenario, when approaching a problem with well-defined rules as this one, the implementation could be a bit different.
  For instance, I've worked on a company where most people would find the code available on commit hash `44a956e12b5acaa5aff9eb6689d74fe783d94d10` a perfect solution, and would consider the
  final looks of the code a bit too complex for such a small problem. Sometimes different teams have different understandings on how much is good enough. As for this coding challenge, I don't
  really know what DiUS consider to be good enough, this code, in my eyes, is my only chance to show you guys about my maturity as a professional and share some of the things I've learned along
  the years. I wouldn't necessarily always use strategies, factories, rules and all of that all the time for the smallest of the tasks, I would first discuss with my team and gather their opinions
  before proposing a solution a given problem. So, I ask you to please take into consideration that I don't yet have a team to help deciding on how much is good enough :)

## REFERENCES

During the development of this solution, I've tried to stick to the tips and recommendations of some of my favourite books.

First, I did my best to stick to the incredibly valuable lessons presented by Uncle Bob in his amazing [Clean Code](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882/ref=sr_1_1?s=books&ie=UTF8&qid=1486086388&sr=1-1&keywords=clean+code)
 book, and tried to create tests, classes, methods, attributes, variables, everything with intention revealing names. From the same author, I've tried to make my code as [S.O.L.I.D.](http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod)
 as possible. I haven't counted it, but I know for sure my code is not 100% compatible with such rules, for different reasons (I'll talk more about such reasons in the [LIMITATIONS](#limitations-and-room-for-improvements) section).

I've also strived to make good use of encapsulation, and I thank Corey Haynes for his incredible book [Understanding the 4 rules of simple design](https://leanpub.com/4rulesofsimpledesign).
  I've taken the liberty of borrowing from him the idea of a `-Rules` class and apply it in this exercise, to decouple and centralize the rules that define when a particular event (e.g.: Advantage, Deuce, ...)
  has taken place. The lessons I took from this book are also the reason why `Score` class has so many methods to make assertions about players points instead of having `Game` or some other class talking to `Player`
  class. My idea here was to encapsulate all things related to score and points behind `Score` class, but there are some violations of this guideline, especially regarding the internals of `Score` class and
  its interactions with `Player`.

Joshua Bloch and his excellent [Effective Java](https://www.amazon.com/Effective-Java-2nd-Joshua-Bloch/dp/0321356683/ref=sr_1_1?s=books&ie=UTF8&qid=1486087176&sr=1-1&keywords=effective+java) were also
  source of inspiration for me, I've used early `return`s many many times because of them, I wish I had used more of the lessons from this book.

As for the tests and refactoring, I've tried to follow the lessons from the aforementioned [Extreme Programming Explained](https://www.amazon.com/Extreme-Programming-Explained-Embrace-Change/dp/0321278658),
  as well as from [Test Driven: TDD and Acceptance TDD for Java Developers](https://www.amazon.com/Test-Driven-Acceptance-Java-Developers/dp/1932394850/ref=sr_1_fkmr0_1?s=books&ie=UTF8&qid=1486087585&sr=1-1-fkmr0&keywords=test+driven+koskella),
  by Lasse Koskela. I've tried to convey the ideas and thoughts I had along the way by creating small commits, containing as few files as possible and using the best commit message I could think of.

Every once in a while I also like to try some of the patterns catalogued by Martin Fowler. In this challenge, I've disguised the [Special Case pattern](https://martinfowler.com/eaaCatalog/specialCase.html)
  into the `VoidStrategy` class, as to avoid the occurrence of a nasty `NullPointerException`.

Last but not least, I've tried to apply the 9 guidelines presented in [Object Calisthenics](https://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf), an awesome exercise for learning
  and practicing OO programming. For instance, I've tried to keep classes smaller than 50 lines as frequently as possible, tried to keep a low number of attributes per class,
  exchanging if-else's for polymorphism, among others.

As you go through code, you may as well find that I got all their lessons wrong and screwed everything up. If so, obviously I'm the one to blame, not the books and their fantastic authors :)


## LIMITATIONS AND ROOM FOR IMPROVEMENTS

* **Playing the game**:

* **OO**: Even though I've tried hard to deliver the best OO implementation I could possibly do, I know there are limitations. For instance, as previously said in [REFERENCES](#references) section,
  there are a lot of encapsulation violations between `Game` and `Player`, and many pieces of code where the "Tell, Don't Ask" principle could be further enforced. At this point, you might be asking yourself
  "*Well, if you already knew about it, then why didn't you do something about it?*". And the answer is: basically because I'd have to invest a lot of time to improve this and I wasn't sure this was your main
  concern with this challenge. I assumed you guys would be more interested in how I would test the solution, how would I break things up into different responsibilities and how well could I convey my thoughts on
  that via whatever media. I hope I've managed to accomplish this part reasonably well.

* **Separation of concerns**: there a few intermixed responsibilities in my code. For instance, `Player` holds both the person's name and points, but I'm not 100% sure the points belong here, since, in my eyes,
  they're tied to 3 concepts: `Game`, `Score` and the `Player` itself, since the points are what a `Player` scores in the `Game`. I believe there's some room for improvement here.
   here as well.

* **Tests**: as may have seen in my tests, there's a lot of duplication, especially when it comes to points, scores, etc. There are many many places where tests inputs are almost 100% duplicated. I could have
  created auxiliary methods and constants to eliminate such duplication and try to make assertions and fixtures more reusable, but I decided to favour readability over duplication and save some time along the way.

## BUT FELIPE, WHY DID YOU TAKE SO LONG?

Basically because I wanted to make sure my ideas would be properly communicated to you guys. When I started scratching how to approach this challenge, I had some ideas in mind and I wanted to at least try and
  communicate them via code and commit messages. Maybe I could have done a time-boxed challenge and have spent not more than 2 hours, but my concern was that I would end up with a series of half-communicated
  ideas and would end up confusing you. From the very beginning, my basic idea was what I described in the beginning: write a thorough test suite, back it up with throw away "production" code and refactor it to
  use both the Strategy pattern and the `Score` abstraction. I'd be very frustrated if I had to write a section here saying "You see this 500 lines `Game` class? So, my idea is to do this and that and end up
  like this". Not to mention the risk of being unable to properly describe and convey my ideas and make it even more confusing to you guys. So, that's why it took me a little longer than expected to complete this
  challenge, I hope I've been able to convey all of my ideas and make my solution comprehensible enough.

## ASSUMPTIONS

* It's not necessary to provide a way to "play" the game. The challenge is about implementing the `Game` methods described in the challenge, there's no need to provide a way for the user to interact with it via a
  command-line interface of any kind of user interface.
* Tests and conveying my ideas were the highest priorities
* 100% object-oriented code was a nice-to-have, even desirable, but not mandatory

## THANK YOU

Regardless of succeeding or failing this recruiting process, I just wanted to thank you guys for the opportunity. I had a lot of fun working on this challenge. I hope I pass it, though :)
