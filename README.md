#### F16 Final Remarks
======================
Most of the changes made during F16 refactored code under the hood in an effort to allow for future flexibility to changes in the code. A couple changes include updating the class structure of certain essential game elements(Entities and Items):

1. Class structure of in-game players:
```
                Entity
                  |
      MainCharacter -- Enemy
                         |
                       Goblin
```                     

2. Class structure of in-game items:
```                
                 Item
                   |
      Weapon -- Potion -- Spell
```      
   
This project is still a work in progress and at this point could evolve into a variety of unique ways. Currently the game functions of the GUI include:
1. The MainCharacter can move around the screen using input from arrow keys
2. An enemy Goblin is displayed and advances towards the MainCharacter
3. A neutral Trader entity is displayed and randomly moves around the game map. You must be within a close radius of the Trader to access the Shop.
4. The Shop can be accessed through a JButton. Currently the shop has very limited function. Clicking the Shop button will display the message: "You must be closer to the Trader to acces the Shop menu."
5. A "Set Weapon" Button exists that allows the user to update the MainCharacter's current weapon from the inventory.

Current Game Limitation: 
After the Shop or the Set Weapon has been accessed, the MainCharacter no longer responds to arrow key input and the 'esc' key does not quit the game. At this point, you must manually close the JFrame to end the game.

What to Work On Next: The next steps to improve the game include:

1. Fixing the existing game logic to allow for uninterrupted gameplay after accessing the Shop or the MainCharacter's inventory.

2. Adding GUI Implementations for a Start menu display as well as a Battle display.

3. Further improve game logic and design, adding appropriate JUnit tests.



cs56-games-simple-rpg
(W15) TBD: It looks like a promising game; the code base looks navigatable but trying to run it produces a really strange window that seems to randomly place blue colored squares on the main green square regardless of what key is pressed and can only be escaped from. It looks fairly extensible but has a bad bug currently and Im having difficulties running it(Paz Zait-Givon)

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

The second version of the game is a GUI version.

![](http://i.imgur.com/yZgilOm.gif)

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
