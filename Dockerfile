FROM java:8u111-jre-alpine
MAINTAINER Javi Moreno <javi.moreno@capside.com>

COPY target/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT  ["java", "-jar", "/app.jar"]

HEALTHCHECK  --start-period=60s --interval=20s --timeout=5s --retries=3 \
             CMD wget -q -s http://127.0.0.1:8080/health || exit 1 

CMD [""]