docker run \
--name some-postgres \
-p 5432:5432 \
-e POSTGRES_USER=app \
-e POSTGRES_PASSWORD=secret \
-e POSTGRES_DB=myapp \
postgres