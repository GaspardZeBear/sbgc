# sbgc (Spring Boot Garbage Collector)

This spring boot application aims at studying various GC (Parallel, G1, Shenandoah ...) while controlling objects lifecycle.

## Memory consumption 

Basically :

- a static array holds chains of objects (dumbo class) : requests use this array til a given index 
This permit to keep datas that will move to old generation, and in steady state keep the old between a computable min/max
- chains contains a given count of dumboes of the same size. Dumboes contains array of Bytes of the gien size and back and forward reerences to next/prev dumbo in the chain

They are created by a request http://xxxx/dumby/{maxIndex}/{count}/{size}/{delay}

## CPU : fibonnaci

http://xxxx/fibo/{c}/{n}

Run c fibonnacci until number n loops

## Launch samples 

nohup /home/docker/jdk-11/bin/java -Dserver.tomcat.max-threads=400 -Dserver.tomcat.max-connections=400 -jar /home/docker/sbgc/target/sbgc-0.0.1-SNAPSHOT.jar > /dev/null &
nohup /usr/lib/jvm/java-13-openjdk-amd64/bin/java -Dserver.tomcat.max-threads=400 -Dserver.tomcat.max-connections=400 -jar /home/docker/sbgc/target/sbgc-0.0.1-SNAPSHOT.jar > /dev/null &

