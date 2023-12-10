docker run -d \
--name some-postgres \
-e POSTGRES_USER=app \
-e POSTGRES_PASSWORD=secret \
-e POSTGRES_DB=myapp \
postgres