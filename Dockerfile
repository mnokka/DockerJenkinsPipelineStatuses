# Start with the official Jenkins LTS image
FROM jenkins/jenkins:lts

# Switch to the root user to install additional software
USER root

# Install necessary plugins
RUN jenkins-plugin-cli --plugins workflow-aggregator configuration-as-code

# configuration-as-code settings
COPY jenkins/casc_configs /var/jenkins_home/casc_configs

# Install necessary build tools
RUN apt-get update && apt-get install -y \
    build-essential \
    gcc \
    make \
    git \
    && apt-get clean

# Switch back to the Jenkins user
USER jenkins
