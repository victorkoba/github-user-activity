# GitHub User Activity

Aplicação de linha de comando em Java que consulta a API pública do GitHub e lista os eventos recentes de um usuário.

Exemplo de saída:

```
PushEvent em victorkoba/GitHubUserActivity (2026-11-07T20:24:00Z)
CreateEvent em victorkoba/GitHubUserActivity (2026-11-07T18:53:00Z)
```

## Requisitos

- Java 11 ou superior
- [Gson 2.11.0](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar)

## Como rodar

O usuário consultado está definido em `src/Main.java`, no método `main`. Troque `"victorkoba"` pelo usuário desejado.

### Pela IDE (IntelliJ)

1. Abra o projeto no IntelliJ.
2. Adicione a dependência `com.google.code.gson:gson:2.11.0` em *File > Project Structure > Libraries* (botão `+` > *From Maven*).
3. Execute a classe `Main`.

### Pelo terminal

Baixe o `gson-2.11.0.jar` (link acima) para a raiz do projeto e rode:

```bash
javac -cp gson-2.11.0.jar -d out src/Main.java

# Windows
java -cp "out;gson-2.11.0.jar" Main

# Linux / macOS
java -cp "out:gson-2.11.0.jar" Main
```
