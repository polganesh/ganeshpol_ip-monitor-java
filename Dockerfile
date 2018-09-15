FROM openjdk:8

#!/bin/bash

RUN set -e && \
    mkdir -p /app && \
    mkdir -p /app/bin && \
    mkdir -p /app/bin/config && \
    mkdir -p /app/logs

COPY target/ip-monitor-java-0.1.jar /app/bin/

WORKDIR  /app

ENTRYPOINT ["java", "-Done-jar.silent=true","-Xms768m", "-Xmx768m", "-jar", "/app/bin/ip-monitor-java-0.1.jar"]

