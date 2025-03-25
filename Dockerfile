FROM ubuntu:latest
LABEL authors="ypathan"

ENTRYPOINT ["top", "-b"]