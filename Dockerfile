FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# argumento para o nome do JAR gerado pelo Maven (ajuste se necessário)
ARG JAR_FILE=target/API_Login_Users-0.0.1-SNAPSHOT.jar

# Copia o JAR gerado pelo Maven para dentro da imagem
COPY ${JAR_FILE} /app/app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/app.jar"]