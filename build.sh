cd src/
javac *.java
cd ..
rm -rf build/
mkdir build
mv src/*.class build/
