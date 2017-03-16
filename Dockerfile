FROM tomee:7-jre-1.7.4-webprofile

ENV PATH=%PATH%;D:\mvn3.2.2\bin 

RUN ["mvn", "-f", "rest/pom.xml"]