x
rm -rf ./src
rm -rf ./target

mkdir ./src
mkdir ./target

javacc Karloff.jj 
mv *.java  ./src
cd ./src
javac *.java
mv *.class  ../target

cd ..
