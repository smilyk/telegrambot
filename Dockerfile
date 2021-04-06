#на основе чего будет состоять образ — adoptopenjdk/openjdk11.
FROM adoptopenjdk/openjdk11:ubi
#добавляем аргумент в образ с именем JAR_FILE, который находится в папке target. Причем нынешняя папка определяется по месту Dockerfile.
ARG JAR_FILE=target/*.jar
#environment variabl
ENV BOT_NAME=SmilykBot
ENV BOT_TOKEN=1442794228:AAGScp-0maWQiltVUyiPUnX9tcb9SCXwCsw
#копируем в докер-образ jar нашего проекта.
COPY ${JAR_FILE} app.jar
#содержит массив, созданный из команды в терминале, которую разделили по пробелу.
#ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]

#То есть, в итоге будет выполнено следующее:
#“java -jar /app.jar”
