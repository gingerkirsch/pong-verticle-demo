FROM hseeberger/scala-sbt:latest

COPY . .

ENV VERTICLE_HOME /usr/verticles

ENV VERTICLE_FILE cmm-pong-verticle-assembly-0.1.jar

RUN sbt assembly

RUN mkdir -p $VERTICLE_HOME
RUN cp target/$VERTICLE_FILE $VERTICLE_HOME/$VERTICLE_FILE

WORKDIR $VERTICLE_HOME

CMD ["java", "-jar", "cmm-pong-verticle-assembly-0.1.jar", "-cluster" ]
