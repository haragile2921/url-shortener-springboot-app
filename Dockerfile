FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/urlshortener-*.jar app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-Dserver.port=${PORT}","-jar","/app/app.jar"]