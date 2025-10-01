FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copia o JAR já construído
COPY target/API_Login_Users-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

# Use variáveis de ambiente para a conexão (não colocar credenciais no Dockerfile)
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/app.jar"]