FROM azul/zulu-openjdk:8
COPY ./target/authentication-thorntail.jar ./
CMD java -jar -Djava.net.preferIPv4Stack=true ./authentication-thorntail.jar