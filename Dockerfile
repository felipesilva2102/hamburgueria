# -----------------------------
# 1ª Etapa: Build com Maven
# -----------------------------
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# -----------------------------
# 2ª Etapa: Runtime no WildFly
# -----------------------------
FROM jboss/wildfly:36.0.1.Final

ENV DEPLOYMENT_DIR /opt/jboss/wildfly/standalone/deployments

COPY --from=build /app/target/couxchiken-1.0-SNAPSHOT.war ${DEPLOYMENT_DIR}/couxchiken.war

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
