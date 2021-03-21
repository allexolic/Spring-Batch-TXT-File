# Spring-Batch-TXT-File


Aplicação Spring Batch que importa um arquivo texto para uma base de dados SQL 

Construir o projeto
$ mvn clean package (dentro da pasta do projeto)

Executar o projeto

java -jar ImportarArquivoTxtBancos-0.0.1-SNAPSHOT.jar --spring.config.location=file:c:/SpringBatchJob/config/application.properties file=file:c:\\Arquivos\\Bancos\\bancos.txt

obs. verifique os diretórios conforme seu ambiente


# Spring-Batch-TXT-File

Spring Batch application that imports a text file into a SQL database

Build the project
$ mvn clean package (inside the project folder)

Run the project

java -jar ImportarArquivoTxtBancos-0.0.1-SNAPSHOT.jar --spring.config.location=file:c:/SpringBatchJob/config/application.properties file=file:c:\\Arquivos\\Bancos\\bancos.txt

Note. check the directories according to your environment