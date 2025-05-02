# StarStrike: A Space Fight Game in jMonkeyEngine

![Game Type](https://img.shields.io/badge/Genre-Space--Shooter-blue)
![Engine](https://img.shields.io/badge/Engine-jMonkeyEngine-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

**StarStrike** is a 3D space fight game developed using [jMonkeyEngine](https://jmonkeyengine.org/). Control your spaceship, shoot down enemy ships, and survive as long as you can in deep space!

## Features

- Player-controlled spaceship with keyboard movement
- Enemy AI with wave-based spawning
- Laser shooting and collision detection
- Explosion effects and sound FX
- Modular codebase with clean structure

---


## Project Structure

```
StarStrike/
├── build.gradle
├── settings.gradle
├── assets/
│   ├── Models/
│   ├── Textures/
│   └── Sounds/
└── src/
    └── main/
        └── java/
            └── mygame/
```

---

## Installation

1. Clone the repo:

```bash
git clone https://github.com/thillainiraml-tech/StarStrikeGame.git
cd StarStrike
```

2. Open in IntelliJ IDEA or jMonkeyEngine SDK.

3. Mark directories:
   - `assets/` as Resources Root
   - `src/main/java` as Sources Root

4. Run the `Main.java` file to start the game.

---

## Controls

| Action     | Key         |
|------------|-------------|
| Move Left  | A           |
| Move Right | D           |
| Move Up    | W           |
| Move Down  | S           |
| Shoot      | Spacebar    |

---

## Dependencies

- jMonkeyEngine 3.6+
- Java 11+

You can install jMonkeyEngine via Gradle or by using the jMonkeyEngine SDK.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Credits

- 3D assets from [Kenney.nl](https://kenney.nl/assets/space-shooter-redux)
- Sounds by [Kenney Audio Assets](https://kenney.nl/assets)

---

## Contributions

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

