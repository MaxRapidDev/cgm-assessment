# cgm-assessment

## Demo
http://cgmdemo-env.eba-gffs6ibe.eu-central-1.elasticbeanstalk.com/#/

## TODO`s:
* Backend
  * More JUnit-Tests
  * Use DTO`s in RestServices instead of entities
  * Secure and auth
* Frontend
  * Technical
    * Jest Tests
    * E2E Tests
    * Storybook
    * Document the components
    * API and Entities in Webapp as TypeScript
  * UI
    * Responsive design
    * Dirty-protection for unsaved changes in forms
    * Hande serverside errors at rest calls

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `cgm-app-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.

The application is now runnable using `java -jar target/cgm-app-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/cgm-app-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.