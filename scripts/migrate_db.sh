cd ..
mvn flyway:migrate \
-Dflyway.user=app \
-Dflyway.password=secret \
-Dflyway.url=jdbc:postgresql://localhost:5432/myapp \
-Dflyway.baselineOnMigrate=true