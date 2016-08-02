# Simulation-BlackJack
Simulates a game of Black Jack, keeping track of cash on hand and the current card count.  Can be used to test new card counting algorithms.

## requirements
```
sudo apt-get install openjdk-9-jdk
```

## clone the repo
```
git clone https://github.com/stevenharradine/Simulation-BlackJack.git
```

## configure simulation
```
nano src/configure.java
```

## build and run
```
./build.sh && ./run.sh
```

## cleanup (optional)
WARNING: this preforms an `rm -rf bin/` please review the code and use at own risk.
```
cd build
java BlackJack
```
