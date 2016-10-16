# Gossiping Bus Drivers Kata
> description available at https://docs.google.com/document/d/10kyCQbLNvRrBdr3nPr0AOQT80xJZwbxcoI_QgIE4aQ8/edit#heading=h.4mcr0mcs1zd3

### What's the rationale behind the solution?

The basic idea I've tried to convey here is that bus drivers will exchange gossips as time passes. Therefore, there's a `Clock` abstraction, and every time the clock ticks, the drivers are going to exchange gossips with all drivers standing in the same bus stop, and then move on to the next stop in their route. As long as not all drivers have al
 got hold of all gossips, `Clock` keeps ticking. At the end of the day, if not all drivers have all gossips, the solution outputs `never`. Otherwise, the solution outputs the number of clock ticks needed to get all drivers up to date with everybody's gossips.

### How do I run this?

As the problem description doesn't specify any input media, the solution works based on acceptance tests. So, in order to run the tests, install Scala (http://www.scala-lang.org/) and afterwards install SBT (http://www.scala-sbt.org/). Both can be installed via different package managers, like Homebrew (http://brew.sh/), SDKMAN! (http://sdkman.io/) and many others.

Once you have both installed, open your favourite shell, go to this project's root folder and run `sbt test`. All tests will be executed and a nice test summary will be printed in the console.