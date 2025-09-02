# -----------------------------
# 1ª Etapa: Build com Maven
# -----------------------------
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Definir diretório de trabalho
WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Compilar e empacotar (gera .war dentro de target/)
RUN mvn clean package -DskipTests

# -----------------------------
# 2ª Etapa: Runtime no WildFly
# -----------------------------
FROM quay.io/wildfly/wildfly:36.0.1.Final

# Definir variáveis
ENV DEPLOYMENT_DIR /opt/jboss/wildfly/standalone/deployments

# Copiar o WAR gerado do build para o WildFly
COPY --from=build /app/target/couxchiken-1.0-SNAPSHOT.war ${DEPLOYMENT_DIR}/couxchiken.war

# Expor a porta padrão
EXPOSE 8080

# Comando padrão (start WildFly standalone)
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
