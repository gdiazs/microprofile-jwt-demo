FROM azul/zulu-openjdk:8
COPY ./target/accounts-thorntail.jar ./
CMD java -jar -Djava.net.preferIPv4Stack=true ./accounts-thorntail.jar