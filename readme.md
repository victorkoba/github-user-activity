# github-user-activity
Sample solution for the [github-user-activity](https://roadmap.sh/projects/github-user-activity) challenge from [roadmap.sh](https://roadmap.sh/).

## How to run

Clone the repository and run the following command:

```bash
git clone https://github.com/victorkoba/github-user-activity.git
cd github-user-activity
```

Download the [Gson](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar) dependency and compile the project (requires Java 11+):

```bash
curl -L -o gson-2.11.0.jar https://repo1.maven.org/maven2/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar
javac -cp gson-2.11.0.jar -d out src/Main.java
```

Run the following command and type the username to list its activities:

```bash
# Windows
java -cp "out;gson-2.11.0.jar" Main

# Linux / macOS
java -cp "out:gson-2.11.0.jar" Main
```

```
Enter username: kamranahmedse
```