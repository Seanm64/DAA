C:\Users\seanm\.jdks\corretto-19.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.1\lib\idea_rt.jar=49700:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.1\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\seanm\IdeaProjects\Sodoku\target\classes;C:\Users\seanm\.m2\repository\org\apache\maven\maven-core\2.0.6\maven-core-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-settings\2.0.6\maven-settings-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\wagon\wagon-file\1.0-beta-2\wagon-file-1.0-beta-2.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-plugin-parameter-documenter\2.0.6\maven-plugin-parameter-documenter-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\wagon\wagon-http-lightweight\1.0-beta-2\wagon-http-lightweight-1.0-beta-2.jar;C:\Users\seanm\.m2\repository\org\apache\maven\wagon\wagon-http-shared\1.0-beta-2\wagon-http-shared-1.0-beta-2.jar;C:\Users\seanm\.m2\repository\jtidy\jtidy\4aug2000r7-dev\jtidy-4aug2000r7-dev.jar;C:\Users\seanm\.m2\repository\xml-apis\xml-apis\1.0.b2\xml-apis-1.0.b2.jar;C:\Users\seanm\.m2\repository\org\apache\maven\reporting\maven-reporting-api\2.0.6\maven-reporting-api-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\doxia\doxia-sink-api\1.0-alpha-7\doxia-sink-api-1.0-alpha-7.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-profile\2.0.6\maven-profile-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-model\2.0.6\maven-model-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-artifact\2.0.6\maven-artifact-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\wagon\wagon-provider-api\1.0-beta-2\wagon-provider-api-1.0-beta-2.jar;C:\Users\seanm\.m2\repository\org\codehaus\plexus\plexus-container-default\1.0-alpha-9-stable-1\plexus-container-default-1.0-alpha-9-stable-1.jar;C:\Users\seanm\.m2\repository\junit\junit\3.8.1\junit-3.8.1.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-repository-metadata\2.0.6\maven-repository-metadata-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-error-diagnostics\2.0.6\maven-error-diagnostics-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-project\2.0.6\maven-project-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-plugin-registry\2.0.6\maven-plugin-registry-2.0.6.jar;C:\Users\seanm\.m2\repository\commons-cli\commons-cli\1.0\commons-cli-1.0.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-plugin-api\2.0.6\maven-plugin-api-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\wagon\wagon-ssh-external\1.0-beta-2\wagon-ssh-external-1.0-beta-2.jar;C:\Users\seanm\.m2\repository\org\apache\maven\wagon\wagon-ssh-common\1.0-beta-2\wagon-ssh-common-1.0-beta-2.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-plugin-descriptor\2.0.6\maven-plugin-descriptor-2.0.6.jar;C:\Users\seanm\.m2\repository\org\codehaus\plexus\plexus-interactivity-api\1.0-alpha-4\plexus-interactivity-api-1.0-alpha-4.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-artifact-manager\2.0.6\maven-artifact-manager-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\maven-monitor\2.0.6\maven-monitor-2.0.6.jar;C:\Users\seanm\.m2\repository\org\apache\maven\wagon\wagon-ssh\1.0-beta-2\wagon-ssh-1.0-beta-2.jar;C:\Users\seanm\.m2\repository\com\jcraft\jsch\0.1.27\jsch-0.1.27.jar;C:\Users\seanm\.m2\repository\org\codehaus\plexus\plexus-utils\1.4.1\plexus-utils-1.4.1.jar;C:\Users\seanm\.m2\repository\classworlds\classworlds\1.1\classworlds-1.1.jar;C:\Users\seanm\.m2\repository\org\sat4j\org.sat4j.core\2.3.1\org.sat4j.core-2.3.1.jar org.example.Main
FILE #0
5 4 0 2 0 9 0 0 1 
0 0 0 5 0 0 0 0 4 
0 0 7 0 0 0 9 0 0 
8 0 0 0 3 0 0 6 7 
0 0 0 6 0 5 0 0 0 
9 3 0 0 1 0 0 0 2 
0 0 1 0 0 0 6 0 0 
2 0 0 0 0 6 0 0 0 
3 0 0 1 0 7 0 4 9 


This is solvable, Solved output:

5 4 3 2 6 9 8 7 1 
6 8 9 5 7 1 3 2 4 
1 2 7 8 4 3 9 5 6 
8 1 5 9 3 2 4 6 7 
4 7 2 6 8 5 1 9 3 
9 3 6 7 1 4 5 8 2 
7 9 1 4 2 8 6 3 5 
2 5 4 3 9 6 7 1 8 
3 6 8 1 5 7 2 4 9 


Total time for solving: 426 milliseconds


FILE #1
1 0 0 2 3 4 0 0 12 0 6 0 0 0 7 0 
0 0 8 0 0 0 7 0 0 3 0 0 9 10 6 11 
0 12 0 0 10 0 0 1 0 13 0 11 0 0 14 0 
3 0 0 15 2 0 0 14 0 0 0 9 0 0 12 0 
13 0 0 0 8 0 0 10 0 12 2 0 1 15 0 0 
0 11 7 6 0 0 0 16 0 0 0 15 0 0 5 13 
0 0 0 10 0 5 15 0 0 4 0 8 0 0 11 0 
16 0 0 5 9 12 0 0 1 0 0 0 0 0 8 0 
0 2 0 0 0 0 0 13 0 0 12 5 8 0 0 3 
0 13 0 0 15 0 3 0 0 14 8 0 16 0 0 0 
5 8 0 0 1 0 0 0 2 0 0 0 13 9 15 0 
0 0 12 4 0 6 16 0 13 0 0 7 0 0 0 5 
0 3 0 0 12 0 0 0 6 0 0 4 11 0 0 16 
0 7 0 0 16 0 5 0 14 0 0 1 0 0 2 0 
11 1 15 9 0 0 13 0 0 2 0 0 0 14 0 0 
0 14 0 0 0 11 0 2 0 0 13 3 5 0 0 12 


This is solvable, Solved output:

1 5 10 2 3 4 9 11 12 16 6 14 15 13 7 8 
14 16 8 13 5 15 7 12 4 3 1 2 9 10 6 11 
9 12 4 7 10 16 6 1 8 13 15 11 3 5 14 2 
3 6 11 15 2 13 8 14 7 5 10 9 4 16 12 1 
13 4 14 3 8 7 11 10 5 12 2 6 1 15 16 9 
8 11 7 6 4 1 2 16 9 10 14 15 12 3 5 13 
12 9 1 10 13 5 15 6 3 4 16 8 14 2 11 7 
16 15 2 5 9 12 14 3 1 11 7 13 10 6 8 4 
6 2 16 14 11 9 4 13 15 1 12 5 8 7 10 3 
7 13 9 1 15 2 3 5 11 14 8 10 16 12 4 6 
5 8 3 11 1 10 12 7 2 6 4 16 13 9 15 14 
15 10 12 4 14 6 16 8 13 9 3 7 2 11 1 5 
2 3 5 8 12 14 10 15 6 7 9 4 11 1 13 16 
10 7 13 12 16 3 5 9 14 8 11 1 6 4 2 15 
11 1 15 9 6 8 13 4 16 2 5 12 7 14 3 10 
4 14 6 16 7 11 1 2 10 15 13 3 5 8 9 12 


Total time for solving: 898 milliseconds


FILE #2
0 0 0 0 0 0 0 0 0 0 0 0 0 8 0 0 
0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 
0 15 0 0 0 12 0 5 0 0 0 0 0 0 0 0 
5 7 3 0 11 0 0 0 0 0 0 0 0 0 0 0 
14 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
12 0 0 0 0 0 0 0 0 0 0 0 0 16 0 0 
0 0 0 0 0 0 0 0 6 0 0 0 0 5 0 0 
0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 
0 0 0 0 8 0 0 0 0 0 0 0 0 0 0 0 
0 0 5 0 0 0 0 2 0 0 0 0 0 0 0 0 
0 0 14 0 0 0 0 0 0 0 0 0 0 0 0 8 
0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 16 
0 0 0 0 0 0 0 0 0 0 0 5 0 4 16 13 
0 0 0 0 0 0 0 0 13 0 15 0 0 0 7 0 
0 0 0 0 0 0 13 0 0 0 0 0 0 0 0 0 
0 0 16 0 0 0 0 0 0 0 0 0 0 0 0 0 


This is solvable, Solved output:

6 2 12 11 7 4 15 13 1 10 3 14 16 8 5 9 
1 4 13 8 9 6 14 10 5 2 16 7 3 11 15 12 
9 15 10 16 3 12 2 5 4 6 11 8 7 1 13 14 
5 7 3 14 11 8 1 16 12 15 9 13 2 10 6 4 
14 5 7 4 2 3 6 1 10 11 8 16 9 13 12 15 
12 1 2 6 4 5 9 11 3 13 7 15 8 16 14 10 
10 9 8 3 13 7 16 15 6 1 14 12 11 5 4 2 
13 16 11 15 10 14 12 8 9 4 5 2 6 7 1 3 
3 10 1 2 8 9 7 4 16 14 12 6 13 15 11 5 
4 6 5 9 1 16 3 2 15 8 13 11 12 14 10 7 
16 11 14 7 15 13 5 12 2 9 1 10 4 6 3 8 
8 13 15 12 14 10 11 6 7 5 4 3 1 2 9 16 
11 3 9 1 6 2 8 7 14 12 10 5 15 4 16 13 
2 8 6 10 5 1 4 3 13 16 15 9 14 12 7 11 
7 12 4 5 16 15 13 14 11 3 2 1 10 9 8 6 
15 14 16 13 12 11 10 9 8 7 6 4 5 3 2 1 


Total time for solving: 863 milliseconds


FILE #3
0 2 0 0 0 3 14 0 8 0 0 0 0 0 0 0 0 13 4 24 0 7 1 0 0 
0 10 17 0 0 0 6 18 0 0 22 16 0 12 0 0 0 0 1 0 0 0 13 19 0 
0 15 24 13 7 0 0 0 4 0 10 0 0 3 14 0 18 0 0 0 0 22 2 6 0 
0 0 1 21 0 0 15 0 22 0 0 19 13 0 0 0 8 0 0 0 0 16 18 20 0 
0 5 0 0 20 7 25 19 0 0 0 21 17 18 2 10 12 22 9 15 11 0 0 0 0 
11 0 0 0 22 8 0 24 7 1 5 0 0 0 13 16 17 25 23 2 4 0 6 0 19 
16 9 12 0 17 0 19 22 0 0 0 0 18 21 0 0 20 6 13 0 7 0 0 23 11 
0 0 6 0 21 9 16 0 3 0 0 22 20 19 0 0 0 0 15 8 25 0 0 0 0 
0 0 23 5 0 2 0 0 11 17 8 0 0 0 16 12 9 0 0 21 0 3 10 0 0 
0 0 0 0 0 6 0 0 12 0 9 1 25 0 3 0 11 0 0 7 0 0 21 0 0 
0 0 9 0 0 23 0 5 17 4 16 0 11 0 22 18 2 0 21 13 0 0 7 0 0 
4 6 0 0 5 0 0 2 0 0 0 18 21 24 0 0 19 3 0 12 23 0 0 17 0 
0 0 0 12 11 0 7 3 0 24 17 20 15 13 19 1 0 5 8 0 6 9 0 0 0 
0 22 0 0 14 19 0 6 16 0 0 8 9 7 0 0 0 24 0 0 3 0 0 1 18 
0 0 21 0 0 25 13 0 20 8 12 0 14 0 10 9 16 15 0 6 0 0 4 0 0 
0 0 25 0 0 24 0 0 18 0 4 0 3 10 5 0 1 0 0 14 0 0 0 0 0 
0 0 5 3 0 17 0 0 23 7 13 0 0 0 18 19 21 0 0 22 0 11 12 0 0 
0 0 0 0 18 10 8 0 0 0 0 25 23 2 0 0 5 0 16 11 9 0 3 0 0 
17 20 0 0 2 0 22 16 6 0 0 7 12 0 0 0 0 9 3 0 18 0 23 24 25 
6 0 4 0 16 1 11 12 25 3 19 0 0 0 21 17 23 8 0 18 2 0 0 0 14 
0 0 0 0 4 14 24 11 19 23 21 17 16 8 0 0 0 1 2 9 13 0 0 5 0 
0 1 14 23 0 0 0 0 9 0 0 0 19 5 0 0 24 0 12 0 0 8 17 0 0 
0 16 11 8 0 0 0 0 1 0 6 4 0 0 23 0 15 0 0 0 14 12 9 10 0 
0 21 3 0 0 0 17 0 0 0 0 15 0 25 20 0 0 4 10 0 0 0 16 11 0 
0 0 20 2 0 16 5 8 0 0 0 0 0 0 0 0 6 0 19 25 0 0 0 3 0 


This is solvable, Solved output:

18 2 22 19 9 3 14 17 8 16 15 23 5 20 6 11 25 13 4 24 10 7 1 21 12 
14 10 17 11 8 5 6 18 21 9 22 16 4 12 24 2 7 23 1 20 15 25 13 19 3 
25 15 24 13 7 20 1 23 4 12 10 11 8 3 14 21 18 16 5 19 17 22 2 6 9 
23 4 1 21 12 11 15 10 22 2 7 19 13 9 25 6 8 17 14 3 24 16 18 20 5 
3 5 16 6 20 7 25 19 24 13 1 21 17 18 2 10 12 22 9 15 11 23 14 8 4 
11 3 18 15 22 8 21 24 7 1 5 12 10 14 13 16 17 25 23 2 4 20 6 9 19 
16 9 12 25 17 4 19 22 5 10 24 2 18 21 15 3 20 6 13 1 7 14 8 23 11 
2 7 6 4 21 9 16 13 3 18 23 22 20 19 11 5 14 10 15 8 25 1 24 12 17 
19 14 23 5 1 2 20 25 11 17 8 6 7 4 16 12 9 18 24 21 22 3 10 13 15 
20 8 10 24 13 6 23 15 12 14 9 1 25 17 3 4 11 19 22 7 5 2 21 18 16 
24 19 9 1 25 23 10 5 17 4 16 3 11 6 22 18 2 20 21 13 12 15 7 14 8 
4 6 8 16 5 22 9 2 15 11 25 18 21 24 1 14 19 3 7 12 23 13 20 17 10 
10 23 2 12 11 18 7 3 14 24 17 20 15 13 19 1 22 5 8 4 6 9 25 16 21 
15 22 13 20 14 19 12 6 16 21 2 8 9 7 4 25 10 24 17 23 3 5 11 1 18 
7 18 21 17 3 25 13 1 20 8 12 5 14 23 10 9 16 15 11 6 19 24 4 2 22 
8 11 25 7 23 24 2 21 18 20 4 9 3 10 5 15 1 12 6 14 16 17 19 22 13 
1 24 5 3 10 17 4 9 23 7 13 14 6 16 18 19 21 2 25 22 8 11 12 15 20 
21 12 15 22 18 10 8 14 13 19 20 25 23 2 17 24 5 7 16 11 9 6 3 4 1 
17 20 19 14 2 15 22 16 6 5 11 7 12 1 8 13 4 9 3 10 18 21 23 24 25 
6 13 4 9 16 1 11 12 25 3 19 24 22 15 21 17 23 8 20 18 2 10 5 7 14 
22 25 7 10 4 14 24 11 19 23 21 17 16 8 12 20 3 1 2 9 13 18 15 5 6 
13 1 14 23 15 21 18 4 9 6 3 10 19 5 7 22 24 11 12 16 20 8 17 25 2 
5 16 11 8 19 13 3 20 1 25 6 4 2 22 23 7 15 21 18 17 14 12 9 10 24 
9 21 3 18 6 12 17 7 2 22 14 15 24 25 20 8 13 4 10 5 1 19 16 11 23 
12 17 20 2 24 16 5 8 10 15 18 13 1 11 9 23 6 14 19 25 21 4 22 3 7 


Total time for solving: 2825 milliseconds


FILE #4
0 0 0 0 
0 0 0 3 
0 0 1 0 
0 0 0 0 


This is solvable, Solved output:

2 3 4 1 
1 4 2 3 
3 2 1 4 
4 1 3 2 


Total time for solving: 16 milliseconds


FILE #5
5 4 0 2 0 9 0 0 1 
0 0 0 5 0 0 0 0 4 
0 0 7 0 0 0 9 0 0 
8 0 0 0 3 0 0 6 7 
0 0 0 6 0 5 0 0 0 
9 3 0 0 1 0 0 0 2 
0 0 1 0 0 5 6 0 0 
2 0 0 0 0 6 0 0 0 
3 0 0 1 0 7 0 4 9 


Error Unsatisfiable... (Trivial)
Cannot Be Solved.
Total time for solving: 44 milliseconds



Process finished with exit code 0
