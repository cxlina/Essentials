**NOTE:** Some people asked me if my mods work on Quilt, or if i will port them over if not.

The answer is easy: NO.

Why? Quilt is something i don't want to support myself. It's one of those "It exists just to exist" projects, where i don't see any reason for it to exist.
In terms of development, there's no big changes from fabric, and all changes that exist don't make any sense in my opinion, and/or could easily be included in fabric. but no, they had to "reinvent the wheel".

So in short: if my mods work on quilt, cool. you can obviously use them.
If they don't, you're on your own.


-------------------------------------------------------


This is a mod with Bugfixes and Un-Patches Mojang doesn't care about.

-------------------------------------------------------

**Compile Yourself:**

If you always want the newest version (may be unstable), you can compile this mod from source:

- go into some folder on your pc and run ```git clone https://github.com/cxlina/Essentials/``` (requires git installed on your pc. alternatively you can also click `code/download zip` on the github page and use the `Essentials-master` folder as the folder in the next step)
- Open Intellij, and import the Folder that contains the build.gradle file.
- Wait for everything to index/import, then double-press `ctrl`, type `gradle build`, and wait for it to finish.
- Then you'll get a compiled read-to-use jar-file inside `Imported Folder/build/libs/mod_version+game_version.jar`

**NOTE: You won't get ANY support when using these jars, i don't have any control over code that you may have changed/compiled yourself.**

**Also, when using a newer/older version than available on Modrinth, you'll get the Update-Prompt every restart! THIS IS NOT A BUG!!**
