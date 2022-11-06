# PersistentDataAPI

PersistentDataAPI is a more accessible way to approach the quite new, and powerfull storage that mojang provided to minecraft servers since 1.14.
This API will perform faster, and better when storing information on players, items, and even blocks. 

![](https://img.shields.io/github/tag/thehandsomeyoni/persistentdataapi.svg) ![](https://img.shields.io/github/release/thehandsomeyoni/persistentdataapi.svg)

# What's persistent data?
Persistent data is a new way to store data INSIDE a player/item/block. The data is persistent, which means it's permenant. 
The data will change only when it's asked to perform a change.
The data will be stored even after the plugin (that wrote the data) is removed from the server.

# That's cool! But how do I use it?
To use it you'll have to add the repository and dependency to your pom.xml

Currently, the api will use Jitpack, as the host of the repo, so:

Repository:

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
 ```
 
 Dependency:
 ```xml
<dependency>
    <groupId>com.github.TheHandsomeYoni</groupId>
    <artifactId>PersistentDataAPI</artifactId>
    <version>1.9-BETA</version>
</dependency>
  ```
  
# Usage

# Initialize the api:
Write this method in the onEnable() method, in main class
```java
PersistentDataAPI api = new PersistentDataAPI(this);
```
You have to register this method in the main class, as it requires a JavaPlugin instance;

Once you've initalized the api, you can freely work with it, to match your needs.

# [Documentation](https://thehandsomeyoni.github.io/PersistentDataAPI/)
The documentation can be found here:

https://thehandsomeyoni.github.io/PersistentDataAPI/

# To do:
- [x] Publish a first edition of the api.
- [x] Support persistent data containers in items.
- [x] Support persistent data containers in blocks.
- [x] Create and support custom data types.
- [x] Create custom events that support persistent data.
- [ ] Support persistent data in chunks.

# Credits
This api was created fully by TheHandsomeYoni.
For any questions/support you can contact my email:

`thehandsomeyoni@gmail.com`

Or my Discord:

`Evyaaa#0523`
