# exchange-rate-informer

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>

## Running the application in dev mode.

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application.

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/exchange-rate-informer-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Configuration

The application reads its credentials from environment variables. No credential is stored in this repository.

| Variable | Purpose |
| --- | --- |
| `DB_USER` | PostgreSQL user |
| `DB_PASSWORD` | PostgreSQL password |
| `DB_URL` | Full JDBC URL, e.g. `jdbc:postgresql://HOST:5432/DB` |
| `APP_MS_IDENTIFIER` | Client identifier sent to the auth service |

Local runs (PowerShell):
```powershell
$env:DB_USER = '<user>'
$env:DB_PASSWORD = '<password>'
$env:DB_URL = '<jdbc-url>'
$env:APP_MS_IDENTIFIER = '<identifier>'
.\mvnw.cmd quarkus:dev
```
A `.env` file in the repository root is also read (ordinal 295, below real environment variables) and is already gitignored.

Kubernetes: the Deployment sources all four variables from the Secret `exchange-rate-informer-secrets`
(namespace `cqrs-lab`). Create it once, out of band:
```shell script
kubectl -n cqrs-lab create secret generic exchange-rate-informer-secrets \
  --from-literal=DB_USER='<user>' --from-literal=DB_PASSWORD='<password>' \
  --from-literal=DB_URL='<jdbc-url>' --from-literal=APP_MS_IDENTIFIER='<identifier>'
```

## Related Guides

- REST resources for Hibernate ORM with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate Jakarta REST resources for your Hibernate Panache entities and repositories
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it

## Provided Code

### REST Data with Panache

Generating Jakarta REST resources with Panache

[Related guide section...](https://quarkus.io/guides/rest-data-panache)


### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
