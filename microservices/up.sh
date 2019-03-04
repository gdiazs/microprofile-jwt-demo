mvn clean package -f authentication/pom.xml && mvn clean package -f accounts/pom.xml
java -jar ./authentication/target/authentication-thorntail.jar -Djava.net.preferIPv4Stack=true -Dswarm.port.offset=000 &
java -jar ./accounts/target/accounts-thorntail.jar -Djava.net.preferIPv4Stack=true -Dswarm.port.offset=001 &
