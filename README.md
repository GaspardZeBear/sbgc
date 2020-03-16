# sbgc (Spring Boot Garbage Collector)

This spring boot application aims at studying various GC (Parallel, G1, Shenandoah ...) while controlling objects lifecycle.

Basically :

- a static array holds chains of objects (dumbo class) : requests use this array til a given index 
This permit to keep datas that will move to old generation, and in steady state keep the old between a computable min/max
- chains contains a given count of dumboes of the same size. Dumboes contains array of Bytes of the gien size and back and forward reerences to next/prev dumbo in the chain

They are created by a request http://xxxx/dumby/{maxIndex}/{count}/{size}/{delay}
