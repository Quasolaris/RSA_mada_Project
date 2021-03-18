# RSA_mada_Project

## Team:
Sebastian Grau and Adrian Roth

## Task
Make own RSA encryption with key generation. Code should save files and keys and can read files to decrypt them.


## Known bugs
When CLI or any fileService mathods get called alot of times in a short time, an error occurs. The error is because the stream needs some time to close.

+Fix on user site
  Run fileService methods not in short amounts of time, let the stream close befor new read/write operation.

## Changelog

------------------16.03.2021---------------------

+ Repo created
+ Java project created
+ Created develp branch
+ Added needed classes
+ added placeholder fileService code
+ finished key generating
+ added comments
+ cleand up some code

------------------17.03.2021---------------------

+ Created feature/keys 
+ Cleandup fileService code
+ Made final fileService code
+ fixed space in string bug in keyPair class
+ added own euklid algorithm
+ finsihed CLI class
+ tested encrypt, decrypt, saving and reading files
+ fixed some minor bugs
+ added comments
+ cleand up comments
+ run 400 tests, all successfull (see test in RSA_main)
+ updated changelog
+ Formated README.md with md syntax

------------------18.03.2021---------------------
