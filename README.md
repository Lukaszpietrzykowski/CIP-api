# patient-service-api

## How to run?
To run app you must have database, so run in cmd:

```bash
docker-compose up -d
```
After that you are ready to go to run this app. You can also use [PGADMIN4](https://localhost:5050) to view and manage db.
See [How to use pgadmin4?](#pg_admin_usage)

```yaml
login : pgadmin4@pgadmin.org
password : admin
```
<a name="pg_admin_usage"></a>
## How to use pgadmin4?
PgAdmin4 -> Add sever

```yaml
name : cip

host : container-postgresdb-cip

username : cip

password : cip
```

