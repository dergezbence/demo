mvn flyway:migrate \
-Dflyway.user=postgres \
-Dflyway.password=postgres \
-Dflyway.url=jdbc:postgresql://localhost:5432/postgres \
-Dflyway.baselineOnMigrate=true