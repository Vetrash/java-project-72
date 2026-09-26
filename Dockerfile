FROM gradle:8.7-jdk21 AS build

# Устанавливаем Node.js и npm для сборки Tailwind
USER root
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://deb.nodesource.com/setup_20.x | bash - && \
    apt-get install -y nodejs && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY app /home/gradle/src
WORKDIR /home/gradle/src

# Собираем стили Tailwind
RUN cd tailwind && npm ci
RUN cd tailwind && npm run build:css

# Собираем JAR
RUN gradle shadowJar --no-daemon

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 7070
CMD ["java", "-jar", "app.jar"]