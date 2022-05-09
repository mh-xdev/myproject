FROM eclipse-temurin:11

COPY target/microstream-cluster-node.jar node.jar
EXPOSE 8080

CMD ["java", "-jar", "node.jar"]