#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

# Add environment variables
export BOT_NAME=SmilykBot
export BOT_TOKEN=1442794228:AAGScp-0maWQiltVUyiPUnX9tcb9SCXwCsw
export BOT_DB_USERNAME=root
export BOT_DB_PASSWORD=root

# Start new deployment
docker-compose up --build -d
