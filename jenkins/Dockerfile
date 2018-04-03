FROM jenkins/jenkins:lts

# disabled initial setup
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"


# pre install some plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt


# default user
COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/