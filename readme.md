# Dark Corridors

Dark Corridors is RPG Console game.

## Usage

After downloading your copy I suggest using command line to play this game, if you like you can also run it from IDE from main method in App.class

```java
gradlew clean build
gradlew customFatJar
cd gateway\build\libs
java -jar gateway-XXX.jar

```

## Modules

##### Gateway - determines which modules of application will run
##### Base - contains shared model classes and services to be used accross other modules
##### Console - contains classes required to render and process input from CLI
##### Game - contains game logic and parameters

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
