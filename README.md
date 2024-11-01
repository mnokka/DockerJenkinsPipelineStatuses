POC to setup Jenkins in Docker able to build C code.
<br>
<br>

Start docker: *docker-compose up -d*

Use: *localhost:8080*

Jenkins goes directly to admin state...

Jenkins has pipeline job (for project/hello.c) defined, just hit Build button to build it (output hello will be tested(executed) and archived)



failpipleine.groovy as an example how stage can check it's failure and set failure variable. Then final
phase can inform which part of the build actually failed