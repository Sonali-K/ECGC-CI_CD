 //Email Notifications
         EMAIL_RECIPIENTS = 'sonali.kanse021@gmail.com'
        
        
          //git Checkouts Config variables
          git = 'http://10.212.0.139/testgroup/ecgcdashboardproject'
          gitlab ='http://10.212.0.139/ecgc/smile/test/ecgc-cicd-ms-demo.git'
          
         //Build Compile Config Varibles
         compile = 'mvn -f discoveryserver/pom.xml compile'
         compile1 = 'mvn -f hrd_emp_be/pom.xml compile'
         compile2 ='mvn -f hrd_emp_fe/pom.xml compile'
        
         //Code Analysis SonarQube Config Variables
         sonar ='mvn -f discoveryserver/pom.xml clean package sonar:sonar'
        
         //Unit Testing
         unit_test = 'mvn -f hrd_emp_be/pom.xml clean test'
         reportFilenamePattern = 'hrd_emp_be/test-output/testng-results.xml'
        
         //Containerization config variables
         jar = 'mvn -f discoveryserver/pom.xml package'
         jar1 = 'mvn -f hrd_emp_be/pom.xml package'
         jar2 = 'mvn -f hrd_emp_fe/pom.xml package'
         docker_compose = 'docker-compose build'
        
         //Functional Testing Config Variables
         git1 = 'http://10.212.0.139/testgroup/ecgcdashboardproject'
         mvn_test = 'mvn clean test'
         reportFilenamePattern1 = '**/testng-results.xml'
        
         //Upload Images Config -varibles
         DOCKER_PUSH = 'docker push docker-registry.cdacmumbai.in:5000/discoveryserver.jar'
         DOCKER_PUSH1 = 'docker push docker-registry.cdacmumbai.in:5000/hrd_emp_be.jar'
         DOCKER_PUSH2 = 'docker push docker-registry.cdacmumbai.in:5000/hrd_emp_fe.jar'
         
         
         // Security Testing ZAP Config variables
         host = 'localhost'
         port = '8090'
         timeout= '500'
         zapHome = '/home/ecgc-cicd/Downloads/ZAP_2.7.0/'
         host1 = 'http://10.212.0.72:8082/'
         allowedHosts = 'github.com'
  
         //Performance Testing Config -Variables
         jmeter ='cd /home/ecgc-cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/ sh jmeter.sh -   Jjmeter.save.saveservice.output_format=xml -n -t /home/ecgc- cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/HRDemo.jmx -l /home/ecgc- cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/report.jtl'
        perfReport ='/home/ecgc-cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/report.jtl'
