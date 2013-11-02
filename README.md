techforum4
==========

This repo contains the working code for the demonstration I showed at the Tech Forum 4 talk. It is built using IntelliJ IDE, but you should have little trouble using others (such as Eclipse) with minor adaption.

The program is tested with the following settings:

    Java 1.7.0_45
    Drools Expert 5.5.0 Final
    Windows 7

You should see something like the below in the output:

    Fact: Paul is a Person
    Fact: Peter is a Person
    Fact: Parker is a Person
    Fact: Paul is the father of Peter
    Fact: Peter is the father of Parker
    -----------------------------------------------------------------
    Inferred Paul is Parker's grandpa.
    Grandpa Paul gives 10 candies to grandson Parker
