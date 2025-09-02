# Etapa 1: Build do WAR usando Maven
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar arquivos do projeto Maven
COPY pom.xml .
COPY src ./src

# Build do WAR
RUN mvn clean package -DskipTests

# Etapa 2: Container final com Tomcat
FROM tomcat:10.1.24-jdk21

# Limpar aplicações padrão do Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar WAR da etapa de build
COPY --from=build /app/target/santo-terco-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expor porta padrão do Tomcat
EXPOSE 8080

# Rodar Tomcat em primeiro plano
CMD ["catalina.sh", "run"]
