#qstns

Plans:

0. Market research
1. Pick technology stack
2. Press "magic" button(s)
  20. Test
  21. Code
  
##Market research

REST in JAVA (||||| - max):

+ Simple JAX-RS |||
+ Apache CXF || (hm...)
+ Jersey  ||||| (don't like)
+ RESTEasy | (JBoss - it will be to heavy))
+ Spring |||||
+ RESTX  |||| (nice, but I have already use it now)
+ Spark |||| (learned after jug/gdg 11.12.14)

Test:

+ JUnit
+ Cucumber

"Feel free to write tests in any JVM language" - ask.fm:

+ Clojure (it can be fun)
+ Scala (hm...)
+ Kawa (noup)

Test(Clojure):
+ clojure.test (default lib in clojure) |||
+ Expectations - one assertion per test. ||||
+ Speclj ||||
+ Humane Test Output (for clojure.test) ||
+ Midje |||
+ Lazytest (Not under active development)


##Technology stack

+ Spring ~~Spark (not bad)~~
+ embedded DB
+ Clojure for testing (muahahaha)
+ Mockito + cljito (±Ring-Mock)
+ Speclj or Expectations

##Magic
basic functionality:

- ask question DONE
- list all accepted questions DONE
- list all accepted questions by country code DONE
- question validation
  - blacklisted words DONE
  - timeframe limit DONE
  _i think dat better to use reversed proxy solution (like nginx) or separate small (script or c) solution on individual server_
  - origin country resolution DONE

##self check
- Conformance to business requirements
  - made as much as understand the task
- Code quality
  - java code convention and style
  - SonarQube
- including testability
  - !!en route!!
- How easy it is to run and deploy the service (don't make us install Oracle database please ;)
  - mvn install (maybe with clean) or something like that