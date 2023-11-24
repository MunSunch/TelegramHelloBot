FROM openjdk:17.0.1-jdk
EXPOSE 443
WORKDIR /opt/app
COPY target/TelegramBot-1.5-SNAPSHOT-jar-with-dependencies.jar bot.jar
CMD ["java", "-jar", "/opt/app/bot.jar"]