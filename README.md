# Sample project to read files in Spring Boot project

## Project Highlights
* Reads from a local file directory when ran in local. The location of the file is provided in application.yaml
* When executed in docker the file location is provided as environment variable. Refer to docker compose file
* The file location provided in the docker compose environment variable is bind mounted to the local directory where the files are located
