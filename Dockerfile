FROM gradle:7.1-jdk11-openj9 as builder
WORKDIR /solution-challenge
COPY . .
RUN chmod +x gradlew
RUN ./gradlew build --stacktrace


FROM gradle:7.1-jdk11-openj9
WORKDIR /solution-challenge
EXPOSE 8080
COPY --from=builder /solution-challenge/build/libs/solution-0.0.1-SNAPSHOT.jar .
CMD java -jar solution-0.0.1-SNAPSHOT.jar