# Invisible Kill

A server-side Fabric mod that replaces a player's vanilla death message with
`<Victim> was slain` when the attributed killer is a player who currently has
the Invisibility effect. Non-player and non-invisible kills keep the vanilla
message.

The project targets Minecraft 26.1 and 26.2 with Java 25 and Mojang's official,
unobfuscated class names. Build separately against each Minecraft version.

## Requirements

- JDK 25
- Gradle 9.9.0 or newer
- Fabric Loader 0.19.3 or newer in the server/game installation

## Build

Set `minecraft_version` in `gradle.properties` to `26.1` or `26.2`, then run:

```sh
gradle wrapper --gradle-version 9.9.0
./gradlew clean build
```

The mod jar is created in `build/libs/`. Install it on the server (or in the
singleplayer instance's `mods` folder); clients do not need the mod.
