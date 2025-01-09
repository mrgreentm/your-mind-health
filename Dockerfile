# Usar a imagem base do JDK
FROM openjdk:21-jdk-slim

# Configurar o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY target/yourmindhealth-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta em que sua aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
