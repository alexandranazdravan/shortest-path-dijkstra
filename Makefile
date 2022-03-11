JFLAGS = -g
JC = javac
JVM = java
RM = rm
MAIN = Main

CLASSES = \
	Autoturism.java\
	Autoutilitar.java\
	Autovehicul.java\
	Bicicleta.java\
	Motocicleta.java\
	Camion.java\
	Main.java\
	Graph.java\
	Muchie.java\
	Moped.java\
	Nod.java\
	Vehicul.java\

build: 
	$(JC) $(JFLAGS) $(CLASSES)

run: build
	$(JVM) $(MAIN)

clean:
	$(RM) *.class
