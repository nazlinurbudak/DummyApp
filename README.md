# DummyApp

I have a implemented dependencies library.

```
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib:1.8.21" // Kotlin standard library
    compileOnly("com.android.tools.lint:lint-api:31.1.0") // Lint API
    testImplementation("com.android.tools.lint:lint-tests:31.1.0") // Lint tests
    compileOnly("com.android.tools.lint:lint-checks:31.1.0")
}
```
I've created a checker module that includes the detector classes. Each detector class contains the necessary rules for the project. A detector class must be created for each rule.

it is necessary to implement the detector class into the issue registry file.

```
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    jar {
        manifest {
            attributes('Lint-Registry-v2':'com.nazlinurbudak.checker.MyIssueRegistry')
        }
    }
}
```


<img width="389" alt="Ekran Resmi 2023-08-14 14 53 25" src="https://github.com/nazlinurbudak/DummyApp/assets/68231995/477bbd39-0231-499c-a11f-8981bf3ed012">

# Run

To run the linting process, add the following command to the terminal:

```gradlew app:lintDebug```

<img width="1000" alt="Ekran Resmi 2023-08-14 18 35 13" src="https://github.com/nazlinurbudak/DummyApp/assets/68231995/2579079e-71dc-4063-8ae6-180e2c89ceae">

After running the command, you can view the details of the incorrect parts by following the provided link.

<img width="600"  src="https://github.com/nazlinurbudak/DummyApp/assets/68231995/e2851fab-4696-4bbb-9bbb-7fd865ec6a2d">


The provided code snippet contains incorrect usage of the log and includes a word that is not recommended for use.

You can also see the details in the lint report.

<img width="500" height="500" src="https://github.com/nazlinurbudak/DummyApp/assets/68231995/ece820a9-5339-4fa7-9abb-a954f1a35b30">







