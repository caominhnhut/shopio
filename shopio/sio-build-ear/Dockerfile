FROM frekele/maven:3.5.3-jdk8 as maven

RUN mkdir -p /build
WORKDIR /build
COPY . .

RUN cd ./sio-build-ear

RUN mvn clean package -T1C

FROM jboss/wildfly:14.0.0.Final

COPY --from=maven /build/sio-build-ear/target/shopio.ear /opt/jboss/wildfly/standalone/deployments

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

USER jboss

# cleanup
RUN rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history

ENV JAVA_OPTS="-server -Xms64m -Xmx512m -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=256M -Djava.net.preferIPv4Stack=true -Djboss.modules.system.pkgs=org.jboss.byteman -Djava.awt.headless=true"

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-c", "standalone.xml"]