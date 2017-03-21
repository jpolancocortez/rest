FROM tomee:7-jre-1.7.4-webprofile

RUN apt-get update && apt-get install -y software-properties-common
RUN add-apt-repository "deb http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main"
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections
RUN apt-get update && apt-get install -y oracle-java7-installer maven

ENV JAVA_HOME=/usr/lib/jvm/java-7-oracle/
ENV PATH=$PATH:$JAVA_HOME/bin

WORKDIR /opt/
ADD app /opt
RUN mvn -X -f schema/pom.xml install
RUN mvn -X -f jepc/pom.xml clean install
#RUN ls jepc/web/target

RUN cp jepc/web/target/web-1.0.war /usr/local/tomee/webapps

WORKDIR /usr/local/tomee

RUN sed -i "64i com.sun.jersey.server.impl.cdi.lookupExtensionInBeanManager = true" conf/system.properties
ADD resources/tomee.xml conf/
ADD resources/mysql-connector-java-5.1.37-bin.jar lib
ENV PATH /usr/local/tomee/bin:$PATH
#RUN catalina.sh &
#RUN mvn -X -f /opt/jepc/pom.xml -Dmaven.test.skip=false clean install

CMD ["catalina.sh", "run"]