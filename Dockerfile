FROM adoptopenjdk:16-jdk-hotspot
WORKDIR /opt/app
COPY target/*.jar final_exam.jar
CMD ["java", "-jar", "final_exam.jar"]