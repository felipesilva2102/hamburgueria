# ===== Etapa 1: Build =====
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar pom.xml e baixar dependências (exceto o plugin de deploy)
COPY pom.xml .
RUN mvn dependency:resolve -B

# Copiar o código-fonte e buildar o WAR
COPY src ./src
RUN mvn clean package -DskipTests

# ===== Etapa 2: Runtime =====
FROM tomcat:10.1-jdk21-temurin

# Remover apps padrão do Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar WAR da etapa de build
COPY --from=build /app/target/couxchiken-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expor a porta padrão do Tomcat
EXPOSE 8080

# Comando padrão do Tomcat
CMD ["catalina.sh", "run"]
