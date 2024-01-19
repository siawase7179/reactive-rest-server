FROM openjdk:17-alpine
VOLUME /tmp
ADD build/libs/reactive-rest-server-0.0.1-SNAPSHOT.jar /
ENTRYPOINT exec java $JAVA_OPTS -jar reactive-rest-server-0.0.1-SNAPSHOT.jar 