plugins {
    application
    java
}

repositories {
    mavenLocal()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    mavenCentral()
}

dependencies {
    implementation("edu.cmu.sphinx:sphinx4-core:5prealpha-SNAPSHOT")
    implementation("edu.cmu.sphinx:sphinx4-data:5prealpha-SNAPSHOT")
}

application {
    // Classe principale que nous définirons dans le code Java
    mainClass.set("ReconnaissanceVocale.Main")
}
