cs56-games-simple-rpg
(W15) TBD: It looks like a promising game; the code base looks navigatable but trying to run it produces a really strange window that seems to randomly place blue colored squares on the main green square regardless of what key is pressed and can only be escaped from. It looks fairly extensible but has a bad bug currently and Im having difficulties running it(Paz Zait-Givon)

// Andrew Lai // David Sun

Running the Game
=====================
* If running at CSIL, run `ant build` and then `ant runcli` (for the CLI version of the game) or `ant run` for the GUI version.
* If running through an SSH instance of CSIL, make sure an xserver instance is running for the GUI version and run the above commands.
* If running on a local instance after cloning, the classpath for JUnit must be fixed in the `build.xml` file.
  + Go to [this link]( https://github.com/junit-team/junit/wiki/Download-and-Install) and download the JAR files (junit and hamcrest).
  + Create a `java` directory in your home folder (`cd && mkdir java`)
  + Run cp ~/Downloads/{junit-X.Y.jar,hamcrest-core-XX.YY.jar} where X, Y, XX and YY are corresponding versions of the JAR files you downloaded.
  + Add the following lines to your `.bash_profile` (or to your `.zshrc` if you use zsh):
    ```
    export JUNIT_HOME="$HOME/java"
    export PATH="$PATH:$JUNIT_HOME"
    export CLASSPATH="$CLASSPATH:$JUNIT_HOME/junit-X.Y.jar:$JUNIT_HOME/hamcrest-core-XX.YY.jar"
    ```
  + Now replace all instances of `/cs/faculty/pconrad/public_html/cs56/lib/junit-4.8.2.jar` in the `build.xml` with `${env.JUNIT_HOME}/junit-X.Y.jar` .

---------------------------------------------------

The first version of the game is a CLI version, with a non-functional GUI implementation.

![](http://i.imgur.com/rll8hnf.png)

The second version of the game is a GUI version. (OLD, 2016)

![](http://i.imgur.com/hG1TpJb.gif)

The updated GUI version now features multiple enemies with unique behavior and pathfinding.

![](https://i.imgur.com/t2g3ij7.gif)
---------------------------------------------------

Project History
===============
```
YES | bronhuston | barasuishou | A simple rpg game
— Edit
 W14 | bronhuston 5pm | barasuishou | A simple rpg game
```

### CLI Version
===============
Features for the CLI version:
- Ability to move
- Basic turn-based battle
- Random encounters

A sample playthrough might look like this:

Output:
Main Character HP: 100/100 MP: 100/100 XP: 0/100
Current Location: (0,0)

Options:
1. Move Left
2. Move Right
3. Move Up
4. Move Down
5. Quit

Input:
2

Output:
You have encountered an enemy.
Main Character LV: 1 HP: 100/100 MP: 100/100 XP: 0/100
Current Location: (1,0)
Enemy LV: 1 HP: 20/20 MP 15/15

Options:
1. Attack
2. Run Away

### GUI Version
===============

Current GUI Game Implementations:
- MainCharacter can move around screen using input from arrow keys
- Shop can be accessed through a JButton. Currently the shop has very limited function.
- After shop has been accessed, the MainCharacter no longer responds to arrow key input and the 'esc' key does not quit the game. At this point, you must manually close the JFrame to end the game.

### F17 Final Remarks
=====================
The code is pretty disorganized. All of the new GUI stuff? That takes place inside the "Graphics" folder, specifically inside Display.java. The game loop itself is actually inside SimpleRPG.java, which is located in the SimpleRPG folder. This is because the previous group of students that worked on this didn't really have a working "game," per se, they had a UI that didn't interact with any of the command line version of the game at all.

The main problem is that all the multiple enemy behaviors all take place (hardcoded) inside Display.java. You're going to have to fix that, if you want to make the code extendable - the behaviors themselves should be understandable to extend and implement. Also, the GUI still needs fixing. It's rather ugly LMAO

There is a lot of room to implement the design patterns outlined by the course here. Each enemy has its own behavior, its own variables, its own view on life - however, they're all determined in one place. More importantly, the location tracking in the game is not specific to the classes, but to the _hardcoded instances of those classes spawned by Display.java_. These are major issues that need to be fixed in order to create additional types of enemies.
