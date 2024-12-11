FROM maven:3.8.5-openjdk-17

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean compile

CMD ["mvn", "-q", "exec:java", "-Dexec.mainClass=org.magical_arena.Main"]

