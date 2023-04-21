# Challenge | Automation

## <u> SauceDemo </u>


:pushpin: Challenge de automatizacion creada para presentar a la empresa Crowdar


### Table of Contents
1. [¿Que voy a hacer?](#general-info)
2. [Herramientas](#tools)
3. [Ejecucion](#execution)
4. [¿Como visualizar los reportes?](#reports)


<a name="general-info"></a>
1. ¿Que voy a hacer? :mag_right:

***

#### _En este repositorio se va a automatizar 2 escenarios_
 <ul>
<li>InicioDeSession
<li>AgregadoDeProductoAlCarrito
</ul>

#### _Para llevarlo a cabo se va a utilizar:_
* lenguaje gherkin para hacer más comprensibles todos los escenarios
* Implementar BDD (Desarrollo Impulsado por el Comportamiento)
* Cumpliendo con el patrón <u>SOLID</u>

<a name="tools"></a>
2. Herramientas :briefcase:

* [Intellij IDEA](https://www.jetbrains.com/es-es/idea/)
* [build.gradle]()


```bash
repositories {
    jcenter()
    mavenLocal()
}
buildscript {
    repositories {
        jcenter()
        mavenCentral()
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath("net.serenity-bdd:serenity-gradle-plugin:2.0.70")
        classpath "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.0"
        classpath "gradle.plugin.com.github.sherter.google-java-format:google-java-format-gradle-plugin:0.8"
        classpath "gradle.plugin.co.com.bancolombia.certification:serenity-parallel-execution-plugin:1.0.3"
    }
}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'eclipse'
apply plugin: 'net.serenity-bdd.aggregator'
apply plugin: 'com.github.sherter.google-java-format'
apply plugin: 'co.com.bancolombia.serenity-parallel-execution-plugin'


tasks.withType(JavaCompile) {
    options.encoding = "UTF-8"
}

test {
    systemProperties = System.properties}

tasks.withType(Test) {
    systemProperty "file.encoding", "UTF-8"
}

ext {
    serenityVersion = '2.0.70'
    serenityCucumberVersion = '1.9.45'
}


dependencies {
    testImplementation 'junit:junit:4.12'
    testImplementation 'org.assertj:assertj-core:3.13.2'
    testImplementation 'org.slf4j:slf4j-api:1.7.2'
    testImplementation 'org.slf4j:slf4j-log4j12:1.7.2'
    implementation "net.serenity-bdd:serenity-core:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-junit:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-screenplay:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-cucumber:$rootProject.ext.serenityCucumberVersion"
    implementation "net.serenity-bdd:serenity-screenplay-webdriver:$rootProject.ext.serenityVersion"
    implementation "io.appium:java-client:7.0.0"
    implementation "net.serenity-bdd:serenity-ensure:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-rest-assured:$rootProject.ext.serenityVersion"
    implementation 'net.serenity-bdd:serenity-screenplay-rest:2.0.0'
    implementation 'org.apache.poi:poi-ooxml:5.0.0'
    compileOnly 'org.projectlombok:lombok:1.18.8'
    annotationProcessor 'org.projectlombok:lombok:1.18.8'
    testImplementation group: 'org.hamcrest', name: 'hamcrest-all', version: '1.3'
    implementation group: 'log4j', name: 'log4j', version: '1.2.17', {
        exclude group: 'com.sun.jmx', module: 'jmxri'
        exclude group: 'com.sun.jdmk', module: 'jmxtools'
        exclude group: 'javax.jms', module: 'jms'
    }

}

task parallel(type: ParallelTests, dependsOn: 'clean') {
    srcDirName = 'parallel'
}

gradle.startParameter.continueOnFailure = true
test.finalizedBy(aggregate)
```
#### Lenguague

* [Java](https://www.java.com/en/): Version 1.8_351

```bash
OS : Windos 11
```
***
<a name="execution"></a>
3. Ejecucion :keyboard:

In compliance with the SOLID principles, we must carry out the execution according to the functionality that we want to see:

| Runner (Java Class)                | Features                            |
|------------------------------------|-------------------------------------|
| InicioDeSessionRunner              | inicioDeSession.feature             |
| AgregadoDeProductosAlCarritoRunner | agregadoDeProductoAlCarrito.feature |
| ConsumirServicioDeMLRunner         | consumirServicioDeML.feature        |
| GeneralRunner                      | *.features (Directory)              |                  
***
<a name="reports"></a>
4. ¿Como visualizar los reportes? :computer:

Para la visualizacion del reporte hay 2 caminos:

1: Ejecutar la clase GenrealRunner</br></br>
2: Abrir la consola y ejecutar el comando:</br></br>
Para Chrome:
```bash
gradle clean test -D webdriver.chrome.driver=src/test/resources/webdriver/windows/chromedriver.exe
```
Para Firefox:
```bash
gradle clean test -D webdriver.gecko.driver=src/test/resources/webdriver/windows/geckodriver.exe
```


Luego de Cualquiera de esos 2 Pasos se debe serguir el siguiente camino

:one: Ir a la carpeta Target

:two: Ir hasta la ruta site/serenity/index.html

:three: Hacer Click derecho en el archivo "index.html", seleccionar "Open in", "Browser" y seleccionar el que deseea.
