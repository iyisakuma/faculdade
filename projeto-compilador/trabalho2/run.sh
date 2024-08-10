#!/bin/sh
if [ -z $1 ]
then 
echo "passe o nome do arquivo como parametro. Lembre-se de que esse arquivos deve está contido no diretório \"programs\" "

else 
cd ./target
java Karloff ../$1

cd ..

fi