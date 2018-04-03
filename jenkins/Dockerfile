FROM jenkins/jenkins:lts

# switchs to root user
USER 0
# disabled initial setup
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"


# pre install some plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt


# default user
COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/

RUN apt-get update
RUN curl -sL https://deb.nodesource.com/setup_9.x | bash -
RUN apt-get install nodejs -y
RUN node -v
RUN npm -v
RUN npm install angular


# switchs to default user
USER ${user}