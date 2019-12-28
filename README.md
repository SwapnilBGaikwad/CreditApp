## Credit App

* Build project

./gradlew clean build

Create local build
docker build -t app:1.0 --build-arg APP_ENV=local .

Create Prod build
docker build -t app:1.0 --build-arg APP_ENV=prod .

