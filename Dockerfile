FROM openjdk:8
ADD target/ip-monitor-java-0.1.jar ip-monitor-java-0.1.jar
EXPOSE 80
ENTRYPOINT ["java", "-Done-jar.silent=true","-Xms768m", "-Xmx768m", "-jar", "ip-monitor-java-0.1.jar"]

