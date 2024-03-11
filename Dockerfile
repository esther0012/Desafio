FROM openjdk:17-jdk-alpine

RUN adduser -D desafio

WORKDIR /desafio

COPY /build/libs/Desafio-*.jar desafio.jar

USER desafio

CMD ["java", "-jar", "desafio.jar"]

EXPOSE 8081
