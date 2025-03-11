# GermanMiner Addon Protocol

An example protocol for the GermanMiner LabyMod Addon

## Usage

### Maven

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/Funboyy/GermanMinerProtocol</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>de.funboyy.germanminer</groupId>
        <artifactId>addon-protocol</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```
### Gradle

```kts
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/Funboyy/GermanMinerProtocol")
    }
}

dependencies {
    implementation("de.funboyy.germanminer:addon-protocol:1.0.0-SNAPSHOT")
}
```
