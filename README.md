cs56-games-simple-rpg
(W15) TBD: It looks like a promising game; the code base looks navigatable but trying to run it produces a really strange window that seems to randomly place blue colored squares on the main green square regardless of what key is pressed and can only be escaped from. It looks fairly extensible but has a bad bug currently and Im having difficulties running it(Paz Zait-Givon)

=====================

The first version of the game is a CLI version, with a non-functional GUI implementation.

![](http://i.imgur.com/rll8hnf.png)

project history
===============
```

YES | bronhuston | barasuishou | A simple rpg game
— Edit
 W14 | bronhuston 5pm | barasuishou | A simple rpg game 
```

Features for the CLI version:
-ability to move
-basic turn-based battle
-random encounters

A sample playthrough might look like this:

output:
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
