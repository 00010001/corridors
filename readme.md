  _____          _____  _  __   _____ ____  _____  _____  _____ _____   ____  _____   _____ 
 |  __ \   /\   |  __ \| |/ /  / ____/ __ \|  __ \|  __ \|_   _|  __ \ / __ \|  __ \ / ____|
 | |  | | /  \  | |__) | ' /  | |   | |  | | |__) | |__) | | | | |  | | |  | | |__) | (___  
 | |  | |/ /\ \ |  _  /|  <   | |   | |  | |  _  /|  _  /  | | | |  | | |  | |  _  / \___ \ 
 | |__| / ____ \| | \ \| . \  | |___| |__| | | \ \| | \ \ _| |_| |__| | |__| | | \ \ ____) |
 |_____/_/    \_\_|  \_\_|\_\  \_____\____/|_|  \_\_|  \_\_____|_____/ \____/|_|  \_\_____/ 
                                                                                            
                                                                                            

Dark Corridors is POC of Java based RPG Console game.

## Features

* Player can move in 4 directions on map, which is int matrix
* different values on map can represent different objects
* game uses Stages, which is mode that represent current state of the game
* game checks which value player faces and then renders appropriate view and sets up correct Stage for situation
* application uses GameState object to pass values to services
* Game determines logic based on current Stage and user input

## Usage

After downloading your copy I suggest using command line to play this game, if you like you can also run it from IDE from main method in App class

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
