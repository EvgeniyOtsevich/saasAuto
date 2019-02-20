# Saas-template Automation

## The repository contains automation framework for GL QA Automation ProCamp.

### Setup 
1. Install Saas-template application
2. Clone projects 
```
  > git clone https://github.com/EvgeniyOtsevich/saasAuto.git
```
By default properties are got from `src/config/` folder with next structure:
##### QA_env.properties/Dev_env.properties
```
BaseUrl=..(0.0.0.0)
BasePort=...(8888)
```
##### Common.properties/
```
endPointName=...(/endPointPath)
```
### Execute
For executing tests run
```
  > mvn clean test -Denvironment=QA
```
where `environment` is the name of used environment. There are 2 availabel environments:
- QA
- Dev

### Reporting
For generating allure report run
```
  > mvn allure:report
```
HTML report will be generated in the `/target/site/allure-maven-plugin` and can be opened with one of installed browsers
